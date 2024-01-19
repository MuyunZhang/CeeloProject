
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;

import static java.util.Arrays.sort;

public class Ceelo {
    private Player p1;
    private Player p2;
    private Player p3;
    private int r1;
    private int r2;
    private int r3;
    private Banker boss = new Banker();
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
    public boolean roundResult(int first, int second, int third){
        return true;
    }

    public boolean compare(int[] input,int[] constant){
        int count = 0;
        for(int i = 0; i < input.length; i++){
            if(input[i] == constant[i]){
                count ++;
            }
        }
        if(count == input.length){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean repeat(int[] input){
        int f = input[0];
        int s = input[1];
        int t = input[2];
        int[] fail = new int[]{1,2,3};
        int[] win = new int[]{4,5,6};
        int[] temp = new int[input.length];
        for(int i = 0; i < input.length; i ++){
            temp[i] = input[i];
        }
        Arrays.sort(temp);
        if(f != s && s != t && f != t && !compare(temp,win) && !compare(temp, fail)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean pRound(Player p, int bet){
        boolean won = false;
        p.roll();
        int f = p.getDice1();
        int s = p.getDice2();
        int t = p.getChips();
        int[] fail = new int[]{1,2,3};
        int[] win = new int[]{4,5,6};
        int[] rolls = new int[]{f, s, t};
        boolean again  = repeat(rolls);
        while(again = true){
            p.roll();
            f = p.getDice1();
            s = p.getDice2();
            t = p.getChips();
            rolls = new int[]{f, s, t};
            again = repeat(rolls);
        }

        if(f == s && s == t){
            p.addChips(bet);
            boss.addChips(-bet);
            won = true;
        }
        else if(rolls[0] == rolls[1]){
            p.setScore(rolls[2]);
        }
        else if(rolls[0] == rolls[2]){
            p.setScore(rolls[1]);
        }
        else if(rolls[1] == rolls[2]){
            p.setScore(rolls[0]);
        }
        else {
            Arrays.sort(rolls);
            if(compare(rolls, win)){
                p.addChips(bet);
                boss.addChips(-bet);
                won = true;
            } else if (compare(rolls, fail)) {
                p.addChips(-bet);
                boss.addChips(bet);
                won = false;
            }
        }
        return won;
    }

    public boolean bankRound(Player p, int bet){
        boolean won = false;
        boss.roll();
        int f = boss.getDice1();
        int s = boss.getDice2();
        int t = boss.getChips();
        int[] fail = new int[]{1,2,3};
        int[] win = new int[]{4,5,6};
        int[] rolls = new int[]{f, s, t};
        boolean again = repeat(rolls);
        while(again = true){
            boss.roll();
            f = boss.getDice1();
            s = boss.getDice2();
            t = boss.getChips();
            rolls = new int[]{f, s, t};
            again = repeat(rolls);
        }

        if(f == s && s == t){
            boss.addChips(bet);
            p.addChips(-bet);
            won = true;
        }
        else if(rolls[0] == rolls[1]){
            boss.setScore(rolls[2]);
        }
        else if(rolls[0] == rolls[2]){
            boss.setScore(rolls[1]);
        }
        else if(rolls[1] == rolls[2]){
            boss.setScore(rolls[0]);
        }
        else {
            Arrays.sort(rolls);
            if(compare(rolls, win)){
                boss.addChips(bet);
                p.addChips(-bet);
                won = true;
            } else if (compare(rolls, fail)) {
                boss.addChips(-bet);
                p.addChips(bet);
                won = false;
            }
        }
        return won;
    }




}
