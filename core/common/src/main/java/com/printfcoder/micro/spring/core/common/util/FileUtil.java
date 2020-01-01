package com.printfcoder.micro.spring.core.common.util;

import java.io.File;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/10/18
 **/
public class FileUtil {
    public static String stripPath(String fileName) {
        if (fileName == null) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf(File.separatorChar) + 1, fileName.length());
    }

    public static String stripExtension(String fileName) {
        if (fileName == null) {
            return "";
        }
        if (!fileName.contains(".")) {
            return fileName;
        }
        return fileName.substring(0, fileName.lastIndexOf('.'));
    }
}
