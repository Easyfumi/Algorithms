import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.marinin.Kleptomaniac;
import ru.marinin.Main;

public class KleptomaniacTest {
    @Test
    void kleptoTest() {
        Assertions.assertEquals(Kleptomaniac.countValue(new int[]{31,35,46,49,54,79,82,93,99,99}, 100), 2);
    }
}
