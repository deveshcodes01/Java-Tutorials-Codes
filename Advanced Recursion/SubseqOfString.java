//MOST IMPORTANT FOR PLACEMENTS
// package Advanced Recursion;

public class SubseqOfString {
    public static void Subs(String str, int idx, String newString) {
        if (idx == str.length()) {
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(idx);
        // Include the current character
        Subs(str, idx + 1, newString + currChar);
        // Exclude the current character
        Subs(str, idx + 1, newString);
    }

    public static void main(String args[]) {
        String str = "abc";
        Subs(str, 0, "");
    }
}
// This code generates all subsequences of the given string "abc".