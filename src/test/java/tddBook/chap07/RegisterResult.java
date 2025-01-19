package tddBook.chap07;

public class RegisterResult {
    private CardValidity validity;

    public static RegisterResult success() {
        return null;
    }

    public CardValidity getValidity() {
        return validity;
    }

    public RegisterResult() {
    }

    public static RegisterResult error(CardValidity validity) {
        return new RegisterResult();
    }
}
