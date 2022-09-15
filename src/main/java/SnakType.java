public enum SnakType {

    COLA(100, "Cola", 3333),
    CRISP(50, "Crisp", 6666),
    SWEET(65, "Sweet", 9999);

    private int value;
    private String name;
    private int code;


    SnakType(int value, String name, int code){
        this.value = value;
        this.name = name;
        this.code = code;
    }

    public int getValue(){
        return this.value;
    }

    public String getName(){
        return this.name;
    }

    public int getCode() {
        return code;
    }
}
