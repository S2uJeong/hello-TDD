package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
        // return LocalDate.of(2019,02,03);
        return billingDate.plusMonths(1); //

    }
}
