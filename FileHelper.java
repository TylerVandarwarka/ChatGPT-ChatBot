import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
public class FileHelper {
    public static String readLinesAsString(File file) {
        //List<String> returnLines = new LinkedList<String>();
        String text = "";
        try {
            text = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
//    public static List<String> readLines(File file) {
//        List<String> returnLines = new LinkedList<String>();
//        try {
////           String text = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())),
////                   StandardCharsets.UTF_8);
////            String[] lines = text.split("\n");
////            for (String line : lines) {
////                returnLines.add(line);
////            }
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return returnLines;
//}
//    public static void writeStringToFile(String line, File file) {
//        try {
//            FileWriter myWriter = null;
//            if (file.exists()) {
//                myWriter = new FileWriter(file, true);//if file exists append to file. Works fine.
//            } else {
//                System.out.println("Could not find the file " + file + ". Creating it again");
//                file.createNewFile();
//                myWriter = new FileWriter(file);
//            }
//            myWriter.write(line);
//            myWriter.close();
//// System.out.println("Successfully wrote to the file. "+file.getAbsolutePath());
//        } catch (IOException e) {
//            e.printStackTrace();
//            System.out.println("An error occurred in writing to file " + file + " e=" + e);
//        }
//    }
}