import edu.duke.*;

public class CaesarCipher {
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        int n = input.length();
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted = upperAlphabet.substring(key, 26);
        shifted = shifted + upperAlphabet.substring(0,26);
        //String newString = new String();
        // String lowerAlphabet = upperAlphabet.toLowerCase();
        // String newAlphabet = upperAlphabet + lowerAlphabet;
        //Compute the shifted alphabet
        //String shiftedAlphabet = newAlphabet.substring(key)+ newAlphabet.substring(0,key);
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            // char currChar = encrypted.charAt(i);
            char curChar = input.charAt(i);
            int curIndex = upperAlphabet.indexOf(curChar);
            if (curIndex != -1){
                char shiftedChar = shifted.charAt(curIndex);
                encrypted.setCharAt(i, shiftedChar);
            } else if (curIndex == -1) {
                char upperChar = Character.toUpperCase(curChar);
                int newIndex = upperAlphabet.indexOf(upperChar);
                if (newIndex != -1) {
                    char shiftedNew = shifted.charAt(newIndex);
                    encrypted.setCharAt(i, Character.toLowerCase(shiftedNew));
                }
            }
            //Find the index of currChar in the alphabet (call it idx)
            // int idx = newAlphabet.indexOf(currChar);
            //If currChar is in the alphabet
            //if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                //char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                //encrypted.setCharAt(i, newChar);
            //}
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    public void testCaesar() {
        int key = 17;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println(encrypted);
        String decrypted = encrypt(encrypted, 26-key);
        System.out.println(decrypted);
    }
    
    public void testQuizOne() {
        String message = "At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        //int key = 15;
        //String encrypted = encrypt(message, key);
        //System.out.println(encrypted);
        int key1 = 8, key2 = 21;
        String newEncrypted = encrypt(message, key1);
        String newNew = encrypt(message, key2);
        System.out.println(newEncrypted);
        System.out.println(newNew);
    }
}

