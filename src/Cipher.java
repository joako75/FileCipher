import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cipher {
    /////////////////////////////CAESAR///////////////////////////////
    public static StringBuffer caesar(String s) {
        String alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklm";
        String[] alphabet_array = alphabet.split("");
        ArrayList<String> encoded = new ArrayList<>();

        for(String c : s.split("")){
            boolean caps = Character.isUpperCase(c.charAt(0));

            if(c.matches("[^A-Za-z]")){
                encoded.add(c);
            }
             else if(caps){
                 encoded.add(alphabet_array[alphabet.indexOf(c.toLowerCase()) + 13].toUpperCase());
             }
             else{
                 encoded.add(alphabet_array[alphabet.indexOf(c) + 13]);
             }
        }

        StringBuffer sb = new StringBuffer();
        for(String letter : encoded){
            sb.append(letter);
        }

        System.out.println("Encoded: Caesar");
        return sb;
    }
    /////////////////////////////UNCAESAR///////////////////////////////
    public static StringBuffer uncaesar(String s) {
        String alphabet = "mlkjihgfedcbazyxwvutsrqponmlkjihgfedcba";
        String[] alphabet_array = alphabet.split("");
        ArrayList<String> encoded = new ArrayList<>();

        for(String c : s.split("")){
            boolean caps = Character.isUpperCase(c.charAt(0));

            if(c.matches("[^A-Za-z]")){
                encoded.add(c);
            }
            else if(caps){
                encoded.add(alphabet_array[alphabet.indexOf(c.toLowerCase()) + 13].toUpperCase());
            }
            else{
                encoded.add(alphabet_array[alphabet.indexOf(c) + 13]);
            }
        }

        StringBuffer sb = new StringBuffer();
        for(String letter : encoded){
            sb.append(letter);
        }
        System.out.println("Decoded: Caesar");
        return sb;
    }
    //////////////////REVERSE/////////////////////
    public static StringBuilder reverse(String s){
        StringBuilder sb = new StringBuilder();

        sb.append(s);
        sb.reverse();

        System.out.println("Encoded: Reverse");
        return sb;
    }
    /////////////////////////////ROTATE//////////////////////////////
    //Takes a string and int Number of rotations MAX ROTATIONS: 26 //
    public static StringBuffer rot(String s, int r) throws Exception {
        String alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        String[] alphabet_array = alphabet.split("");
        ArrayList<String> encoded = new ArrayList<>();

        if(r > 26){
            throw new Exception("Rotation must be 26 or less");
        }
        for(String c : s.split("")){
            boolean caps = Character.isUpperCase(c.charAt(0));

            if(c.matches("[^A-Za-z]")){
                encoded.add(c);
            }
            else if(caps){
                encoded.add(alphabet_array[alphabet.indexOf(c.toLowerCase()) + r].toUpperCase());
            }
            else{
                encoded.add(alphabet_array[alphabet.indexOf(c) + r]);
            }
        }

        StringBuffer sb = new StringBuffer();
        for(String letter : encoded){
            sb.append(letter);
        }

        System.out.println("Encoded: Rot" + r);
        return sb;
    }
    /////////////////////////////UNROTATE///////////////////////////////
    //Takes a string and int Number of rotations MAX ROTATIONS: 26 //
    public static StringBuffer unrot(String s, int r) throws Exception {
        String alphabet = "zyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcba";
        String[] alphabet_array = alphabet.split("");
        ArrayList<String> encoded = new ArrayList<>();

        if(r > 26){
            throw new Exception("Rotation must be 26 or less");
        }
        for(String c : s.split("")){
            boolean caps = Character.isUpperCase(c.charAt(0));

            if(c.matches("[^A-Za-z]")){
                encoded.add(c);
            }
            else if(caps){
                encoded.add(alphabet_array[alphabet.indexOf(c.toLowerCase()) + r].toUpperCase());
            }
            else{
                encoded.add(alphabet_array[alphabet.indexOf(c) + r]);
            }
        }

        StringBuffer sb = new StringBuffer();
        for(String letter : encoded){
            sb.append(letter);
        }

        System.out.println("Decoded: Rot" + r);
        return sb;
    }
    /////////////////////////////PIGLATIN///////////////////////////////
    public static StringBuffer piglatin(String s) {
        String[] words = s.split(" ");
        ArrayList<String> pigged = new ArrayList<>();
        String[] vowels = {"a","e","i","o","u","y"};
        List<String> vowels_list = Arrays.asList(vowels);

        for(String w : words){
            String[] word = w.split("");
            if(word.length == 1){
                pigged.add(w + "yay");
            }
            else if(vowels_list.contains(word[0])){
                pigged.add(w + "way");
            }
            else if(vowels_list.contains(word[1])){
                pigged.add(w.substring(1) + word[0] + "ay");
            }
            else{
                pigged.add(w.substring(2) + word[0] + word[1] + "ay");
            }
        }

        StringBuffer sb = new StringBuffer();
        for(String w : pigged) {
            sb.append(w + " ");
        }

        System.out.println("Encoded: Pig Latin");
        return sb;
    }
}
