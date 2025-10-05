package hospital;

public class Patient{
    protected String name;
    int age;
    public String medicalHistory;
    private String contactNumber;

    public Patient(String name, int age, String medicalHistory, String contactNumber) {
        this.name = name;
        this.age = age;
        this.medicalHistory = medicalHistory;
        this.contactNumber = contactNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void displayDetails(){

        System.out.println("Name:" + name);
        System.out.println("Age:" + age);
        System.out.println("Medical History:" + medicalHistory );
        System.out.println("Contact Number" + contactNumber);


    }

}
