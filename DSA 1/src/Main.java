 class Student {
    private String regNo;
    private double CGPA;


    public Student(String regNo, double CGPA) {
        this.regNo = regNo;
        this.CGPA = CGPA;
    }


    public double getCGPA() {
        return CGPA;
    }

    public String getRegNo() {
        return regNo;
    }
}


class StudentManager {
    private Student[] students;


    public StudentManager(Student[] students) {
        this.students = students;
    }


    public void selectionSort() {
        int n = students.length;
        for (int i = 0; i < n - 1; i++) {
            int smallSub = i;
            for (int j = i + 1; j < n; j++) {
                if (students[j].getCGPA() < students[smallSub].getCGPA()) {
                    smallSub = j;
                }
            }

            Student temp = students[i];
            students[i] = students[smallSub];
            students[smallSub] = temp;
        }
    }

    public int linearSearch(double value) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getCGPA() == value) {
                return i;
            }
        }
        return -1;
    }


    public int binarySearch(double value) {
        int low = 0, high = students.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (students[mid].getCGPA() == value) {
                return mid;
            } else if (students[mid].getCGPA() < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public void displayStudents() {
        for (Student student : students) {
            System.out.println(student.getRegNo() + " - " + student.getCGPA());
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("S001", 3.1), new Student("S002", 2.8), new Student("S003", 3.5),
                new Student("S004", 3.9), new Student("S005", 3.2), new Student("S006", 2.5),
                new Student("S007", 3.7), new Student("S008", 3.0), new Student("S009", 2.9),
                new Student("S010", 3.4)
        };

        StudentManager manager = new StudentManager(students);

        manager.selectionSort();
        System.out.println("Sorted Students by CGPA:");
        manager.displayStudents();


        double searchCGPA = 3.5;


        int linearIndex = manager.linearSearch(searchCGPA);
        System.out.println("Using Linear Search:");
        if (linearIndex != -1) {
            System.out.println("Student with CGPA " + searchCGPA + " found at index: " + linearIndex);
        } else {
            System.out.println("Student with CGPA " + searchCGPA + " not found.");
        }


        int binaryIndex = manager.binarySearch(searchCGPA);
        System.out.println("Using Binary Search:");
        if (binaryIndex != -1) {
            System.out.println("Student with CGPA " + searchCGPA + " found at index: " + binaryIndex);
        } else {
            System.out.println("Student with CGPA " + searchCGPA + " not found.");
        }
    }
}
