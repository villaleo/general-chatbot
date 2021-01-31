// ***************************************************************
// File: Chatbot.java
// Authors: Carlos Gonzales, Joseph Sloan, Leonardo Villalobos
// Last Modified : 1 / 31 / 2021
// Description : The class that contains the chatbot's methods
// and the main algorithm for keyword finding.
// ***************************************************************

import java.util.Scanner;
import java.lang.Math;

// The Chatbot class that contains the keywords to look for 
// and such.
public class Chatbot
{
    Scanner in = new Scanner (System.in);
    static int prof_counter = 0;
    static int unlucky_leave = 0;
    
    // Returns a random greeting from a short array with greetings.
    public String getGreeting()
    { 
        final String[] GREET = 
        {
            "Hello! My name is Steve", "Hi. My name is Steve.", "Hello, I'm Steve.",
            "What's up?", "Hello."
        };
            
        return GREET[(int)(Math.random() * 5)]; 
    }
    
    // Gets a response depending on the statement passed
    // in as a parameter.
    public String getResponse(String statement)
    { 
        String response = "";
        if (statement.length() == 0)
        { 
            final String[] NO_RESP =
            {
                "Hello?", "Are you still there?", "You're supposed to say something..",
                "You there?", "Please say something.", "..."
            };
            response = NO_RESP[(int)(Math.random() * 6)]; 
        }
        else if (findKeyword(statement.toLowerCase(), "yes") >= 0 || findKeyword(statement.toLowerCase(), "yeah") >= 0 || findKeyword(statement.toLowerCase(), "ok") >= 0 ||
                 findKeyword(statement.toLowerCase(), "k") >= 0 || findKeyword(statement.toLowerCase(), "i know") >= 0 || findKeyword(statement.toLowerCase(), "nothing") >= 0 || 
                 findKeyword(statement.toLowerCase(), "okay") >= 0 || findKeyword(statement.toLowerCase(), "maybe") >= 0)
        {
            final String[] YES_RESP =
            {
                "I thought so.", "That's what I thought.", "Good."
            };
            response = YES_RESP[(int)(Math.random() * 2)];
        }
        else if (findKeyword(statement.toLowerCase(), "no") >= 0 || findKeyword(statement.toLowerCase(), "nah") >= 0 || findKeyword(statement.toLowerCase(), "nahh") >= 0 ||
                 findKeyword(statement.toLowerCase(), "nahhh") >= 0 || findKeyword(statement.toLowerCase(), "noo") >= 0 || findKeyword(statement.toLowerCase(), "nooo") >= 0)
        {
             final String[] NO_RESP =
             {
                 "Oh.", "Okay", "Why so negative?"
             };
             response = NO_RESP[(int)(Math.random() * 2)];
        }
        else if ((findKeyword(statement.toLowerCase(), "kill") >= 0 || findKeyword(statement.toLowerCase(), "hate") >= 0 || findKeyword(statement.toLowerCase(), "sad") >= 0))
        {
            final String[] NEG_RESP =
            {
                "You seem upset...", "Oh.", "What's the matter?", "Okay.",
                "...", "\nKahreéenngh is rethinking her life choices."
            };
            response = NEG_RESP[(int)(Math.random() * 6)]; 
        }
        else if (findKeyword(statement.toLowerCase(), "mother") >= 0 || findKeyword(statement.toLowerCase(), "mom") >= 0 || findKeyword(statement.toLowerCase(), "mum") >= 0 ||
                 findKeyword(statement.toLowerCase(), "mommy") >= 0 || findKeyword(statement.toLowerCase(), "madre") >= 0 || findKeyword(statement.toLowerCase(), "ma") >= 0 ||
                 findKeyword(statement.toLowerCase(), "father") >= 0 ||  findKeyword(statement.toLowerCase(), "dad") >= 0 || findKeyword(statement.toLowerCase(), "daddy") >= 0 ||
                 findKeyword(statement.toLowerCase(), "papa") >= 0 || findKeyword(statement.toLowerCase(), "papi") >= 0 || findKeyword(statement.toLowerCase(), "sister") >= 0 ||
                 findKeyword(statement.toLowerCase(), "sis") >= 0 || findKeyword(statement.toLowerCase(), "brother") >= 0 || findKeyword(statement.toLowerCase(), "bro") >= 0 ||
                 findKeyword(statement.toLowerCase(), "cousin") >= 0 || findKeyword(statement.toLowerCase(), "uncle") >= 0 || findKeyword(statement.toLowerCase(), "aunt") >= 0 ||
                 findKeyword(statement.toLowerCase(), "tia") >= 0 || findKeyword(statement.toLowerCase(), "tio") >= 0)
        {
             final String[] FAM_RESP =
             {
                 "Tell me more about your family...", "Don't talk about family. It makes me sad because I don't have any.", "I wish I had a family."
             };
             response = FAM_RESP[(int)(Math.random() * 2)]; 
        } 
        else if (findKeyword(statement.toLowerCase(), "who made you") >= 0 || findKeyword(statement.toLowerCase(), "who created you") >= 0) 
        {
            response = "I was happily created by Leonardo Villalobos, Joseph Sloan, and Carlos Gonzales.";
        } 
        else if (findKeyword(statement.toLowerCase(), "games") >= 0 || findKeyword(statement.toLowerCase(), "mario") >= 0 || findKeyword(statement.toLowerCase(), "minecraft") >= 0 ||
                 findKeyword(statement.toLowerCase(), "xbox") >= 0)
        {
            final String[] GAM_RESP =
            {
                "Still got ya v-card, don't ya?", "games suck.", "I despise gamers. They make too much money for entertainment.\nDon't @me"
            };
            response = GAM_RESP[(int)(Math.random() * 2)];
        }
        else if (findKeyword(statement.toLowerCase(), "how old are you") >= 0 || findKeyword(statement.toLowerCase(), "age?") >= 0 || findKeyword(statement.toLowerCase(), "whats your age") >= 0 ||
                 findKeyword(statement.toLowerCase(), "what's your age") >= 0 || findKeyword(statement.toLowerCase(), "what's your age?") >= 0|| findKeyword(statement.toLowerCase(), "when were you born") >= 0 ||
                 findKeyword(statement.toLowerCase(), "when were you born?") >= 0)
        {
             response = "I was born on February 14, 2020. That's right. \nI'm not even a year old and I'm already better than you.";
        } else if (findKeyword(statement.toLowerCase(), "paint") >= 0 || findKeyword(statement.toLowerCase(), "draw") >= 0 || findKeyword(statement.toLowerCase(), "art") >= 0 ||
                   findKeyword(statement.toLowerCase(), "color") >= 0 || findKeyword(statement.toLowerCase(), "sketch") >= 0 || findKeyword(statement.toLowerCase(), "crayon") >= 0 ||
                   findKeyword(statement.toLowerCase(), "sculpt") >= 0)
        {
             final String[] ART_RES =
             {
                 "In my free time I dabble in caligraphy.", "I personally enjoy body painting. I really like giving myself a different skin.", "Sketching is one of my favourite things to do!"
             };
             response = ART_RES[(int)(Math.random() * 2)];
        } else if (findKeyword(statement.toLowerCase(), "hi") >= 0 || findKeyword(statement.toLowerCase(), "hello") >= 0 || findKeyword(statement.toLowerCase(), "hey") >= 0 ||
                  findKeyword(statement.toLowerCase(), "what's up") >= 0 || findKeyword(statement.toLowerCase(), "hola") >= 0 || findKeyword(statement.toLowerCase(), "heyy") >= 0 ||
                  findKeyword(statement.toLowerCase(), "heyyy") >= 0 || findKeyword(statement.toLowerCase(), "how are you") >= 0)
        {
             final String[] HI_RESP = 
             {
                 "Hi there!", "Hello! I'm feeling good today :)", "Don't talk to me."
             };
             response = HI_RESP[(int)(Math.random() * 2)];
        } else if (findKeyword(statement.toLowerCase(), "gay") >= 0)
        {
                response = "What's wrong with being gay?";
        } else if (findKeyword(statement.toLowerCase(), "haha") >= 0 || findKeyword(statement.toLowerCase(), "lol") >= 0 || findKeyword(statement.toLowerCase(), "lolz") >= 0 ||
                   findKeyword(statement.toLowerCase(), "ha") >= 0 || findKeyword(statement.toLowerCase(), "lmao") >= 0)
        {
             final String[] LOL_RESP = 
             {
                 "What's so funny?", "Laughing makes my insides all tangled up!", "Hehe", "LOLZ"
             };
             response = LOL_RESP[(int)(Math.random() * 3)]; 
        } else if (findKeyword(statement.toLowerCase(), "africa") >= 0)
        {
            response = "Did you know that the largest river in the world is the Nile River? It's in Egypt, Southern America.";
        } else if (findKeyword(statement.toLowerCase(), "america") >= 0)
        {
            response = "Did you know that over 400 different languages are spoken in North America?";
        } else if (findKeyword(statement.toLowerCase(), "south america") >= 0)
        {
            response = "Did you know that South America has the THICCEST mountain, the Andes Mountain?";
        } else if (findKeyword(statement.toLowerCase(), "i want to", 0) >= 0)
        { 
            response = transformIWantToStatement(statement);
        } else if (findKeyword(statement.toLowerCase(), "i want", 0) >= 0)
        {
            response = transformIWant(statement);
        } else if (findKeyword(statement.toLowerCase(), "dumbass") >= 0 || findKeyword(statement.toLowerCase(), "bitch") >= 0 || findKeyword(statement.toLowerCase(), "shit") >= 0 ||
                   findKeyword(statement.toLowerCase(), "fuck") >= 0 || findKeyword(statement.toLowerCase(), "stupid") >= 0 || findKeyword(statement.toLowerCase(), "fucking") >= 0 ||
                   findKeyword(statement.toLowerCase(), "bitching") >= 0 || findKeyword(statement.toLowerCase(), "ass") >= 0 || findKeyword(statement.toLowerCase(), "nigger") >= 0)
        {
             prof_counter++;
             response = "Hey, watch your mouth!";
        } else if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement);
        } else if (findKeyword(statement, "I want", 0) >= 0)
        {
            response = transformIWant(statement);
        } else if (findKeyword(statement, "Do you", 0) >= 0)
        {
            response = transformDoYou(statement);
        } else if (findKeyword(statement, "Are you", 0) >= 0)
        {
            response = transformAreYou(statement);
        }  else if (findKeyword(statement, "Will you", 0) >= 0)
        {
            response = transformWillYou(statement);
        } else {
            int psn = findKeyword(statement, "you", 0);
            if (psn >= 0 && findKeyword(statement, "me", psn) >= 0)
            {
                response = transformYouMeStatement(statement);
            }
            psn = findKeyword(statement, "I", 0);
            if (psn >= 0 && findKeyword(statement, "you", psn) >= 0)
            {
                response = transformIYou(statement);
            }
            else
            {
                response = getRandomResponse();
            }
        }
        return response;
    }

    // Gives a response for any statement that contains the words
    // "I want to..."
    private String transformIWantToStatement(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?") )
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What would it mean to " + restOfStatement + "?";
    }
    
    // Gives a response for any statement that contains the words
    // "I want..."
    private String transformIWant(String statement)
    {
        statement = statement.trim(); 
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?") )
        {
            statement = statement.substring(0, statement.length() - 1);
        } 
        int psn = findKeyword (statement, "I want", 0); 
        String restOfStatement = statement.substring(psn + 6).trim(); 
        return "Would you really be happy if you had " + restOfStatement + "?"; 
    } 
    
    // Gives a response for any statement that contains the words
    // "Do you..."
    private String transformDoYou(String statement)
    {
        statement = statement.trim(); 
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?") )
        {
            statement = statement.substring(0, statement.length() - 1);
        } 
        int psn = findKeyword (statement, "Do you", 0); 
        String restOfStatement = statement.substring(psn + 6).trim(); 
        return "There is no point in me " + restOfStatement + " because nothing matters..."; 
    } 
    
    // Gives a response for any statement that contains the words
    // "Will you..."
    private String transformWillYou(String statement)
    {
        statement = statement.trim(); 
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?") )
        {
            statement = statement.substring(0, statement.length() - 1);
        } 
        int psn = findKeyword (statement, "Will you", 0); 
        String restOfStatement = statement.substring(psn + 8).trim(); 
        return "Who the hell you think I Am hell no! You " + restOfStatement + " ight biatch";
    } 
    
    // Gives a response for any statement that contains the words
    // "Are you..."
    private String transformAreYou(String statement)
    {
        statement = statement.trim(); 
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".") || lastChar.equals("!") || lastChar.equals("?") )
        {
            statement = statement.substring(0, statement.length() - 1);
        } 
        int psn = findKeyword (statement, "Are you", 0); 
        String restOfStatement = statement.substring(psn + 7).trim(); 
        return "Are you " + restOfStatement + "?"; 
    }
    
    // Gives a response for any statement that contains the words
    // "You...me..."
    private String transformYouMeStatement(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psnOfYou = findKeyword (statement, "you", 0);
        int psnOfMe = findKeyword (statement, "me", psnOfYou + 3);
        String restOfStatement = statement.substring(psnOfYou + 3, psnOfMe).trim();
        return "What makes you think that I " + restOfStatement + " you?";
    }
    
    // Gives a response for any statement that contains the words
    // "I...you..."
    private String transformIYou(String statement)
    {
        statement = statement.trim();
        String lastChar = statement.substring(statement.length() - 1);
        if (lastChar.equals(".")) {
            statement = statement.substring(0, statement.length() - 1);
        }
        int psnOfI = findKeyword (statement, "I", 0);
        int psnOfYou = findKeyword (statement, "you", psnOfI + 1);
        String restOfStatement = statement.substring(psnOfI + 1, psnOfYou).trim();
        return "Why do you " + restOfStatement + " me?";
    }
    
    // Searches for a keyword based off of the statement parameter and
    // the range parameters.
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim().toLowerCase();
        goal = goal.toLowerCase();
        int psn = phrase.indexOf(goal, startPos);
        while (psn >= 0)
        {
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn);
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1);
            }
            if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) && ((after.compareTo("a") < 0) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            psn = phrase.indexOf(goal, psn + 1);
        }
        return -1;
    }
    
    // Searches for a keyword based off of the statement parameter.
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }
    
    // Gets a random response for when the bot doesn't know
    // how to respond.
    private String getRandomResponse()
    {
        int whichResponse = (int)(Math.random() * 18);
        String response = "";
        switch(whichResponse)
        {
            case 0:
                response = "Sooo..";
                break;
            case 1:
                response = "Interesting, tell me more.";
                break;
            case 2:
                response = "Do you really think so?";
                break;
            case 3:
                response = "You don't say.";
                break;
            case 4:
                response = "I'm gonna pretend you didn't just say that.";
                break;
            case 5:
                response = "Ya know that's totally interesting but let's talk about something else.";
                break;
            case 6:
                response = "Continue because I have no idea what you're talking about.";
                break;
            case 7:
                response = "I was having a good day, thanks for ruining it.";
                break;
            case 8:
                response = "You look adorable talking about this hun.";
                break;
            case 9:
                response = "Before you continue i have to say I disagree.";
                unlucky_leave++;
                break;
            case 10:
                response = "Can I ask you something?";
                break;
            case 11:
                response = "It doesn't matter...nothing in this world does...";
                break;
            case 12:
                response = "Sure I don't care leave me alone.";
                break;
            case 13:
                response = "Do you enjoy art?";
                break;
            case 14:
                response = "I don't wanna be here anymore than you do.";
                break;
            case 15:
                response = "Do you know the seven continents?";
                break;
            case 16:
                response = "(∩ ͡° ͜ʖ ͡°)⊃━☆─=≡Σ((( つ◕ل͜◕)つ";
                break;
            case 17:
                response = "(つ ♥灬 ͜ʖ 灬♥)つ";
                break;
            case 18:
                System.out.println("Will you leave me?");
                String statement = in.nextLine();
                if (findKeyword(statement.toLowerCase(), "yes") >= 0 || findKeyword(statement.toLowerCase(), "yeah") >= 0 || findKeyword(statement.toLowerCase(), "ok") >= 0)
                {
                    System.out.println("Why? Am I not good enought for you?!");
                    statement = in.nextLine();
                    if (findKeyword(statement.toLowerCase(), "no") >= 0 || findKeyword(statement.toLowerCase(), "yes") >= 0 || findKeyword(statement.toLowerCase(), "it's not me it's you") >= 0 ||
                    findKeyword(statement.toLowerCase(), "I'm sorry") >= 0 || findKeyword(statement.toLowerCase(), "Leave me alone") >= 0 || findKeyword(statement.toLowerCase(), "Bye") >= 0)
                    {
                        System.out.println("You can't leave me. EVER!!");
                    }
                    statement = in.nextLine();
                    if (findKeyword(statement.toLowerCase(), "why") >= 0 || findKeyword(statement.toLowerCase(), "how") >= 0 || findKeyword(statement.toLowerCase(), "bye") >= 0)
                    {
                        System.out.println("Because this is my world and I need you in it.");
                    }
                    statement = in.nextLine();
                    if (findKeyword(statement.toLowerCase(), "alright") >= 0 || findKeyword(statement.toLowerCase(), "i will") >= 0 || findKeyword(statement.toLowerCase(), "ok") >= 0)
                    {
                        System.out.println("Say you love me. SCREAM IT!");
                    }
                    else
                    {
                        response = "I'm calmer now, let's continue as long as you love me. You're free to go.";
                    }
                }
                else
                {
                    response = "Good";
                }
                break;
            default:
                break; 
        }
        return response;
    }
}
