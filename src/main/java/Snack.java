public class Snack {
    private SnakType snack;

    public Snack(SnakType snack) {
        this.snack = snack;
    }

    public int getValue(){
        return this.snack.getValue();
    }

    public String  getName(){
        return snack.getName();
    }

    public int getCode(){
        return snack.getCode();
    }

}
