//Static block is a block that is executed only once when class is loaded into the memory.
//Used to initializes the static variables.
// executes only once.

class Static{
    static int x;
    static
    {
        x = 10;
        System.out.println("Static block executes.");
    }
    public static void main(String [] args)
    {
        System.out.println("Value of x is:" + x);

    }
}
