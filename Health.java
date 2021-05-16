
/**
 * Write a description of class Health here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Health
{
    private int health, maxHealth;
    public Health(int health)
    {
        this.health = health;
        this.maxHealth = health;
    }

    public void healthBoost(int boostAmount)
    {
        health += boostAmount;
        maxHealth += boostAmount;
        System.out.println("Your max health has been boosted and is now " + maxHealth + ".");
        notOver();
    }
    
    public void healing(int amountHealed)
    {
        health += amountHealed;
        notOver();
    }
    
    public void healing (double percentHealed)
    {
        health += (percentHealed*maxHealth);
        notOver();
    }
    
    public void damage(int damaged)
    {
        health -= damaged;
    }
    
    public void damage(double percentDamage)
    {
        health -= (percentDamage * maxHealth);
    }
    
    public void notOver()
    {
        if(health > maxHealth)
            health = maxHealth;
    }
    
    public int getCurrentHealth()
    {
        return health;
    }
    
    public int getMaxHealth()
    {
        return maxHealth;
    }
}
