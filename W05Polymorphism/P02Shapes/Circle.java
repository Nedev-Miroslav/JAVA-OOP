package W05Polymorphism.P02Shapes;

public class Circle extends Shape {
    private Double radius;

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Circle(Double radius) {
        this.setRadius(radius);
        this.calculatePerimeter();
        this.calculateArea();
    }

    public final Double getRadius() {
        return radius;
    }


    @Override
    protected Double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    protected Double calculateArea() {
        return Math.PI * radius * radius;
    }

}
