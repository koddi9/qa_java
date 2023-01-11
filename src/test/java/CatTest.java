import com.example.Cat;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Predator predator;

    @Test
    public void getFamilyTest() {
        Cat cat = new Cat(predator);
        String catSound = cat.getSound();
        assertEquals(
                "Мяу", catSound
        );
    }

    @Test
    public void getFoodTest() throws Exception {
        when(predator.eatMeat()).thenReturn(Collections.emptyList());
        Cat cat = new Cat(predator);
        List<String> food = cat.getFood();
        assertTrue(food.isEmpty());
        verify(predator, times(1)).eatMeat();
    }
}

