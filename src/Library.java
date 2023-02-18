import java.util.Scanner;

public class Library {
    Scanner scan=new Scanner(System.in);
    int choice,count;
    Librarian[] librarians=new Librarian[5];
    Student[] students=new Student[50];
    Books[] book=new Books[100];
    Library() {
        librarians[0]=new Librarian("John20","John Abraham","John20","20");
        for(int a=1;a<5;a++) {
            librarians[a]=new Librarian();
        }
        students[0]=new Student("Akash Rai","22002171310109");
        students[1]=new Student("Mansi Malaviya","22002171310054");
        students[2]=new Student("Aditya Singh","22002171210065");
        students[3]=new Student("Patel Hensy","22002171310082");
        students[4]=new Student("Bhatt Shreeom","22002171310008");
        for(int i=5;i<50;i++){
            students[i]=new Student();
        }
        book[0]=new Books("Java The Complete Reference","Herbert Schildt",5);
        book[1]=new Books("Core Java An Integrated Approach","Dr R Nageswara Rao",5);
        book[2]=new Books("Core Java Volume I-Fundamentals","Cay S. Horstmann",5);
        book[3]=new Books("The Java Programming Language","James Gosling",5);
        book[4]=new Books("Higher Engineering Mathematics","Dr B S Grewal",5);
        book[5]=new Books("Engineering Physics","G Vijayakumari",5);
        book[6]=new Books("Software Engineering","Roger S. Pressman",5);
        book[7]=new Books("Beginning Arduino","Michael McRobetrs",5);
        book[8]=new Books("Environmental Science","Dr. B.R. Shah",5);
        book[9]=new Books("Physics-2","Nimish Das",5);
        for(int i=10;i<100;i++){
            book[i]=new Books();
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
        options_2();
        if(choice_2==0) {
            options();
        }
        else if(choice_2==9) {
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
    int choice_2,serial;
    void options_2() {
        System.out.println("\n***************************************************************");
        System.out.println("Press 0 to return to the login menu.");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println("Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println("Press 9 to Show All Registered Librarians.");
        System.out.println("***************************************************************");
        choice_2= scan.nextInt();
        switch (choice_2) {
            case 0:
            case 9:
                return;
            case 1: System.out.print("Enter no of books to be added : ");
                int nBook=scan.nextInt();
                for(int i=0;i<nBook;i++) {
                    System.out.println("Enter Book "+(i+1));
                    add();
                    System.out.println();
                }
                break;
            case 2: upgradeQuantity();
                break;
            case 3: search();
                break;
            case 4: show();
                break;
            case 5: registerStudent();
                break;
            case 6: showStudents();
                break;
            case 7: verification();
                checkOut();
                break;
            case 8: verification();
                checkIn();
                break;
            default: System.out.println("Invalid Input\nPress between 0 to 9");
        }
        options_2();
    }
    void add() {
        for(int i=0;i<100;i++) {
            if (book[i].bookName == null) {
                book[i].addBook();
                Books.scan.nextLine();
                break;
            }
        }
    }
    void show() {
        book[0].header();
        for(int i=0;i<100;i++) {
            if (book[i].bookName == null) {
                continue;
            }
            book[i].display();
        }
    }
    void upgradeQuantity() {
        System.out.println("To Upgrade Quantity");
        serial=searchID();
        System.out.print("Quantity you want to Add : ");
        int quantity=scan.nextInt();
        book[serial].bookQuantity+=quantity;
        System.out.println("Quantity has been upgraded sucessfully");
    }
    void search() {
        System.out.println("***************************************************************");
        System.out.println("Press 1 to Search by Book ID");
        System.out.println("Press 2 to Search by Book Name.");
        System.out.println("Press 3 to Search by Author Name.");
        System.out.println("***************************************************************");
        int choice_search= scan.nextInt();
        switch (choice_search) {
            case 1 -> serial = searchID();
            case 2 -> serial = searchName();
            case 3 -> serial = searchAuthor();
            default -> {
                System.out.println("Invalid Input\nPress between 1 to 3");
                search();
            }
        }
        if(serial==401){
            System.out.println("No such book found in the library");
        }
        else {
            book[serial].displayOneBook();
        }
    }
    int searchID() {
        System.out.print("Enter Book ID : ");
        int enteredBookID=scan.nextInt();
        int i=0;
        for(;i<100;i++) {
            if(book[i].bookID==enteredBookID){
                break;
            }
            else if(book[i].bookID==0){
                return 401;//error code
            }
        }
        return i;
    }
    int searchName() {
        System.out.print("Enter Book Name : ");
        scan.nextLine();
        String enteredBookName=scan.nextLine();
        int i=0;
        for(;i<100;i++){
            if(book[i].bookName==null){
                return 401;//error code
            }
            else if(book[i].bookName.equalsIgnoreCase(enteredBookName)){
                break;
            }
        }
        return i;
    }
    int searchAuthor() {
        System.out.print("Enter Author Name : ");
        scan.nextLine();
        String enteredAuthorName=scan.nextLine();
        int i=0;
        for(;i<100;i++) {
            if(book[i].authorName==null){
                return 401;//error code
            }
            else if(book[i].authorName.equalsIgnoreCase(enteredAuthorName)){
                break;
            }
        }
        return i;
    }
    void registerStudent(){
        for(int i=0;i<50;i++){
            if(students[i].studentName==null){
                students[i].registration();
                break;
            }
        }
    }
    void showStudents() {
        students[0].header();
        for(int i=0;i<50;i++) {
            if (students[i].studentName == null) {
                break;
            }
            students[i].displayStudent();
        }
    }
    void verification() {
        System.out.print("Enter Student Id : ");
        scan.nextLine();
        String id=scan.nextLine();
        for (int i=0;i<50;i++) {
            if(students[i].libID==null) {
                System.out.println("ID doesn't exist");
                break;
            }
            else {
                if (students[i].libID.equals(id)) {
                    System.out.println("ID verified");
                    students[i].displayStudent();
                    break;
                }
                else if (i == 49) {
                    System.out.println("ID doesn't exist");
                }
            }
        }
    }
    void checkIn() {

    }
    void checkOut() {

    }
}