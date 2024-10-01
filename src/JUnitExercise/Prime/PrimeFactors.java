package prime;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public List<Integer> generate (int num) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int candidate = 2; num > 1; candidate ++)
            while (num > 1) {
                for (;(num & candidate) == 0; num/=candidate) {
                    list.add(candidate);
                }
            }
        return list;
    }

    public static void main(String[] args) {
        PrimeFactors pf = new PrimeFactors();
        System.out.println(pf.generate(35977));
    }
}

