package myHashTables;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class myHashTable {
    private class Entry{
        private int key;
        private String value;

        private Entry(int key, String value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return (key+"="+value);
        }
    }

    private LinkedList<Entry>[] myLLArray;
    private int size;


    private myHashTable(int size){
        this.size = size;
        this.myLLArray = new LinkedList[size];
    }

    private int hashFunction(int key){
        return key%size;
    }

    public void put(int key,String value){
        var item = new Entry(key,value);
        int hash = hashFunction(key);
        if (myLLArray[hash] == null){
            myLLArray[hash] = new LinkedList<>();
            myLLArray[hash].add(item);
        }else{
                //if it has the same key, just replace the value
            for (var entry:myLLArray[hash]) {
                if (entry.key == key){
                    //pop and add new item
                    myLLArray[hash].remove(entry);
                    break;
                }
            }
            //java documentation states that: "add" method and "addLast" are equivalent
            myLLArray[hash].add(item);
        }
    }

    public String get(int key){
        int hash = hashFunction(key);
        if (myLLArray[hash] == null || myLLArray[hash].isEmpty()){
            throw new NoSuchElementException();
        }else{
            var ll = myLLArray[hash];
            while (!ll.isEmpty()){
                var item = ll.pop();
                if (item.key == key) return item.value;
            }
        }
        return null;
    }

    public void remove(int key){
        var hash = hashFunction(key);
        if (myLLArray[hash] == null || myLLArray[hash].isEmpty()) throw new IllegalStateException();
        for (var entry:myLLArray[hash]) {
            if (entry.key == key){
                //remove it
                myLLArray[hash].remove(entry);
                break;
            }
        }
    }

    @Override
    public String toString(){
        var arr = new String[size];
        for (int i = 0; i < size; i++) {
            if (myLLArray[i] == null) continue;
            String llValue = "";
            LinkedList<Entry> temp = myLLArray[i];
            while(!temp.isEmpty()){
                llValue += temp.poll().toString();
                if (!temp.isEmpty()) llValue += " -> ";
            }
            arr[i] = llValue;
        }

        return Arrays.toString(arr);
    }

}
