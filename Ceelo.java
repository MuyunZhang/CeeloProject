
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.io.IOException;

import static java.util.Arrays.sort;

public class Ceelo {
    private Player p1;
    private Player p2;
    private Player p3;


    private int bankScore;

    private int playerScore;
    private Banker boss = new Banker();
    private Die d;
    private boolean end = false;

    private boolean rollAgain;
    private Scanner scan;

    private boolean bankWinner;
    private int round;

    private boolean playAgain = true;

    private boolean playerWin;
    private Player[] all;


    private boolean win;
    public Ceelo(){

    }
    public void setup(){
        scan = new Scanner(System.in);
        System.out.println("Welcome to Ceelo");
        System.out.println("Enter player1's name: ");
        String name1 = scan.nextLine();
        p1 = new Player(Colors.GREEN + name1 + Colors.RESET);
        System.out.println("Enter player2's name: ");
        String name2 = scan.nextLine();
        p2 = new Player(Colors.GREEN + name2 + Colors.RESET);
        System.out.println("Enter player3's name: ");
        String name3 = scan.nextLine();
        p3 = new Player(Colors.GREEN + name3 + Colors.RESET);
        boss = new Banker();
        d = new Die();
        all = new Player[] {p1, p2, p3};
        System.out.println("Game ready, defeat the Banker");

    }

