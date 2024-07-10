package chap03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {
    @Test
    @DisplayName("만원 납부하면 한달 뒤가 만료일이 됨")
    void test1() {
        LocalDate billingDate = LocalDate.of(2019,01,03);
        int payAmount = 10_000;

        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);

        assertEquals(expiryDate, LocalDate.of(2019,02,03));
    }


}
