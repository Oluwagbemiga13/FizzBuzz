/*
 * Created by Daniel.
 * Spend 8 hours working on it.
 * 15.5.2022
 */


package fizzbuzz;
import java.util.*;

/*This is upgraded version of FizzBuzz
 *It has menu and saves numbers in ArrayLists
 *It prints these ArrayLists
 *I fixed all Bugs I found.
 *Doesnt works with plurals. Maybe in a future.
 *I really improved my skills in User input.
*/
public class FizzBuzz {
    // It should´ve made it better UI. Doesn´t working.
    public static void startAtTop(){
    for(int i = 1; i<37;i++){
        System.out.print("\n");
    }
    }
   
    // Creating ArrayLists
    public static ArrayList<Integer> fizz = new ArrayList<>();
    public static ArrayList<Integer> buzz = new ArrayList<>();
    public static ArrayList<Integer> fizzBuzz = new ArrayList<>();
    public static ArrayList<String> fizzBuzzAll = new ArrayList<>();
    public static ArrayList<Integer> clean = new ArrayList<>();
    public static ArrayList<String> valid = new ArrayList<>();
    
    public static String nameOfUser;
    
    public static int commandMenu;
    
    static String type;
    
    // Constructor so far just defines what is valid input
    public FizzBuzz(){
        valid.add("Fizz");
        valid.add("Buzz");
        valid.add("FizzBuzz");
        valid.add("Clean");
        valid.add("All");
    }
    /*
    Checks name if there are any numbers. If yes than it knows you made your 
    name up and gives you name Aladeen. Search "Aladeen restaurant scene" 
    on YouTube 
    */
    public static boolean isAladeen(){
        boolean aladeen = false;
        for(int i = 0; i < nameOfUser.length();i++){
            char character = nameOfUser.charAt(i);
            if(character == '0'||character == '1'||character == '2'||
               character == '3'||character == '4'||character == '5'||
               character == '6'||character == '7'||character == '8'||
               character == '9'){
            aladeen = true;
            }
        }
        return aladeen;
    }
    // Introduce program and takes userName from user 
    public void introduce(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name and press ENTER : ");
        nameOfUser = scanner.nextLine();
        
        if(isAladeen()){
        System.out.println("\nThere is a number in a name?");
        System.out.println("Who are you? An Aladeen sympathizer?!");
        System.out.println("No! It´s Aladeen!");
        nameOfUser = "Aladeen";
        }
        System.out.println("\n");
        System.out.println("Hi " + nameOfUser + ".");
        System.out.println("I am program that searches for FizzBuzz numbers.");
        System.out.println("If number is divisible by 3 without reminder. It´s Fizz number.");
        System.out.println("If number is divisible by 5 without reminder. It´s Buzz number.");
        System.out.println("If number is divisible by both without reminder. It´s FizzBuzz number.");
        System.out.println("If number is not divisible any of those numbers. It´s Clean number.");
        
        
    }
    
    // Cleans all ArayLists. Its used in search method
    public static void cleanMemory(){
        fizz.clear();
        buzz.clear();
        fizzBuzz.clear();
        clean.clear();
        fizzBuzzAll.clear();
    }
    
    // Starts main menu 
    public static void menu ()throws InputMismatchException{
        //int command;
        boolean isValid;
        //startAtTop();
        
        System.out.println("\n_________MAIN MENU_________");
        System.out.println("0 - MENU");
        System.out.println("1 - SEARCH");
        System.out.println("2 - PRINT");
        System.out.println("3 - EXIT");
       // System.out.println("___________________________");
        System.out.println("***************************");
        
        Scanner scanner = new Scanner(System.in);
        try{
        System.out.print("Type your comand HERE : ");
        commandMenu = scanner.nextInt();
        }
        catch(Exception InputMismatchException){
        System.out.print("\nInvalid input! Try again.");
        commandMenu = 0;
        }
        // HERE you are trying to check if input is valid and loop until it´s valid.
        if(commandMenu > 3 || commandMenu < 0){
            isValid = false;
            //commandMenu > 3 || commandMenu < 0
            while(!isValid){
                System.out.print("Invalid input! Try again.");
                System.out.print("Type your comand HERE : ");
                commandMenu = scanner.nextInt();
                
                    if (commandMenu<=3&&commandMenu>=0){
                        isValid = true;                
                }
            }
             } 

        if (commandMenu == 0){
            menu();
            isValid = true;
        }
        if (commandMenu == 1){
            search();
            isValid = true;
        }
        if (commandMenu == 2){
           printNumbers();
           isValid = true;
        }
        if (commandMenu == 3){
           isValid = true;
           System.out.println("\nEXITING PROGRAM. BYE!!");
           System.exit(0);
        }
    }
    
