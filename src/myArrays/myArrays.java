package myArrays;

public class myArrays {
    private  int[] array;
    int length;
    private int counter = 0;

    public myArrays(int length){
        this.length = length;
        this.array = new int[length];
    }


    public void insert(int item){
        if(counter >= length) expandArray();
        array[counter] = item;
        counter++;
    }

    public void removeAt(int index){
        if (index >= length){
            System.out.println("index out of bound");
            return;
        }
        boolean Found = false;
        int newLength = length - 1;
        int[] temp = new int[newLength];
        for (int i = 0; i < newLength; i ++){
            if(i == index){
                Found = true;
            }
            if(Found){
                temp[i] = array[i+1];
            }else{
                temp[i] = array[i];
            }
        }
        array = temp;
        length = newLength;
    }



    public void expandArray(){
        int newLength = (length+1);
        int[] temp = new int[newLength];
        for(int i = 0; i < length; i++){
            temp[i] = array[i];
        }
        length = newLength;
        array = temp;
    }

    public void print(){
        for(int i: array){
            System.out.println(i);
        }
    }


    public int indexOf(int item){

        for (int i = 0; i < length; i++) {
            if (array[i] == item) return i;
        }
        return -1;
    }




}
