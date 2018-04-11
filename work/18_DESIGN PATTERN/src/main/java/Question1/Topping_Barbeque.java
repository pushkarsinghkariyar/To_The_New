package Question1;

public class Topping_Barbeque extends Topping_Decorator {
    Pizza pizza;

    public Topping_Barbeque(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDesc() {
        return pizza.getDesc()+" Barbeque";
    }

    @Override
    public int getcost() {
        return (90+pizza.getcost());
    }
}
