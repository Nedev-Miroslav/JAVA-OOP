package W02ExerciseEncapsulation.P03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void buyProduct (Product product){
        if(this.money >= product.getCost()){
            products.add(product);
            money -= product.getCost();
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name + " - ");
        if (products.isEmpty()){
            sb.append("Nothing bought");
        } else {
            sb.append(String.join(", ", products.stream().map(p -> p.getName()).collect(Collectors.toList())));
        }
        return sb.toString();
    }
}
