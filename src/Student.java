import java.util.Scanner;

public class Student {
    Scanner scan=new Scanner(System.in);
    String studentName,enrollmentNumber;
    String libID;
    static int serial=1001;
    Student(String studentName,String enrollmentNumber) {
        libID="S"+serial++;
        this.studentName=studentName;
        this.enrollmentNumber=enrollmentNumber;
    }
    Student() {

    }
    void registration() {
        libID="S"+serial;
        serial++;
        System.out.print("Student name : ");
        studentName=scan.nextLine();
        System.out.print("Student enrollment number : ");
        enrollmentNumber=scan.nextLine();
    }
    void displayStudent() {
        System.out.print(libID+"   ");
        System.out.print(enrollmentNumber);
        spaceEnroll();
        System.out.print(studentName+"\n");
    }
    void header() {
        System.out.println("  ID   "+"Enrollment Number     "+"  Student name");
    }
    void spaceEnroll() {
        int space=22-enrollmentNumber.length();
        if(space<0){
            System.out.print("     ");
        }
        else {
            for (int i = 0; i < space; i++) {
                System.out.print(" ");
            }
        }
    }
}

