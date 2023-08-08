import java.util.Scanner;
import java.util.ArrayList;


public class ListMaker {
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        final String menu = "A - add  D - delete  P - print  Q - quit";
        boolean done = false;
        String cmd = "";
        Scanner in = new Scanner(System.in);

        do{

            displayList();
            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();

            switch(cmd){
                case "A":
                    String input = SafeInput.getNonZeroLenString(in, "Enter an item");
                    list.add(input);
                    break;
                case "D":
                    System.out.println("Which item would you like to delete?");
                    int toDelete = SafeInput.getRangedInt(in, "Which item would you like to delete?", 1, list.size());
                    list.remove(toDelete -1);
                    break;
                case "P":
                    break;
                case "Q":
                    boolean quit = SafeInput.getYNConfirm(in, "Are you sure you want to quit? [Y or N]");
                    if(quit){
                        System.exit(0);
                    }

                    break;
            }



        }while(!done);
    }

    private static void displayList() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        if(list.size() != 0) {

            for (int i = 0; i < list.size(); i++) {

                System.out.printf("%3d%35s", i + 1, list.get(i));
                System.out.println();
            }
        }
        else
            System.out.println("+++         List is empty           +++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
    }
}