package W05Polymorphism.P02Shapes;

public class Rectangle extends Shape {

    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        this.calculatePerimeter();
        this.calculateArea();
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    protected Double calculatePerimeter() {
       return this.height * 2 + this.width * 2;
    }

    @Override
    protected Double calculateArea() {
        return this.height * this.width;
    }
}

