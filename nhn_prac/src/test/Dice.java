package test;

public class Dice {

    private int ran_num;

    public Dice(int number) {
        if (number <= 0 || number > 6) {
            throw new IllegalArgumentException("Invalid Number");
        }
        this.ran_num = number;
    }

    public int getRan_num() {
        return ran_num;
    }
}
