package Question1;

public class Peppy_Paneer extends Pizza {

    public Peppy_Paneer() {
        desc="Peppy_Paneer";
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public int getcost() {
        return 100;
    }
}
