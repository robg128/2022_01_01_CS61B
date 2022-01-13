import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void TestOffByOne() {
        char a = 'a';
        char b = 'b';
        assertEquals(true, offByOne.equalChars(a, b));

        a = 'r';
        b = 'q';
        assertEquals(true, offByOne.equalChars(a, b));

        a = 'a';
        b = 'e';
        assertEquals(false, offByOne.equalChars(a, b));

        a = 'a';
        b = 'a';
        assertEquals(false, offByOne.equalChars(a, b));

        a = 'a';
        b = 'z';
        assertEquals(false, offByOne.equalChars(a, b));

        a = '&';
        b = '%';
        assertEquals(true, offByOne.equalChars(a, b));

        a = 'a';
        b = 'A';
        assertEquals(false, offByOne.equalChars(a, b));
    }
}
