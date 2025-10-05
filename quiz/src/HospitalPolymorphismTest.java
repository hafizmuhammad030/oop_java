public class HospitalPolymorphismTest {

    public static void main(String[] args) {
        // Create objects of Doctor and Surgeon
        Employee employee = new Employee();
        Doctor doctor = new Doctor();
        Surgeon surgeon = new Surgeon();

        // Demonstrating polymorphism by assigning references
        employee = doctor;
        employee.login();  // Outputs: Doctor logged in.

        employee = surgeon;
        employee.login();  // Outputs: Surgeon logged in.


        // Using instanceof to call child-specific method
        if (employee instanceof Surgeon) { 
            Surgeon s = (Surgeon) employee;
            s.performSurgery();  // Outputs: Surgery performed in Operating Room.
        }
    }
}
