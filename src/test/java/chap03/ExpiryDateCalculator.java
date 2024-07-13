package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
    LocalDate calculateExpiryDate(PayData data) {
        int addedMonths = data.getPayAmount() / 10_000;

        if (data.getFirstBillingDate() != null) {
            LocalDate candidateExp = data.getBillingDate().plusMonths(addedMonths);
            if (data.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()) {

                final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth(); // 후보 만료일이 속한 월의 마지막 일자


                if ( dayLenOfCandiMon < data.getFirstBillingDate().getDayOfMonth()) {
                    return candidateExp.withDayOfMonth(dayLenOfCandiMon);
                }
                return candidateExp.withDayOfMonth(data.getFirstBillingDate().getDayOfMonth());
            }

        }
        return data.getBillingDate().plusMonths(addedMonths);

    }
}