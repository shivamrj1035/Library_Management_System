import java.util.Scanner;

public class Operations {
    Scanner scan=new Scanner(System.in);
    Books[] book=new Books[100];
    Operations() {
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
    int choice,serial;
    void options() {
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
        choice= scan.nextInt();
        switch (choice) {
            case 0: return;
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
            case 7: checkOut();
                break;
            case 8: checkIn();
                break;
            case 9: return;
            default: System.out.println("Invalid Input\nPress between 0 to 9");
        }
        options();
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

    }
    void showStudents() {

    }
    void checkIn() {

    }
    void checkOut() {

    }
}