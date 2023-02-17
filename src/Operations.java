import java.util.Scanner;

public class Operations {
    Scanner scan=new Scanner(System.in);
    Books[] book=new Books[100];
    void start(){
        book[0]=new Books("Java","DJU",5);
        book[1]=new Books("Physics","DRS",5);
        book[2]=new Books("Mathematics","FIK",5);
        book[3]=new Books("SE","MMS",5);
        book[4]=new Books("ES","DSP",5);
        for(int i=5;i<100;i++){
            book[i]=new Books();
        }
    }
    int choice;
    void options() {
        System.out.println("***************************************************************");
        System.out.println("Press 0 to Exit Application.");
        System.out.println("Press 1 to Add new Book.");
        System.out.println("Press 2 to Upgrade Quantity of a Book.");
        System.out.println("Press 3 to Search a Book.");
        System.out.println("Press 4 to Show All Books.");
        System.out.println("Press 5 to Register Student.");
        System.out.println("Press 6 to Show All Registered Students.");
        System.out.println("Press 7 to Check Out Book. ");
        System.out.println("Press 8 to Check In Book");
        System.out.println("***************************************************************");
        choice= scan.nextInt();
        switch (choice){
            case 0: return;
            case 1: System.out.print("Enter no of books to be added : ");
                int nBook=scan.nextInt();
                for(int i=0;i<nBook;i++) {
                    System.out.println("Enter Book "+(i+1));
                    add();
                    System.out.println();
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4: show();
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            default: System.out.println("Invalid Input\nPress between 0 to 8");
        }
        options();
    }
    void add(){
        for(int i=0;i<100;i++) {
            if (book[i].bookName == null) {
                book[i].addBook();
                Books.scan.nextLine();
                break;
            }
        }
    }
    void show(){
        for(int i=0;i<100;i++) {
            if (book[i].bookName == null) {
                break;
            }
            book[i].display();
        }
    }
}