    // Searches for FB numbers. Add them into Lists.
    public static void search(){
       boolean isValid = true;
       cleanMemory();
       int inputNumber;
       
       System.out.print("\nPlease type the higest number you want to check: ");
       Scanner scanner = new Scanner(System.in);
       try{
       inputNumber = scanner.nextInt();
       }
       catch(Exception InputMismatchException){
           inputNumber = -1;
       }
       if(inputNumber<1){
           isValid = false;
           System.out.println("Invalid input! Please insert new number.");
           search();
       }
       
       if(isValid){
       for(int i = 1; i <= inputNumber; i++){
           
                   
            if (i%3==0&&i%5==0){
                //System.out.println("FizzBuzz");
                fizzBuzz.add(i);
                fizzBuzzAll.add("FizzBuzz"); 
            }
            else if (i%3==0){
                //System.out.println("Fizz");
                fizz.add(i);
                fizzBuzzAll.add("Fizz");
            }
            else if (i%5==0){
                //System.out.println("Buzz");
                buzz.add(i);
                fizzBuzzAll.add("Buzz");
            }
            else {
                clean.add(i);
                fizzBuzzAll.add(String.valueOf(i));
            }
            }
        System.out.println("I searched numbers from 1 to " + inputNumber);
        menu();
            }
        }

    // prints selected List. Some troubles with singular and plural.
    public static void printNumbers(){
        boolean isValid;
        ArrayList<Integer> numbersForPrint = new ArrayList<>();
        ArrayList<String> stringForPrint = new ArrayList<>();
        int command;
        String ending ="es.";
        
        // Scanner
        System.out.println("\n_________PRINT_________");
        System.out.println("0 - Fizz  \n1 - Buzz \n2 - FizzBuzz \n3 - Clean \n4 - Whole sequence \n5 - Back to MENU");
        System.out.println("***********************");
        System.out.println("Type command and press ENTER:");
        Scanner scanner = new Scanner(System.in);
        try{
        command = scanner.nextInt();
                }
        catch(Exception InputMismatchException){
            command = 5;
        }
        
        if (command==0){
            for(int i = 0; i < fizz.size(); i++){
                numbersForPrint.add(fizz.get(i));
            }
            type = "Fizz";
        }
        if (command==1){
            for(int i = 0; i < buzz.size(); i++){
                numbersForPrint.add(buzz.get(i));
            }
            type = "Buzz";
        }
        if (command==2){
            for(int i = 0; i < fizzBuzz.size(); i++){
                numbersForPrint.add(buzz.get(i));
            }
            type = "FizzBuzz";
        }
        if (command==3){
            for(int i = 0; i < clean.size(); i++){
                numbersForPrint.add(clean.get(i));
            }
            type = "Clean";
        }
        if (command==4){
            for(int i = 0; i < fizzBuzzAll.size(); i++){
                stringForPrint.add(fizzBuzzAll.get(i));
            }
            type = "All";
        }       
        if (command==5){
            menu();
        }
        if (command<0||command>5){
            System.out.println("\nInvalid input! Try again.");
            printNumbers();
        }       
        if(numbersForPrint.size()==1){
            ending = ".";
        }
        // here you are trying to add ending to CLEAN category
        if(command==3){
            ending = "s.";
        }

        System.out.println("\n");
        if(numbersForPrint.isEmpty()&& stringForPrint.isEmpty()){
            System.out.println("There are no " + type + " numbers!");
            isValid = false;
        }
        else if(!valid.contains(type)){
            System.out.println("Invalid input: " + type + "!");
            isValid = false;
        }
        // If uncomment -> ERROR! 
        //if((numbersForPrint.size())==1){
        //    System.out.println("I´ve found 1 " + " " + type + " number.");
        //}
        
        else if(type.equals("Clean")){
            if(numbersForPrint.size()==1){
            System.out.println("I´ve found " + numbersForPrint.size() + " " + type + ".");
            isValid = true;
            }
            else{
            System.out.println("I´ve found " + numbersForPrint.size() + " " + type + "s.");
            isValid = true;
            }
        }
        else if(type.equals("All")){
            if(stringForPrint.size()==1){
            System.out.println("Here is whole sequence. It contains " + stringForPrint.size() + " record." );
            isValid = true;
        }
            else{
            System.out.println("Here is whole sequence. It contains " + stringForPrint.size() + " records" );
            isValid = true;
            }
        }
        else {  
        System.out.println("I´ve found " + numbersForPrint.size() + " " + type + ending);
        isValid = true;
        }
        if(isValid){
            for (Integer number : numbersForPrint) {
                System.out.println(type + ": " + number);
        }
            for (var var : stringForPrint) {
                System.out.println("All: " + var);
        }
        }
        menu();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FizzBuzz test = new FizzBuzz();
        test.introduce();
        menu();
    }
    
}