    public void gameplay(){
        while(playAgain = true) {
            while (!end) {
                round++;
                if (p1.getChips() > 0) {
                    System.out.println(p1.getName() + ", how many chips do you wager");
                    int w1 = scan.nextInt();
                    p1.setWager(w1);
                } else {
                    p1.setAvailable(false);
                    System.out.println(p1.getName() + " is unavailable");
                }
                if (p2.getChips() > 0) {
                    System.out.println(p2.getName() + ", how many chips do you wager");
                    int w2 = scan.nextInt();
                    p2.setWager(w2);
                } else {
                    p2.setAvailable(false);
                    System.out.println(p2.getName() + " is unavailable");
                }
                if (p3.getChips() > 0) {
                    System.out.println(p3.getName() + ", how many chips do you wager");
                    int w3 = scan.nextInt();
                    p3.setWager(w3);
                } else {
                    p3.setAvailable(false);
                    System.out.println(p3.getName() + " is unavailable");
                }

                System.out.println("Round " + round);
                boolean bankWin = bankRound();
                if (bankWin == false && boss.getScore() > 0) {
                    bankScore = boss.getScore();
                } else if (bankWin == false) {
                    bankWinner = false;
                } else {
                    bankWinner = true;
                }
                if (bankWinner = false) {
                    if (p1.getAvailable()) {
                        pRound(p1, p1.getWager());
                        if (p1.getRoundWin()) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p1.getName() + " rolled " + p1.getDice1() + ", " + p1.getDice2() + ", " + p1.getDice3());
                            System.out.println(p1.getName() + " automatically wins this round");
                            System.out.println("Banker loses " + p1.getWager() + " chips");
                            System.out.println(p1.getName() + "gains " + p1.getWager() + " chips");
                        } else if (boss.getScore() > p1.getScore()) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p1.getName() + " rolled " + p1.getDice1() + ", " + p1.getDice2() + ", " + p1.getDice3());
                            System.out.println("Banker won this round against you");
                            System.out.println("Banker gains " + p1.getWager() + " chips");
                            System.out.println(p1.getName() + " lost " + p1.getWager() + " chips");
                        } else {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p1.getName() + " rolled " + p1.getDice1() + ", " + p1.getDice2() + ", " + p1.getDice3());
                            System.out.println("Banker's score this round is: " + boss.getScore());
                            System.out.println(p1.getName()+ "'s score this round is: " + p1.getScore());
                            System.out.println(p1.getName() + " has a higher score");
                            System.out.println(p1.getName() + " wins this round");
                            System.out.println("Banker loses " + p1.getWager() + " chips");
                            System.out.println(p1.getName() + "gains " + p1.getWager() + " chips");
                        }

                    }
                    if (p2.getAvailable()) {
                        pRound(p2, p2.getWager());
                        if (p2.getRoundWin()) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p2.getName() + " rolled " + p2.getDice1() + ", " + p2.getDice2() + ", " + p2.getDice3());
                            System.out.println(p2.getName() + " automatically wins this round");
                            System.out.println("Banker loses " + p2.getWager() + " chips");
                            System.out.println(p2.getName() + "gains " + p2.getWager() + " chips");
                        } else if (boss.getScore() > p2.getScore()) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p2.getName() + " rolled " + p2.getDice1() + ", " + p2.getDice2() + ", " + p2.getDice3());
                            System.out.println("Banker won this round against you");
                            System.out.println("Banker gains " + p2.getWager() + " chips");
                            System.out.println(p2.getName() + " lost " + p2.getWager() + " chips");
                        } else {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p2.getName() + " rolled " + p2.getDice1() + ", " + p2.getDice2() + ", " + p2.getDice3());
                            System.out.println("Banker's score this round is: " + boss.getScore());
                            System.out.println(p2.getName()+ "'s score this round is: " + p2.getScore());
                            System.out.println(p2.getName() + " has a higher score");
                            System.out.println(p2.getName() + " wins this round");
                            System.out.println("Banker loses " + p2.getWager() + " chips");
                            System.out.println(p2.getName() + "gains " + p2.getWager() + " chips");
                        }
                    }
                    if (p3.getAvailable()) {
                        pRound(p3, p3.getWager());
                        if (p3.getRoundWin()) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p3.getName() + " rolled " + p3.getDice1() + ", " + p3.getDice2() + ", " + p3.getDice3());
                            System.out.println(p3.getName() + " automatically wins this round");
                            System.out.println("Banker loses " + p3.getWager() + " chips");
                            System.out.println(p3.getName() + "gains " + p3.getWager() + " chips");
                        } else if (boss.getScore() > p3.getScore()) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p3.getName() + " rolled " + p3.getDice1() + ", " + p3.getDice2() + ", " + p3.getDice3());
                            System.out.println("Banker won this round against you");
                            System.out.println("Banker gains " + p3.getWager() + " chips");
                            System.out.println(p3.getName() + " lost " + p3.getWager() + " chips");
                        } else {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p3.getName() + " rolled " + p3.getDice1() + ", " + p3.getDice2() + ", " + p3.getDice3());
                            System.out.println("Banker's score this round is: " + boss.getScore());
                            System.out.println(p3.getName()+ "'s score this round is: " + p3.getScore());
                            System.out.println(p3.getName() + " has a higher score");
                            System.out.println(p3.getName() + " wins this round");
                            System.out.println("Banker loses " + p3.getWager() + " chips");
                            System.out.println(p3.getName() + "gains " + p3.getWager() + " chips");
                        }
                    }
                } else if (bankWinner == true) {
                    System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                    System.out.println("Banker automatically wins this round");
                    System.out.println("All players lost their wager to the Banker");
                }
                round ++;
                if (!p1.getAvailable() && !p2.getAvailable() && !p3.getAvailable()) {
                    end = true;
                    playerWin = false;
                } else if (boss.getChips() <= 0) {
                    end = true;
                    playerWin = true;
                }
            }
            if (playerWin = false) {
                System.out.println("The Banker won, better luck next time");
            } else if (playerWin = true) {
                System.out.println("The players won, good job");
            }
            System.out.println("Would all of you like to play again?");
            System.out.println("Enter y for yes, n for no");
            String again = scan.nextLine();
            while(!again.equals("y") && !again.equals("n")){
                System.out.println("invalid input");
                System.out.println("Enter y for yes, n for no");
                again = scan.nextLine();
            }
            if(again.equals("y")){
                playAgain = true;
            }
            else if(again.equals("n")){
                playAgain = false;
            }
        }
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
        p.setRoundWin(won);
        return won;
    }

    public boolean bankRound(){
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
            boss.addChips(p1.getWager());
            boss.addChips(p2.getWager());
            boss.addChips(p3.getWager());
            if(p1.getChips() > 0) {
                p1.addChips(-p1.getWager());
            }
            if(p2.getChips() > 0) {
                p2.addChips(-p2.getWager());
            }
            if(p3.getChips() > 0) {
                p3.addChips(-p3.getWager());
            }
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
                boss.addChips(p1.getWager());
                boss.addChips(p2.getWager());
                boss.addChips(p3.getWager());
                if(p1.getChips() > 0) {
                    p1.addChips(-p1.getWager());
                }
                if(p2.getChips() > 0) {
                    p2.addChips(-p2.getWager());
                }
                if(p3.getChips() > 0) {
                    p3.addChips(-p3.getWager());
                }
                won = true;
            } else if (compare(rolls, fail)) {
                boss.addChips(-p1.getWager());
                boss.addChips(-p2.getWager());
                boss.addChips(-p3.getWager());
                if(p1.getChips() > 0) {
                    p1.addChips(p1.getWager());
                }
                if(p2.getChips() > 0) {
                    p2.addChips(p2.getWager());
                }
                if(p3.getChips() > 0) {
                    p3.addChips(p3.getWager());
                }
                won = false;
            }
        }
        return won;
    }




}
