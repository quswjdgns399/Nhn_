package test;

public class DiceCalculator {

    private DiceCalculator() {
    }

    public static int addDice(Dice first, Dice second) {
        return first.getRan_num() + second.getRan_num();
    }


    public static boolean odd(Dice dice) {
        return dice.getRan_num() % 2 != 0;
    }

    public static String getIndexOf(String str, int index) {
        return str.substring(0, index + 1);
    }
}
