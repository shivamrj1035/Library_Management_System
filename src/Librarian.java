public class Librarian {
    String password,fullName,librarianId,age;
    boolean access;
    Librarian(String fullName,String password,String age) {
        this.fullName=fullName;
        this.password=password;
        this.age=age;
        createLibrarianID();
    }
    Librarian(){
        //just testing comment by shivam
        //do nothing constructor
    }
    void signUp() {
        // To signup
        System.out.print("Enter Full Name : ");
        fullName=Library.scan.nextLine();
        System.out.print("Enter Age : ");
        age=Library.scan.nextLine();
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
        // To take password as input and verify it
        String pass;
        for(;;) {
            System.out.print("Enter Password : ");
            pass =Library.scan.nextLine();
            int countDigit=0,countSpecial=0,countLowercase=0,countUppercase=0;
            for(int i=0;i<pass.length();i++) {
                if(pass.charAt(i)>='0' && pass.charAt(i)<='9') {
                    countDigit++;
                } else if (pass.charAt(i)>='a' && pass.charAt(i)<='z') {
                    countLowercase++;
                } else if (pass.charAt(i)>='A' && pass.charAt(i)<='Z') {
                    countUppercase++;
                } else {
                    countSpecial++;
                }
            }
            if(pass.length()>=8 && countDigit>=1 && countLowercase>=1 && countUppercase>=1 && countSpecial >=1) {
                break;
            } else {
                System.out.println("""
                        Please enter a password having :-
                        --> Minimum length 8
                        --> Includes at least one lowercase letter
                        --> Includes at least one Uppercase letter
                        --> Includes at least one number
                        --> Includes at least one special character

                        re-enter password""");
            }
        }
        System.out.print("Confirm Password : ");
        String confirmPass=Library.scan.nextLine();
        if(pass.equals(confirmPass)){
            password=pass;
        } else {
            System.out.println("Password and confirm password don't match\nre-enter password");
            enterPassword();
        }
    }
    void createLibrarianID() {
        // Create a user id for librarian
        String[] name=fullName.split(" ");
        librarianId=name[0]+"@";
        librarianId=librarianId.concat(age);
    }
    void login(String enteredUserId,String enteredPassword) {
        // To sign in userid
        if(enteredUserId.equals(librarianId)&&enteredPassword.equals(password)) {
            System.out.println("You have successfully signed in");
            access=true;
        } else {
            access=false;
        }
    }

    void display() {
        // To display all signed up Librarians
        System.out.print(librarianId);
        idSpace();
        System.out.print(fullName);
        nameSpace();
        System.out.print(age+"\n");
    }
    // Adding some extra space for better looks
    void idSpace(){
        int space=15-librarianId.length();
        if(space<0){
            System.out.print("     ");
        } else {
            int i = 0;
            while (i < space) {
                System.out.print(" ");
                i++;
            }
        }
    }
    void nameSpace(){
        int space=30-fullName.length();
        if(space<0){
            System.out.print("     ");
        } else {
            int i = 0;
            while (i < space) {
                System.out.print(" ");
                i++;
            }
        }
    }
    void header() {
        //Label used when we want to display all librarians
        System.out.println("Librarian ID   Librarian Name               Librarian Age");
    }
}
