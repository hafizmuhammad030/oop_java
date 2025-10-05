import java.sql.SQLOutput;

class Person {
    private String name;
    private int age;

    Person()
    {
        name = "Unknown";
        age = 0;


    }
     Person(String name, int age)
     {
         this.name = name;
         this.age = age;


     }

    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("Alice", 18);

        System.out.println("Person 1:" + p1.name + ",Age:" + p1.age);
        System.out.println("Person 2:" + p2.name + ",Age:" + p2.age);


    }



}
