package leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class SalesforceTestFileAggregator {

    public static void main(String[] args) {
        processFile();
    }

    private static void processFile() {
        try {
            // Create a Scanner to read the text file
            String filePath = "input.txt";
            Scanner scanner = new Scanner(new File(filePath));
            long count = 0;
            long sum = 0;

            // Read and parse the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(" ");
                if (tokens.length > 0) {
                    String lastWord = tokens[tokens.length - 1];
                    if(Long.parseLong(lastWord) > 5000) {
                        count++;
                        sum += Long.parseLong(lastWord);
                    }
                }
            }
            writeFile(count, sum, filePath);
            // Close the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    private static void writeFile(long count, long sum, String filePath) {
        String fileName = "bytes_" + filePath;
        try {
            // Create a FileWriter to write to the file
            FileWriter fileWriter = new FileWriter(fileName);

            // Write the text to the file
            fileWriter.write(count + "\n");
            fileWriter.write(sum + "\n");

            // Close the FileWriter
            fileWriter.close();


        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
