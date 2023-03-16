package week7;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ReadWriteComplex {
    static final String filePath = "C:\\Users\\tobia\\IdeaProjects\\Advanced_Programming\\src\\main\\java\\week7\\complexNums";
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));



        FileInputStream fileInput = new FileInputStream(filePath.toString());
        FileOutputStream fileOutput = new FileOutputStream(endPath.toString());

        System.out.println("Read / Write?");
        try{
            String input = br.readLine();
            switch (input.toLowerCase()){
                case("read")-> readNums(br);
                case("write")-> writeNums(br);
                default -> throw new InvalidInputException(input);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void writeNums(BufferedReader br) throws IOException {
        System.out.println("Create complex number, insert x,y seperated by a space");
        FileOutputStream fileOutput = new FileOutputStream(filePath);
        try{
            int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            Complex output = new Complex(xy[0],xy[1]);
            fileOutput.write(output.);

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            fileOutput.close();
        }

    }

    private static void readNums(BufferedReader br) {


    }


    private static class InvalidInputException extends Exception {
        public InvalidInputException(String input) {
            super(input+" Is invalid input");
        }
    }
}
