package P;

 class teacher extends person  {
    private int salary;
    private String experience;

     public teacher(String name, int age, String gender, int salary, String experience) {
         super(name, age, gender);
         this.salary = salary;
         this.experience = experience;
     }
 }
