public class Circle extends AbstractShape{
    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double area(){
        return Math.PI*radius*radius;
    }

    public double perimeter(){
        return Math.PI*2*radius;
    }
    public String getName(){
        return "Circle";
    }
}
