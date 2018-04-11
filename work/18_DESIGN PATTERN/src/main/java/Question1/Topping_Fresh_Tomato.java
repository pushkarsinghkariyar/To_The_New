package Question1;

public class Topping_Fresh_Tomato extends Topping_Decorator {
    Pizza pizza;

    public Topping_Fresh_Tomato(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDesc() {
        return pizza.getDesc() + " Fresh Tomato";
    }

    @Override
    public int getcost() {
        return (50+ pizza.getcost());
    }
}
