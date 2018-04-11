package Question1;

public class Topping_Paneer extends Topping_Decorator {
    Pizza pizza;

    public Topping_Paneer(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDesc() {
        return pizza.getDesc()+" Paneer";
    }

    @Override
    public int getcost() {
        return (60+pizza.getcost());
    }
}
