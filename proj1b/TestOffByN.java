import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void TestOffByNequalChars() {
        CharacterComparator cc5 = new OffByN(5);

        char a = 'f';
        char b = 'a';
        assertEquals(true, cc5.equalChars(a, b));

        a = 'f';
        b = 'h';
        assertEquals(false, cc5.equalChars(a, b));
    }

    @Test
    public void TestOffByNPalindromeFinder() {
        Palindrome palindrome = new Palindrome();

        String actual = "abcgf";
        assertEquals(true, palindrome.isPalindrome(actual, 5));

        actual = "aaaa";
        assertEquals(false, palindrome.isPalindrome(actual, 5));
    }
}
