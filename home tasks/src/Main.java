class Muhammad {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {
        Muhammad main = new Muhammad();

        main.setName("Alice");
        main.setAge(18);

        System.out.println("Name: " + main.getName());
        System.out.println("Age: " + main.getAge());
}
}