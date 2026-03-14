import java.util.Arrays;

public class Marks {
    public static class StudentData {
        String name;
        int rno;
        int[] marks;

        StudentData(int[] s) {
            // marks = s; // shallow copy
            marks = Arrays.copyOf(s, s.length);
        }

        StudentData(int s) {
            marks = new int[s]; // shallow copy
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 7, 1, 4, 8 };
        StudentData s1 = new StudentData(arr);
        s1.marks[0] = 40;
        System.out.println(arr[0]);
        StudentData s2 = new StudentData(2);
        // s1.marks[0] = 89;
        // s1.marks[1] = 95;
        // s1.marks[2] = 56;
        // s1.marks[3] = 69;
    }
}
