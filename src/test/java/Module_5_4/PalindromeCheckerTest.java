package Module_5_4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeCheckerTest {
    @Test
    public void testIsPalindromeWithValidPalindromes() {
        PalindromeChecker checker = new PalindromeChecker();

        assertTrue(checker.isPalindrome("radar"));
        assertTrue(checker.isPalindrome("A man, a plan, a canal, Panama"));
        assertTrue(checker.isPalindrome("Was it a car or a cat I saw?"));
        assertTrue(checker.isPalindrome("Madam, in Eden, I'm Adam"));
    }

    @Test
    public void testIsPalindromeWithInvalidPalindromes() {
        PalindromeChecker checker = new PalindromeChecker();

        assertFalse(checker.isPalindrome("hello"));
        assertFalse(checker.isPalindrome("metropolia"));
        assertFalse(checker.isPalindrome("Palindrome"));
    }

    @Test
    public void testIsPalindromeWithEmptyString() {
        PalindromeChecker checker = new PalindromeChecker();

        assertTrue(checker.isPalindrome(""));
    }
}
