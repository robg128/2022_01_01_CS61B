import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void FirstTest() {
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> stu = new StudentArrayDeque<>();
        String msg = "";

        int randnum = StdRandom.uniform(100);
        sol.addFirst(randnum);
        stu.addFirst(randnum);
        msg += "addFirst(" + randnum + ")";
        assertEquals(msg, sol.get(0), stu.get(0));

        randnum = StdRandom.uniform(100);
        sol.addLast(randnum);
        stu.addLast(randnum);
        msg += "addLast(" + randnum + ")";
        assertEquals(msg, sol.get(0), stu.get(0));

        Integer expect = sol.removeFirst();
        Integer actual = stu.removeFirst();
        msg += "removeFirst()";
        assertEquals(msg, expect, actual);

        expect = sol.removeLast();
        actual = stu.removeLast();
        msg += "removeLast()";
        assertEquals(msg, expect, actual);
    }

    @Test
    public void testArratDeque2() {
        ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();
        int random = StdRandom.uniform(100);
        ads.addFirst(random);
        sad.addFirst(random);
        assertEquals("addFirst("+random+")", ads.get(0), sad.get(0));
        System.out.println("addFirst("+random+")");

        random = StdRandom.uniform(100);
        ads.addLast(random);
        sad.addLast(random);
        assertEquals("addLast("+random+")", ads.get(1), sad.get(1));
        System.out.println("addLast("+random+")");

        Integer actual = ads.removeFirst();
        Integer expected = sad.removeFirst();
        assertEquals("removeFirst()", actual, expected);
        System.out.println("removeFirst()");

        actual = ads.removeLast();
        expected = sad.removeLast();
        assertEquals("removeLast()", actual, expected);
        System.out.println("removeLast()");
    }
}
