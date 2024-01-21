public class Player {
    Player player1;
    Player player2;
    Player player3;
    int dice1;
    int dice2;
    int dice3;
    Die d = new Die();

    String name;
    int chips;
    int score;

    int wager;

    boolean inGame;
    boolean roundWin;

    public Player(String name){
        this.name = name;
        chips = 100;
        score = 0;
        wager = 0;
        inGame = true;
    }
    public void roll() {
        dice1 = d.rollDice1();
        dice2 = d.rollDice2();
        dice3 = d.rollDice3();
    }

    public void setRoundWin(boolean win){
        roundWin = win;
    }

    public boolean getRoundWin(){
        return roundWin;
    }
    public void setWager(int w){
        wager = w;
    }

    public int getWager(){
        return wager;
    }

    public void setAvailable(boolean in){
        inGame = in;
    }
    public boolean getAvailable(){
        return inGame;
    }
    public String getName(){
        return name;
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
    public int getChips() {
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
