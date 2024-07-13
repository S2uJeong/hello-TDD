package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    LocalDate calculateExpiryDate(PayData data) {
        // return LocalDate.of(2019,02,03);
        // return billingDate.plusMonths(1);
        return data.getBillingDate().plusMonths(1);

    }
}
