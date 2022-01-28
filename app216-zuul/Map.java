import java.util.*;
/**
 * This class is reponsible for creating and
 * linking all the Locations in the game to
 * form a 2D or 3D network
 *
 *  [Pub]<---->[Outside]<---->[Theatre]
 *                 |
 *          [Computer Lab]<---->[Office]
 *             
 * @author Derek Peacock and Nicholas Day
 * @version 2021-08-22
 */
public class Map
{
    // Need to add a list of exits
    
    CommandReader reader;
    
    private Location warehouse, petrolstation, address1, address2,
    address3, address4, address5, address6, address7, address8;

    private Location currentLocation;
    
    public Player player;
    
    public int fuelcapacity;
    
    public ArrayList<Location> checklist;

    /**
     * Constructor for objects of class Map
     */
    public Map()
    {
        createLocations();
    }

    /**
     * Create all the Locations and link their exits together.
     * Set the current location to the outside.
     * Both locations need to have been created before
     * their exists are linked.
     */
    private void createLocations()
    {
        createWarehouse();
        createAddress1();
        createAddress2();
        createAddress3();
        createAddress4();
        createAddress5();
        createAddress6();
        createAddress7();
        createAddress8();
        createPetrolStation();
        currentLocation = warehouse;  // start game outside
    }
    
    /**
     * Create the outside and link it to the
     * theatre, lab and pub
     */
    private void createWarehouse()
    {
        warehouse = new Location("Current Location: Warehouse");
        warehouse.setExit("east", address1);
        this.fuelcapacity = 100;
    }
    
    private void createPetrolStation()
    {
        petrolstation = new Location("Current Location: Petrol Station");
        petrolstation.optionsForFuel();
        petrolstation.setExit("west", address5);
        address1.deliverProduct();
    }
    
    private void createAddress1()
    {
        address1 = new Location("Current Location: Address 1");
        warehouse.setExit("east", address1);
        address1.setExit("east", address2);
        address1.setExit("west", warehouse);
        address1.deliverProduct();
    }
    
      public int decreaseFuelCapacity()
    {
      int min = 15;
      int max = 18;
      
      //Generate random int value from 15 to 18
      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
      
      this.fuelcapacity = this.fuelcapacity - random_int;
      
      return this.fuelcapacity;
    }
    
    public int getFuelCapacity()
    {
        return fuelcapacity;
    }
    
     public void optionForDelivery()
    {
    }
    
    private void createAddress2()
    {
        address2 = new Location("Current Location: Address 2");
        address2.setExit("west", address1);
        address2.setExit("east", address3);
        address1.setExit("east", address2);
        address2.setExit("to petrol station", petrolstation);
        address2.deliverProduct();
    }
    
    public void deliverPackageToAddress1()
    {
    }
    
    private void createAddress3()
    {
        address3 = new Location("Current Location: Address 3");
        address3.setExit("west", address2);
        address3.setExit("east", address4);
        address2.setExit("east", address3);
        address3.setExit("to petrol station", petrolstation);
        address3.deliverProduct();
    }
    
    private void createAddress4()
    {
        address4 = new Location("Current Location: Address 4");
        address4.setExit("east", address5);
        address4.setExit("west", address3);
        address3.setExit("east", address4);
        address4.deliverProduct();
    }
    
    /**
     * Create the pub and link it to the outside
     */
    private void createAddress5()
    {
        address5 = new Location("Current Location: Address 5");
        address5.setExit("west", address4);
        address4.setExit("east", address5);
        address5.setExit("east", petrolstation);
        address5.deliverProduct();
    }
    
    private void createAddress6()
    {
        address6 = new Location("Current Location: Address 6");
        address6.setExit("east", address7);
        address6.setExit("west", address5);
        address5.setExit("east", address6);
        address6.setExit("to petrol station", petrolstation);
    }
    
    /**
     * Create the office linked to the lab
     */
    private void createAddress7()
    {
        address7 = new Location("Current Location: Address 7");
        address7.setExit("east", address8);
        address7.setExit("west", address6);
        address6.setExit("east", address7);
        address7.setExit("to petrol station", petrolstation);
    }
    
    /**
     * Create the lab and link it to the outside and office
     */
    private void createAddress8()
    {
        // create the Locations
        address8 = new Location("Current Location: Address 8");
        address7.setExit("east", address8);
        address8.setExit("to petrol station", petrolstation);
        address8.setExit("west", address7);
        warehouse.setExit("to warehouse", warehouse);
        warehouse.setExit("previous address", address8);
    }
    
    public Location getCurrentLocation()
    {
        return currentLocation;
    }
    
    public void enterLocation(Location nextLocation)
    {
        currentLocation = nextLocation;
    }
}
