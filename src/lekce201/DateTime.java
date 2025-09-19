package lekce201;

public class DateTime {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis()); //UNIXTIME v ms

//       long start = System.currentTimeMillis(); --> NEPOUZIVA SE - muze se stat synchronizace
        long start = System.nanoTime(); // nema pevne dany zacatek
        for (int i = 0; i < 2_000_000_000; i++) {

        }
//        long end = System.currentTimeMillis();
        long end = System.nanoTime();
        System.out.println(end - start);
    }
}