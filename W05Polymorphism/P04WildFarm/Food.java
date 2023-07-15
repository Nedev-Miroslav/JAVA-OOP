package W05Polymorphism.P04WildFarm;

public abstract class Food {
    private Integer quantity;;

    public Integer getQuantity() {
        return quantity;
    }

    protected void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Food(Integer quantity) {
       this.setQuantity(quantity);
    }
}
