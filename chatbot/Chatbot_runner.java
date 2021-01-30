import java.util.Scanner;
import java.util.*;

/**
 * The runner class.
 * @vers : 4.0.2.18.20
 */
public class Chatbot_runner {
    
    public static void main(String[] bot) {
        Chatbot kahreéenngh = new Chatbot();
        System.out.println (kahreéenngh.getGreeting());
        
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();
        final String[] GOODBYES = {"See yah later.", "Bye now!", "byeee!", "Goodbye, friend."};
        final String[] LEAVE_PROF = {"I don't have to listen to this.", "Enough!", "Now you've done it."};
        
        while (!statement.toLowerCase().equals("bye")) {
            System.out.println (kahreéenngh.getResponse(statement));
            statement = in.nextLine();
            Chatbot var = new Chatbot();
            if (var.unlucky_leave == 2) {
                System.out.println("Yea that's nice.");
                System.out.println("I'm leaving now, bye.");
                System.out.println("Kahreéenngh has left the chat.");
                break;
            }
            if (statement.toLowerCase().equals("fortnite")) {
                System.out.println("Kahreéenngh has left the chat.");
                break;
            }
            Chatbot var2 = new Chatbot();
            if (var2.prof_counter == 2) {
                System.out.println(LEAVE_PROF[(int)(Math.random() * 2)]);
                System.out.println("Kahreéenngh has left the chat.");
                break;
            }
            if (statement.toLowerCase().equals("bye")) {
                System.out.println(GOODBYES[(int)(Math.random() * 3)]);
            }
            
        }
    }

}
