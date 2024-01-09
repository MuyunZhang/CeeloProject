
public class Banker {




    int chips;
    int score;
    public Banker(){
        chips = 1000;
        score = 0;
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
