
/**
 * The wizard will be a magical character with high strength, 
 * but low health and speed
 *
 * @Robert
 * @5/15/21
 */
public class Wizard extends Character
{
    private boolean magic;
    public Wizard(String name)
    {
        super(25, 70, 15, name, "wizard");
        this.magic = true;
    }
}