/**
 * Created by danil on 05.09.2019.
 */
public class Rockets {
    Vector3 position = new Vector3(0, 0, 0);
    String name;

    public Rockets(String name)
    {
        this.name = name;
    }

    public Rockets(String name, Vector3 position)
    {
        this.name = name;
        this.position = position;
    }

    static private Rockets instance;

    public static Rockets get_instance() {
        if(instance == null) {
            instance = new Rockets("static");
        }
        return instance;
    }

}
