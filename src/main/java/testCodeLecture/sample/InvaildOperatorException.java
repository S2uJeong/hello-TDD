package testCodeLecture.sample;

public class InvaildOperatorException extends RuntimeException {
    public InvaildOperatorException() {
        super("Invaild operator, you need to choose one of (+,-,*,/)");
    }
}
