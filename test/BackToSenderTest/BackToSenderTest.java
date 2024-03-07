package BackToSenderTest;

import BackToSender.BackToSender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackToSenderTest {

    @Test
    public void testThatRiderWillBePaidAfter80SuccessfullyDeliveredPackages(){
        int numberOfParcelsDelivered = 80;
        assertEquals(45_000, BackToSender.pay(numberOfParcelsDelivered));
    }

    @Test
    public void testThatRiderWillBePaidAfter25SuccessfullyDeliveredPackages(){
        int numberOfParcelsDelivered = 25;
        assertEquals(9000, BackToSender.pay(numberOfParcelsDelivered));
    }

    @Test
    public void testThatRiderWillBePaidAfter55SuccessfullyDeliveredPackages(){
        int numberOfParcelsDelivered = 55;
        assertEquals(16_000, BackToSender.pay(numberOfParcelsDelivered));
    }

    @Test
    public void testThatRiderWillBePaidAfter65SuccessfullyDeliveredPackages(){
        int numberOfParcelsDelivered = 65;
        assertEquals(21_250, BackToSender.pay(numberOfParcelsDelivered));
    }

    @Test
    public void testThatFunctionReturnsZeroWhenNumberOfParcelsIsNegative(){
        int numberOfParcelsDelivered = -80;
        assertEquals(0, BackToSender.pay(numberOfParcelsDelivered));
    }
}
