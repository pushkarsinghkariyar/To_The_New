package Question1;

public class Margherita extends Pizza {

    public Margherita() {desc="Margherita";
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public int getcost() {
        return 300;
    }
}
