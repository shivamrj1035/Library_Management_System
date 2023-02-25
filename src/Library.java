import java.util.*;

public class Library {
    static Scanner scan=new Scanner(System.in);
    Random random = new Random();
    int choice,count;
    static Librarian[] librarians=new Librarian[5];
    static Student[] students=new Student[50];
    static Books[] book=new Books[100];
    Library() {
        librarians[0]=new Librarian("Librarian","Librarian@21","21");
        for(int a=1;a<5;a++) {
            librarians[a]=new Librarian();
        }
        students[0]=new Student("Akash Rai","22002171310109");
        students[1]=new Student("Mansi Malaviya","22002171310054");
        students[2]=new Student("Aditya Singh","22002171210065");
        students[3]=new Student("Patel Hensy","22002171310082");
        students[4]=new Student("Bhatt Shreeom","22002171310008");
        for(int i=5;i<50;i++) {
            students[i]=new Student();
        }
        book[0]=new Books("Java The Complete Reference","Herbert Schildt","Tata McGrawHill",5);
        book[1]=new Books("Core Java An Integrated Approach","Dr R Nageswara Rao","Dream tech Press",5);
        book[2]=new Books("Core Java Volume I-Fundamentals","Cay S. Horstmann","Pearson India",5);
        book[3]=new Books("The Java Programming Language","James Gosling","Addison Wesley",5);
        book[4]=new Books("Higher Engineering Mathematics","Dr B S Grewal","Khanna Publisher",5);
        book[5]=new Books("Engineering Physics","G Vijayakumari","Vikas Publishing House",5);
        book[6]=new Books("Software Engineering","Roger S. Pressman","Tata McGrawHill",5);
        book[7]=new Books("Beginning Arduino","Michael McRobetrs","Apress",5);
        book[8]=new Books("Environmental Science","Dr. B.R. Shah","Mahajan Publishing House",5);
        book[9]=new Books("Physics-2","Nimish Das","Books India",5);
        for(int i=10;i<100;i++) {
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
        switch (choice) {
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
        System.out.print("Enter User ID  : ");
        String enteredUserId = scan.nextLine();
        System.out.print("Enter Password : ");
        String enteredPassword = scan.nextLine();
        captcha();
        if (count == 2) {
            System.out.println("Account locked for 1 hour");
            access = false;
        }
        else {
            for (int i = 0; i < 5; i++) {
                if (librarians[i].librarianId == null) {
                    System.out.println("Incorrect User Id or Password");
                    count++;
                    scan.nextLine();
                    login();
                    break;
                }
                else {
                    librarians[i].login(enteredUserId, enteredPassword);
                    if (librarians[i].access) {
                        access = true;
                        break;
                    }
                    else if (i == 4) {
                        System.out.println("Incorrect User Id or Password");
                        count++;
                        login();
                    }
                }
            }
        }
    }
    void captcha() {
        int a=random.nextInt(100);//creates a random variable between 0 and 99
        int b=random.nextInt(10);//creates a random variable between 0 and 9
        int operator=random.nextInt(3);
        char operator_sign;
        int answer;
        if (operator == 1) {
            operator_sign = '-';
            answer = a - b;
        }
        else if(operator == 2) {
            operator_sign = '+';
            answer = a + b;
        }
        else {
            operator_sign = '*';
            answer = a * b;
        }
        System.out.print("CAPTCHA --> "+a+operator_sign+b+" = ");
        int ans=scan.nextInt();
        if(answer!=ans) {
            System.out.println("Entered Captcha answer is incorrect\n");
            captcha();
        }
    }
    void control() {
        options_2();
        if(choice_2==0) {
            options();
            if(choice==0||!access){
                if(choice==0) {
                    System.out.println("***************** Thanks for using our system *****************");
                }
                return;
            }
        }
        else if(choice_2==10) {
            showLibrarians();
        }
       control();
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
        System.out.println("Press 0 to return to the login menu");
        System.out.println("Press 1 to Add new Book");
        System.out.println("Press 2 to Upgrade Quantity of a Book");
        System.out.println("Press 3 to Search a Book");
        System.out.println("Press 4 to Show All Books");
        System.out.println("Press 5 to Register Student");
        System.out.println("Press 6 to Show All Registered Students");
        System.out.println("Press 7 to issue Book");
        System.out.println("Press 8 to return Book");
        System.out.println("Press 9 to search a student");
        System.out.println("Press 10 to Show All Registered Librarians");
        System.out.println("***************************************************************");
        choice_2= scan.nextInt();
        switch (choice_2) {
            case 0:
            case 10:
                return;
            case 1: System.out.print("Enter no of books to be added : ");
                int nBook=scan.nextInt();
                for(int i=0;i<nBook;i++) {
                    System.out.println("Enter Book "+(i+1));
                    add();
                    System.out.println();
                }
                System.out.println("Books are added successfully");
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
            case 7: issueBook(verification());
                break;
            case 8: returnBook(verification());
                break;
            case 9: verification();
                break;
            default: System.out.println("Invalid Input\nPress between 0 to 9");
        }
        options_2();
    }
    void add() {
        for(int i=0;i<100;i++) {
            if (book[i].bookName == null) {
                book[i].addBook();
                scan.nextLine();
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
        System.out.println("Quantity has been upgraded successfully");
    }
    void search() {
        System.out.println("***************************************************************");
        System.out.println("Press 1 to Search by Book ID");
        System.out.println("Press 2 to Search by Book Name");
        System.out.println("Press 3 to Search by Author Name");
        System.out.println("Press 4 to Search by publisher Name");
        System.out.println("***************************************************************");
        int choice_search= scan.nextInt();
        switch (choice_search) {
            case 1 -> serial = searchID();
            case 2 -> searchName();
            case 3 -> searchAuthor();
            case 4 -> searchPublisher();
            default -> {
                System.out.println("Invalid Input\nPress between 1 to 4");
                search();
            }
        }
        if(choice_search==1) {
            if (serial == 401) {
                System.out.println("No such book found in the library");
            }
            else {
                book[serial].displayOneBook();
            }
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
    void searchName() {
        System.out.print("Enter Book Name : ");
        scan.nextLine();
        String enteredBookName=scan.nextLine();
        int i;
        int count=0;
        for(i=0;i<100;i++){
            if(book[i].bookName==null){
                if(count==0) {
                    System.out.println("No such book found in the library");
                }
                break;
            }
            else if(book[i].bookName.equalsIgnoreCase(enteredBookName)){
                book[i].displayOneBook();
                System.out.println();
                count++;
            }
        }
    }
    void searchAuthor() {
        System.out.print("Enter Author Name : ");
        scan.nextLine();
        String enteredAuthorName=scan.nextLine();
        int i;
        int count=0;
        for(i=0;i<100;i++) {
            if(book[i].authorName==null){
                if(count==0) {
                    System.out.println("No such book found in the library");
                }
                break;
            }
            else if(book[i].authorName.equalsIgnoreCase(enteredAuthorName)) {
                book[i].displayOneBook();
                System.out.println();
                count++;
            }
        }
    }
    void searchPublisher() {
        System.out.print("Enter Publisher : ");
        scan.nextLine();
        String enteredPublisher=scan.nextLine();
        int i=0;
        int count=0;
        for(;i<100;i++) {
            if(book[i].publisher==null) {
                if(count == 0) {
                    System.out.println("No such book found in the library");
                }
                break;
            }
            else if(book[i].publisher.equalsIgnoreCase(enteredPublisher)) {
                book[i].displayOneBook();
                System.out.println();
                count++;
            }
        }
    }
    void registerStudent(){
        System.out.print("Student enrollment number : ");
        scan.nextLine();
        String enrollmentNumber=scan.nextLine();
        int check=0;
        for(int i=0;i<50;i++) {
            if(students[i].studentName==null) {
                break;
            }
            else if(students[i].enrollmentNumber.equals(enrollmentNumber)) {
                System.out.println("Student already registered ");
                check=1;
                break;
            }
        }
        if(check==0) {
            for (int i = 0; i < 50; i++) {
                if(students[i].studentName==null) {
                    students[i].registration(enrollmentNumber);
                    System.out.println("Student registered successfully");
                    break;
                }
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
    int verification() {
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
                    students[i].displayOneStudent();
                    return i;
                }
                else if (i == 49) {
                    System.out.println("ID doesn't exist");
                }
            }
        }
        return 401;
    }
    void issueBook(int verification) {
        if(verification!=401) {
            int temp=students[verification].count();
            if(temp<3) {
                System.out.println();
                int serial = searchID();
                while (serial == 401) {
                    System.out.println("Please enter correct book id");
                    serial = searchID();
                }
                book[serial].displayOneBook();
                if (book[serial].bookQuantity > 0) {
                    System.out.print("Enter issue date(DD MM YYYY) : ");
                    scan.nextLine();
                    String issueDate = scan.nextLine();
                    book[serial].bookQuantity--;
                    System.out.println("Book issued successfully");
                    students[verification].issueBook(book[serial].bookID, issueDate);
                }
                else {
                    System.out.println("Book not available");
                }
            }
            else {
                System.out.println("Maximum no of book issued");
            }
        }
    }

    void returnBook(int verification) {
        if(verification!=401) {
            System.out.println();
            int serial=searchID();
            while (serial == 401) {
                System.out.println("Please enter correct book id");
                serial = searchID();
            }
            if(students[verification].checkBook(book[serial].bookID)){
                System.out.println();
                System.out.print("Enter return date(DD MM YYYY) : ");
                scan.nextLine();
                String returnDate=scan.nextLine();
                book[serial].bookQuantity++;
                int days=students[verification].returnBook(book[serial].bookID,returnDate);
                if(days>15) {
                    System.out.println(students[verification].studentName+" is late for returning book by "+(days-15)+" days\nFine : " +((days-15)*2));
                }
                System.out.println("Book returned successfully");
            }
            else{
                System.out.println("Student has issued no such book");
            }
        }
    }

    public  static void main(String[]args) {
        Library library=new Library();
        System.out.println("******************** Welcome to the Library ********************");
        library.options();
        if(library.choice==0||!library.access){
            if(library.choice==0) {
                System.out.println("***************** Thanks for using our system *****************");
            }
            return;
        }
        library.control();
    }
}