package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void test1() {
        String[] inputArray = "1,2".split(",");
        assertThat(inputArray).contains("1");
        assertThat(inputArray).containsExactly("1", "2");
    }

    @Test
    void test2() {
        String input = "(1,2)".substring(1, 4);
        assertThat(input).isEqualTo("1,2");
    }

    @Test
    @DisplayName("StringIndexOutOfBoundsException 예외 발생 테스트")
    void test3() {
        assertThatThrownBy(() -> {
            "abc".charAt(4);
        }).isInstanceOf(StringIndexOutOfBoundsException.class).hasMessageContaining("String index out of range: 4");
    }
}
