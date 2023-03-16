package week7;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ReadDir {
    public static void main(String[] args) {
        File file = null;
        String[] paths;
        String filePath;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input file path:");
        try {
            filePath = br.readLine();
// create new file object
            file = new File(filePath);
// array of files and directory
            paths = file.list();
// for each name in the path array
            for (String path : paths) {
// prints filename and directory name
                System.out.println(path);
            }
        } catch (Exception e) {
// if any error occurs
            e.printStackTrace();
        }
    }
}