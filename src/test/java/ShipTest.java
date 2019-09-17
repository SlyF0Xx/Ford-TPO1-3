import net.jqwik.api.*;

public class ShipTest {
    @Provide
    Arbitrary<Rockets> first() {
        Arbitrary<Integer> x = Arbitraries.integers();
        Arbitrary<Integer> y = Arbitraries.integers();
        Arbitrary<Integer> z = Arbitraries.integers();

        Arbitrary<Vector3> vector3 = Combinators.combine(x, y, z).as(Vector3::new);

        Arbitrary<String> rocket_name = Arbitraries.strings();

        return Combinators.combine(rocket_name, vector3).as(Rockets::new);
    }


    @Property
    boolean ship_rocket_test_x(@ForAll("first") Rockets rockets)
    {
        Ship ship = new Ship();
        ship.GoToRockets(rockets);
        return rockets.position.x == ship.direction.x;
    }

    @Property
    boolean ship_rocket_test_y(@ForAll("first") Rockets rockets)
    {
        Ship ship = new Ship();
        ship.GoToRockets(rockets);
        return rockets.position.y == ship.direction.y;
    }

    @Property
    boolean ship_rocket_test_z(@ForAll("first") Rockets rockets)
    {
        Ship ship = new Ship();
        ship.GoToRockets(rockets);
        return rockets.position.z == ship.direction.z;
    }

    /*
    @Test
    void ship_shake_test()
    {
    }
    */
}
