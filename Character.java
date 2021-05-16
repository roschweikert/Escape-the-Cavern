
/**
 * This will be the character creation
 *
 * @Robert
 * @5/15/21
 */
public class Character
{
    private int health, strength, speed;
    private String name, type;
    public Character(int health, int strength, int speed, String name, String type)
    {
        this.health = health;
        this.strength = strength;
        this.speed = speed;
        this.name = name;
        this.type = type;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public int getStrength()
    {
        return strength;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public String getType()
    {
        return type;
    }
    
    @Override public String toString()
    {
        return "You are a " + type + " named " + name + ".";
    }
}