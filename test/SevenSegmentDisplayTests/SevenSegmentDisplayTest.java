package SevenSegmentDisplayTests;

import org.junit.jupiter.api.Test;

import SevenSegmentDisplay.SevenSegmentDisplay;

import static org.junit.jupiter.api.Assertions.*;

public class SevenSegmentDisplayTest {

    @Test
    public void testTheLengthOfInputMustBeEightCharacters__ThrowsExceptionIfNot(){
        String input = "1234567890";
        assertThrows(IllegalArgumentException.class,()->SevenSegmentDisplay.checkInputLength(input));

    }

    @Test
    public void testTheInputCanOnlyBeZerosAndOnes(){
        String input = "1234567890";
        assertThrows(IllegalArgumentException.class,()->SevenSegmentDisplay.checkInput(input));
    }

    @Test
    public void testSevenSegmentIsOn(){
        String input = "11111111";
        assertTrue(SevenSegmentDisplay.isOn(input));
    }

    @Test
    public void testSevenSegmentIsOff(){
        String input = "11111110";
         assertFalse(SevenSegmentDisplay.isOn(input));
    }
}