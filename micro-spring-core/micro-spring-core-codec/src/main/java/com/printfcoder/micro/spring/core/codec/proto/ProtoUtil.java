/**
 * Copyright 2016-2017 Sixt GmbH & Co. Autovermietung KG
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a
 * copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 * <p>
 * modified by printfcoder
 */

package com.printfcoder.micro.spring.core.codec.proto;

import com.google.gson.*;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;
import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;
import com.printfcoder.micro.spring.core.common.util.FileUtil;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ProtoUtil {

    public static final int MAX_HEADER_CHUNK_SIZE = 1000;
    public static final int MAX_BODY_CHUNK_SIZE = 10_000_000;

    private static <TYPE extends Message> TYPE.Builder getBuilder(Class<TYPE> messageClass) throws NoSuchMethodException,
            InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException {

        Constructor<TYPE> constructor = messageClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        TYPE instance = constructor.newInstance();

        return instance.newBuilderForType();
    }

    /**
     * NOTE: this is only using the first element of the JsonArray
     */
    public static <TYPE extends Message> TYPE jsonToProtobuf(JsonArray request, Class<TYPE> messageClass) throws NoSuchMethodException,
            InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
        if (request == null || request.size() < 1 || request.get(0).isJsonNull()) {
            return null;
        }
        return jsonToProtobuf(request.get(0).toString(), messageClass);
    }

    /**
     * Converts a JSON String to a protobuf message
     * <p>
     * Note: Ignores unknown fields
     *
     * @param input        the input String to convert
     * @param messageClass the protobuf message class to convert into
     * @return the converted protobuf message (null in case of null input)
     */
    public static <TYPE extends Message> TYPE jsonToProtobuf(String input, Class<TYPE> messageClass) throws NoSuchMethodException,
            InstantiationException, IllegalAccessException, java.lang.reflect.InvocationTargetException {
        if (input == null) {
            return null;
        }

        if (!isValidJSON(input)) {
            return (TYPE) getBuilder(messageClass).getDefaultInstanceForType();
        }

        try {
            TYPE.Builder builder = getBuilder(messageClass);
            JsonElement element = new JsonParser().parse(input);
            cleanJsonElement(element);
            JsonFormat.parser().ignoringUnknownFields().merge(element.toString(), builder);
            return (TYPE) builder.build();
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing json to protobuf. Input = " + input, e);
        }
    }

    private static void cleanJsonElement(JsonElement element) {
        if (element.isJsonNull() || element.isJsonPrimitive()) {
            return;
        }
        if (element.isJsonArray()) {
            cleanJsonArray(element.getAsJsonArray());
        }
        if (element.isJsonObject()) {
            cleanJsonObject(element.getAsJsonObject());
        }
    }

    private static void cleanJsonArray(JsonArray array) {
        Iterator<JsonElement> iter = array.iterator();
        while (iter.hasNext()) {
            JsonElement ele = iter.next();
            if (ele.isJsonNull()) {
                iter.remove();
                continue;
            } else {
                cleanJsonElement(ele);
            }
        }
    }

    private static void cleanJsonObject(JsonObject element) {
        Set<Map.Entry<String, JsonElement>> members = element.entrySet();
        Iterator<Map.Entry<String, JsonElement>> iter = members.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, JsonElement> member = iter.next();
            JsonElement value = member.getValue();
            cleanJsonElement(value);
        }
    }

    private static boolean isValidJSON(String input) {
        if (StringUtils.isBlank(input)) {
            return false;
        }

        if (!input.startsWith("{")) {
            return false;
        }

        try {
            new JsonParser().parse(input);
        } catch (JsonParseException ex) {
            return false;
        }

        return true;
    }

    /**
     * Converts a byte array to a protobuf message
     *
     * @param data         the byte array to convert
     * @param messageClass the protobuf message class to convert into
     * @return the converted protobuf message
     * @throws MicroRpcException if something goes wrong during the deserialization
     */
    public static <TYPE extends Message> TYPE byteArrayToProtobuf(byte data[], Class<TYPE> messageClass)
            throws MicroRpcException {
        try {
            Message.Builder builder = getBuilder(messageClass);
            return (TYPE) builder.mergeFrom(data).build();
        } catch (Exception e) {
            throw new MicroRpcException(500, "Error deserializing byte array to protobuf: " + e);
        }
    }

    /**
     * Creates an empty protobuf message of the specified type
     *
     * @param klass the protobuf message type
     * @return the generated protobuf message
     */
    public static <TYPE extends Message> TYPE newEmptyMessage(Class<TYPE> klass) {
        try {
            Message.Builder builder = getBuilder(klass);
            return (TYPE) builder.build();
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing byte array to protobuf", e);
        }
    }

    /**
     * Converts a protobuf message to a JSON object
     * <p>
     * Note: Preserves the field names as defined in the proto definition
     *
     * @param input the protobuf message to convert
     * @return the converted JSON object
     */
    public static JsonObject protobufToJson(Message input) {
        JsonObject object = new JsonObject();
        if (input != null) {
            try {
                String jsonString = JsonFormat.printer()
                        .preservingProtoFieldNames()
                        .print(input);
                object = new JsonParser().parse(jsonString).getAsJsonObject();
            } catch (Exception e) {
                throw new RuntimeException("Error deserializing protobuf to json", e);
            }
        }
        return object;
    }

    /**
     * Converts a protobuf message to a JSON object
     * <p>
     * Note: Camel-cases the field names as defined in the proto definition
     *
     * @param input the protobuf message to convert
     * @return the converted JSON object
     */
    public static JsonObject protobufToJsonCamelCase(Message input) {
        JsonObject object = new JsonObject();
        if (input != null) {
            try {
                String jsonString = JsonFormat.printer()
                        .print(input);
                object = new JsonParser().parse(jsonString).getAsJsonObject();
            } catch (Exception e) {
                throw new RuntimeException("Error deserializing protobuf to json", e);
            }
        }
        return object;
    }

    /**
     * Converts a protobuf message to a JSON object
     * <p>
     * Note: Preserves the field names as defined in the proto definition
     * Note:
     *
     * @param input the protobuf message to convert
     * @return the converted JSON object
     */
    public static JsonObject protobufToJsonWithDefaultValues(Message input) {
        JsonObject object = new JsonObject();
        if (input != null) {
            try {
                String jsonString = JsonFormat.printer()
                        .preservingProtoFieldNames()
                        .includingDefaultValueFields()
                        .print(input);
                object = new JsonParser().parse(jsonString).getAsJsonObject();
            } catch (Exception e) {
                throw new RuntimeException("Error deserializing protobuf to json", e);
            }
        }
        return object;
    }

    /**
     * Converts a JSON object to a protobuf message.
     * <p>
     * Note: Ignores unknown fields
     *
     * @param builder the proto message type builder
     * @param input   the JSON object to convert
     * @return the converted protobuf message
     */
    public static Message fromJson(Message.Builder builder, JsonObject input) throws Exception {
        JsonFormat.parser().ignoringUnknownFields().merge(input.toString(), builder);
        return builder.build();
    }

    /**
     * Converts a proto file name into a class name according to the rules defined by protobuf:
     * https://developers.google.com/protocol-buffers/docs/reference/java-generated
     * <p>
     * The file name will be camel cased (and underscores, hyphens etc. stripped out).
     *
     * @param protoFileName The file name to process: e.g. my_service.proto
     * @return The class name: MyService
     */
    public static String toClassName(String protoFileName) {

        if (protoFileName == null) {
            return null;
        }
        String fileName = FileUtil.stripPath(protoFileName);
        fileName = FileUtil.stripExtension(fileName);

        String parts[] = fileName.split("[^A-Za-z0-9]");

        StringBuilder classNameBuilder = new StringBuilder();
        for (String part : parts) {
            classNameBuilder.append(StringUtils.capitalize(part));
        }
        return classNameBuilder.toString();
    }
}
