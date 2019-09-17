import net.jqwik.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

public class ControllPanaelTest {
    @Provide
    Arbitrary<Map<String, Boolean>> first() {
        Arbitrary<String> keys = Arbitraries.strings()
                                            .withSamples("start")
                                            .withSamples("draw arc")
                                            .withSamples("rotate");

        Arbitrary<Boolean> values = Arbitraries.constant(false);

        return Arbitraries.maps(keys, values);
    }

    @Property
    boolean disabled_toglers(@ForAll("first") HashMap<String, Boolean> disabled_toglers)
    {
        Ship ship = new Ship();
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.ship = ship;

        controlPanel.toglers = disabled_toglers;

        controlPanel.Apply();
        return !ship.isShaking && !ship.hasDrawnArc && !ship.hasRoteted && ship.direction == null;
    }

    @Example
    void empty_togler_test()
    {
        Ship ship = new Ship();
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.ship = ship;

        controlPanel.Apply();
        assertThat(ship.isShaking).isFalse();
        assertThat(ship.hasDrawnArc).isFalse();
        assertThat(ship.hasRoteted).isFalse();
        assertThat(ship.direction).isNull();
    }

    @Example
    void start_togler_test()
    {
        Ship ship = new Ship();
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.ship = ship;

        controlPanel.toglers.put("start", true);

        controlPanel.Apply();
        assertThat(ship.isShaking).isTrue();
        assertThat(ship.hasDrawnArc).isFalse();
        assertThat(ship.hasRoteted).isFalse();
        assertThat(ship.direction).isNull();
    }

    @Example
    void draw_arc_togler_test()
    {
        Ship ship = new Ship();
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.ship = ship;

        controlPanel.toglers.put("draw arc", true);

        controlPanel.Apply();
        assertThat(ship.isShaking).isFalse();
        assertThat(ship.hasDrawnArc).isTrue();
        assertThat(ship.hasRoteted).isFalse();
        assertThat(ship.direction).isNull();
    }

    @Example
    void rotate_togler_test()
    {
        Ship ship = new Ship();
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.ship = ship;

        controlPanel.toglers.put("rotate", true);

        controlPanel.Apply();
        assertThat(ship.isShaking).isFalse();
        assertThat(ship.hasDrawnArc).isFalse();
        assertThat(ship.hasRoteted).isTrue();
        assertThat(ship.direction).isNull();
    }

    @Example
    void rocket_togler_test()
    {
        Ship ship = new Ship();
        ControlPanel controlPanel = new ControlPanel();
        controlPanel.ship = ship;

        Rockets test_rocket = new Rockets("test rocket");
        controlPanel.rockets.add(test_rocket);
        controlPanel.toglers.put("test rocket", true);

        controlPanel.Apply();
        assertThat(ship.isShaking).isFalse();
        assertThat(ship.hasDrawnArc).isFalse();
        assertThat(ship.hasRoteted).isFalse();
        assertThat(ship.direction).isEqualTo(test_rocket.position);
    }
}
