package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열 계산기 테스트")
    void calculatorTest() {
        String input = "2 + 3 * 4 / 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String[] values = input.split(" ");
        int result = stringToInt(values[0]);
        for (int i = 0; i < values.length - 2; i += 2) {
            result = calculate(result, values[i + 1].charAt(0), stringToInt(values[i + 2]));
        }
        assertEquals(result, 10);
    }

    int calculate(int num1, char operator, int num2) {
        if (operator == '+') {
            return add(num1, num2);
        }
        if (operator == '-') {
            return subtract(num1, num2);
        }
        if (operator == '*') {
            return multiply(num1, num2);
        }
        if (operator == '/') {
            return divide(num1, num2);
        }
        throw new IllegalArgumentException("잘못된 입력값입니다.");
    }


    int stringToInt(String input) {
        return Integer.parseInt(input);
    }

    int add(int a, int b) {
        return a + b;
    }

    int subtract(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    }
}
