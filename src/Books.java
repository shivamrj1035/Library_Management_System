public class Books {
    int bookID,bookQuantity;
    static int serial=1001;
    //To give id to the books
    String bookName,authorName,publisher;
    Books(String bookName,String authorName,String publisher) {
        //to add initial books
        bookID=serial++;
        this.bookName=bookName;
        this.authorName=authorName;
        this.bookQuantity= 5;
        this.publisher=publisher;
    }
    Books() {
        //do nothing constructor
    }
    void addBook(int i) {
        //To add book entered by the librarian
        bookID=1001+i;
        System.out.print("Enter Book Name : ");
        bookName=Library.scan.nextLine();
        System.out.print("Enter Author Name : ");
        authorName=Library.scan.nextLine();
        System.out.print("Enter Publisher : ");
        publisher=Library.scan.nextLine();
        System.out.print("Enter Quantity : ");
        bookQuantity=Library.scan.nextInt();
    }
    void display() {
        //to display all the books
        System.out.print(bookID+"   ");
        System.out.print(bookName);
        spaceBookName();
        System.out.print(authorName);
        spaceAuthorName();
        System.out.print(publisher);
        spacePublisher();
        System.out.print("    "+bookQuantity+"\n");
    }
    void header() {
        //Label used when we want to display all books
        System.out.println(" ID   "+"             Book Name               "+"       Author Name       "+"        Publisher       "+"     Quantity ");
    }
    void displayOneBook() {
        //to display one single book
        System.out.println("ID          : "+bookID+"\nBook Name   : "+bookName+"\nAuthor Name : "+authorName+"\nPublisher   : "+publisher);
    }
    //these three methods are adding extra space between two values so that books are displayed in a better way
    void spaceBookName() {
        int space=39-bookName.length();
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
    void spaceAuthorName() {
        int space=25-authorName.length();
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
    void spacePublisher() {
        int space=25-publisher.length();
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
}