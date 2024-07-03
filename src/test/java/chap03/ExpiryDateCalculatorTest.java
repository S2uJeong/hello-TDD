package chap03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * test 메서드 명명으로 만들어진 순서를 나타냄
 * testN() : N번째로 만들어진 테스트이다.
 */
public class ExpiryDateCalculatorTest {
    @Test
    @DisplayName("만원 납부하면 한달 뒤가 만료일이 됨")
    void test1() {
        LocalDate biliingDate = LocalDate.of(2019, 3, 1);
        int payAmount = 10_000;

        ExpiryDataCalculator cal = new ExpiryDataCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(biliingDate, payAmount);

        assertEquals(LocalDate.of(2019,4,1), expiryDate);
    }
}
