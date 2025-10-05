public class Doctor extends Employee {
    String specialization;

    @Override

    public void login(){
        System.out.println( "Doctor logged in.");
    }
}
