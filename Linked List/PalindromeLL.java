
// ----PALINDROME LINKED LIST
import java.util.ArrayList;

public class PalindromeLL {
    public boolean isPalindrome(ListNode head) {
        // ----METHOD 1----
        ListNode temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while (temp != null) {
            arr.add(temp.val);
            temp = temp.next;
        }
        int i = 0, j = arr.size() - 1;
        while (i < j) {
            if (arr.get(i) != arr.get(j)) {
                return false;
            } else {
                i++;
                j++;
            }
        }
        return true;
    }
}
