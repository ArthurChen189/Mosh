package myHashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class findFirstNonRepeatingChar {
    public static char findFirstNonRep(String str){
        Set<Character> set = new HashSet<>();
        Map<Character,Integer> map= new HashMap<>();
        for (char i:str.toCharArray()){
            if (map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
        }

        for (var item: map.entrySet()) {
            if(item.getValue() == 1)
                set.add(item.getKey());
        }

        for (var item: str.toCharArray()){
            if (set.contains(item)) return item;
        }

        return 0;
    }
}
