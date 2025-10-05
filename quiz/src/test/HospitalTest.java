package test;
import hospital.Patient;
import hospital.Inpatient;
import hospital.details.Outpatient;

public class HospitalTest {
    public static void main(String[] args) {
        Patient patient = new Patient("Muhammad", 18, "clear", "03214430159");
        Inpatient inpatient = new Inpatient("Muhammad", 18, "clear", "03214430159", 18, "20");
        inpatient.displayInpatientDetails();
        Outpatient outpatient = new Outpatient("Muhammad", 18, "clear", "03214430159");
        outpatient.displayOutpatientDetails();


    }
}
