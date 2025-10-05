//Encapsulation is the concept of hiding the internal details of object and exposes only the necessary
// parts. It protects the objects data from directly calls into the another classes.
// It is achieved by primarily private the data and then uses getters and setters.

class Maida{
    private String name;
    private int age;


    public String getName()
    {
        return name;

    }
    public  void setName(String name)
    {
        this.name = name;

    }
    public int getAge()
    {
        return age;
    }
    public void setAge(int age )
    {
        if (age > 0)
        {
            this.age = age;
        }
        else {
            System.out.println("Invalid age");
        }
    }


}
public class Encapsulation {
    public static void main(String[] args) {
        Maida person = new Maida();

        person.setName("John");

        person.setAge(18);
        System.out.println("Enter the name:");
        System.out.println(person.getName());
        System.out.println("Enter the age:");
        System.out.println(person.getAge());
    }
}
