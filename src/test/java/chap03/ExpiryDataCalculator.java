package chap03;

import java.time.LocalDate;

public class ExpiryDataCalculator {
    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
        // return LocalDate.of(2019,4,1);  일반화 전
        return billingDate.plusMonths(1);

    }
}

