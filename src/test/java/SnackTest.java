import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SnackTest {

    Snack cola;
    Snack crisp;
    Snack sweet;

    @Before
    public void before(){
        cola = new Snack(SnakType.COLA);
        crisp = new Snack(SnakType.CRISP);
        sweet = new Snack(SnakType.SWEET);
    }

    @Test
    public void getPriceOfCola(){
        assertEquals(1.00, cola.getValue(), 0.0);
    }

    @Test
    public void getPriceOfCrisp(){
        assertEquals(0.50, crisp.getValue(), 0.0);
    }

    @Test
    public void getPriceOfSweet(){
        assertEquals(0.65, sweet.getValue(), 0.0);
    }
}
