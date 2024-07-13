package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    LocalDate calculateExpiryDate(PayData data) {
        // return LocalDate.of(2019,02,03);
        // return billingDate.plusMonths(1);
        if (data.getFirstBillingDate() != null) {
            LocalDate candidateExp = data.getBillingDate().plusMonths(1);
            if (data.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {
                return candidateExp.withDayOfMonth(data.getFirstBillingDate().getDayOfMonth());
            }
//            if (data.getFirstBillingDate().equals(LocalDate.of(2019, 1, 31))) {
//                return LocalDate.of(2019, 3, 31);
//            }
        }
        return data.getBillingDate().plusMonths(1);

    }
}
