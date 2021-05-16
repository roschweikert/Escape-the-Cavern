
/**
 * Write a description of class Strength here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Strength
{
    private int strength;
    public Strength(int strength)
    {
        this.strength = strength;
    }

    public void strengthBoost(int amountBoosted)
    {
        strength += amountBoosted;
    }
    
    public int getStrength()
    {
        return strength;
    }
}
