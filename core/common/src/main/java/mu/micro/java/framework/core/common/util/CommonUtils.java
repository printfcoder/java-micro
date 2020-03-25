package mu.micro.java.framework.core.common.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;


public class CommonUtils {

    public static <K, V> V putToConcurrentMap(ConcurrentMap<K, V> map, K key, V value) {
        V old = map.putIfAbsent(key, value);
        return old != null ? old : value;
    }

    public static boolean isTrue(String b) {
        return b != null && StringUtils.TRUE.equalsIgnoreCase(b);
    }

    public static boolean isTrue(Boolean b) {
        return b != null && b;
    }

    public static boolean isFalse(Boolean b) {
        return b != null && !b;
    }

    public static boolean isFalse(String b) {
        return b != null && StringUtils.FALSE.equalsIgnoreCase(b);
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection collection) {
        return collection != null && !collection.isEmpty();
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map map) {
        return map != null && !map.isEmpty();
    }

    public static boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isNotEmpty(Object[] array) {
        return array != null && array.length > 0;
    }

    public static <T extends Number> T parseNum(T num, T defaultInt) {
        return num == null ? defaultInt : num;
    }

    public static int parseInt(String num, int defaultInt) {
        if (num == null) {
            return defaultInt;
        } else {
            try {
                return Integer.parseInt(num);
            } catch (Exception e) {
                return defaultInt;
            }
        }
    }

    public static long parseLong(String num, long defaultLong) {
        if (num == null) {
            return defaultLong;
        } else {
            try {
                return Long.parseLong(num);
            } catch (Exception e) {
                return defaultLong;
            }
        }
    }

    public static boolean parseBoolean(String bool, boolean defaultInt) {
        if (bool == null) {
            return defaultInt;
        } else {
            return Boolean.parseBoolean(bool);
        }
    }

    public static int[] parseInts(String nums, String sperator) {
        String[] ss = StringUtils.split(nums, sperator);
        int[] ints = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            ints[i] = Integer.parseInt(ss[i]);
        }
        return ints;
    }

    public static <T> boolean listEquals(List<T> left, List<T> right) {
        if (left == null) {
            return right == null;
        } else {
            if (right == null) {
                return false;
            }
            if (left.size() != right.size()) {
                return false;
            }

            List<T> ltmp = new ArrayList<T>(left);
            List<T> rtmp = new ArrayList<T>(right);
            for (T t : ltmp) {
                rtmp.remove(t);
            }
            return rtmp.isEmpty();
        }
    }

    public static String join(Collection collection, String separator) {
        if (isEmpty(collection)) {
            return StringUtils.EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        for (Object object : collection) {
            if (object != null) {
                String string = StringUtils.toString(object);
                if (string != null) {
                    sb.append(string).append(separator);
                }
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - separator.length()) : StringUtils.EMPTY;
    }
}
