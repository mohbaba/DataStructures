package FireDrillTests;

import FireDrill.TaskThree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TaskThreeTest {
    @Test
    public void testFunctionReturnsHighestOccurringNumber(){
        TaskThree task = new TaskThree();
        int[] user_input = {1,2,2,3,4,2};
        int[] expected = {3,2};
        assertArrayEquals(expected, task.getHighestOccurringNumber(user_input))
    }
}
