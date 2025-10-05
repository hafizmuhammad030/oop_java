// Polymorphism Example

// polymorphism is a greek word having same object with different behaviour.
// Types of polymorphism are:
// Compile Time polymorphism And Run Time polymorphism.
// Method Overloading:
// It is when a class contains more than one type of method having same name of object and different
// type of parameters is called method overloading.


class A{
    public static void add()
    {
        int a = 20, b = 30;
        int c = a + b;
        System.out.println(c);

    }

    public void add (int x, int y)
    {
        int v;
         v= x + y;
        System.out.println(v);

    }
    public void add (double g, int u)
    {
        double f;
          f = g + u;
        System.out.println(f);

    }
    public static void main(String [] args)
    {
        A Muhammad = new A();
        System.out.println("Enter the add function:");
        Muhammad.add();

        Muhammad.add(2,8);
        Muhammad.add(3.4,8);

        
    }



}
