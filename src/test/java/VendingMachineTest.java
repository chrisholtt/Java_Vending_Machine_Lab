import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class VendingMachineTest {
    VendingMachine vendingMachine;

    Coin oneP;
    Coin twoP;
    Coin fiveP;
    Coin tenP;
    Coin twentyP;
    Coin fiftyP;
    Coin onePound;
    Coin twoPound;
    Snack cola;
    Snack crisp;
    ArrayList<Coin> coins;



    @Before
    public void setUp(){
        vendingMachine = new VendingMachine(0);
        oneP =  new Coin(CoinType.ONEP);
        twoP = new Coin(CoinType.TWOP);
        fiveP = new Coin(CoinType.FIVEP);
        tenP = new Coin(CoinType.TENP);
        twentyP = new Coin(CoinType.TWENTYP);
        fiftyP = new Coin(CoinType.FIFTYP);
        onePound = new Coin(CoinType.ONEPOUND);
        twoPound = new Coin(CoinType.TWOPOUND);
        cola = new Snack(SnakType.COLA);
        crisp = new Snack(SnakType.CRISP);
        coins = new ArrayList<>();
    }

    @Test
    public void acceptsValidCoins(){
        vendingMachine.insertCoin(twoPound);
        assertEquals(200, vendingMachine.getinsertedMoney());
    }


    @Test
    public void acceptsLotsOfCoins(){
        vendingMachine.insertCoin(oneP);
        vendingMachine.insertCoin(onePound);
        vendingMachine.insertCoin(tenP);
        vendingMachine.insertCoin(twentyP);
        assertEquals(130, vendingMachine.getinsertedMoney());
    }

    @Test
    public void canAddSnack(){
        vendingMachine.insertSnack(cola);
        assertEquals(new Integer(1), vendingMachine.getStock());
    }


    @Test
    public void insertedMoneyIsReducedAfterPurchase(){
        vendingMachine.insertSnack(cola);
        vendingMachine.insertCoin(twoPound);
        vendingMachine.buySnack(cola);
        assertEquals(100, vendingMachine.getinsertedMoney());
    }

    @Test
    public void canGetInsertedMoneyBack(){
        vendingMachine.insertCoin(twoPound);
        assertEquals(200, vendingMachine.change());
    }

    @Test
    public void snackStockDecreasesWhenPurchased(){
        vendingMachine.insertSnack(cola);
        vendingMachine.insertCoin(onePound);
        vendingMachine.buySnack(cola);
        assertEquals(new Integer(0), vendingMachine.getStock());
    }

    @Test
    public void canBuySnackWithCode(){
        vendingMachine.insertSnack(cola);
        vendingMachine.insertCoin(twoPound);
        vendingMachine.insertCode(3333);
        assertEquals(new Integer(0), vendingMachine.getStock());
    }

    @Test
    public void doesNotSwallowTheMoney(){
        vendingMachine.insertSnack(cola);
        vendingMachine.insertCoin(twoPound);
        vendingMachine.insertCode(3333);
        assertEquals(100, vendingMachine.getMoney());
    }

    @Test
    public void canReturnCoins(){
        assertFalse(vendingMachine.giveChange(215).isEmpty());
    }

    @Test
    public void returnsInsertedCoins(){
        vendingMachine.insertCoin(twoPound);
        vendingMachine.insertCoin(fiftyP);
        coins.add(twoPound);
        coins.add(fiftyP);
        assertEquals(coins, vendingMachine.returnCoins());
    }







}
