import java.util.*;

class Student {
    String name;
    int id;
    double grade;

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Name:" + name + "', ID=" + id + ", Grade=" + grade + "}";
    }
}

class StudentEnrollment {
    private LinkedList<Student> students;

    public StudentEnrollment() {
        students = new LinkedList<>();
    }


    public void enrollStudent(String name, int id, double grade)
    {
        students.add(new Student(name, id, grade));
    }


    public boolean removeStudent(int id)
    {
        for (int i = 0; i < students.size(); i++)
        {
            if (students.get(i).id == id) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }


    public Student searchStudent(String name)
    {
        for (Student student : students) {
            if (student.name.equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }


    public void sortStudents() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).name.compareToIgnoreCase(students.get(j + 1).name) > 0) {

                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }


    public Student getTopStudent() {
        if (students.isEmpty()) return null;
        Student topStudent = students.get(0);
        for (Student student : students) {
            if (student.grade > topStudent.grade) {
                topStudent = student;
            }
        }
        return topStudent;
    }


    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StudentEnrollment enrollment = new StudentEnrollment();


        enrollment.enrollStudent("Alice", 101, 88.5);
        enrollment.enrollStudent("Bob", 102, 92.0);
        enrollment.enrollStudent("Charlie", 103, 85.0);


        System.out.println("All Students:");
        enrollment.displayStudents();


        String searchName = "Bob";
        Student foundStudent = enrollment.searchStudent(searchName);
        if (foundStudent != null)
        {
            System.out.println("Found: " + foundStudent);
        } else {
            System.out.println(searchName + " not found.");
        }


        enrollment.sortStudents();
        System.out.println("\nSorted Students afterwards:");
        enrollment.displayStudents();

        Student topStudent = enrollment.getTopStudent();  
        System.out.println("\nTop Student: " + topStudent);


        enrollment.removeStudent( 102);
        System.out.println("\nStudents after removal:");
        enrollment.displayStudents();
    }
}
