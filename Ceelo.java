
import java.awt.*;
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
    private Banker boss = new Banker();
    private Die d;
    private boolean end = false;
    private Scanner scan;

    String highest = "";

    private boolean bankWinner;

    private boolean pWin;
    private int round;

    private boolean playAgain = true;


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
        System.out.println("Game ready, defeat the Banker");

    }

    public void gameplay(){
        while(playAgain == true) {
            setup();
            boolean playerWin = false;
            while (!end) {
                round++;
                System.out.println("Round " + round);
                System.out.println("---------------------------------------------------------------------------------" + "\n");
                if (p1.getChips() > 0) {
                    System.out.println(p1.getName() + ", how many chips do you wager");
                    int w1 = scan.nextInt();
                    while(w1 > p1.getChips() || w1 < 0){
                        System.out.println("invalid input");
                        System.out.println(p1.getName() + ", how many chips do you wager");
                        w1 = scan.nextInt();
                    }
                    scan.nextLine();
                    p1.setWager(w1);
                } else {
                    p1.setAvailable(false);
                    System.out.println(p1.getName() + " is unavailable");
                }
                if (p2.getChips() > 0) {
                    System.out.println(p2.getName() + ", how many chips do you wager");
                    int w2 = scan.nextInt();
                    while(w2 > p2.getChips() || w2 < 0){
                        System.out.println("invalid input");
                        System.out.println(p2.getName() + ", how many chips do you wager");
                        w2 = scan.nextInt();
                    }
                    scan.nextLine();
                    p2.setWager(w2);
                } else {
                    p2.setAvailable(false);
                    System.out.println(p2.getName() + " is unavailable");
                }
                if (p3.getChips() > 0) {
                    System.out.println(p3.getName() + ", how many chips do you wager");
                    int w3 = scan.nextInt();
                    while(w3 > p3.getChips() || w3 < 0){
                        System.out.println("invalid input");
                        System.out.println(p3.getName() + ", how many chips do you wager");
                        w3 = scan.nextInt();
                    }
                    scan.nextLine();
                    p3.setWager(w3);
                } else {
                    p3.setAvailable(false);
                    System.out.println(p3.getName() + " is unavailable");
                }

                System.out.println(Colors.BLUE + "Start" + "\n" + "---------------------------------" + Colors.RESET);
                bankRound();
                if (boss.getRoundWin() == false && boss.getScore() > 0) {
                    bankScore = boss.getScore();
                    bankWinner = false;
                } else if (boss.getRoundWin() == false) {
                    bankWinner = false;
                    pWin = true;
                } else {
                    bankWinner = true;
                }
                if (bankWinner == false && pWin == false) {
                    if (p1.getAvailable()) {
                        pRound(p1, p1.getWager());
                        if (p1.getRoundWin() == true) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p1.getName() + " rolled " + p1.getDice1() + ", " + p1.getDice2() + ", " + p1.getDice3());
                            System.out.println(p1.getName() + " automatically wins this round");
                            System.out.println("Banker loses " + p1.getWager() + " chips");
                            System.out.println(p1.getName() + " gains " + p1.getWager() + " chips");
                        }else if (p1.getRoundWin() == false && p1.getScore() == 0) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p1.getName() + " rolled " + p1.getDice1() + ", " + p1.getDice2() + ", " + p1.getDice3());
                            System.out.println(p1.getName() + " automatically loses this round");
                            System.out.println("Banker gains " + p1.getWager() + " chips");
                            System.out.println(p1.getName() + " loses " + p1.getWager() + " chips");
                        }
                        else if (boss.getScore() > p1.getScore()) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p1.getName() + " rolled " + p1.getDice1() + ", " + p1.getDice2() + ", " + p1.getDice3());
                            System.out.println("Banker's score this round is: " + boss.getScore());
                            System.out.println(p1.getName() + "'s score this round is: " + p1.getScore());
                            System.out.println("Banker won this round against you");
                            System.out.println("Banker gains " + p1.getWager() + " chips");
                            boss.addChips(p1.getWager());
                            System.out.println(p1.getName() + " lost " + p1.getWager() + " chips");
                            p1.loseChips(p1.getWager());
                        } else if(p1.getScore() > boss.getScore()){
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p1.getName() + " rolled " + p1.getDice1() + ", " + p1.getDice2() + ", " + p1.getDice3());
                            System.out.println("Banker's score this round is: " + boss.getScore());
                            System.out.println(p1.getName()+ "'s score this round is: " + p1.getScore());
                            System.out.println(p1.getName() + " has a higher score");
                            System.out.println(p1.getName() + " wins this round");
                            System.out.println("Banker loses " + p1.getWager() + " chips");
                            boss.loseChips(p1.getWager());
                            System.out.println(p1.getName() + " gains " + p1.getWager() + " chips");
                            p1.addChips(p1.getWager());
                        }
                        else{
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p1.getName() + " rolled " + p1.getDice1() + ", " + p1.getDice2() + ", " + p1.getDice3());
                            System.out.println("Tie");
                            System.out.println(p1.getName() + " wins this round");
                            System.out.println(p1.getName() + " gains " + p1.getWager() + " chips");
                            p1.addChips(p1.getWager());
                            System.out.println("Banker loses " + p1.getWager() + " chips");
                            boss.loseChips(p1.getWager());
                        }
                    }
                    System.out.println(Colors.YELLOW + "-------------------------------------------------------------------------------------" + Colors.RESET);
                    if (p2.getAvailable() && boss.getChips() > 0) {
                        pRound(p2, p2.getWager());
                        if (p2.getRoundWin() == true) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p2.getName() + " rolled " + p2.getDice1() + ", " + p2.getDice2() + ", " + p2.getDice3());
                            System.out.println(p2.getName() + " automatically wins this round");
                            System.out.println("Banker loses " + p2.getWager() + " chips");
                            System.out.println(p2.getName() + " gains " + p2.getWager() + " chips");
                        }else if (p2.getRoundWin() == false && p2.getScore() == 0) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p2.getName() + " rolled " + p2.getDice1() + ", " + p2.getDice2() + ", " + p2.getDice3());
                            System.out.println(p2.getName() + " automatically loses this round");
                            System.out.println("Banker gains " + p2.getWager() + " chips");
                            System.out.println(p2.getName() + " loses " + p2.getWager() + " chips");
                        }
                        else if (boss.getScore() > p2.getScore()) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p2.getName() + " rolled " + p2.getDice1() + ", " + p2.getDice2() + ", " + p2.getDice3());
                            System.out.println("Banker's score this round is: " + boss.getScore());
                            System.out.println(p2.getName() + "'s score this round is: " + p2.getScore());
                            System.out.println("Banker won this round against you");
                            System.out.println("Banker gains " + p2.getWager() + " chips");
                            boss.addChips(p2.getWager());
                            System.out.println(p2.getName() + " lost " + p2.getWager() + " chips");
                            p2.loseChips(p2.getWager());
                        } else if(p2.getScore() > boss.getScore()){
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p2.getName() + " rolled " + p2.getDice1() + ", " + p2.getDice2() + ", " + p2.getDice3());
                            System.out.println("Banker's score this round is: " + boss.getScore());
                            System.out.println(p2.getName()+ "'s score this round is: " + p2.getScore());
                            System.out.println(p2.getName() + " has a higher score");
                            System.out.println(p2.getName() + " wins this round");
                            System.out.println("Banker loses " + p2.getWager() + " chips");
                            boss.loseChips(p2.getWager());
                            System.out.println(p2.getName() + " gains " + p2.getWager() + " chips");
                            p2.addChips(p2.getWager());
                        }
                        else{
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p2.getName() + " rolled " + p2.getDice1() + ", " + p2.getDice2() + ", " + p2.getDice3());
                            System.out.println("Tie");
                            System.out.println(p2.getName() + " wins this round");
                            System.out.println(p2.getName() + " gains " + p2.getWager() + " chips");
                            p2.addChips(p2.getWager());
                            System.out.println("Banker loses " + p2.getWager() + " chips");
                            boss.loseChips(p2.getWager());
                        }
                    }
                    System.out.println(Colors.YELLOW + "-------------------------------------------------------------------------------------" + Colors.RESET);
                    if (p3.getAvailable() && boss.getChips() > 0) {
                        pRound(p3, p3.getWager());
                        if (p3.getRoundWin() == true) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p3.getName() + " rolled " + p3.getDice1() + ", " + p3.getDice2() + ", " + p3.getDice3());
                            System.out.println(p3.getName() + " automatically wins this round");
                            System.out.println("Banker loses " + p3.getWager() + " chips");
                            System.out.println(p3.getName() + " gains " + p3.getWager() + " chips");
                        } else if (p3.getRoundWin() == false && p3.getScore() == 0) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p3.getName() + " rolled " + p3.getDice1() + ", " + p3.getDice2() + ", " + p3.getDice3());
                            System.out.println(p3.getName() + " automatically loses this round");
                            System.out.println("Banker gains " + p3.getWager() + " chips");
                            System.out.println(p3.getName() + " loses " + p3.getWager() + " chips");
                        } else if (boss.getScore() > p3.getScore()) {
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p3.getName() + " rolled " + p3.getDice1() + ", " + p3.getDice2() + ", " + p3.getDice3());
                            System.out.println("Banker's score this round is: " + boss.getScore());
                            System.out.println(p3.getName() + "'s score this round is: " + p3.getScore());
                            System.out.println("Banker won this round against you");
                            System.out.println("Banker gains " + p3.getWager() + " chips");
                            boss.addChips(p3.getWager());
                            System.out.println(p3.getName() + " lost " + p3.getWager() + " chips");
                            p3.loseChips(p3.getWager());
                        } else if(p3.getScore() > boss.getScore()){
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p3.getName() + " rolled " + p3.getDice1() + ", " + p3.getDice2() + ", " + p3.getDice3());
                            System.out.println("Banker's score this round is: " + boss.getScore());
                            System.out.println(p3.getName()+ "'s score this round is: " + p3.getScore());
                            System.out.println(p3.getName() + " has a higher score");
                            System.out.println(p3.getName() + " wins this round");
                            System.out.println("Banker loses " + p3.getWager() + " chips");
                            boss.loseChips(p3.getWager());
                            System.out.println(p3.getName() + " gains " + p3.getWager() + " chips");
                            p3.addChips(p3.getWager());
                        }
                        else{
                            System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                            System.out.println(p3.getName() + " rolled " + p3.getDice1() + ", " + p3.getDice2() + ", " + p3.getDice3());
                            System.out.println("Tie");
                            System.out.println(p3.getName() + " wins this round");
                            System.out.println(p3.getName() + " gains " + p3.getWager() + " chips");
                            p3.addChips(p3.getWager());
                            System.out.println("Banker loses " + p3.getWager() + " chips");
                            boss.loseChips(p3.getWager());
                        }
                    }
                } else if (bankWinner == true) {
                    System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                    System.out.println("Banker automatically wins this round");
                    System.out.println("All players lost their wager to the Banker");
                }
                else if(bankWinner == false && pWin == true){
                    System.out.println("Banker rolled " + boss.getDice1() + ", " + boss.getDice2() + ", " + boss.getDice3());
                    System.out.println("Banker automatically loses this round");
                    System.out.println("All players takes their wagers from the Banker");
                }
                System.out.println("Round over");
                p1.setScore(0);
                p2.setScore(0);
                p3.setScore(0);
                p1.setRoundWin(false);
                p2.setRoundWin(false);
                p3.setRoundWin(false);
                boss.setScore(0);
                boss.setRoundWin(false);
                bankWinner = false;
                System.out.println("This round's results: ");
                System.out.println("--------------------------------------------" + "\n");
                if(p1.getAvailable()){
                    System.out.println(p1.getName() + " has " + p1.getChips() + " chips left");
                }
                else{
                    System.out.println(p1.getName() + " is out");
                }
                if(p2.getAvailable()){
                    System.out.println(p2.getName() + " has " + p2.getChips() + " chips left");
                }
                else{
                    System.out.println(p2.getName() + " is out");
                }
                if(p3.getAvailable()){
                    System.out.println(p3.getName() + " has " + p3.getChips() + " chips left");
                }
                else{
                    System.out.println(p3.getName() + " is out");
                }
                if(boss.getChips() > 0){
                    System.out.println("The Banker has " + boss.getChips() + " chips left");
                }
                else{
                    System.out.println("The Banker is out");
                }
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("error");
                }

                if (!p1.getAvailable() && !p2.getAvailable() && !p3.getAvailable()) {
                    end = true;
                    playerWin = false;
                } else if (boss.getChips() <= 0) {
                    end = true;
                    playerWin = true;
                }

            }
            if (playerWin == false) {
                System.out.println("The Banker won, better luck next time");
            }
            else if (playerWin == true) {
                System.out.println("The players won, good job");
                System.out.println("The player with the highest score is " + highest + " with " + highestScore() + " chips left");
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
                bankWinner = false;
                end = false;
            }
            else if(again.equals("n")){
                playAgain = false;
            }
        }
    }

    public int highestScore(){
        int score = 0;
        if(score < p1.getChips()){
            score = p1.getChips();
            highest = p1.getName();
        }
        if(score < p2.getChips()){
            score = p2.getChips();
            highest = p2.getName();
        }
        if(score < p3.getChips()){
            score = p3.getChips();
            highest = p3.getName();
        }
        return score;
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


    public void pRound(Player p, int bet){
        p.roll();
        int f = p.getDice1();
        int s = p.getDice2();
        int t = p.getDice3();
        int[] fail = new int[]{1,2,3};
        int[] win = new int[]{4,5,6};
        int[] rolls = new int[]{f, s, t};
        boolean again  = repeat(rolls);
        while(again == true){
            p.roll();
            f = p.getDice1();
            s = p.getDice2();
            t = p.getDice3();
            rolls = new int[]{f, s, t};
            again = repeat(rolls);
        }

        if(f == s && s == t){
            p.addChips(bet);
            boss.loseChips(bet);
            p.setRoundWin(true);
        }
        else if(f == s){
            p.setScore(t);
        }
        else if(f == t){
            p.setScore(s);
        }
        else if(s == t){
            p.setScore(f);
        }
        else {
            Arrays.sort(rolls);
            if(compare(rolls, win)){
                p.addChips(bet);
                boss.loseChips(bet);
                p.setRoundWin(true);
            } else if (compare(rolls, fail)) {
                p.loseChips(bet);
                boss.addChips(bet);
                p.setRoundWin(false);
            }
        }
    }

    public void bankRound(){
        boss.roll();
        int f = boss.getDice1();
        int s = boss.getDice2();
        int t = boss.getDice3();
        int[] fail = new int[]{1,2,3};
        int[] win = new int[]{4,5,6};
        int[] rolls = new int[]{f, s, t};
        boolean again = repeat(rolls);
        while(again == true){
            boss.roll();
            f = boss.getDice1();
            s = boss.getDice2();
            t = boss.getDice3();
            rolls = new int[]{f, s, t};
            again = repeat(rolls);
        }
        if(f == s && s == t){
            boss.addChips(p1.getWager());
            boss.addChips(p2.getWager());
            boss.addChips(p3.getWager());
            if(p1.getChips() > 0) {
                p1.loseChips(p1.getWager());
            }
            if(p2.getChips() > 0) {
                p2.loseChips(p2.getWager());
            }
            if(p3.getChips() > 0) {
                p3.loseChips(p3.getWager());
            }
            boss.setRoundWin(true);
        }
        else if(f == s){
            boss.setScore(t);
        }
        else if(f == t){
            boss.setScore(s);
        }
        else if(s == t){
            boss.setScore(f);
        }
        else {
            Arrays.sort(rolls);
            if(compare(rolls, win)){
                boss.addChips(p1.getWager());
                boss.addChips(p2.getWager());
                boss.addChips(p3.getWager());
                if(p1.getChips() > 0) {
                    p1.loseChips(p1.getWager());
                }
                if(p2.getChips() > 0) {
                    p2.loseChips(p2.getWager());
                }
                if(p3.getChips() > 0) {
                    p3.loseChips(p3.getWager());
                }
                boss.setRoundWin(true);
            } else if (compare(rolls, fail)) {
                boss.loseChips(p1.getWager());
                boss.loseChips(p2.getWager());
                boss.loseChips(p3.getWager());
                if(p1.getChips() > 0) {
                    p1.addChips(p1.getWager());
                }
                if(p2.getChips() > 0) {
                    p2.addChips(p2.getWager());
                }
                if(p3.getChips() > 0) {
                    p3.addChips(p3.getWager());
                }
                boss.setRoundWin(false);
            }
        }
    }
}
