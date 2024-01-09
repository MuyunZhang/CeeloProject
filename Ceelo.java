
import java.util.Scanner;
import java.io.IOException;
public class Ceelo {
    private Player p1;
    private Player p2;
    private Player p3;
    private Scanner scan;
    public Ceelo(){

    }
    public void setup(){
        scan = new Scanner(System.in);
        System.out.println("Welcome to Ceelo");
        System.out.println("Enter player1's name");
        String name1 = scan.nextLine();
        p1 = new Player(name1);
        System.out.println("Enter player2's name");
        String name2 = scan.nextLine();
        p2 = new Player(name2);
        System.out.println("Enter player3's name");
        String name3 = scan.nextLine();
        p3 = new Player(name3);

    }
    public void gameMenu(){

    }

    public void play(){





    }



}
