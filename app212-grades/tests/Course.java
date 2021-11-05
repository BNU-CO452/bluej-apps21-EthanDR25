import java.util.ArrayList;
/**
 * This class stores information about a course
 * that enrolled students may want to complete
 *
 * @author Derek Peacock and Nicholas Day
 * @version 0.1 11/Sep/2020
 */
public class Course
{
    public final static int MAXN_MODULES = 4;
    
    public ArrayList<Module> modules;
    
    private String code;
    private String title;
    
    private Grades finalGrade;
     
    /**
     * I have modified this constructor to ensure that it displays
     * the correct data for the name of my course and the course code.
    */
    public Course()
    {
        this("BB1DSC1", "BSc (Hons) Data Science");
    }
    
    /**
     * Constructor for objects of class Course
     */
    public Course(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        
        modules  = new ArrayList<Module>();
        
        createModules();
    }

    /**
     * Create four modules and add them to the
     * modules list for testing purposes.  These
     * must be your four modules.
     */
    public void createModules()
    {
    Module co452 = new Module("CO452", "Programming Concepts");
    addModule(co452);
    Module co405 = new Module("CO405", "Database Design");
    addModule(co405);
    Module co450 = new Module("CO450", "Computer Architectures");
    addModule(co450);
    Module co456 = new Module("CO456", "Web Development");
    addModule(co456);
    }
    
    public void addModule(Module module)
    {
        if(modules.size() < MAXN_MODULES)
        {
            modules.add(module);
        }
    }
    
    /**
     * This is the method for converting a final mark for a module into a 
     * grade.
     */
    public Grades convertToGrade(int mark)
    {
        if(mark <= Grades.F.getValue() && mark >= Grades.NS.getValue())
        {
            return Grades.F;
        }
        else if(mark > Grades.F.getValue() && mark <= Grades.D.getValue())
        {
            return Grades.D;
        }
        else if(mark > Grades.D.getValue() && mark <= Grades.C.getValue())
        {
            return Grades.C;
        }
        else if(mark > Grades.C.getValue() && mark <= Grades.B.getValue())
        {
            return Grades.B;
        }
        else if(mark > Grades.B.getValue() && mark <= Grades.A.getValue())
        {
            return Grades.A;
        }
        else
        {
            return Grades.NS;
        }
    }
    
    /**
     * Calculate the average mark from the four module marks
     * and convert that into a final grade.
     */
    public Grades calculateGrade(ArrayList<ModuleMark> marks)
    {
        int total = 0;
        
        int averageGrade = 0;
        for(ModuleMark mark: marks)
        {
            total = total + mark.getValue();
        }
        averageGrade = total / 4;
        
        finalGrade = convertToGrade(averageGrade);
        
        return finalGrade;
    }
    
    /**
     * Prints out the details of a course and the
     * four modules
     */
    public void print()
    {
        System.out.println();
        System.out.println("Course code: " + code + "\nCourse Title: " + title);
        System.out.println("");
        for(Module module: modules)
        {
            System.out.println("" + module.code + " \t" + module.title);
            System.out.println("" + module.CREDIT + " credits");
        }
    }
    
    /**
     * Print the course's four modules
     */
    public void printModules()
    {
        for(Module module: modules)
        {
            System.out.println(module.getCode());
            System.out.println("\t" + module.getTitle());
        }
    }
}
