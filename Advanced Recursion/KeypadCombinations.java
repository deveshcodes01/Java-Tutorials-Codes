//MOST IMPORTANT FOR PLACEMENTS PART 2
// package Advanced Recursion;

public class KeypadCombinations {
    public static String[] keypad = { ".", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static void printComb(String str, int idx, String combi) {
        if (idx == str.length()) {
            System.out.println(combi);
            return;
        }
        char currChar = str.charAt(idx);
        String mapping = keypad[currChar - '0'];
        for (int i = 0; i < mapping.length(); i++) {
            printComb(str, idx + 1, combi + mapping.charAt(i));
        }
    }

    public static void main(String[] args) {
        String str = "23";
        printComb(str, 0, "");
    }
}
