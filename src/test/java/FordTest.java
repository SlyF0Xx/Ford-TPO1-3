import net.jqwik.api.*;
import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FordTest {

    @Provide
    Arbitrary<Map<String, Boolean>> first() {
        Arbitrary<String> keys = Arbitraries.strings();

        Arbitrary<Boolean> values = Arbitraries.samples(true, false);

        return Arbitraries.maps(keys, values).ofMinSize(1);
    }

    @Property
    boolean didnt_sckoc(@ForAll("first") HashMap<String, Boolean> any_toglers){
        Ford ford = new Ford(new TrueBoolean());
        Ship ship = new Ship();
        ControlPanel cp = new ControlPanel();
        cp.ship = ship;
        cp.toglers = any_toglers;
        ford.RandomTogle(cp);

        return !ship.isShaking && !ship.hasDrawnArc && !ship.hasRoteted && ship.direction == null;
    }

    @Property
    void did_sckoc(@ForAll("first") HashMap<String, Boolean> any_toglers){
        Ford ford = new Ford(new TrueBoolean());
        ford.ToSckok();
        Ship ship = new Ship();
        ControlPanel cp = new ControlPanel();
        cp.ship = ship;
        any_toglers.put("start", false);
        any_toglers.put("draw arc", false);
        any_toglers.put("rotate", false);
        cp.toglers = any_toglers;

        ford.RandomTogle(cp);

        assertThat(ship.isShaking).isTrue();
        assertThat(ship.hasDrawnArc).isTrue();
        assertThat(ship.hasRoteted).isTrue();
    }

}
