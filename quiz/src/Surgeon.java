public class Surgeon extends Doctor{
    String operatingRoom;
    @Override
    public void login(){
        System.out.println( "Surgeon logged in.");
    }
    public void performSurgery()
    {
        System.out.println("Surgery performed in Operating Room.");
    }

}
