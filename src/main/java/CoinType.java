public enum CoinType {

    TWOPOUND(200),
    ONEPOUND(100),
    FIFTYP(50),
    TWENTYP(20),
    TENP(10),
    FIVEP(5),
    TWOP(2),
    ONEP(1);

    private final int value;

    CoinType(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
