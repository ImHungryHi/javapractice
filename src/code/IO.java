package code;

import java.io.*;
import java.util.ArrayList;

public class IO {
    public static void readFromConsoleAndCapitalize() {
        try {
            // Capitalize substrings from an input & skip double spaces
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            String[] words = s.split(" ");
            s = "";

            for (String word : words) {
                if (!word.isEmpty()) {
                    s += (word.substring(0, 1).toUpperCase() + word.substring(1));

                    if (!word.equals(words[words.length - 1]))
                        s += " ";
                }
            }

            System.out.println(s);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void readFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();

            FileInputStream file = new FileInputStream(fileName);

            while (file.available() > 0) {
                System.out.print((char)file.read());
            }

            file.close();
        }
        catch (Exception ex) {
            // Sup?
        }
    }

    public static void readLinesFromFile(String fileName) {
        try {
            ArrayList<String> content = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String input = reader.readLine();

            while (input != null) {
                content.add(input);
                input = reader.readLine();
            }

            reader.close();
        } catch (Exception ex) {}
    }

    public static void writeFileFromConsole() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            String input = "";

            do {
                input = reader.readLine();
                writer.write(input);
                writer.newLine();
            } while (!input.equals("exit"));

            reader.close();
            writer.close();
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void getFilesMinByte() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        try (FileInputStream fileStream = new FileInputStream(fileName)) {
            byte minByte = 127;
            byte curByte = (byte) fileStream.read();

            while (curByte != -1) {
                if (curByte < minByte) {
                    minByte = curByte;
                    curByte = (byte) fileStream.read();
                }
            }

            fileStream.close();

            System.out.println(minByte);
        }
    }
}
