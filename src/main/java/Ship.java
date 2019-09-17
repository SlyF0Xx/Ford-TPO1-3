/**
 * Created by danil on 05.09.2019.
 */
public class Ship {
    Vector3 direction;
    public boolean isShaking;
    boolean hasDrawnArc;
    boolean hasRoteted;

    void ToShake(){
        isShaking = true;
    }

    void Rotate(){
        hasRoteted = true;
    }

    void DrawArc(){
        hasDrawnArc = true;
    }

    void GoToRockets(Rockets rockets){
        direction = rockets.position;
    }

}
