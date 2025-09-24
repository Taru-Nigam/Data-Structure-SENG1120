public class Rectangle extends AbstractShape {
    private double length, width;

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double area(){
        return length * width;
    }
    public double perimeter(){
        return 2*(length+width);
    }
    public String getName(){
        return "Rectangle";
    }
}
