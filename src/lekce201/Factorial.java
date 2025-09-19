/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lekce201;

/**
 *
 * @author filip.dostal.s
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(TimeConsument.test(10000, () -> findMaxFactorial()));
        System.out.println(TimeConsument.test(10000, () -> findMaxFactorialBetter()));
    }

    public static double factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1); // rozdel a panuj
        }
    }

    public static double factorialBetter(int n) {
        double f = n;
        for (int i = n - 1; i > 1; i--) {
            f *= i;
        }
        return f;
    }

    public static int findMaxFactorial() {
        for (int n = 1; ; n++) {
            double f = factorial(n);
            if (f == Double.POSITIVE_INFINITY) {
                return n;
            }
        }
    }

    public static int findMaxFactorialBetter() {
        double f = 1;
        for (int n = 1; ; n++) {
            f *= n;
            if (f == Double.POSITIVE_INFINITY) {
                return n;
            }
        }
    }
}