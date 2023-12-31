package W05Polymorphism.P02Shapes;

public abstract class Shape {


    private Double perimeter;
    private Double area;



    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    public Double getPerimeter() {
        return perimeter;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public Double getArea() {
        return area;
    }

    protected abstract Double calculatePerimeter();
    protected abstract Double calculateArea();


}
