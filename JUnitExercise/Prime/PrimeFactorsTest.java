package prime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestPrimeFactors {
    private static PrimeFactors pf;
    @BeforeAll
    public static void initialize() {
        pf = new PrimeFactors();
    }

    @Test
    public void testOne() {
        assertEquals(list(1), pf.generate(1));

    }

    @Test
    public void testTwo() {
        assertEquals(list(2), pf.generate(2));

    }

    @Test
    public void testThree() {
        assertEquals(list(3), pf.generate(3));

    }
    @Test
    public void testFour() {
        assertEquals(list(4), pf.generate(4));

    }
    @Test
    public void testFive() {
        assertEquals(list(5), pf.generate(5));

    }
    @Test
    public void testSix() {
        assertEquals(list(6), pf.generate(6));

    }
    @Test
    public void testSeven() {
        assertEquals(list(7), pf.generate(7));

    }
    @Test
    public void testEight() {
        assertEquals(list(2,2,2), pf.generate(8));

    }
    @Test
    public void testZero() {
        assertEquals(list(0), pf.generate(0));

    }
    @Test
    public void testNine() {
        assertEquals(list(3,3), pf.generate(9));

    }
    @Test
    public void testFifteen() {
        assertEquals(list(3,5), pf.generate(15));

    }


    public List<Integer> list(int...ints) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : ints) {
            if (num > 1) {
                list.add(num);
            }
        }
        return list;
    }
}