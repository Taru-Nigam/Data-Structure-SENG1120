public class Triangle extends AbstractShape{
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) throws InvalidShapeException {
        if (!isValidTriangle(a,b,c)){
            throw new InvalidShapeException("Invalid Triangle Sides: " + a +", " + b +", "+ c);
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    private boolean isValidTriangle(double a, double b, double c){
        return (a+b>c)&&(a+c>b)&&(b+c>a);
    }

    @Override
    public double area(){
        double s = (a+b+c)/2.0;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    @Override
    public double perimeter(){
        return a+b+c;
    }
    @Override
    public String getName(){
        return "Triangle";
    }
}
