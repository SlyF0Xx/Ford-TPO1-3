import java.util.Random;

class RandomBoolean implements INextRandomBoolean
{
    @Override
    public boolean next_random_boolean()
    {
        return new Random().nextBoolean();
    }
}