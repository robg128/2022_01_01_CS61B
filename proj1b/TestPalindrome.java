import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void TestPalindrome() {
        String actual = "racecar";
        assertEquals(true, palindrome.isPalindrome(actual));

        actual = "aaaaaaab";
        assertEquals(false, palindrome.isPalindrome(actual));

        actual = "";
        assertEquals(true, palindrome.isPalindrome(actual));

        actual = "a";
        assertEquals(true, palindrome.isPalindrome(actual));

        actual = "cat";
        assertEquals(false, palindrome.isPalindrome(actual));
    }


//    public void TestPalindromeRecursion() {
//        String actual = "racecar";
//        assertEquals(true, palindrome.isPalindromeRecursion(actual));
//
//        actual = "aaaaaaab";
//        assertEquals(false, palindrome.isPalindromeRecursion(actual));
//
//        actual = "";
//        assertEquals(true, palindrome.isPalindromeRecursion(actual));
//
//        actual = "a";
//        assertEquals(true, palindrome.isPalindromeRecursion(actual));
//
//        actual = "cat";
//        assertEquals(false, palindrome.isPalindromeRecursion(actual));
//    }

    @Test
    public void TestOffByOnePalindromeFinder() {
        String actual = "flake";
        assertEquals(true, palindrome.isPalindrome(actual, TestOffByOne.offByOne));
    }
}
