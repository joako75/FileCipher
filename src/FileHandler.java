import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/////////////////FILE HANDLER///////////////////
public class FileHandler {
    static StringBuffer sb = new StringBuffer();

    /////////////////CREATE FILE////////////////
    // Takes a filepath to create
    public static void create(String f) {
        try {
            File file = new File(f);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /////////////////WRITE TO FILE///////////////////
    // Takes a string and a filepath then writes the string to the file
    public static void write(String s, String f) {
        try {
            FileWriter writer = new FileWriter(f);
            writer.write(s);
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /////////////////READ FILE///////////////////
    // Takes a filepath and reads the file copying content into string buffer
    public static void read(String f) {
        sb.delete(0, sb.length()); // Clear the stringbuffer before using
        try {
            File file = new File(f);
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                sb.append(data);
                System.out.println("File read successfully");
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /////////////////DELETE FILE///////////////////
    // Takes a filepath and deletes the file
    public static void delete(String f) {
        File file = new File(f);
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
    /////////////////ENCRYPT FILE///////////////////
    // This method takes a filepath of a file to encrypt and a cipher name
    // then encrypts the file using the cipher and writes the encrypted message back to the file
    public static void encrypt_file(String inputFile, String cipher) throws Exception {
        try {
            FileHandler.read(inputFile);
            String text = FileHandler.sb.toString();
            PrintWriter pw = new PrintWriter(inputFile);
            pw.close();

            switch(cipher){
                case "caesar":
                    FileHandler.write(Cipher.caesar(text).toString(), inputFile);
                    break;
                case "uncaesar":
                    FileHandler.write(Cipher.uncaesar(text).toString(), inputFile);
                    break;
                case "reverse":
                    FileHandler.write(Cipher.reverse(text).toString(), inputFile);
                    break;
                case "piglatin":
                    FileHandler.write(Cipher.piglatin(text).toString(), inputFile);
                    break;
                default:
                    int r = 0;
                    if(cipher.matches("^rot\\d+$")) {
                        final Pattern lastIntPattern = Pattern.compile("[^0-9]+([0-9]+)$");
                        Matcher matcher = lastIntPattern.matcher(cipher);
                        if (matcher.find()) {
                            String someNumberStr = matcher.group(1);
                            r = Integer.parseInt(someNumberStr);
                            FileHandler.write(Cipher.rot(text, r).toString(), inputFile);
                        }
                    }
                    else if (cipher.matches("^unrot\\d+$")) {
                        final Pattern lastIntPattern2 = Pattern.compile("[^0-9]+([0-9]+)$");
                        Matcher matcher2 = lastIntPattern2.matcher(cipher);
                        if (matcher2.find()) {
                            String someNumberStr = matcher2.group(1);
                            r = Integer.parseInt(someNumberStr);
                            FileHandler.write(Cipher.unrot(text, r).toString(), inputFile);
                        }
                    }
            }
            System.out.println("File encrypted");

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    /////////////////ENCRYPT TO NEW FILE///////////////////
    // This method takes a filepath of a file to encrypt, a destination filepath, and a cipher name
    // then encrypts the file using the cipher and writes the encrypted message to the destination file
    public static void encrypt_to_new_file(String inputFile, String destinationFile, String cipher) throws Exception {
        try {
            FileHandler.read(inputFile);
            String text = FileHandler.sb.toString();
            FileHandler.create(destinationFile);

            switch(cipher){
                case "caesar":
                    FileHandler.write(Cipher.caesar(text).toString(), destinationFile);
                    break;
                case "uncaesar":
                    FileHandler.write(Cipher.uncaesar(text).toString(), destinationFile);
                    break;
                case "reverse":
                    FileHandler.write(Cipher.reverse(text).toString(), destinationFile);
                    break;
                case "piglatin":
                    FileHandler.write(Cipher.piglatin(text).toString(), destinationFile);
                    break;
                default:
                    int r = 0;
                    if(cipher.matches("^rot\\d+$")) {
                        final Pattern lastIntPattern = Pattern.compile("[^0-9]+([0-9]+)$");
                        Matcher matcher = lastIntPattern.matcher(cipher);
                        if (matcher.find()) {
                            String someNumberStr = matcher.group(1);
                            r = Integer.parseInt(someNumberStr);
                            FileHandler.write(Cipher.rot(text, r).toString(), destinationFile);
                        }
                    }
                    else if (cipher.matches("^unrot\\d+$")) {
                        final Pattern lastIntPattern2 = Pattern.compile("[^0-9]+([0-9]+)$");
                        Matcher matcher2 = lastIntPattern2.matcher(cipher);
                        if (matcher2.find()) {
                            String someNumberStr = matcher2.group(1);
                            r = Integer.parseInt(someNumberStr);
                            FileHandler.write(Cipher.unrot(text, r).toString(), destinationFile);
                        }
                    }
            }
            System.out.println("File encrypted");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}