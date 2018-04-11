package Question1;

public class Topping_Capsicum extends Topping_Decorator {
    Pizza pizza;

    public Topping_Capsicum(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDesc() {
        return pizza.getDesc()+" Capsicum";
    }

    @Override
    public int getcost() {
        return (80+pizza.getcost());
    }
}
