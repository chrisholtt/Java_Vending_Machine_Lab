import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private HashMap<Snack, Integer> stock;
    private int money;
    private int insertedMoney;
    private ArrayList<Coin> insertedCoins;
    private int insertedCode;

    public VendingMachine(int money) {
        this.money = money;
        this.insertedMoney = 0;
        this.insertedCoins = new ArrayList<>();
        this.stock = new HashMap<Snack, Integer>();
        this.insertedCode = 0000;
    }

    public Coin insertCoin(Coin coin){
        if (coin.getValue() == 1 || coin.getValue() == 2){
            return coin;
        } else {
            insertedCoins.add(coin);
            insertedMoney += coin.getValue();
            return null;
        }
    }

    public void insertSnack(Snack snack){
        if (stock.containsKey(snack)) {
            stock.put(snack, stock.get(snack) + 1);
        } else {
            stock.put(snack, 1);
        }
    }

    public Integer getStock() {
        Integer totalSnacks = 0;
        for(Map.Entry<Snack, Integer> set : stock.entrySet()){
            totalSnacks += set.getValue();
        }
        return totalSnacks;
    }

    public Snack buySnack(Snack snack){
        if (this.insertedMoney >= snack.getValue() ) {
            this.insertedMoney -= snack.getValue();
            this.money += snack.getValue();
            stock.put(snack, stock.get(snack) - 1);
            return snack;
        } else {
            return null;
        }
    }

    public int change(){
        return this.insertedMoney;
    }

    public ArrayList<Coin> returnCoins(){
        return this.insertedCoins;
    }

    public void insertCode(int code){
        this.insertedCode = code;
        for (Map.Entry<Snack, Integer> entry : stock.entrySet()) {
            Snack snack = entry.getKey();
            if(snack.getCode() == code){
                buySnack(snack);
            }
        }
    }

    public ArrayList<Coin> giveChange(int value){
        int currentValue = value;
        ArrayList<Coin> coins = new ArrayList<>();
        while (currentValue != 0.0){
            for(CoinType coin : CoinType.values()){
                if(coin.getValue() <= currentValue){
                    Coin a = new Coin(coin);
                    currentValue -= coin.getValue();
                    coins.add(a);
                }
            }
        }
        return coins;
    }

    public int getMoney(){
        return this.money;
    }

    public int getinsertedMoney(){
        return this.insertedMoney;
    }

}
