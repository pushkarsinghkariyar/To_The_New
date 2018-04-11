package Question4;

public class Street_Fighter {

    Rollable rollable;
    Jumpable jumpable;

    public void kick(){
        System.out.println("This is Kicking Method");
    }

    public void punch(){
        System.out.println("This is punching method");
    }

    public Rollable getRollable() {
        return rollable;
    }

    public void setRollable(Rollable rollable) {
        this.rollable = rollable;
    }

    public Jumpable getJumpable() {
        return jumpable;
    }

    public void setJumpable(Jumpable jumpable) {
        this.jumpable = jumpable;
    }

    public void jump(){
        jumpable.jump();
    }

    public void roll(){
        rollable.roll();
    }
}
