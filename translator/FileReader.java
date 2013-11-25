package translator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

public static void main(String[] args) {

    File file = new File("E:/Intern/Java/workspace/Translator/src/translator/first.txt");

    try {

        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String s= sc.next();
            System.out.println(s);
        }
        sc.close();
    } 
    catch (FileNotFoundException e) {
        e.printStackTrace();
    }
 }
}