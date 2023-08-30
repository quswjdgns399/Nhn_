package test;

public class Number {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Number(int num) {
        this.num = num;
    }

    public static void main(String[] args) {

        printNum();
    }

    private static void printNum() {
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);
        System.out.println(5);
        System.out.println(6);
    }
}

