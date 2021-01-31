// ***************************************************************
// File: Chatbot_runner.java
// Authors: Carlos Gonzales, Joseph Sloan, Leonardo Villalobos
// Last Modified : 1 / 31 / 2021
// Description : The class that contains the main method to execute
// the chatbot.
// ***************************************************************
import java.util.Scanner;
import java.util.*;

// Main class that contains the main() method to execute the program.
public class Chatbot_runner
{
    // Main method that initializes the bot and contains various
    // conditions to check for words found in the user's response.
    public static void main(String[] bot)
    {
        Chatbot steve = new Chatbot();
        System.out.println (steve.getGreeting());
        
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();
        final String[] GOODBYES = 
        {
            "See yah later.", "Bye now!", "byeee!", "Goodbye, friend."
        };
        final String[] LEAVE_PROF =
        {
            "I don't have to listen to this.", "Enough!", "Now you've done it."
        };
        
        // Conditions to check when to terminate the program.
        while (!statement.toLowerCase().equals("bye"))
        {
            System.out.println (steve.getResponse(statement));
            statement = in.nextLine();
            Chatbot var = new Chatbot();
            if (var.unlucky_leave == 2)
            {
                System.out.println("Yea that's nice.");
                System.out.println("I'm leaving now, bye.");
                System.out.println("Steve has left the chat.");
                break;
            }
            if (statement.toLowerCase().equals("fortnite"))
            {
                System.out.println("Steve has left the chat.");
                break;
            }
            Chatbot var2 = new Chatbot();
            if (var2.prof_counter == 2)
            {
                System.out.println(LEAVE_PROF[(int)(Math.random() * 2)]);
                System.out.println("Steve has left the chat.");
                break;
            }
            if (statement.toLowerCase().equals("bye"))
            {
                System.out.println(GOODBYES[(int)(Math.random() * 3)]);
            }
        }
    }
}
