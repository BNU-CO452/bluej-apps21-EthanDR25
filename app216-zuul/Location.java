import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
/**
 * Class Location - a location on the map of an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Location" represents one place in the scenery of the game.  It is 
 * connected to other locations via exits.  For each existing exit, the 
 * location stores a reference to the neighboring locations.
 * 
 * @author  Michael Kölling and David J. Barnes
 * Modified by Derek Peacock & Nicholas Day
 * @version 2016.02.29
 */

public class Location 
{
    private String description;
    private HashMap<String, Location> exits;
    private boolean isDelivered;
    // stores exits of this room.
    public Player player;
    
    public ArrayList<Location> checklist;
    
    Location address;
    /**
     * Create a location described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     */
    public Location(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }
    
    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Location neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }
    
    public boolean deliverProduct()
    {
        return isDelivered = true;
    }
    
    public void deliverAProduct()
    {
    }
    
    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return description;
    }
    
    public void optionsForFuel()
    {
        
    }
    
    public void increasePetrolOption()
    {
        System.out.println("Increase Fuel");
        System.out.println("How much?" + "\n\n" + "£18: 28 gallons");
        System.out.println("How much?" + "\n\n" + "£28: 57 gallons");
    }
    
    public int increaseFuelByTwentyEight()
    {
        return player.getFuelAmount() + 28;
    }
    
     public int increaseFuelByFiftySeven()
    {
        return player.getFuelAmount() + 57;
    }
    
   /**
     * Return a string describing the locations's exits, 
     * for example "Exits: north west".
     */
    private String getExitString()
    {
        String returnString = "Available Exits: ";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            returnString += "\n\n" + exit;
        }
        return returnString;
    }

    
    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Location getExit(String direction) 
    {
        return exits.get(direction);
    }
}

