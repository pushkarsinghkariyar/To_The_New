package Question1;

public class Application {
    public static void main(String[] args) {
        Pizza mypizza = new Chicken_Fiesta();
        mypizza = new Topping_Barbeque(mypizza);
        mypizza = new Topping_Jalapeno(mypizza);
        System.out.println(mypizza.getDesc()+". The cost of the pizza is- "+ mypizza.getcost());
    }
}
