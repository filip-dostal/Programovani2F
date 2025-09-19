/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lekce201;

import cz.gyarab.util.Utils;
import cz.gyarab.util.light.Matrix;

public class RunInterval {
    public static void main(String[] args) {
        int i = 1;
        long finished = System.nanoTime() + 1_000_000_000;
        while (System.nanoTime() < finished) {
            i++;
            System.out.println(i);
        }
        System.out.println("The last number is: " + i);
    }
}