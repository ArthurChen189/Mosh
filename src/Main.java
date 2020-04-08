import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        int length = 0;
        try {
            Scanner sc = new Scanner(new File("path"));
            while(sc.hasNextLine()){
                length++;
            }

            length /= 2;

            String[] name = new String[length];
            String[] answers = new String[length];

            for (int i = 0; i < length; i++) {
                name[i] = sc.nextLine();
                answers[i] = sc.nextLine();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
