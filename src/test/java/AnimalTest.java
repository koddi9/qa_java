import com.example.Animal;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AnimalTest {

    @Test(expected = Exception.class)
    public void getFoodInvalidKind() throws Exception {
        Animal animal = new Animal();
        List<String> resultFood = animal.getFood("unknownType");
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
