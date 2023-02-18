import java.util.Scanner;

public class Library {
    Scanner scan=new Scanner(System.in);
    int choice,count;
    Librarian[] librarians=new Librarian[5];
    S
    Operations operations = new Operations();
    Library() {
        librarians[0]=new Librarian("John20","John Abraham","John20","20");
        for(int a=1;a<5;a++) {
            librarians[a]=new Librarian();
        }
    }
    static  int i=1;
    boolean access=true;
    void options() {
        System.out.println("***************************************************************");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("Press 1 Sign Up.");
        System.out.println("Press 2 Login.");
        System.out.println("***************************************************************");
        choice=scan.nextInt();
        scan.nextLine();
        switch (choice){
            case 0 : return;
            case 1 : signUp();
                options();
                break;
            case 2 : login();
                break;
            default: System.out.println("Invalid Input\nPress between 0 to 2");
                options();
        }
    }
    void signUp() {
        if(i==5) {
            System.out.println("Maximum Accounts Created");
        }
        else {
            librarians[i].signUp();
            i++;
        }
    }
    void login() {
        System.out.print("Enter User ID : ");
        String enteredUserId = scan.nextLine();
        System.out.print("Enter Password : ");
        String enteredPassword = scan.nextLine();
        if (count == 2) {
            System.out.println("Account locked for 1 hour");
            access = false;
        }
        else {
            for (int i = 0; i < 5; i++) {
                if (librarians[i].librarianId == null) {
                    System.out.println("Incorrect User Id or Password");
                    count++;
                    login();
                    break;
                } else {
                    librarians[i].login(enteredUserId, enteredPassword);
                    if (librarians[i].access) {
                        access = true;
                        break;
                    } else if (i == 4) {
                        System.out.println("Incorrect User Id or Password");
                        count++;
                        login();
                    }
                }
            }
        }
    }
    void control(){
        operations.options();
        if(operations.choice==0) {
            options();
        }
        else if(operations.choice==9) {
            showLibrarians();
            control();
        }
    }
    int s;
    void showLibrarians() {
        System.out.println("Librarian ID   Librarian Name               Librarian Age");
        for(s=0;s<5;s++) {
            if(librarians[s].librarianId==null){
                break;
            }
            System.out.print(librarians[s].librarianId);
            idSpace();
            System.out.print(librarians[s].fullName);
            nameSpace();
            System.out.print(librarians[s].age+"\n");
        }
    }
    void idSpace(){
        int space=15-librarians[s].librarianId.length();
        if(space<0){
            System.out.print("     ");
        }
        else {
            for (int i = 0; i < space; i++) {
                System.out.print(" ");
            }
        }
    }
    void nameSpace(){
        int space=30-librarians[s].fullName.length();
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