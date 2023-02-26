import java.util.*;
public class Library {
    static Scanner scan=new Scanner(System.in);
    static Random random = new Random();
    static Librarian[] librarians=new Librarian[5]; //creates 5 librarians
    static Student[] students=new Student[50]; //creates 50 students
    static Books[] book=new Books[100]; //creates 100 books
    /*
    A constructor to set
    --> Default librarian
        --> User ID  : Librarian@21
        --> Password : Librarian@21
    --> Store 10 books data
    --> Resister 5 students data
    */
    Library() {
        librarians[0]=new Librarian("Librarian","Librarian@21","21");
        for(int a=1;a< librarians.length;a++) {
            librarians[a]=new Librarian();
        }
        students[0]=new Student("Akash Rai","22002171310109");
        students[1]=new Student("Mansi Malaviya","22002171310054");
        students[2]=new Student("Aditya Singh","22002171210065");
        students[3]=new Student("Patel Hensy","22002171310082");
        students[4]=new Student("Bhatt Shreeom","22002171310008");
        for(int i=5;i< students.length;i++) {
            students[i]=new Student();
        }
        book[0]=new Books("Java The Complete Reference","Herbert Schildt","Tata McGrawHill");
        book[1]=new Books("Core Java An Integrated Approach","Dr R Nageswara Rao","Dream tech Press");
        book[2]=new Books("Core Java Volume I-Fundamentals","Cay S. Horstmann","Pearson India");
        book[3]=new Books("The Java Programming Language","James Gosling","Addison Wesley");
        book[4]=new Books("Higher Engineering Mathematics","Dr B S Grewal","Khanna Publisher");
        book[5]=new Books("Engineering Physics","G Vijayakumari","Vikas Publishing House");
        book[6]=new Books("Software Engineering","Roger S. Pressman","Tata McGrawHill");
        book[7]=new Books("Beginning Arduino","Michael McRobetrs","Apress");
        book[8]=new Books("Environmental Science","Dr. B.R. Shah","Mahajan Publishing House");
        book[9]=new Books("Physics-2","Nimish Das","Books India");
        for(int i=10;i< book.length;i++) {
            book[i]=new Books();
        }
    }
    static  int librarianAccount_count =1; //counts how many librarians account have been created
    int choice; //stores choices entered by the user
    int loginAttempt_count; //counts how many login attempt had been made by the user
    boolean access; //stores true--> login id and password are correct
    void loginMenu() {
        //login menu
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
                loginMenu();
                break;
            case 2 : login();
                break;
            default: System.out.println("Invalid Input\nPress between 0 to 2");
                loginMenu();
        }
    }
    //signUp method
    void signUp() {
        if(librarianAccount_count == librarians.length) {
            System.out.println("Maximum Accounts Created");
        } else {
            librarians[librarianAccount_count].signUp();
            //calls the signUp method in the Librarians class to register a librarian
            librarianAccount_count++;
        }
    }
    void login() {
        System.out.print("Enter User ID  : ");
        String enteredUserId = scan.nextLine();
        System.out.print("Enter Password : ");
        String enteredPassword = scan.nextLine();
        captcha();
        if (loginAttempt_count == 2) {
            System.out.println("Account locked for 1 hour");
            access = false;
        } else {
            for (int i = 0; i < librarians.length; i++) {
                if (librarians[i].librarianId == null) {
                    System.out.println("Incorrect User Id or Password");
                    loginAttempt_count++;
                    scan.nextLine();
                    login();
                    break;
                } else {
                    librarians[i].login(enteredUserId, enteredPassword);
                    if (librarians[i].access) {
                        access = true;
                        break;
                    } else if (i == (librarians.length-1)) {
                        System.out.println("Incorrect User Id or Password");
                        loginAttempt_count++;
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
        } else if(operator == 2) {
            operator_sign = '+';
            answer = a + b;
        } else {
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
        mainMenu();
        if(mainMenu_choice ==0) {
            loginMenu();
            if(choice==0||!access){
                if(choice==0) {
                    System.out.println("***************** Thanks for using our system *****************");
                }
                return;
            }
        } else if(mainMenu_choice ==10) {
            showLibrarians();
        }
       control();
    }
    void showLibrarians() {
        librarians[0].header();
        for (Librarian librarian : librarians) {
            if (librarian.librarianId == null) {
                continue;
            }
            librarian.display();
        }
    }
    int mainMenu_choice, bookId;
    void mainMenu() {
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
        mainMenu_choice = scan.nextInt();
        switch (mainMenu_choice) {
            case 0:
            case 10:
                return;
            case 1: no_Books();
                break;
            case 2: upgradeQuantity();
                break;
            case 3: searchBooks();
                break;
            case 4: showBooks();
                break;
            case 5: registerStudent();
                break;
            case 6: showStudents();
                break;
            case 7: issueBook(searchStudent());
                break;
            case 8: returnBook(searchStudent());
                break;
            case 9: searchStudent();
                break;
            default: System.out.println("Invalid Input\nPress between 0 to 9");
        }
        mainMenu();
    }
    void no_Books() {
        int freeSpace_count=0;
        int nBook;
        for (Books books : book) {
            if (books.bookName == null) {
                freeSpace_count++;
            }
        }
        if(freeSpace_count==0) {
            System.out.println("Shelf is full");
            return;
        }
        for(;;) {
            System.out.print("Enter no of books to be added : ");
            nBook= scan.nextInt();
            if(nBook<=freeSpace_count) {
                break;
            }
            System.out.println("Shelf can now only store : "+freeSpace_count+" books");
        }
        for(int i=0;i<nBook;i++) {
            System.out.println("Enter Book "+(i+1));
            addBooks();
            System.out.println();
        }
        System.out.println("Books are added successfully");
    }
    void addBooks() {
        scan.nextLine();
        for (Books books : book) {
            if (books.bookName == null) {
                books.addBook();
                break;
            }
        }
    }
    void showBooks() {
        book[0].header();
        for (Books books : book) {
            if (books.bookName == null) {
                continue;
            }
            books.display();
        }
    }
    void upgradeQuantity() {
        System.out.println("To Upgrade Quantity");
        bookId=searchID();
        if(bookId==401) {
            System.out.println("No such book found in the library");
            return;
        }
        System.out.print("Quantity you want to Add : ");
        int quantity=scan.nextInt();
        book[bookId].bookQuantity+=quantity;
        System.out.println("Quantity has been upgraded successfully");
    }
    void searchBooks() {
        System.out.println("***************************************************************");
        System.out.println("Press 1 to Search by Book ID");
        System.out.println("Press 2 to Search by Book Name");
        System.out.println("Press 3 to Search by Author Name");
        System.out.println("Press 4 to Search by publisher Name");
        System.out.println("***************************************************************");
        int search_choice= scan.nextInt();
        switch (search_choice) {
            case 1 -> bookId = searchID();
            case 2 -> searchName();
            case 3 -> searchAuthor();
            case 4 -> searchPublisher();
            default -> {
                System.out.println("Invalid Input\nPress between 1 to 4");
                searchBooks();
            }
        }
        if(search_choice==1) {
            if (bookId == 401) {
                System.out.println("No such book found in the library");
            }
            else {
                book[bookId].displayOneBook();
            }
        }
    }
    int searchID() {
        System.out.print("Enter Book ID : ");
        int enteredBookID=scan.nextInt();
        int i=0;
        for(;i<book.length;i++) {
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
        int display_count=0;
        for (Books books : book) {
            if (books.bookName == null) {
                if (display_count == 0) {
                    System.out.println("No such book found in the library");
                }
                break;
            } else if (books.bookName.equalsIgnoreCase(enteredBookName)) {
                books.displayOneBook();
                System.out.println();
                display_count++;
            }
        }
    }
    void searchAuthor() {
        System.out.print("Enter Author Name : ");
        scan.nextLine();
        String enteredAuthorName=scan.nextLine();
        int display_count=0;
        for (Books books : book) {
            if (books.authorName == null) {
                if (display_count == 0) {
                    System.out.println("No such book found in the library");
                }
                break;
            } else if (books.authorName.equalsIgnoreCase(enteredAuthorName)) {
                books.displayOneBook();
                System.out.println();
                display_count++;
            }
        }
    }
    void searchPublisher() {
        System.out.print("Enter Publisher : ");
        scan.nextLine();
        String enteredPublisher=scan.nextLine();
        int display_count=0;
        for (Books books : book) {
            if (books.publisher == null) {
                if (display_count == 0) {
                    System.out.println("No such book found in the library");
                }
                break;
            } else if (books.publisher.equalsIgnoreCase(enteredPublisher)) {
                books.displayOneBook();
                System.out.println();
                display_count++;
            }
        }
    }
    void registerStudent(){
        System.out.print("Student enrollment number : ");
        scan.nextLine();
        String enrollmentNumber=scan.nextLine();
        int check=0;
        for (Student student : students) {
            if (student.studentName == null) {
                break;
            } else if (student.enrollmentNumber.equals(enrollmentNumber)) {
                System.out.println("Student already registered ");
                check = 1;
                break;
            }
        }
        if(check==0) {
            for (Student student : students) {
                if (student.studentName == null) {
                    student.registration(enrollmentNumber);
                    System.out.println("Student registered successfully");
                    break;
                }
            }
        }
    }
    void showStudents() {
        students[0].header();
        for (Student student : students) {
            if (student.studentName == null) {
                break;
            }
            student.displayStudent();
        }
    }
    int searchStudent() {
        System.out.print("Enter Student Id : ");
        scan.nextLine();
        String id=scan.nextLine();
        for (int i=0;i< students.length;i++) {
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
    void issueBook(int student_id) {
        if(student_id!=401) {
            int issuedBook_count=students[student_id].count();
            if(issuedBook_count<3) {
                System.out.println();
                bookId = searchID();
                while (bookId == 401) {
                    System.out.println("Please enter correct book id");
                    bookId = searchID();
                }
                book[bookId].displayOneBook();
                if (book[bookId].bookQuantity > 0) {
                    System.out.print("Enter issue date(DD MM YYYY) : ");
                    scan.nextLine();
                    String issueDate = scan.nextLine();
                    book[bookId].bookQuantity--;
                    System.out.println("Book issued successfully");
                    students[student_id].issueBook(book[bookId].bookID, issueDate);
                } else {
                    System.out.println("Book not available");
                }
            } else {
                System.out.println("Maximum no of book issued");
            }
        }
    }
    void returnBook(int student_id) {
        if(student_id!=401) {
            System.out.println();
            bookId=searchID();
            while (bookId == 401) {
                System.out.println("Please enter correct book id");
                bookId = searchID();
            }
            if(students[student_id].checkBook(book[bookId].bookID)){
                System.out.println();
                System.out.print("Enter return date(DD MM YYYY) : ");
                scan.nextLine();
                String returnDate=scan.nextLine();
                book[bookId].bookQuantity++;
                int days=students[student_id].returnBook(book[bookId].bookID,returnDate);
                if(days>15) {
                    System.out.println(students[student_id].studentName+" is late for returning book by "+(days-15)+" days\nFine : " +((days-15)*2));
                }
                System.out.println("Book returned successfully");
            } else {
                System.out.println("Student has issued no such book");
            }
        }
    }
    public  static void main(String[]args) {
        Library library=new Library();
        System.out.println("******************** Welcome to the Library ********************");
        library.loginMenu();
        if(library.choice==0||!library.access){
            if(library.choice==0) {
                System.out.println("***************** Thanks for using our system *****************");
            }
            return;
        }
        library.control();
    }
}