import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

class Student{
     String name;
     String rollNo;
     String course;
     double CGPA;


    public Student(String name, String rollNo, String course, double CGPA) {
        this.name = name;
        this.rollNo = rollNo;
        this.course = course;
        this.CGPA = CGPA;
    }
    public void display()
    {
        System.out.println("Name:" + name + "rollNo:" + rollNo + "course:" + course + "cgpa" + CGPA);
    }
}
public class Main{
    public static void main(String [] args) {
        LinkedList<Student> students = new LinkedList<>();

        students.addFirst(new Student("Bob", "123", "sdgd", 2.4));
        students.addLast(new Student("alice", "321", "ffef", 2.9));

        students.removeFirst();
        students.removeLast();

        students.addFirst(new Student("maida", "456", "dbdfsb", 4.4));
        students.addLast(new Student("fatima", "432", "fdgfg", 1.9));


        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).rollNo.equals("456")) {
                students.remove(i);
                break;
            }
        }
        for (Student s : students) {
            if (s.rollNo.equals("456")) {
                s.CGPA = 2.5;
            }
        }
        for (Student s : students) {
            if (s.rollNo.equals("456")) {
                s.display();
            }
        }
        ListIterator<Student> iterator = students.listIterator();
        System.out.println("In forward direction:");
        while(iterator.hasNext())
        {
            iterator.next().display();
        }

        System.out.println("In backward direction");
        {
            while(iterator.hasPrevious()){
                iterator.previous().display();
            }
        }


    }

}