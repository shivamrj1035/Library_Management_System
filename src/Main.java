public class Main {
    public  static void main(String[]args) {
        Operations op = new Operations();
        System.out.println("********************Welcome to the Library!********************");
        System.out.println("                Select From The Following Options:             ");
        System.out.println("***************************************************************");
        op.start();
        op.options();
        if(op.choice==0){
            return;
        }
    }
}