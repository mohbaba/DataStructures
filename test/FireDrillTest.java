import FireDrill.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class FireDrillTest {
    @Test
    public void inputEvenNumberArray_OutputsBinaryArrayTest(){
        int[] input = {4,5,8,8,8,2,9};
        int[] expected = {0,1,0,0,0,0,1};

        assertArrayEquals(expected,Task.convertToBinary(input));
    }

    @Test
    public void inputEvenNumberArray_OutputsBooleanArrayTest(){
        int[] input = {4,5,8,8,8,2,9};
        boolean[] expected = {false,true,false,false,false,false,true};

        assertArrayEquals(expected,Task.convertToBoolean(input));
    }
    @Test
    public void inputo(){

        int[] expected = {0,0,0,0,0,0,0,0,0,0};

        assertArrayEquals(expected,Task.convertToBoolean());
    }
}
