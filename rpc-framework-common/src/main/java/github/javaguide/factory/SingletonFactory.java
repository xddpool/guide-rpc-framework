package github.javaguide.factory;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * 获取单例对象的工厂类
 *
 * @author shuang.kou
 * @createTime 2020年06月03日 15:04:00
 */
public final class SingletonFactory {

    // 通过 map 存取 单例
    private static final Map<String, Object> OBJECT_MAP = new ConcurrentHashMap<>();

    private SingletonFactory() {
    }

    // 获取单例的方法
    public static <T> T getInstance(Class<T> c) {
        if (c == null) {
            throw new IllegalArgumentException();
        }
        String key = c.toString();
        if (OBJECT_MAP.containsKey(key)) {
            return c.cast(OBJECT_MAP.get(key));
        } else {
            return c.cast(OBJECT_MAP.computeIfAbsent(key, new Function<String, Object>() {
                @Override
                public Object apply(String k) {
                    try {
                        return c.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        throw new RuntimeException(e.getMessage(), e);
                    }
                }
            }));
        }
    }
}
