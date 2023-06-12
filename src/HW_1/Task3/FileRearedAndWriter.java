package HW_1.Task3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class FileRearedAndWriter {
    private static final String PKG_DIRECTORY = "src/professional/consult/hw1/task3";
    private static final String OUTPUT_FILE_NAME = "output.txt";
    private static final String INPUT_FILE_NAME = "input.txt";

    public static void main(String[] args) throws IOException {
        readAndWrite();
    }

    public static void readAndWrite() throws IOException {
        Scanner scanner = new Scanner(new File(PKG_DIRECTORY + "/" + INPUT_FILE_NAME));
        Writer writer = new FileWriter(PKG_DIRECTORY + "/" + OUTPUT_FILE_NAME);

        try (scanner; writer) {
            while (scanner.hasNext()) {
                writer.write(scanner.nextLine().toUpperCase() + "\n");
            }
        }
    }
}
