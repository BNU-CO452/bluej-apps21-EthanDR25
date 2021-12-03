
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Ethan Dias-Richards
 * @version 2/12/2021
 */
public class StockApp
{
    private InputReader reader;
    
    private StockList stock;
    
    private Product product;
    
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();
        
        stock = new StockList();
        StockDemo demo = new StockDemo(stock);
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;
        
        while(!finished)
        {
            printHeading();
            printMenuChoices();
           
            String choice = reader.getString("\n" + "Please enter your choice: ");
            
            finished = executeChoice(choice.toLowerCase());
        }
    }
    
    /**
     * This is is the method which reads the user input and executes 
     * a method based on what has been typed in by the user.
     */
    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit"))
        {
            return true;
        }
        else if(choice.equals("print"))
        {
            stock.print();
        }
        else if(choice.equals("add"))
        {
            addProduct();
        }
        else if(choice.equals("remove"))
        {
            removeOption();
            stock.print();
        }
        else if(choice.equals("buy"))
        {
            buyAProduct();
        }
        else if(choice.equals("sell"))
        {
            sellAProduct();
        }
        else if(choice.equals("search"))
        {
            search();
        }
        else if(choice.equals("low stock"))
        {
            lowStockProducts();
        }
        
        return false;
    }
    
    /**
     * This is the method used to add a product to the stocklist of
     * products.
     */
    private void addProduct()
    {
        System.out.println("\n" + "Adding a New Product" + "\n");
        int id = reader.getInt("Please enter a product ID: ");
        String name = reader.getString("Please enter the name of the product: ");
        Product product = new Product(id, name);
        stock.add(product);
        stock.print();
    }
    
    /**
     * This is the method for removing a product from the stocklist.
     */
    public void removeOption()
    {
        System.out.println("\n"+ "Removing a Product" + "\n");
        int id = reader.getInt("Please enter a product ID: ");
        
        Product product = stock.findProduct(id);
        stock.removeProduct(id);
    }
    
    /**
     * This is the method which enables a user to 
     * buy a product.
     */
    public void buyAProduct()
    {
        System.out.println("\n");
        int id = reader.getInt("Please enter a product ID: ");
        int quantity = reader.getInt("Please enter the quantity: ");
        
        Product product = stock.findProduct(id);
        product.increaseQuantity(quantity);
        
        System.out.println("Product ID: " + id);
        System.out.println("Quantity purchased: " + quantity + "\n");
        stock.print();
    }
    
    /**
     * This is the method which enables a user to 
     * sell a product.
     */
    public void sellAProduct()
    {
        System.out.println("\n");
        int id = reader.getInt("Please enter a product ID: ");
        int quantity = reader.getInt("Please enter the quantity: ");
        
        Product product = stock.findProduct(id);
        product.decreaseQuantity(quantity);

        System.out.println("\n" + "Product ID: " + id);
        System.out.println("Quantity sold: " + quantity);
        stock.print();
    }
    
    /**
     * This is the method for printing all products with a low
     * stock level within the range of 1-5.
     */
    public void lowStockProducts()
    {
        System.out.println("\n" + "Products which are low in stock:");
        
        System.out.println("--------------------------------" + "\n");
        stock.printProductsWithLowStock();
    }
    
    public void search()
    {
        System.out.println("\n");
        String phrase = reader.getString("Please enter a name: ");
        stock.searchForPhrase(phrase);
    }
    
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Print:      Print all products");
        System.out.println("    Quit:       Quit the program");
        System.out.println("    Buy:        Buy a product");    
        System.out.println("    Sell:       Sell a product");  
        System.out.println("    Search:     Search for all products containing a phrase");
        System.out.println("    Low Stock:  Print all products with a low stock");
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("    by Ethan Dias-Richards");
        System.out.println("********************************");
    }
}