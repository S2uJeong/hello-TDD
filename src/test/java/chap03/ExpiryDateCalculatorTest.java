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
        assertExpiryDate(PayData.builder()
                .payAmount(10_000)
                .billingDate(LocalDate.of(2019, 1, 2))
                .build(), LocalDate.of(2019, 2, 2));
        assertExpiryDate(PayData.builder()
                .payAmount(10_000)
                .billingDate(LocalDate.of(2019, 2, 3))
                .build(), LocalDate.of(2019, 3, 3));
    }
    // 예외 상황 테스트 시작
    @Test
    @DisplayName("납부일과 한달 뒤 일자가 같지 않음")
    void test2() {
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019,1,31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019,2,28)
        );
    }

    @Test
    @DisplayName("첫 납부일과 만료일 일자가 다를때 만원 납부")
    void test3() {
        PayData payData =  PayData.builder()
                .firstBillingDate(LocalDate.of(2019,1,31))
                .billingDate(LocalDate.of(2019,2,28))
                .payAmount(10_000)
                .build();
        assertExpiryDate(payData, LocalDate.of(2019,3,31));

        PayData payData2 =  PayData.builder()
                .firstBillingDate(LocalDate.of(2019,1,30))
                .billingDate(LocalDate.of(2019,2,28))
                .payAmount(10_000)
                .build();
        assertExpiryDate(payData2, LocalDate.of(2019,3,30));
    }
    @Test
    @DisplayName("이만원 이상 납부하면 비례해서 만료일 계산")
    void test4() {
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019,3,1))
                        .payAmount(20_000)
                        .build()
                , LocalDate.of(2019,5,1)
        );
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019,3,1))
                        .payAmount(30_000)
                        .build()
                , LocalDate.of(2019,6,1)
        );
    }

    @Test
    @DisplayName("첫 납부일과 만료일 일자가 다를 때 이만원 이상 납부")
    void test5() {
        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2019,1,31))
                        .billingDate(LocalDate.of(2019,2,28))
                        .payAmount(20_000)
                        .build()
                , LocalDate.of(2019,4,30)
        );
    }

    @Test
    @DisplayName("십만원을 납부하면 1년 제공")
    void test6() {
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019,1,28))
                        .payAmount(100_000)
                        .build()
                ,LocalDate.of(2020,1,28)
        );
    }

    @Test
    @DisplayName("십삼만원을 납부하면 1년3개월 제공")
    void test7() {
        assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019,1,2))
                        .payAmount(130_000)
                        .build()
                ,LocalDate.of(2020,4,2)
        );
    }

    private void assertExpiryDate(PayData data, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(data);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }

}
