import com.example.Feline;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FelineTest {
    Feline feline;

    @Before
    public void init() {
        feline = new Feline();
    }

    @Test
    public void getFamilyTest() {
        String family = feline.getFamily();
        assertEquals("Кошачьи", family);
    }

    @Test
    public void getKittensTest() {
        int kittensCount = feline.getKittens();
        assertEquals(1, kittensCount);
    }

    @Test
    public void getKittensTest_randomCount() {
        int kittensCount = feline.getKittens(11);
        assertEquals(11, kittensCount);
    }
}
