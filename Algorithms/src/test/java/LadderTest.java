
import org.junit.jupiter.api.Test;
import ru.marinin.Ladder;
import org.junit.jupiter.api.Assertions;

public class LadderTest {
    @Test
    void One() {
        Assertions.assertEquals(Ladder.checkCount(new int[]{1, 2}, 2), 3);
    }
    @Test
    void Two() {
        Assertions.assertEquals(Ladder.checkCount(new int[]{2, -1}, 2), 1);
    }
    @Test
    void Three() {
        Assertions.assertEquals(Ladder.checkCount(new int[]{-1, 2, 1}, 3), 3);
    }
    @Test
    void Four() {
        Assertions.assertEquals(Ladder.checkCount(new int[]{1, -2, -4, 8}, 4), 7);
    }
    @Test
    void Five() {
        Assertions.assertEquals(Ladder.checkCount(new int[]{1, -4, -2, 8}, 4), 7);
    }
    @Test
    void Six() {
        Assertions.assertEquals(Ladder.checkCount(new int[]{1}, 1), 1);
    }
    @Test
    void Seven() {
        Assertions.assertEquals(Ladder.checkCount(new int[]{-1,-2,-3,-4}, 4), -6);
    }

}
