package test;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class DiceTest {
    @org.junit.jupiter.api.Test
    @DisplayName("Dice 객체 생성 테스트")
    void diceConstructorTest() {
        Dice dice = new Dice(4);

        Assertions.assertEquals(4, dice.getRan_num());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("addDice 테스트")
    void adddiceTest() {
        Dice dice1 = new Dice(1);
        Dice dice2 = new Dice(4);

        Assertions.assertEquals(DiceCalculator.addDice(dice1, dice2), 5);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    @DisplayName("odd true 테스트")
    void oddTrueTest(int number) {

        Dice dice = new Dice(number);
//        Assertions.assertEquals(DiceCalculator.odd(dice), true);
        Assertions.assertTrue(DiceCalculator.odd(dice));

    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    @DisplayName("odd false 테스트")
    void oddFalseTest(int number) {

        Dice dice = new Dice(number);
        Assertions.assertEquals(DiceCalculator.odd(dice), false);

    }

    static Stream<Arguments> diceValue() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(4, 5, 9),
                Arguments.of(6, 6, 12),
                Arguments.of(1, 1, 2),
                Arguments.of(3, 2, 5)
        );
    }

    @ParameterizedTest(name = "Dice {0} + Dice {1} = Dice{3}")
    @MethodSource("diceValue")
    @DisplayName("DiceCalculator.add 테스트")
    void DiceaddTEst(int first, int second, int result) {
        Dice firstDice = new Dice(first);
        Dice secondDice = new Dice(second);

        Assertions.assertEquals(result, DiceCalculator.addDice(firstDice, secondDice));

    }

    @org.junit.jupiter.api.Test
    @DisplayName("DiceCalculator.getIndex Test")
    void getIndexOfTest() {
        Dice dice = new Dice(5);
        String str = "a1b2c3d4";

        Assertions.assertEquals("a1b2c3", DiceCalculator.getIndexOf(str, dice.getRan_num()));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Dice 객체 생성 반복 테스트")
    void diceInteratorTest() {
        int[] arr = {1, 2, 3, 4, 5, 6};

        for (int i = 0; i < arr.length; i++) {
            Dice dice = new Dice(arr[i]);

            Assertions.assertEquals(arr[i], dice.getRan_num());
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("Dice 객체 Param Test")
    void diceParamTest(int number) {

        Dice dice = new Dice(number);
        Assertions.assertEquals(number, dice.getRan_num());

    }

    @org.junit.jupiter.api.Test
    @DisplayName("Dice 객체 생성 테스트 (number : -1)")
    void negativeDiceConstructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Dice(-1));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Dice 객체 생성 테스트 (number : 7)")
    void oversixDice() {
        try {
            new Dice(7);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Dice(7));
    }


}
