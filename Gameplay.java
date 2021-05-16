import java.util.*;
/**
 * Gameplay is where the actual game will be run from.
 *
 * @Robert
 * @5/15/21
 */
public class Gameplay
{
    public static void main (String [] args)
    {
        Scanner scan = new Scanner(System.in);
        GameSetup g1 = new GameSetup();
        System.out.println(g1.characterInfo());
        System.out.println(g1.healthInfo());
        System.out.println();
        boolean finished = false;
        boolean validResponse = false;
        String direction;
        while(!finished)
        {
            System.out.println("Hello, thanks for playing \"Escape the Cavern\", before we get started I would like to explain how this works.");
            System.out.println("You will be given text that tells you about your setting, you can then give simple text commands, to interact with you environment.");;
            System.out.println("The directional commands are forwards, backwards, left, right, up, and down.");
            System.out.println("In the case that your command is not recognized you will get the same prompt again, please give a different command.");
            System.out.println("Thank you. Now let's begin.");
            System.out.println();
            System.out.println("You wake up in the middle of a cavern. You feel a dull pain in your head as if someone knocked you out.");
            System.out.println("There is a lit torch and a small dagger on the ground next to you, you pick them up, and stand up.");
            int hitHead = 0;
            while(!validResponse)
            {
                System.out.println("You look around, but can't see an exit. Which way do you want to go?");
                direction = scan.nextLine();
                if(direction.equals("left")||direction.equals("backwards")||direction.equals("forwards"))
                {   
                    hitHead ++;
                    if(hitHead > 8)
                    {
                        System.out.println("You ran into a wall too many times and died.");
                        System.out.println("Game over.");
                        return;
                    } 
                    System.out.println("You run into a wall, and then head back to your starting point.");
                }
                else if(direction.equals("right"))
                {
                    System.out.println();
                    System.out.println("To the right you find a hallway, and walk down it.");
                    System.out.println("It leads to another cave, however this one has a bag in it.");
                    System.out.println("There is also an exit of this cave in front of you. It seems to go up. Towards the surface, perhaps.");
                    validResponse = true;
                }
            }
            validResponse = false;
            boolean bagOpened = false;
            boolean whetstoneFound = false;
            while(!validResponse)
            {
                System.out.println("So what do you want to do now?");
                direction = scan.nextLine().toLowerCase();
                if(direction.equals("exit")||direction.equals("leave")||direction.equals("forward"))
                {
                    System.out.println();
                    System.out.println("You leave the room and go on to the next one.");
                    System.out.println("When you enter the next room you see a goblin holding a club.");
                    validResponse = true;
                }
                else if(direction.equals("bag")||direction.equals("open bag"))
                {
                    if(bagOpened)
                    {
                        System.out.println("You already checked there.");
                    }
                    else
                    {
                        System.out.println("You open the bag and find a sword, you recognize it and swap your dagger out for it.");
                        bagOpened = true;
                        g1.getStrengthClass().strengthBoost(2);
                    }
                }
                else if(whetstoneFound)
                    System.out.println("You already searched the room.");
                else if(direction.equals("look around"))
                {
                    System.out.println("In the corner of the room you find a whetstone on the ground.");
                    System.out.println("You sharpen your weapon, and put the whetstone in your pocket in case you find a new weapon later.");
                    g1.getStrengthClass().strengthBoost(1);
                }
            }
            validResponse = false;
            int goblinHealth = 32;
            while(!validResponse)
            {
                System.out.println("What is your plan of action?");
                direction = scan.nextLine().toLowerCase();
                if(direction.equals("run")||direction.equals("forward")||direction.equals("run past him")||direction.equals("go past him")
                ||direction.equals("flee")||direction.equals("go around")||direction.equals("leave"))
                {
                    if (g1.getSpeed() > 40)
                    {
                        System.out.println("You were able to get past him with just a scratch, only losing one health.");
                        g1.getHealthClass().damage(1);
                        validResponse = true;
                    }
                    else if (g1.getSpeed() <= 15)
                    {
                        System.out.println("You got hit trying to get past him and were forced back losing two health.");
                        g1.getHealthClass().damage(2);
                    }
                    else
                    {
                        System.out.println("You were barely hit but were forced back losing one health.");
                        g1.getHealthClass().damage(1);
                    }
                    if(!g1.isAlive())
                    {
                        System.out.println("You lost all of your health, and died.");
                        System.out.println("Game Over");
                    }
                    else
                    {
                        System.out.println(g1.healthInfo());
                    }
                }
                else if(direction.equals("fight")||direction.equals("attack"))
                {
                    if(g1.getSpeed() > 10)
                    {
                        goblinHealth -= g1.getStrength();
                        if(goblinHealth > 0)
                        {
                            System.out.println("You attacked the goblin however he is still standing.");
                        }
                    }
                    if(goblinHealth > 0)
                    {
                        g1.getHealthClass().damage((int)(Math.random()*3) + 1);
                        System.out.println("The goblin swings his club at you.");
                        System.out.println(g1.healthInfo());
                    }
                    else
                    {
                        System.out.println("You killed the goblin and leave the room.");
                        validResponse = true;
                        break;
                    }
                    if(g1.getSpeed() <= 10)
                    {
                        goblinHealth -= g1.getStrength();
                    }
                    if(goblinHealth <= 0)
                    {
                        System.out.println("You killed the goblin and leave the room.");
                        validResponse = true;   
                    }
                }
            }
            System.out.println();
            System.out.println("As you leave the room, you see light ahead of you. You follow it and it brings you outside where a horse is waiting for.");
            System.out.println();
            System.out.println("Congrats " + g1.getName() + ", you have escaped the cavern, and can return home to your village, where you can live the rest of your days in peace.");
            finished = true;
        }
    }
}
