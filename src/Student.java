import java.util.Scanner;

public class Student {
    Scanner scan=new Scanner(System.in);
    String studentName,enrollmentNumber;
    String libID;
    int[] issuedBookID={0,0,0};
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
    void displayOneStudent() {
        System.out.println("Id : "+libID+"\nEnrollment Number : "+enrollmentNumber+"\nName : "+studentName);
        System.out.println();
        System.out.println("Issued Book ID");
        int count=0;
        for(int i=0;i<3;i++) {
            if(issuedBookID[i]!=0) {
                System.out.println(issuedBookID[i]);
                count++;
            }
        }
        if(count==0) {
            System.out.println("None");
        }
    }
    int count(){
        int countIssuedBook=0;
        for(int i=0;i<3;i++) {
            if(issuedBookID[i]!=0) {
                countIssuedBook++;
            }
        }
        return (countIssuedBook);
    }
    void issueBook(int id) {
        for(int i=0;i<3;i++) {
            if(issuedBookID[i]==0) {
                issuedBookID[i]=id;
                break;
            }
        }
    }
    boolean checkBook(int id) {
        for(int i=0;i<3;i++) {
            if(issuedBookID[i]==id) {
                return  true;
            }
        }
        return false;
    }
    void returnBook(int id) {
        for(int i=0;i<3;i++) {
            if(issuedBookID[i]==id) {
                issuedBookID[i]=0;
                break;
            }
        }
    }
}