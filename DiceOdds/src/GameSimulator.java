/**
 *  Title:           DiceOdds
 * @author:          Matthew Hall
 *  This program calculates the wins and losses of each game
 *  for game one we calculate the average wins for 4 games
 *  for game two we calculate the average wins for 24 games
 *
 *  This program uses nest for loops and if else statements
 *  to determine what increments
 */


/**
   This program sumulates the wins and losses for
   two different games of dice.
*/
public class GameSimulator
{
   private int tries;
   private Die d1;
   private Die d2;
   private int wins;
   private int losses;

   /**
      Construct a simulator object for die games.
      @param numSides the number of sides on the die.
      @param numTries the number of times to run the simulation.
   */
   public GameSimulator(int numSides, int numTries)
   {
      tries = numTries; // This assigns tries with the parameter numTries
      d1 = new Die(numSides); // This assigned d1 with Die Class so that we can use class methods
      d2 = new Die(numSides); // This assigned d2 with Die Class so that we can use class methods

   }

   /**
      Runs a single die simulation.
      One die is cast 4 times. If a six appears in those 4 casts,
      then wins is incremented, otherwise losses is incremented.
      Simulation is run according to the number of tries set.
   */
   public void runSingleDieSimulation()
   {
      int atLeastOneD1 = 0;   //This variable is declared
      for (int i = 1; i <= tries; ++i) { //The for loop will loop the amount of times requested by the user
         atLeastOneD1 = 0; // This variable's purpose is to increment when a 6 is found
         for (int j = 0; j < 4; ++j) { //This nested for loop iterates 4 times for the game
            if (d1.cast() == 6){
               ++atLeastOneD1; //If the die rolls a 6 we increment 1
            }
         }
         if (atLeastOneD1 > 0) { //This is checking if atleast one 6 was rolled
            ++wins; //If it is then we increment the wins
         }
         else {
            ++losses; //Otherwise we increment the losses
         }
      }

   }

   /**
      Runs a double die simulation.
      A pair of dice are cast 24 times. If a double-six appears in
      those 24 casts, then wins is incremented, otherwise losses
      is incremented. The simulation is run according to the number
      of tries set.
   */
   public void runDoubleDieSimulation()
   {
      int atLeastOne = 0; //This variable is declared
      wins = 0; //We reset the wins and losses because the results of the last game are still stored
      losses = 0;
      for (int i = 1; i <= tries; ++i) { //The for loop will loop the amount of times requested by the user
         atLeastOne = 0; // This variable's purpose is to increment when a 6 is found
         for (int j = 0; j < 24; ++j) { //This nest for loop iterates 24 times for a single game
            if (d1.cast() == 6 && d2.cast() == 6){ //If the pair of dice both roll a 6 then "atLeastOne" increments
               ++atLeastOne;
               }
            }
            if (atLeastOne > 0) { //If atLeastOne is more than 1 then the wins increment
               ++wins;
            }
            else {
               ++losses;
            }
         }
      }

   /**
      Returns the % of wins.
      @return the % of wins.
   */
   public double getWinPercent()
   {
      return (double)(wins) / (wins + losses);
   }

   /**
      Returns the number of wins.
      @return the number of wins.
   */
   public int getWins()
   {
      return wins;
   }

   /**
      Returns the number of losses.
      @return the number of losses.
   */
   public int getLosses()
   {
      return losses;
   }
}
