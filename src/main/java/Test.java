public class Test {
    public static void main(String[] args) {
        int payAmount = 130_000;
        int addedMonths = payAmount >= 100_000 ? (payAmount / 100_000) * 12 + (payAmount % 100_000) / 10_000 : payAmount / 10_000;

        System.out.println(addedMonths);
    }
}
