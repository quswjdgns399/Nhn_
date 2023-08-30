package test;

import java.util.Random;

/**
 * Main 클래스입니다.
 */
public class Main {

    /**
     * main method.
     *
     * @param args input 인자
     */
    public static void main(String[] args) {

        Random r = new Random();
        int random1 = r.nextInt(6) + 1;
        int random2 = r.nextInt(6) + 1;


//        int random1 = (int) (Math.random() * 6) + 1;
//        int random2 = (int) (Math.random() * 6) + 1;

        Dice first = new Dice(random1);
        Dice second = new Dice(random2);

        System.out.println("주사위 합 = " + DiceCalculator.addDice(first, second));

        String str = "abcdefg";

        int val = (int) (Math.random() * str.length());
        System.out.println(DiceCalculator.getIndexOf(str, val));

        int random4 = (int) (Math.random() * 6) + 1;
        Dice dice = new Dice(random4);
        System.out.println("주사위 눈이 홀수 :? " + DiceCalculator.odd(dice));


        try {
            new Library(-1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        String book3 = "살롯의 거미줄";

        Library library = new Library(5);
        library.add("해리포터");
        library.add(book3);

        try {
            library.add(book3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        library.delete("해리포터");

        try {
            library.delete("스파이더맨");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        library.find(book3);

        library.findAll();

        library.add("java7");
        library.add("java8");
        library.add("java9");
        library.add("java10");

        library.findAll();

        try {
            library.add("java22");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

//good
}
