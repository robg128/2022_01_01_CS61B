package synthesizer;
import edu.princeton.cs.algs4.In;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
//        ArrayRingBuffer arb = new ArrayRingBuffer(10);
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        arb.enqueue(10);
        arb.enqueue(20);
        arb.enqueue(30);
        arb.enqueue(40);
        assertEquals((Integer) 10, arb.peek());
        assertEquals((Integer) 10, arb.dequeue());
        assertEquals((Integer) 20, arb.peek());
        arb.enqueue(50);
        assertEquals((Integer) 20, arb.dequeue());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
