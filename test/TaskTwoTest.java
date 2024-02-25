import FireDrill.TaskTwo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskTwoTest {
    @Test
    public void testFunctionToReturnAge(){
        String input = "12/12/2022";
        int expectedOutput = 1;
        assertEquals(expectedOutput, TaskTwo.calculateAge(input));
    }
}
