import java.util.*;
import java.lang.Math;

public class Player
{
    // instance variables - replace the example below with your own
    public int fuelcapacity;
    
    private int accountbalance;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        // initialise instance variables
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getFuelAmount()
    {
        // put your code here
     return fuelcapacity;
    }
    
    public int decreaseFuelCapacity()
    {
      int min = 15;
      int max = 18;
        
      //Generate random int value from 15 to 18
      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);

      return fuelcapacity = fuelcapacity - random_int;
    }
    
    public int increaseAccountBalance()
    {
        return accountbalance += 10;
    }
    
    public void increaseFuelByTwentyEight()
    {
        this.fuelcapacity = fuelcapacity + 28;
    }
    
    public void increaseFuelByFiftySeven()
    {
        this.fuelcapacity = fuelcapacity + 57;
    }
    
    public int getBalance()
    {
        return accountbalance;
    }
    
    public int getFuelCapacity()
    {
        return fuelcapacity;
    }
    
}
