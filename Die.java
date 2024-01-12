
public class Die {


    private int dice1;
    private int dice2;
    private int dice3;




    public Die(){
        dice1 = 0;
        dice2 = 0;
        dice3 = 0;
    }

    public void reset(){
        dice1 = 0;
        dice2 = 0;
        dice3 = 0;
    }

    public int rollDice1(){
        int hi = (int) (Math.random() * 6 + 1);
        dice1 = hi;
        return dice1;
    }
    public int rollDice2(){
        int hi = (int) (Math.random() * 6 + 1);
        dice2 = hi;
        return dice2;
    }
    public int rollDice3(){
        int hi = (int) (Math.random() * 6 + 1);
        dice3 = hi;
        return dice3;
    }

    public void setDice1(int dice1) {
        this.dice1 = dice1;
    }

    public void setDice2(int dice2) {
        this.dice2 = dice2;
    }

    public void setDice3(int dice3) {
        this.dice3 = dice3;
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


}
