package hospital.details;
import hospital.Patient;

 public class Outpatient extends Patient{

     public Outpatient(String name, int age, String medicalHistory, String contactNumber) {
         super(name, age, medicalHistory, contactNumber);

     }
     public  void displayOutpatientDetails(){

         displayDetails();
     }


 }
