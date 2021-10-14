package data_generators;

import java.util.HashMap;

public abstract class DataGenerator {

    protected HashMap<String, String> map;

    public DataGenerator() {
        map = new HashMap<>();
    }

    public HashMap<String, String> getData() {
        return map;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        map.entrySet().forEach(entry -> sb.append(entry.getKey()).append(" = ").append(entry.getValue()).append("\n"));
        return sb.toString();
    }
}
