public class Main {
    public  static void main(String[]args) {
        Library library=new Library();
        System.out.println("********************Welcome to the Library!********************");
        System.out.println("                Select From The Following Options:             ");
        System.out.println("***************************************************************");
        library.options();
        if(library.choice==0||!library.access){
            return;
        }
        library.control();
    }
}