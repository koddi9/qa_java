import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    String animalKind;
    List<String> expectedResultFood;

    public AnimalParameterizedTest(String animalKind, List<String> expectedResultFood) {
        this.animalKind = animalKind;
        this.expectedResultFood = expectedResultFood;
    }

    @Test
    public void getFoodValidKind() throws Exception {
        Animal animal = new Animal();
        List<String> resultFood = animal.getFood(animalKind);
        assertEquals(expectedResultFood, resultFood);
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }
}
