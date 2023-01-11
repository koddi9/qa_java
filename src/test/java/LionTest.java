import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void lionInit_validMaleSex() throws Exception {
        String sex = "Самец";
        Lion lion = new Lion(feline, sex);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void lionInit_validFemaleSex() throws Exception {
        String sex = "Самка";
        Lion lion = new Lion(feline, sex);
        assertFalse(lion.doesHaveMane());
    }

    @Test(expected = Exception.class)
    public void lionInit_invalidSex_throwsException() throws Exception {
        String sex = "invalidSex";
        Lion lion = new Lion(feline, sex);
    }

    @Test
    public void getFoodTest() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(Collections.emptyList());
        Lion lion = new Lion(feline, "Самка");
        List<String> food = lion.getFood();
        assertTrue(food.isEmpty());
        verify(feline,times(1)).getFood("Хищник");
    }

    @Test
    public void getKittensTest() throws Exception {
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, "Самка");
        int kittensCount = lion.getKittens();
        assertEquals(1, kittensCount);
        verify(feline,times(1)).getKittens();
    }
}
