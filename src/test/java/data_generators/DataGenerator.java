package data_generators;

import java.util.HashMap;

//Klasa za generisanje i cuvanje vise podataka odjednom.
//U klasama naslednicama u konstruktoru definisati podatke koje su potrebni
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
