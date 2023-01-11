import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTest {

    String animalKind;
    List<String> expectedResultFood;

    public AnimalTest(String animalKind, List<String> expectedResultFood) {
        this.animalKind = animalKind;
        this.expectedResultFood = expectedResultFood;
    }

    @Test
    public void getFood_validKind() throws Exception {
        Animal animal = new Animal();
        List<String> resultFood = animal.getFood(animalKind);
        assertEquals(expectedResultFood, resultFood);
    }

    @Test(expected = Exception.class)
    public void getFood_invalidKind() throws Exception {
        Animal animal = new Animal();
        List<String> resultFood = animal.getFood("unknownType");
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Test
    public void getFamilyTest() {
        Animal animal = new Animal();
        String familyText = animal.getFamily();
        assertEquals(
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", familyText
        );
    }
}
