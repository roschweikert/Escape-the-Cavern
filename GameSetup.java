import java.util.*;
/**
 * This will be the main body of code for the game
 *
 * @Robert Schweikert
 * @5/15/21
 */
public class GameSetup
{
    private String name;
    private Character player;
    private Health playerHealth;
    private Strength playerStrength;
    private int speed;
    public GameSetup()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello, before we get started what is your name?");
        name = scan.nextLine();
        System.out.println("Thanks " + name + ", what class do you want to be? Your options are a warrior, an all-around build,"
                           + " a thief, a high speed build, a tank, a high health build, or a wizard, a high attack build.");
        String type = scan.nextLine();
        type = type.toLowerCase();
        while(!(type.equals("wizard")||type.equals("warrior")||type.equals("tank")||type.equals("thief")))
        {
            System.out.println("That was an invalid response please put either warrior, thief, tank, or wizard.");
            type = scan.nextLine();
            type = type.toLowerCase();
        }
        if(type.equals("wizard"))
            player = new Wizard(name);
        if(type.equals("warrior"))
            player = new Warrior(name);
        if(type.equals("tank"))
            player = new Tank(name);
        if(type.equals("thief"))
            player = new Thief(name);
        playerHealth = new Health(player.getHealth());
        playerStrength = new Strength(player.getStrength());
        speed = player.getSpeed();
    }
    
    public Health getHealthClass()
    {
        return playerHealth;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public Strength getStrengthClass()
    {
        return playerStrength;
    }
    
    public int getStrength()
    {
        return playerStrength.getStrength();
    }
    
    public boolean isAlive()
    {
        return (playerHealth.getCurrentHealth() > 0);
    }
    
    public String healthInfo()
    {
        return "Your health is " + playerHealth.getCurrentHealth() + ", and your max health is " + playerHealth.getMaxHealth() + ".";
    }
    
    public String getName()
    {
        return name;
    }
    
    public String characterInfo()
    {
        return player.toString();
    }
}
