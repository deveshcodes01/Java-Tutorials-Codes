package Maps_and_Sets;

import java.util.HashMap;

public class Maps_STL {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("raghav", 25);
        map.put("aditya", 19);
        map.put("vivek", 17);
        map.put("deepika", 25);
        for (String key : map.keySet()) {
            System.out.print(key + " " + map.get(key));
        }
        // System.out.println(map + " " + map.size());
        // System.out.println(map.remove("vivek"));
        // System.out.println(map+" "+map.size());
        // System.out.println(map.get("Raghav"));
        // map.put("deepika",20);
    }
}
