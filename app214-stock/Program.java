
/**
 * This is the Program class which executes the necessary code required
 * to run the StockApp.
 *
 * @author Ethan Dias-Richards
 * @version 2/12/2021
 */
public class Program
{
    private static StockApp app;
    
    public static void main(String[] args)
    {
        app = new StockApp();
        app.run();
    }
}
