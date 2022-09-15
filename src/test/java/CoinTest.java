import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    Coin fiveP;
    Coin twoP;
    Coin poundCoin;

    @Before
    public void before(){
        fiveP = new Coin(CoinType.FIVEP);
        twoP = new Coin(CoinType.TWOP);
        poundCoin = new Coin(CoinType.ONEPOUND);
    }

    @Test
    public void fivePIsFiveP(){
        assertEquals(0.05, fiveP.getValue(), 0.0);
    }

    @Test
    public void twoPIsTwoP(){
        assertEquals(0.02, twoP.getValue(), 0.0);
    }

    @Test
    public void onePoundIsOnePound(){
        assertEquals(1.0, poundCoin.getValue(), 0.0);
    }


}
