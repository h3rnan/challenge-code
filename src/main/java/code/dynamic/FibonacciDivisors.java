package code.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hernan on 01-04-14.
 * Problem Big Number Divisors
 * Problem Fast Fibonacci
 */
public class FibonacciDivisors {

    public static Map<Integer, Long> map = new HashMap<Integer, Long>();

    public static void main(String[] args) {
        int iterator = 0;
        int numDivisors;
        long fibonacciNum;
        do {
            System.out.println("iteracion => " + iterator);
            fibonacciSeriesMap(iterator);
            fibonacciNum = map.get(iterator);
            System.out.println("serie fibonacci => " + fibonacciNum);
            numDivisors = divisors(fibonacciNum);
            System.out.println("numero de divisores =>" + numDivisors);
            iterator++;
        } while (numDivisors < 1001);
        System.out.println("-- NUMERO FIBONACCI ESPERADO -- " + fibonacciNum);
    }

    private static int divisors(long num) {
        int count = 0;
        int top = (int) Math.sqrt(num);
        for (int i = 1; i < top; i++) {
            if (num % i == 0)
                count += 2;
        }
        if (top * top == num)
            count++;
        return count;
    }

    private static void fibonacciSeriesMap(int iterator) {
        if (iterator < 2) {
            map.put(iterator, 1L);
        } else {
            long series = map.get(iterator - 1) + map.get(iterator - 2);
            map.put(iterator, series);
        }
    }
}
