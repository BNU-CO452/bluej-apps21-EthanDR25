
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * modified by Ethan Dias-Richards
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(81, "iPhone 7"));
        stock.add(new Product(82, "iPhone 8"));
        stock.add(new Product(83, "Apple Watch Series 8"));
        stock.add(new Product(84, "Casio Watch"));
        stock.add(new Product(85, "Sony TV"));
        stock.add(new Product(86, "Anker Charger"));
        stock.add(new Product(87, "USB Flash Drive"));
        stock.add(new Product(88, "Airpods"));
        stock.add(new Product(89, "Wallet"));
        stock.add(new Product(90, "Printer"));
    }
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        stock.print();

        buyProducts();
        stock.print();        

        sellProducts();
        stock.print();        
    }
    /**
     * This is the method for buying various quantities of products.
     */
    private void buyProducts()
    {
        Product product;
        int quantity = 1;
        
        for(int id = 90; id <= 92; id++)
        {
            product = stock.findProduct(id);
            
            if(product == null)
            {
                System.out.println("Product " + id + "Not Found");
            }
            else
            {
                stock.buyProduct(id, quantity);
            }
        }
    }
    
    /**
     * This is the method for selling various quantities of the products.
     */
    private void sellProducts()
    {
        Product product;
        int quantity = 1;
        
        for(int id = 90; id <= 92; id++)
        {
            product = stock.findProduct(id);
            
            if(product == null)
            {
                System.out.println("Product " + id + "Not Found");
            }
            else
            {
                stock.sellProduct(id, quantity);
            }
        }
    }
    }    
    