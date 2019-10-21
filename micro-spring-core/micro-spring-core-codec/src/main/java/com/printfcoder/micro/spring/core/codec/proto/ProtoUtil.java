package com.printfcoder.micro.spring.core.codec.proto;

import com.google.protobuf.MessageLite;
import com.printfcoder.micro.spring.core.common.exception.MicroRpcException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/21
 **/

public class ProtoUtil {


    /**
     * Cache of parseFrom method
     */
    ConcurrentMap<Class, Method> parseFromMethodMap = new ConcurrentHashMap<Class, Method>();

    /**
     * Cache of toByteArray method
     */
    ConcurrentMap<Class, Method> toByteArrayMethodMap = new ConcurrentHashMap<Class, Method>();

    /**
     * 请求参数类型缓存 {service+method:class}
     */
    private ConcurrentMap<String, Class> requestClassCache = new ConcurrentHashMap<String, Class>();

    /**
     * 返回结果类型缓存 {service+method:class}
     */
    private ConcurrentMap<String, Class> responseClassCache = new ConcurrentHashMap<String, Class>();

    /**
     * 从缓存中获取请求值类
     *
     * @param service 接口名
     * @param methodName 方法名
     * @return 请求参数类
     */
    public Class getReqClass(String service, String methodName) {

        String key = buildMethodKey(service, methodName);
        Class reqClass = requestClassCache.get(key);
        if (reqClass == null) {
            // 读取接口里的方法参数和返回值
            String interfaceClass = ConfigUniqueNameGenerator.getInterfaceName(service);
            Class clazz = ClassUtils.forName(interfaceClass, true);
            loadProtoClassToCache(key, clazz, methodName);
        }
        return requestClassCache.get(key);
    }

    /**
     * 从缓存中获取返回值类
     *
     * @param service 接口名
     * @param methodName 方法名
     * @return 请求参数类
     */
    public Class getResClass(String service, String methodName) {
        String key = service + "#" + methodName;
        Class reqClass = responseClassCache.get(key);
        if (reqClass == null) {
            // 读取接口里的方法参数和返回值
            String interfaceClass = ConfigUniqueNameGenerator.getInterfaceName(service);
            Class clazz = ClassUtils.forName(interfaceClass, true);
            loadProtoClassToCache(key, clazz, methodName);
        }
        return responseClassCache.get(key);
    }

    /**
     * 拼装缓存的key
     *
     * @param serviceName 接口名
     * @param methodName 方法名
     * @return Key
     */
    private String buildMethodKey(String serviceName, String methodName) {
        return serviceName + "#" + methodName;
    }

    /**
     * 加载protobuf接口里方法的参数和返回值类型到缓存，不需要传递
     *
     * @param key 缓存的key
     * @param clazz 接口名
     * @param methodName 方法名
     */
    private void loadProtoClassToCache(String key, Class clazz, String methodName) {
        Method pbMethod = null;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (methodName.equals(method.getName())) {
                pbMethod = method;
                break;
            }
        }
        if (pbMethod == null) {
            throw new MicroRpcException(500, "Cannot found protobuf method: " + clazz.getName() + "." + methodName);
        }
        Class[] parameterTypes = pbMethod.getParameterTypes();
        if (parameterTypes == null
            || parameterTypes.length != 1
            || isProtoBufMessageObject(parameterTypes[0])) {
            throw new MicroRpcException(500, "class based protobuf: " + clazz.getName() + ", only support one protobuf parameter!");
        }
        Class reqClass = parameterTypes[0];
        requestClassCache.put(key, reqClass);
        Class resClass = pbMethod.getReturnType();
        if (resClass == void.class || !isProtoBufMessageClass(resClass)) {
            throw new MicroRpcException(500, "class based protobuf: " + clazz.getName() + ", only support return protobuf message!");
        }
        responseClassCache.put(key, resClass);
    }

    /**
     * Is this object instanceof MessageLite
     *
     * @param object unknown object
     * @return instanceof MessageLite
     */
    boolean isProtoBufMessageObject(Object object) {
        if (object == null) {
            return false;
        }
        if (MULTIPLE_CLASSLOADER) {
            return object instanceof MessageLite || isProtoBufMessageClass(object.getClass());
        } else {
            return object instanceof MessageLite;
        }
    }

    /**
     * Is this class is assignable from MessageLite
     *
     * @param clazz unknown class
     * @return is assignable from MessageLite
     */
    boolean isProtoBufMessageClass(Class clazz) {
        return clazz != null && ClassUtils.isAssignableFrom(MessageLite.class, clazz);
    }
}
