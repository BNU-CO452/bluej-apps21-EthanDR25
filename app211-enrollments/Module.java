
/**
 * This is the Module class which contains all of the necessary code required in order to ensure all of the correct data is displayed and that the correct
 * outputs are made.
 *
 * @author Ethan Dias-Richards
 * @version 20/10/2021
 */
public class Module
{
    
    private String moduleName;
    
    private String moduleCode;
    
    private int moduleCredit;

    /**
     * This is the constructor for creating objects of the Module class. The name of the module, the module code, and the credit value are the variables or
     * parameters that can be set with this constructor.
     */
    public Module(String moduleName, String moduleCode)
    {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
    }
    
    public void setModuleCredit(int moduleCredit)
    {
        this.moduleCredit = moduleCredit;
    }
    /**
     * This is the code required in order to get the name of the module.
     */
    public String getModuleName()
    {
        return this.moduleName;
    }
    /**
     * This is the code required in order to get the module code.
     */
    public String getModuleCode()
    {
        return this.moduleCode;
    }
    /**
     * This is the code required in order to get the module credit value.
     */
    public int getModuleCredit()
    {
        return this.moduleCredit;
    }
    /**
     * This is the print method for printing out the module details which consists of the name of the module, the module code, and the module credit value.
     */
    public void print()
    {
        System.out.println("Module Name: " + moduleName);
        System.out.println("Module Code: " + moduleCode);
        System.out.println("Module Credit: " + moduleCredit);
    }
    
}
