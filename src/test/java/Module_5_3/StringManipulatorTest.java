package Module_5_3;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StringManipulatorTest {

    @Test
    public void testConcatenate() {
        StringManipulator manipulator = new StringManipulator();
        String result = manipulator.concatenate("Hello", "World");
        assertEquals("HelloWorld", result);
    }

    @Test
    public void testFindLength() {
        StringManipulator manipulator = new StringManipulator();
        int length = manipulator.findLength("JUnit");
        assertEquals(5, length);
    }

    @Test
    public void testConvertToUpperCase() {
        StringManipulator manipulator = new StringManipulator();
        String result = manipulator.convertToUpperCase("java");
        assertEquals("JAVA", result);
    }

    @Test
    public void testConvertToLowerCase() {
        StringManipulator manipulator = new StringManipulator();
        String result = manipulator.convertToLowerCase("JUnit");
        assertEquals("junit", result);
    }

    @Test
    public void testContainsSubstring() {
        StringManipulator manipulator = new StringManipulator();
        boolean contains = manipulator.containsSubstring("Hello, World!", "World");
        assertTrue(contains);

        contains = manipulator.containsSubstring("Hello, World!", "Java");
        assertFalse(contains);
    }
}
