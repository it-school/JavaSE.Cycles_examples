package itschool;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
/*
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task4Hard();

        hometask7();
*/
        hometask6();
    }

    private static void hometask6() {
        final int VALUE = 60;
        int[] values = new int[VALUE];
        Random random = new Random();
        int personalScore = 0;
        for (int i = 0; i < values.length; i++) {
            values[i] = random.nextInt(50); // [0..N)
        }
        System.out.println(Arrays.toString(values));
        int[] copy = values.clone();

        for (int i = 0; i < values.length; i++) {
            for (int j = i + 1; j < values.length; j++) {
                if (values[i] == values[j]) {
                    values[j] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(values));

        final int K = 0;

/*
        for (int i = 0; i < K; i++) {
            newArr[i] = copy[i];
        }
        for (int i = K; i < copy.length; i++) {
            newArr[i-1] = copy[i];
        }
*/

        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(deleteElementAt(copy, K)));
        System.out.println(Arrays.toString(copy));
    }

    private static int[] deleteElementAt(int[] copy, int K) {
        int[] newArr = new int[copy.length - 1];

        for (int i = 0, j = 0; i < copy.length; i++, j++) {
            newArr[j] = copy[i];
            if (i == K) {
                j--;
            }
        }
        copy = newArr;
        return copy;
    }

    private static void task1() {
        double a = 10, b = 195, c = 2;
        double D;

        long t1, t2, t3;
        t1 = System.nanoTime();
        D = b * b + 4 * a * c;
        t2 = System.nanoTime();
        D = Math.pow(D, 2) + 4 * a * c;
        t3 = System.nanoTime();
        if (a != 0) {
//            if (D > 0) {
//                System.out.println("x1 = " + (-b + Math.sqrt(D) / (2 * a)) + ", x2 = " + (-b - Math.sqrt(D) / (2 * a)));
//            } else if (D < 0) {
//                System.out.println("No solutions");
//            } else {
//                System.out.println(-b / (2 * a));
//            }
            System.out.println((D > 0) ? "x1 = " + (-b + Math.sqrt(D) / (2 * a)) + ", x2 = " + (-b - Math.sqrt(D) / (2 * a)) : D < 0 ? "No solutions" : "" + (-b / (2 * a)));
        } else {
            System.out.println("Incorrect start values: a = 0");
        }
//        System.out.println(t2-t1);
//        System.out.println(t3-t2);

    }

    private static void task2() {
        int number = 222222;
        int tensOfThousands = 0, thousands = 0, hundreds = 0, decimals = 0, ones = 0, hundredsOfThousands = 0;
        ones = number / 1 % 10;
        decimals = number / 10 % 10;
        hundreds = number / 100 % 10;
        thousands = number / 1000 % 10;
        tensOfThousands = number / 10000 % 10;
        hundredsOfThousands = number / 100000 % 10;
        if (ones + decimals + hundreds == thousands + tensOfThousands + hundredsOfThousands)
            System.out.println("Happy ticket");
        else
            System.out.println("Ordinary ticket");
    }

    private static void task3() {
        int counter = 1;
        for (; counter <= 3; ) {
            System.out.println("Counter = " + ++counter);
        }
        System.out.println(counter);

        Enter:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i+j: " + (i + j) + "\n");
                if (j == 3)
                    return;
                i++;
            }
        }
    }

    private static void task4() {
        long start = System.currentTimeMillis();
        double z = 0;
        // x = -100..100 , 0.01
        // y = -1000..1000 , 0.01
        // z = (y^3 + x ^ 2) / (x + y);
        double x2 = 0;
        for (double x = -100; x <= 100; x += 0.1) {
            x2 = x * x;
            for (double y = -1000; y <= 1000; y += 0.01) {
                z = (2 * y * y * y + 3 * y * y) / (x + y);
            }
            //System.out.println(x);
        }
        System.out.println((System.currentTimeMillis() - start));
        System.out.println(z);
    }

    private static void task4Hard() {
        double x = 0, numerator = 0, denominator = 1, z = 0;
        final int N = 10; // [0..10)
        for (int i = 1; i < 20; i++) {
            denominator = 1;
            for (int k = 1; k < N; k++) {
                x = Math.random() * 10;
                numerator = Math.pow(x, k);
                denominator = denominator * k;
                z += numerator / denominator;
            }
        }

        System.out.println(z);
    }

    private static void task5() {

        double sum = 0, x = 1, fact = 1, sl = 0;
        int sign = 1;
        for (int k = 1; k <= 13; k += 2) {
            sum += sign * Math.pow(x, k) / fact;
            fact = fact * (k + 1) * (k + 2);
            sign *= -1;
        }
        System.out.println("Result = " + sum);
    }

    private static void task6() {
        long number = 34555678987633335l;
        long a = 5l, b = 3l;
        int cA = 0, cB = 0;
        int digit = 0;
        while (number > 0) {
            digit = (int) (number % 10);
            //System.out.println(digit);
            if (digit == a)
                cA++;
            else if (digit == b)
                cB++;

            number /= 10;
        }
        System.out.println(cA);
        System.out.println(cB);
        System.out.println(cA < cB ? "Yes" : "No");
    }

    private static void hometask7() {
        final int N = 15;
        int n = 0, start = 100;

        while (n < N) {
            if (start % 19 == 0) {
                System.out.print(start + "\t");
                n++;
            }
            start++;
        }

        System.out.println();
        for (start = 100, n = 0; n < N; start++) {
            if (start % 19 == 0) {
                System.out.print(start + "\t");
                n++;
            }
        }
    }

    public static long factorial(int n) {
        long f = 1;

        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}

