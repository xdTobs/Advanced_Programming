package week7;

import java.io.*;
import java.sql.SQLOutput;

public class CopyFileUsingByteStream {

    public static void main(String[] args) throws IOException {


        StringBuilder filePath = new StringBuilder("");
        StringBuilder endPath = new StringBuilder("");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter file to be copied:");
            filePath = new StringBuilder(br.readLine());
            System.out.println("Enter directory to copy to:");
            endPath = new StringBuilder(br.readLine());
        } catch (Exception e) {
            // if any error occurs
            e.printStackTrace();
        }

        validatePaths(filePath,endPath);

        FileInputStream fileInput = new FileInputStream(filePath.toString());
        FileOutputStream fileOutput = new FileOutputStream(endPath.toString());
        try {
            byte[] content = fileInput.readAllBytes();
            fileOutput.write(content);

        } catch (Exception e) {
            // if any error occurs
            e.printStackTrace();
        } finally {
            fileOutput.close();
            fileInput.close();
        }
    }

    private static void validatePaths(StringBuilder filePath, StringBuilder endPath) {
        try {
            if (filePath.equals("")) throw new InvalidInputException("filePath is empty");
            if (endPath.equals("")) throw new InvalidInputException("endPath is empty");
            File testFile = new File(filePath.toString());
            if (!testFile.isFile()) throw new NotAFileException(filePath.toString());
            File endFile = new File(endPath.toString());

            boolean needsPermission = false;
            if (endFile.isFile()) {
                needsPermission = true;
            }


            if (!needsPermission && endFile.isDirectory()) {

                endPath.append(testFile.getName());
                System.out.println(endPath);
                endFile = new File(endPath.toString());
                needsPermission = !endFile.createNewFile();
            }

            if(needsPermission) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Seems like the output file already exists. Should it be overridden? (Reply: Yes) ");
                String returned = br.readLine();
                if (!returned.toLowerCase().equals("yes")) throw new InvalidPermissionException();
                //deletes content of file maybe?
               // new FileOutputStream(endPath).close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class InvalidInputException extends Exception {
        public InvalidInputException(String invalid_input) {
            super("The given input\"" + invalid_input + "\" is invalid");
        }
    }

    private static class NotAFileException extends Exception {
        public NotAFileException(String testFile) {
            super("The path:" + testFile + " Does not lead to a file");
        }
    }

    private static class InvalidPermissionException extends Exception {
        public InvalidPermissionException() {
            super("Invalid permission to override file");
        }
    }
}
