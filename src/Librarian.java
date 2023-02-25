import java.util.Scanner;

public class Librarian {
    Scanner scan=new Scanner(System.in);
    String password,fullName,librarianId,age;
    boolean access;
    Librarian(String fullName,String password,String age) {
        this.fullName=fullName;
        this.password=password;
        this.age=age;
        createLibrarianID();
    }
    Librarian(){
        //do nothing constructor
    }
    void signUp() {
        System.out.print("Enter Full Name : ");
        fullName=scan.nextLine();
        System.out.print("Enter Age : ");
        age=scan.nextLine();
        int temp_age=Integer.parseInt(age);
        if(temp_age<=20) {
            System.out.println("You age must be above 20 to sign up");
            return;
        }
        enterPassword();
        createLibrarianID();
        System.out.println("You have successfully Signed Up \nYour login Id is : "+librarianId);
    }
    void enterPassword() {
        String pass;
        for(;;) {
            System.out.print("Enter Password : ");
            pass = scan.nextLine();
            int countDigit=0,countSpecial=0,countLowercase=0,countUppercase=0;
            for(int i=0;i<pass.length();i++) {
                if(pass.charAt(i)>='0' && pass.charAt(i)<='9') {
                    countDigit++;
                }
                else if (pass.charAt(i)>='a' && pass.charAt(i)<='z') {
                    countLowercase++;
                }
                else if (pass.charAt(i)>='A' && pass.charAt(i)<='Z') {
                    countUppercase++;
                }
                else {
                    countSpecial++;
                }
            }
            if(pass.length()>=8 && countDigit>=1 && countLowercase>=1 && countUppercase>=1 && countSpecial >=1) {
                break;
            }
            else {
                System.out.println("Please enter a password having minimum length 8 and includes at least one lowercase letter,Uppercase letter,one number and one special character");
            }
        }
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
        librarianId=name[0]+"@";
        librarianId=librarianId.concat(age);
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