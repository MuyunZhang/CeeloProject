
public class Banker {
    int chips;
    int score;
    int dice1;
    int dice2;
    int dice3;
    Die d = new Die();
    public Banker(){
        chips = 1000;
        score = 0;
    }
    public void roll() {
        dice1 = d.rollDice1();
        dice2 = d.rollDice2();
        dice3 = d.rollDice3();
    }

    public int getDice1(){
        return dice1;
    }
    public int getDice2(){
        return dice2;
    }
    public int getDice3(){
        return dice3;
    }

    public int getChips(){
        return chips;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int points){
        score = points;
    }

    public void addChips(int added){
        chips += added;
    }

    public void loseChips(int loss){
        chips -= loss;
    }
}
