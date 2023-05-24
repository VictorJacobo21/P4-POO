package vj.cardshark;

import org.junit.Test;
import static org.junit.Assert.*;

public class FueraDeRangoExceptionTest {
    
    @Test
    public void testConstructor() {
        String message = "Mensaje de prueba";
        FueraDeRangoException exception = new FueraDeRangoException(message);
        
        assertEquals(message, exception.getMessage());
    }
}
