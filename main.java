import java.util.Random;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        //game variables
        String[] enimies ={"Skeleton", "Zombic","Spider", "Assassin"};
        int maxEnemyHealth = 75;
        int enemyAttackDamage =25;

        //player variable
        int health =100;
        int attackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount =30;
        int healthpositionDropChance = 50;

        boolean running = true;
        System.out.println("Welcome to the Dungeon !");

        GAME:
        while(running)
        {
            System.out.println("------------------------------------");
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enimies[rand.nextInt(enimies.length)];
            System.out.println("\t # " +enemy +" appeared! #\n");
            //  #skeliton is appeared!

            while(enemyHealth >0)
            {
              System.out.println("\tYour Hp:" + health);
              System.out.println("\t"+enemy+"'s HP: "+enemyHealth);
              System.out.println("\n\tWhat would you like to do? ");
              System.out.println("\t1.Attack");
              System.out.println("\t2.Drink health potion");
              System.out.println("\t3.Run!");

              String input = sc.nextLine();
              if(input.equals("1"))
              {
                int damageDealt = rand.nextInt(attackDamage);
                int damageTaken = rand.nextInt(enemyAttackDamage);
                

                enemyHealth -= damageDealt;
                health -=damageTaken;
                System.out.println("\t> You Strike the "+enemy+" for "+damageDealt+" damage. ");
                System.out.println("\t> You recive "+damageTaken+" in retation: ");

                if(health <1)
                {
                    System.out.println("\t> You have taken too much damage, you are too weak to go on!");
                    break;
                }
              }
              else if(input.equals("2"))
              {
                if(numHealthPotions >0)
                {
                    health += healthPotionHealAmount;
                    numHealthPotions--;
                    System.out.println("\t> You drink health potion, healing yourself for "+ healthPotionHealAmount+" ."  +"\n\t> you now have"+health+"HP."
                    +"\n\t> You have "+numHealthPotions+" health positions left.\n");
    
                }
                else{
                    System.out.println("\t> You have health potions left! Defeat enemies for a chance to get one!\n");
                }

              }
              else if(input.equals("3"))
              {
                System.out.println("\t> You run away from the "+ enemy+" !");
                continue GAME;
              }
              else
              {
                System.out.println("\t Invalid command");
              }

            }
            if(health <1)
            {
                System.out.println(" You limp out of the dungeon, Weak from battel. ");
                break;
            }
            System.out.println("------------------------------------");
            System.out.println(" # "+ enemy + "was defeated! #");
            System.out.println(" # You have " + health+ " HP left.#");
            
            if(rand.nextInt(100) <healthpositionDropChance)
            {
                numHealthPotions ++;
                System.out.println(" # The "+ enemy+" dropped a health potion! # ");
                System.out.println(" # You now have "+ numHealthPotions +"health potion(s). # ");
            }
            System.out.println("------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1.Continue fighting");
            System.out.println("2. Exit dungeon");

            String input = sc.nextLine();

            while(!input.equals("1") && !input.equals("2"))
            {
                System.out.println(" Invalid command !");
                input = sc.nextLine();
            }
            if(input.equals("1"))
            {
              System.out.println("You continue on your advanture");
            }
            else if(input.equals("2")){
                System.out.println("You exit the dungeon, Succesful from your advanture");

            }
            System.out.println("######################");
        System.out.println("# THANKS FOR PLAYING #");
        System.out.println("######################");
        }
        sc.close();
    }
}
