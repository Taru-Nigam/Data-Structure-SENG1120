public class Person {
    private String name;
    private int age;

    public Person(){
        this.name = "Unknown";
        this.age = 0;
    }

    public Person(String name){
        this.name = name;
        this.age = 0;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("Alice");
        Person p3 = new Person("Bob", 20);

        System.out.println("Name: "+p1.getName() + ", Age: " +p1.getAge());
        System.out.println("Name: "+p2.getName() +  ", Age: " +p3.getAge());
        System.out.println("Name: "+p3.getName() +  ", Age: " +p3.getAge());
    }
}
