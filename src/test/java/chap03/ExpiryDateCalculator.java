package chap03;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
    LocalDate calculateExpiryDate(PayData data) {
        int addedMonths = data.getPayAmount() >= 100_000 ? (data.getPayAmount() / 100_000) * 12 + (data.getPayAmount() % 100_000) / 10_000 : data.getPayAmount() / 10_000;
        if (data.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(data, addedMonths);
        } else {
            return data.getBillingDate().plusMonths(addedMonths);
        }
    }
    private LocalDate expiryDateUsingFirstBillingDate(PayData data, int addedMonths) {
        LocalDate candidateExp = data.getBillingDate().plusMonths(addedMonths);

        if (isSameDayOfMonth(data.getBillingDate(), candidateExp)) {
            final int dayOfFirstBilling = data.getFirstBillingDate().getDayOfMonth();
            final int dayLenOfCandiMon = lastDayOfMonth(candidateExp); // 후보 만료일이 속한 월의 마지막 일자
            if ( dayLenOfCandiMon < dayOfFirstBilling) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(dayOfFirstBilling);
        } else {
            return candidateExp;
        }
    }

    private boolean isSameDayOfMonth(LocalDate date1, LocalDate date2) {
        return date1.getDayOfMonth() == date2.getDayOfMonth();
    }

    private int lastDayOfMonth(LocalDate date) {
        return YearMonth.from(date).lengthOfMonth();
    }
}
