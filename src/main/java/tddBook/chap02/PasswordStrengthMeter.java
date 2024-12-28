package tddBook.chap02;

public class PasswordStrengthMeter {
    public PasswordStrength meter(String s) {
        if (s == null || s.isEmpty()) return PasswordStrength.INVALID;
        boolean islengthEnough = s.length() >= 8;
        boolean isContainsNum = meetsContainingNumber(s);
        boolean isContainsUppercase = meetsContainingUppercase(s);
        if(islengthEnough && !isContainsNum && !isContainsUppercase) return PasswordStrength.WEAK;
        if (!islengthEnough) return PasswordStrength.NORMAL;
        if (!isContainsNum) return PasswordStrength.NORMAL;
        if (!isContainsUppercase) return PasswordStrength.NORMAL;
        return PasswordStrength.STRONG;
    }
    private boolean meetsContainingNumber(String s) {
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean meetsContainingUppercase(String s) {
        for (char ch : s.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }
}
