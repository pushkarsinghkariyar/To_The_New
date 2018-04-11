package Question4;

public class Application {

    public static void main(String[] args) {

        Street_Fighter street_fighter1=new Street_Fighter();
        street_fighter1.setJumpable(new Jump_Level_1());
        street_fighter1.setRollable(new Roll_Level_2());
        street_fighter1.roll();
        street_fighter1.jump();
        street_fighter1.kick();
        street_fighter1.punch();

        Street_Fighter streetFighter3 = new Street_Fighter();
        streetFighter3.setJumpable(new Jump_Level_1());
        streetFighter3.setRollable(new Roll_Level_2());
        streetFighter3.roll();
        streetFighter3.jump();
        streetFighter3.kick();
        streetFighter3.punch();
    }
}
