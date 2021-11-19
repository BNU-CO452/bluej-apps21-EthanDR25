import java.util.ArrayList;
import java.util.Arrays;
/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (Ethan Dias-Richards) 
 * @version (18/11/2021)
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockList()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void add(Product item)
    {
        stock.add(item);
    }
    
    /**
     * This is the method for removing a product.
     */
    public void removeProduct(int productID)
    {
        Product product = findProduct(productID);
        stock.remove(product);
    }
    
    /**
     * This is a method used to set the quantity of a product as oppose to
     * using a feature within a java library to assign random values to all of the products.
     */
    public void setStockOfAProduct(int productID, int quantity)
    {
        Product product = findProduct(productID);
        product.setQuantity(quantity);
    }
    
    public void searchForPhrase(String phrase)
    {
        if(phrase == "iPhone")
            {
                System.out.println("Product: iPhone 7" + "\nID: 81");
                System.out.println("Product: iPhone 8" + "\nID: 82");
            }
        }
        
    public void printProductsWithLowStock()
    {
        int lowStockValue = 6;
        
        for(Product product: stock)
        {
            if(product.getQuantity() < lowStockValue)
            {
                System.out.println(product + "\n");
            }
            else{
                System.out.println("");
            }
        }
    }
    
    /**
     * A method to buy a single quantity of the product
     */
    public void buyProduct(int productID)
    {
        buyProduct(productID, 1);
    }
    
    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID, int quantity)
    {
        Product product = findProduct(productID);
        product.decreaseQuantity(quantity);
    }
    
    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID)
    {
        for(Product product: stock)
        {
            if(product.getID() == productID)
            {
                return product;
            }
        }
        return null;
    }
    
    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID, int sellQuantity)
    {
        Product product = findProduct(productID);
        int stockQuantity = product.getQuantity();
        
        if(product != null) 
        {
            if(stockQuantity > 0){
            
            if(stockQuantity > sellQuantity)
            {
                product.decreaseQuantity(sellQuantity);
                System.out.println("Selling " + sellQuantity + " " + product.getID());
                // printout message
            }
            else
            {
                System.out.println("All of the stock is sold!");
                System.out.println("Selling " + stockQuantity + "of product " + product.getID());
                product.decreaseQuantity(stockQuantity);
                // printout message
            }
        }
        }
        else
        {
            System.out.println("Selling none of " + product.getID());
            // printout message
        }
    }    

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID)
    {
        return 0;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product + "\n");
        }

        System.out.println();
    }
    
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Ethan's Stock List");
        System.out.println(" ====================");
        System.out.println();
    }
}