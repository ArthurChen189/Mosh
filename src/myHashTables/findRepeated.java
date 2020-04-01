package myHashTables;

import java.util.HashSet;
import java.util.Set;

public class findRepeated {
    public static char findFirstRepeated(String str){
        Set<Character> set = new HashSet<>();
        for (var item: str.toCharArray()) {
            if (set.contains(item)) return item;
            set.add(item);
        }
        return 0;
    }
}
