package github.javaguide;

import java.util.HashMap;
import java.util.Map;

public class Holder<T> {
    private volatile T value;

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }
}

class TestHolder {
    public static void main(String[] args) {


        Holder<Map<String, Object>> mapHolder = new Holder<>();

        HashMap<String, Object> map = new HashMap<>();
        map.put("xx", 12);
        map.put("xxx", 123);
        map.put("xxxx", 1234);
        map.put("xxxxx", 12345);
        map.put("xxxxxx", 123456);

        mapHolder.set(map);

        Map<String, Object> stringObjectMap = mapHolder.get();
        stringObjectMap.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);

    }
}