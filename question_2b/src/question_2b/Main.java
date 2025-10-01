package question_2b;

//Custom exception class
class MyCustomException extends Exception {
 public MyCustomException(String message) {
     super(message); // Pass the message to the Exception superclass
 }
}

//Main class
public class Main {
 // Method that can throw the custom exception
 public static void checkNumber(int number) throws MyCustomException {
     if (number < 0) {
         // Throw custom exception if number is negative
         throw new MyCustomException("Error: Negative numbers are not allowed. You entered: " + number);
     } else {
         System.out.println("The number is valid: " + number);
     }
 }

 public static void main(String[] args) {
     try {
         checkNumber(10);  // Valid number
         checkNumber(-5);  // This will throw the custom exception
     } catch (MyCustomException e) {
         // Catch the custom exception and display message
         System.out.println(e.getMessage());
     }

     System.out.println("Program continues after handling the exception.");
 }
}
