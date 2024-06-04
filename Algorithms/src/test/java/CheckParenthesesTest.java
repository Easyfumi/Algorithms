import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.marinin.algorithmic_tasks.ValidParenthesesTask;

public class CheckParenthesesTest {
    @Test
    void testOne() {
        Assertions.assertEquals(ValidParenthesesTask.checkParentheses("(()())()"), "CORRECT");
    }
    @Test
    void testTwo() {
        Assertions.assertEquals(ValidParenthesesTask.checkParentheses("()[]{}(a)(())"), "CORRECT");
    }
    @Test
    void testThree() {
        Assertions.assertEquals(ValidParenthesesTask.checkParentheses("(()"), "INCORRECT");
    }
    @Test
    void testFour() {
        Assertions.assertEquals(ValidParenthesesTask.checkParentheses("(()(())))"), "INCORRECT");
    }
    @Test
    void testFive() {
        Assertions.assertEquals(ValidParenthesesTask.checkParentheses(""), "CORRECT");
    }
}
