
public class Main {
    public static void main(String[] args) throws Exception {
        // System.out.println(cipher.caesar("My name is Devin McDermott! This is my <>Caesar Cypher<>, and it's 100% + or - a bit ^_^"))//System.out.println(cipher.uncaesar("Zl anzr vf Qriva ZpQrezbgg! Guvf vf zl <>Pnrfne Plcure<>, naq vg'f 100% + be - n ovg ^_^"));
        // System.out.println(cipher.reverse("traf"));
        // System.out.println(cipher.rot("Hello World!", 22));
        // System.out.println(cipher.unrot("Dahhk Sknhz!", 22));
        // System.out.println(cipher.piglatin("This is a test for Pig Latin I hope it works"));

        // String myFile = "C:\\Users\\Devin McDermott\\IdeaProjects\\fileboi.txt";
        // FileHandler.create(myFile);
        // FileHandler.write("You can write to the file", myFile);
        // FileHandler.read(myFile);
        // FileHandler.delete(myFile);
        // System.out.println(FileHandler.sb);

        // Change File path to your IdeaProjects file path and create a starting "myFile" manually or through
        // provided methods
        String myFile = "C:\\Users\\Devin McDermott\\IdeaProjects\\message.txt";
        String myCodedFile = "C:\\Users\\Devin McDermott\\IdeaProjects\\codedmessage.txt";
        String myDecodedFile = "C:\\Users\\Devin McDermott\\IdeaProjects\\decodedmessage.txt";

         FileHandler.encrypt_to_new_file(myFile, myCodedFile, "rot20");
         FileHandler.encrypt_to_new_file(myCodedFile, myDecodedFile, "unrot20");


    }
}
