
import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;
public class Ceelo {
    private Player p1;
    private Player p2;
    private Player p3;
    private int r1;
    private int r2;
    private int r3;
    private Banker boss;
    private Die d;
    private boolean end = false;

    private boolean rollAgain;
    private Scanner scan;

    private boolean win;
    public Ceelo(){

    }
    public void setup(){
        scan = new Scanner(System.in);
        System.out.println("Welcome to Ceelo");
        System.out.println("Enter player1's name");
        String name1 = scan.nextLine();
        p1 = new Player(Colors.GREEN + name1 + Colors.RESET);
        System.out.println("Enter player2's name");
        String name2 = scan.nextLine();
        p2 = new Player(Colors.GREEN + name2 + Colors.RESET);
        System.out.println("Enter player3's name");
        String name3 = scan.nextLine();
        p3 = new Player(Colors.GREEN + name3 + Colors.RESET);
        boss = new Banker();
        d = new Die();
        System.out.println("Game ready, defeat the Banker");

    }
    public boolean roundResult(int first, int second, int third){
        return true;
    }

    public void play(Player p, int bet){
        p.roll();
        int f = p.getDice1();
        int s = p.getDice2();
        int t = p.getChips();
        boolean again = false;
        int[] fail = new int[]{1,2,3};
        int[] rolls = new int[]{f, s, t};

        if(f == s && s == t){
            p.addChips(bet);
            boss.addChips(-bet);
        }
        else if(){

        }





    }

    public void gameplay(){
        while(!end){
            System.out.println("Player 1, how many chips do you wager");
            int w1 = scan.nextInt();
            System.out.println("Player 2, how many chips do you wager");
            int w2 = scan.nextInt();
            System.out.println("Player 3, how many chips do you wager");
            int w3 = scan.nextInt();

        }
    }



}
