/**
 * Created by danil on 05.09.2019.
 */
public class Main {
    public static void main(String [] args){
        RandomBoolean random = new RandomBoolean();

        Ford ford = new Ford(random);
        Ship ship = new Ship();
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.ship = ship;

        ford.ToSckok();
        ford.RandomTogle(controlPanel);
    }
}
