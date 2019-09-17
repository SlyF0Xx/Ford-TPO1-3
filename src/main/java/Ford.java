import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Map;
import java.util.Random;

/**
 * Created by danil on 05.09.2019.
 */

public class Ford {
    INextRandomBoolean randomer;

    boolean isSckok;

    Ford(INextRandomBoolean randomer)
    {
        this.randomer = randomer;
    }

    void ToSckok(){
        isSckok = true;
    }

    void RandomTogle(ControlPanel cp){
        if(isSckok){
            for (Map.Entry<String, Boolean> togl :cp.toglers.entrySet()) {
                togl.setValue(randomer.next_random_boolean());
            }
            cp.Apply();
        }
    }
}
