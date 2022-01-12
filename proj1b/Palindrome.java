import java.util.Calendar;

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }

        return d;
    }

    public boolean isPalindromeRecursion(String word) {
        Deque<Character> d = wordToDeque(word);

        return isPalindromeHelper(d);
    }

    public boolean isPalindromeHelper(Deque d) {
        if (d.size() <= 1) {
            return true;
        }
        if (d.removeFirst() == d.removeLast()) {
            return isPalindromeHelper(d);
        }
        return false;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        d = wordToDeque(word);
        char q, p;
        while (d.size() > 1) {
            q = d.removeFirst();
            p = d.removeLast();

            if (q != p) {
                return false;
            }
        }
        return true;
    }

    public void test1() {
        return;
    }
}
