import java.util.Scanner;

public class Librarian {
    Scanner scan=new Scanner(System.in);
    String password,fullName,librarianId,age;
    boolean access;
    Librarian(String librarianId,String fullName,String password,String age) {
        this.librarianId=librarianId;
        this.fullName=fullName;
        this.password=password;
        this.age=age;
    }
    Librarian(){

    }
    void signUp() {
        System.out.print("Enter Full Name : ");
        fullName=scan.nextLine();
        System.out.print("Enter Age : ");
        age=scan.nextLine();
        enterPassword();
        createLibrarianID();
        System.out.println("You have successfully Signed Up \nYour login Id is : "+librarianId);
    }
    void enterPassword() {
        System.out.print("Enter Password : ");
        String pass=scan.nextLine();
        System.out.print("Confirm Password : ");
        String confirmPass=scan.nextLine();
        if(pass.equals(confirmPass)){
            password=pass;
        }
        else {
            System.out.println("Password and confirm password don't match\nre-enter password");
            enterPassword();
        }
    }
    void createLibrarianID() {
        String[] name=fullName.split(" ");
        librarianId=name[0].concat(age);
    }
    void login(String enteredUserId,String enteredPassword) {
        if(enteredUserId.equals(librarianId)&&enteredPassword.equals(password)) {
            System.out.println("You have successfully signed in");
            access=true;
        }
        else{
            access=false;
        }
    }
}