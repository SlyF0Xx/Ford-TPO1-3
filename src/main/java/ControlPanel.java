import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.stream.Stream;

/**
 * Created by danil on 05.09.2019.
 */
public class ControlPanel {
    public HashMap<String, Boolean> toglers = new HashMap<>();
    public HashSet<Rockets> rockets = new HashSet<>();
    public Ship ship;

    public void Apply(){
        for (Map.Entry<String, Boolean> togler : toglers.entrySet()) {
            if (togler.getKey().equals("start") && togler.getValue()) {
                ship.ToShake();
            } else if (togler.getKey().equals("draw arc") && togler.getValue()) {
                ship.DrawArc();
            } else if (togler.getKey().equals("rotate") && togler.getValue()) {
                ship.Rotate();
            } else if (togler.getValue()) {
                /*
                Stream<Rockets> stream = rockets.stream().filter((rocket) -> rocket.name.equals(togler.getKey()));
                if (stream.count() == 1) {
                    ship.GoToRockets(stream.findFirst().get());
                }
                */
                if (rockets.stream().filter((rocket) -> rocket.name.equals(togler.getKey())).count() == 1) {
                    ship.GoToRockets(rockets.stream().filter((rocket) -> rocket.name.equals(togler.getKey())).findFirst().get());
                }
            }
        }
    }
}
