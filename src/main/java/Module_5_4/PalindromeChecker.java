package Module_5_4;

public class PalindromeChecker {
    public boolean isPalindrome(String str) {
        str = str.replaceAll("\\s+", "").toLowerCase();
        str = str.replaceAll(",", "");
        str = str.replace("?", "");
        str = str.replace("'", "");

        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
