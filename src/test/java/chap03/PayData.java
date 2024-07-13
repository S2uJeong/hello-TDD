package chap03;

import java.time.LocalDate;

public class PayData {
    private LocalDate billingDate;
    private int payAmount;
    private LocalDate firstBillingDate;

    public PayData() {
    }

    public PayData(LocalDate billingDate, LocalDate firstBillingDate, int payAmount) {
        this.billingDate = billingDate;
        this.firstBillingDate = firstBillingDate;
        this.payAmount = payAmount;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PayData data = new PayData();

        public PayData build() {
            return data;
        }
        public Builder billingDate(LocalDate billingDate) {
            data.billingDate = billingDate;
            return this;
        }

        public Builder payAmount(int payAmount) {
            data.payAmount = payAmount;
            return this;
        }
        public Builder firstBillingDate(LocalDate firstBillingDate) {
            data.firstBillingDate = firstBillingDate;
            return this;
        }
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public LocalDate getFirstBillingDate() {
        return firstBillingDate;
    }
}
