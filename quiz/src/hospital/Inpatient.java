package hospital;

 public class Inpatient extends Patient {
     public int wardNumber;
     protected String admissionDate;

     public Inpatient(String name, int age, String medicalHistory, String contactNumber, int wardNumber, String admissionDate) {
         super(name, age, medicalHistory, contactNumber);
         this.wardNumber = wardNumber;
         this.admissionDate = admissionDate;
     }
     public void displayInpatientDetails(){

         System.out.println("Ward Number:" + wardNumber);
         System.out.println("Admission date:" + admissionDate);



     }


 }
