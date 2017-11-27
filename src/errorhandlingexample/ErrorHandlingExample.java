package errorhandlingexample;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * 
  Title:           Programming Assignment: Error Handling
  Semester:        COP3337 – Fall 2017
  @author          5793866
  Instructor:      C. Charters
  
   Due Date:       10/22/2017

 * In this program We read and parse different files in order to "catch" any 
 * possible exception that can occur in the process, Such as reading a line as
 * and integer when it should have been a string or even attempting to 
 * read an empty file.
 */
public class ErrorHandlingExample {

    //Define a global array of Student objects, but don't instantiate it until the getUserInput() method.
    Student[] stdObj;
    Scanner myFile;
    
    /**
     * The main method is responsible for creating an instance of the class and 
     * calling  all the non static methods that build the class and it also
     * decides whether or not to handle a user input again if a mistake was 
     * made in the input of one of those methods.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       boolean tryAgain = true;
       int menuItemSelected = 0;
       ErrorHandlingExample errorHandle1 = new ErrorHandlingExample();
       while (tryAgain)
       {
           try
           {
               menuItemSelected = errorHandle1.getUserInput();
               errorHandle1.processFile(menuItemSelected);
               errorHandle1.summarizeResults();
               tryAgain = false;
           }
           catch (FileNotFoundException e)
           {
               tryAgain = true;
               System.out.println(e.getMessage());
           }
           catch (InputMismatchException e)
           {
               tryAgain = false;
               System.out.println(e.getMessage());
           }
           catch (BadDataException e)
           {
               tryAgain = false;
               System.out.println(e.getMessage());
           }
           catch (NoSuchElementException e)
           {
               tryAgain = false;
               System.out.println(e.getMessage());
           }
           catch (Exception e)
           {
               tryAgain = false;
               System.out.println(e.getMessage());
           }
           
       }
        
    }
    
    /**
     * The getUserInput method gets and returns an input from the user while at 
     * the same time making sure its a valid input between 1 and 6.
     * @return 
     */
    public int getUserInput() 
    {
        boolean validMenu = false;
        int usersChoice = 0;
        Scanner keyboard = new Scanner(System.in);
        
        while (!validMenu)
        {
            try
            {
                displayMenu();
                usersChoice = keyboard.nextInt();
                if (usersChoice < 1 || usersChoice > 6)
                {
                    System.out.println("Your selection is invalid. Enter  1 - 6.");
                    validMenu = false;
                }
                else
                {
                    validMenu = true;
                }
                               
            }
            catch(InputMismatchException e)
            {
                validMenu = false;
                keyboard.nextLine();
                System.out.println("Incorrect menu selection.");
            }
        }
       
        return usersChoice;
        
    }
    
    
    /**
     * The processFile method is responsible for processing all the different
     * files in the project folder,It selects a file with the userChoice parameter 
     * returned from the getUserInput method.
     * @param usersChoice
     * @throws FileNotFoundException 
     */
    public void processFile(int usersChoice) throws FileNotFoundException
    {
        int numRecs;
        String fileName;
        String badData1 = "goodFile.txt";
        String badData2 = "tooFewRecs.txt";
        String badData3 = "tooManyRecs.txt";
        String badData4 = "nonNumericRecCounter.txt";
        String badData5 = "invalidData.txt";
        String badData6 = "xyz.txt";
        
        switch (usersChoice)
        {
            case 1:
                fileName = badData1;
                break;
            case 2:
                fileName = badData2;
                break;
            case 3:
                fileName = badData3;
                break;
            case 4:
                fileName = badData4;
                break;
            case 5:
                fileName = badData5;
                break;
            case 6:
                fileName = badData6;
                break;
            default:
                fileName = badData1;
        }
        
        
        try
        {
           File aFile = new File(fileName);
           myFile = new Scanner(aFile);
           numRecs = myFile.nextInt();
           int counter =0;
           
           //This is where you instantiate the array of Student objects, and
           //where you use a counter loop, using numRecs as number of time to loop, 
           //to read all the records in the input file, and 
           //create a Student object per record, to place in the global array of Student objects
           //You can do these steps either right here, or by calling a method that does them.
           //When this method successfully ends, the array of Student objects should be populated.
           stdObj = new Student[numRecs];
           while(myFile.hasNext() || counter <numRecs)
           {
                String name = myFile.next();
                Double gpa  = myFile.nextDouble();
                stdObj[counter] = new Student(name,gpa);
                counter++;
           }
           
        
        }
        catch (FileNotFoundException e)
        {
            throw new FileNotFoundException("The file " + fileName + " was not found.");
            
        }
        catch (InputMismatchException e)
        {
            throw new InputMismatchException("Not a string or a double or int");
               
        }
        catch (BadDataException e)
        {
            //You can report on the bad data, and skip the bad record, so you can process the rest of the records.
            throw new BadDataException("bad data");
        }
        catch (NoSuchElementException e)
        {
            throw new NoSuchElementException("No element to be read (size "
                    + "bigger than the number of elements in the file)");
        }
        catch (IndexOutOfBoundsException e)
        {
            throw new IndexOutOfBoundsException("Index out of bound (Too many elements for array size)");
        }
        catch (Exception e)
        {
            
               
        }
        finally 
        {
            if(myFile != null) myFile.close();
        }
        
        
    }           
  
    /**
     * The displayMenu method simply displays the menu for the user.
     */
    public void displayMenu()
    {
        System.out.println("What type of file do you wish to read?");
        System.out.println("1.  Good File");
        System.out.println("2.  Too few recs in the counter (more recs than anticipated");
        System.out.println("3.  Too many recs in the counter (less recs than anticipated");
        System.out.println("4.  Non-numeric record counter");
        System.out.println("5.  Invalid data in record - ex. GPA non-numeric");
        System.out.println("6.  Invalid file name");
  
    }
    
    /**
     * The summarizeResults method takes no parameter and find the maximum, minimum 
     * and average GPA of the class. In this case our student object array.
     */
    public void summarizeResults()
    {
        //This is where you use the array of Student objects you created, and you
        //loop through it, finding the student with the highest gpa, the lowest gpa, and then
        //accumulate all the gpas, so that at the end of the loop, you can calculate the average gpa.
        
        //You can optionally put try catch for the arrayOutOfBounds error.
       //By now, the data in the array should be valid, since any errors were caught in the processFile method
       //You should have skipped the bad data recs.
        
        //If you skipped a bad data record, you could have an array with empty elements.  Thus, 
        //you could have exceptions if you don't first check that the element is not equal to nulls.
        double avg =0.0;
        Arrays.sort(stdObj);
        System.out.println("The Highest GPA is: "+stdObj[0].getGpa()+"!!!!!");
        System.out.println("The Lowest GPA is: "+stdObj[stdObj.length-1].getGpa()+" :( :( moon2SPY");
        for(int i =0;i<stdObj.length;i++)
        {
            avg += stdObj[i].getGpa();
        }
        avg /= stdObj.length;
        System.out.println("The Average GPA of the class is: "+avg+"!!!!!");
        
    }
    
}
