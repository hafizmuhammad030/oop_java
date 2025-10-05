// Method Overriding:
// It is whenever we write methods in super and subclass in such a way that the method names and
// parameters are same.

class shape{

    void show(){
        System.out.println("Cant show anything");


    }


}
class demo extends shape{
    @Override
    void show ()
    {
        System.out.println("Square shape");
    }
}
class Overriding{
    public static void main(String [] args )
    {
        shape r = new demo();
        r.show();
    }
}
