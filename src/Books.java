import java.util.Scanner;

public class Books {
    static Scanner scan=new Scanner(System.in);
    int bookID;
    static int serial=1001;
    String bookName;
    String authorName;
    int bookQuantity;
    Books(String bookName,String authorName,int bookQuantity){
        bookID=serial++;
        this.bookName=bookName;
        this.authorName=authorName;
        this.bookQuantity=bookQuantity;
    }
    Books(){
    }
    void addBook() {
        bookID=serial++;
        System.out.print("Enter Book Name : ");
        bookName=scan.nextLine();
        System.out.print("Enter Author Name : ");
        authorName=scan.nextLine();
        System.out.print("Enter Quantity : ");
        bookQuantity=scan.nextInt();
    }
    void display() {
        System.out.print(bookID+"   ");
        System.out.print(bookName);
        spaceBookName();
        System.out.print(authorName);
        spaceAuthorName();
        System.out.print("    "+bookQuantity+"\n");
    }
    void header(){
        System.out.println(" ID   "+"               Book Name               "+"       Author Name       "+" Quantity ");
    }
    void displayOneBook() {
        System.out.print("ID          : "+bookID+"\nBook Name   : "+bookName+"\nAuthor Name : "+authorName+"\nQuantity    : "+bookQuantity+"\n");
    }
    void spaceBookName() {
        int space=39-bookName.length();
        if(space<0){
            System.out.print("     ");
        }
        else {
            for (int i = 0; i < space; i++) {
                System.out.print(" ");
            }
        }
    }
    void spaceAuthorName() {
        int space=25-authorName.length();
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
