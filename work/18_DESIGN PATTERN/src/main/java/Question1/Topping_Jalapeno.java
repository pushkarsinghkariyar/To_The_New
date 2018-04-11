package Question1;

public class Topping_Jalapeno extends Topping_Decorator {
    Pizza pizza;

    public Topping_Jalapeno(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDesc() {
        return pizza.getDesc()+" Jalapeno";
    }

    @Override
    public int getcost() {
        return (70+pizza.getcost());
    }
}
