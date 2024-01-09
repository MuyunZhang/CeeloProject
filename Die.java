
public class Die {


    private int dice1;
    private int dice2;
    private int dice3;




    public Die(){
        dice1 = 0;
        dice2 = 0;
        dice3 = 0;
    }


    public void rollDice1(){
        int hi = (int) (Math.random() * 6 + 1);
        dice1 = hi;
    }
    public void rollDice2(){
        int hi = (int) (Math.random() * 6 + 1);
        dice2 = hi;
    }
    public void rollDice3(){
        int hi = (int) (Math.random() * 6 + 1);
        dice3 = hi;
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
