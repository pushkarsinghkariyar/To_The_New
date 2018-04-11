package Question1;

public class Chicken_Fiesta extends Pizza {

    public Chicken_Fiesta() {desc="Chicken Fiesta";
    }

    @Override
    public String getDesc() {
        return desc;
    }

    @Override
    public int getcost() {
        return 400;
    }
}
