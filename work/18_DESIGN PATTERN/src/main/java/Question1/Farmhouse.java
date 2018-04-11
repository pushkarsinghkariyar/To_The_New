package Question1;

public class Farmhouse extends Pizza {
    public Farmhouse() {
        desc="Farmhouse";
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public int getcost() {
        return 200;
    }
}
