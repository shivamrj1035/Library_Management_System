import java.util.Scanner;

public class Books {
    static Scanner scan=new Scanner(System.in);
    int serialNo;
    static int serial=1;
    String bookName;
    String authorName;
    int bookQuantity;
    Books(String bookName,String authorName,int bookQuantity){
        serialNo=serial++;
        this.bookName=bookName;
        this.authorName=authorName;
        this.bookQuantity=bookQuantity;
    }
    Books(){
    }
    void addBook() {
        serialNo=serial++;
        System.out.print("Enter Book Name : ");
        bookName=scan.nextLine();
        System.out.print("Enter Author Name : ");
        authorName=scan.nextLine();
        System.out.print("Enter Quantity : ");
        bookQuantity=scan.nextInt();
    }
    void display(){
        System.out.println("No : "+serialNo+" : Book Name : "+bookName+" Author Name : "+authorName+" Quantity : "+bookQuantity);
    }
}
