public abstract class AbstractShape implements Shape{
    public abstract String getName();
    public void display(){
        System.out.println("Area: " + area());
        System.out.println("Perimeter: "+ perimeter());
    }
}
