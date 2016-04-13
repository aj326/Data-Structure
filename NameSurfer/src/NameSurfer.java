
/*  Student information for assignment:
 *
 *  On my honor, Ahmed AlJehairan, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: aa29665
 *  email address: ahmed24633@gmail.com
 *  Grader name: Yuanzhong
 *  Number of slip days I am using:1
 */
//TREND: No name doubles every decade
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.UIManager;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class NameSurfer {

    // constants for menu choices
    public static final int SEARCH = 1;
    public static final int ONE_NAME = 2;
    public static final int APPEAR_ONCE = 3;
    public static final int APPEAR_ALWAYS = 4;
    public static final int POP_POS = 5;
    public static final int POP_NEG = 6;
    public static final int MINE = 7;
    public static final int QUIT = 8;

    public static void tester(String exp,
            String result, String whatAmITesting, int testNum) {

        System.out.println("Test " + testNum + " " + (exp.equals(result) ? "Passed" : "Failed") + " " + whatAmITesting);

    }
    // main method. Driver for the whole program

    public static void main(String[] args) {

////      Tests
//        int testNum = 1;
//        NameRecord dummyDef = new NameRecord("Def 248 328 532 764 733 0 0 0 0 0 0");
//        NameRecord dummyZero = new NameRecord("allEqualtoZero 0 0 0 0 0 0 0 0 0 0 0");
//        
//        NameRecord dummyEqRan = new NameRecord("allEqualtoRandom 13 13 13 13 13 13 13 13 13 13 13");
//        
//        NameRecord dummyInc1 = new NameRecord("IncreasingPop Test 11 10 9 8 7 6 5 4 3 2 1");
//        NameRecord dummyInc2 = new NameRecord("IncreasingPop Test 0 0 0 0 0 0 0 0 0 0 0");
//        NameRecord dummyInc3 = new NameRecord("IncreasingPop Test 11 10 0 8 7 6 5 4 3 2 1");
//        NameRecord dummyInc4 = new NameRecord("IncreasingPop Test 0 10 9 8 7 6 5 4 3 2 1");
//        NameRecord dummyInc5 = new NameRecord("IncreasingPop Test 0 0 9 8 7 6 5 4 3 2 1");
//        NameRecord dummyInc6 = new NameRecord("IncreasingPop Test 1 2 3 4 5 6 7 8 9 10 11");
//
//        NameRecord dummyDec1 = new NameRecord("DecreasingPop Test 1 2 3 4 5 6 7 8 9 10 11");
//        NameRecord dummyDec2 = new NameRecord("DecreasingPop Test 0 0 0 0 0 0 0 0 0 0 0");
//        NameRecord dummyDec3 = new NameRecord("DecreasingPop Test 1 2 3 4 5 6 7 0 9 10 11");
//        NameRecord dummyDec4 = new NameRecord("DecreasingPop Test 1 2 3 4 5 6 7 8 9 10 0");
//        NameRecord dummyDec5 = new NameRecord("DecreasingPop Test 1 2 3 4 5 6 7 8 9 0 0");
//        NameRecord dummyDec6 = new NameRecord("DecreasingPop Test 11 10 9 8 7 6 5 4 3 2 1");
//
//
//
//        //Dummies: dummyDef, dummyZero, dummyEqRan, dummyInc(1-6), dummyInc(1-6)
//        tester("Def", dummyDef.getName(), "getName/Constructor", testNum); testNum++;
//        tester("248", dummyDef.getRank(0)+"", "storeRanks/Constructor/getRank", testNum); testNum++;
//        tester("1900", dummyDef.bestDecade()+"", "bestDecade", testNum); testNum++;
//        tester("1900", dummyZero.bestDecade()+"", "bestDecade", testNum); testNum++;
//        tester("1900", dummyEqRan.bestDecade()+"", "bestDecade", testNum); testNum++;
//        tester("2000", dummyDec6.bestDecade()+"", "bestDecade", testNum); testNum++;
//
//        tester("11", dummyDec6.countRanks()+"", "countRanks/rankedOnlyOnce/rankedInAll", testNum); testNum++;
//        tester("5", dummyDef.countRanks()+"", "countRanks/rankedOnlyOnce/rankedInAll", testNum); testNum++;
//        tester("0", dummyZero.countRanks()+"", "countRanks/rankedOnlyOnce/rankedInAll", testNum); testNum++;
//
//        //Pop up tests
//        tester("true", dummyInc1.isImproving()+"", "IncreaseInPopularity", testNum); testNum++;
//        tester("false", dummyInc2.isImproving()+"", "IncreaseInPopularity", testNum); testNum++;
//        tester("false", dummyInc3.isImproving()+"", "IncreaseInPopularity", testNum); testNum++;
//        tester("true", dummyInc4.isImproving()+"", "IncreaseInPopularity", testNum); testNum++;
//        tester("false", dummyInc5.isImproving()+"", "IncreaseInPopularity", testNum); testNum++;
//        tester("false", dummyInc6.isImproving()+"", "IncreaseInPopularity", testNum); testNum++;
//        
//        //Pop down tests
//        tester("true", dummyDec1.isWorsening()+"", "DecreaseInPopularity", testNum); testNum++;
//        tester("false", dummyDec2.isWorsening()+"", "DecreaseInPopularity", testNum); testNum++;
//        tester("false", dummyDec3.isWorsening()+"", "DecreaseInPopularity", testNum); testNum++;
//        tester("true", dummyDec4.isWorsening()+"", "DecreaseInPopularity", testNum); testNum++;
//        tester("false", dummyDec5.isWorsening()+"", "DecreaseInPopularity", testNum); testNum++;
//        tester("false", dummyDec6.isWorsening()+"", "DecreaseInPopularity", testNum); testNum++;








        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Unable to set look at feel to local settings. "
                    + "Continuing with default Java look and feel.");
        }
        try {
            System.out.println("Opening GUI to choose file with names data.");
            Scanner fileScanner = new Scanner(getFile());
            Names n = new Names(fileScanner);
            int choice;
            Scanner keyboard = new Scanner(System.in);
            fileScanner.close();
            do {
                showMenu();
                choice = getChoice(keyboard);
                if (choice == SEARCH) {
                    search(n, keyboard);
                } else if (choice == ONE_NAME) {
                    oneName(n, keyboard);
                } else if (choice == APPEAR_ONCE) {
                    appearOnce(n);
                } else if (choice == APPEAR_ALWAYS) {
                    appearAlways(n);
                } else if (choice == POP_POS) {
                    popular(n);
                } else if (choice == POP_NEG) {
                    lessPopular(n);
                } else if (choice == MINE) {
                    //will return zero with given data
                    //try Moore 1 2 4 8 16 32 64 128 256 512 1024
                    doubleTrouble(n);
                } else {
                    System.out.println("\n\nGoodbye.");
                }

            } while (choice != QUIT);
        } catch (FileNotFoundException e) {
            System.out.println("Problem reading the data file. Exiting the program." + e);
        }
    }

    // method that shows names that are increasing in popularity
    // pre: n != null
    // post: print out names that are increasing in popularity
    private static void popular(Names n) {
        assert n != null : "Names cannot be null";
        ArrayList names = n.gettingPop();
        System.out.println("There are exactly " + names.size() + " names that are increasing in popularity:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }

    // method that shows names that are decreasing in popularity
    // pre: n != null
    // post: print out names that are decreasing in popularity
    private static void lessPopular(Names n) {
        assert n != null : "Names cannot be null";
        ArrayList names = n.gettingLessPop();
        System.out.println("There are exactly " + names.size() + " names that are decreasing in popularity:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }

    // method that shows names that are doubling every decade (2^n)
    // pre: n != null
    // post: print out names that are doubling every decade (2^n)
    private static void doubleTrouble(Names n) {
        assert n != null : "Names cannot be null";
        ArrayList names = n.Moore();
        System.out.println("There are exactly " + names.size() + " names that are decreasing in popularity:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }

    // method that shows names that have appeared in ever decade
    // pre: n != null
    // post: print out names that have appeared in ever decade
    private static void appearAlways(Names n) {
        assert n != null : "Names cannot be null";
        ArrayList names = n.rankedEveryDecade();
        System.out.println("There are exactly " + names.size() + " names that appear in every decade:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }

    // method that shows names that have appeared in only one decade
    // pre: n != null
    // post: print out names that have appeared in only one decade
    private static void appearOnce(Names n) {
        assert n != null : "Names cannot be null";
        ArrayList names = n.rankedOnce();
        System.out.println("There are exactly " + names.size() + " names that only appear once:");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }

    // method that shows data for one name, or states that name has never been ranked
    // pre: n != null, keyboard != null and is connected to System.in
    // post: print out the data for n or a message that n has never been in the top 1000 for any decade
    private static void oneName(Names n, Scanner keyboard) {
        assert n != null : "Names cannot be null";
        assert keyboard != null : "Not a valid choice";
        String query = keyboard.next();

        NameRecord print = n.findName(query);
        System.out.println(print.getName() + ":" + print.getRanks());
        for (int i = 0; i < print.rankSize(); i++) {
            System.out.println(print.DECADES[i] + ": " + print.getRank(i));
        }
    }

    // method that shows all names that contain a substring from the user
    // and the decade they were most popular in
    // pre: n != null, keyboard != null and is connected to System.in
    // post: show the correct data		
    private static void search(Names n, Scanner keyboard) {
        assert n != null : "Names cannot be null";
        assert keyboard != null : "Not a valid choice";
        String query = keyboard.next();
        String name = "";
        ArrayList listOfNames = n.findNames(query);

        System.out.println("There are " + listOfNames.size() + " for " + query + ".\nMatches and best Decade are:\n");
        for (int i = 0; i < listOfNames.size(); i++) {
//            System.out.println((NameRecord) listOfNames);
            name = ((NameRecord) listOfNames.get(i)).getName() + "";
            System.out.println(name + ": " + n.findName(name).bestDecade());
        }

    }

    // get choice from the user
    // keyboard != null and is connected to System.in
    // return an int that is >= SEARCH and <= QUIT
    private static int getChoice(Scanner keyboard) {
        int choice = getInt(keyboard, "Enter choice: ");
        keyboard.nextLine();
        while (choice < SEARCH || choice > QUIT) {
            System.out.println("\n" + choice + " is not a valid choice");
            choice = getInt(keyboard, "Enter choice: ");
            keyboard.nextLine();
        }
        return choice;
    }

    // ensure an int is entered from the keyboard
    // pre: s != null and is connected to System.in
    private static int getInt(Scanner s, String prompt) {
        System.out.print(prompt);
        while (!s.hasNextInt()) {
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }

    // show the user the menu
    private static void showMenu() {
        System.out.println("\nOptions:");
        System.out.println("Enter " + SEARCH + " to search for names.");
        System.out.println("Enter " + ONE_NAME + " to display data for one name.");
        System.out.println("Enter " + APPEAR_ONCE + " to display all names that appear in only one decade.");
        System.out.println("Enter " + APPEAR_ALWAYS + " to display all names that appear in all decades.");
        System.out.println("Enter " + POP_POS + " to display all names that are increasing in popularity.");
        System.out.println("Enter " + POP_NEG + " to display all names are decreasing in popularity.");
        System.out.println("Enter " + MINE + " to display all names that are doubling every decade.");
        System.out.println("Enter " + QUIT + " to quit.\n");
    }

    /** Method to choose a file using a traditional window.
     * @return the file chosen by the user. Returns null if no file picked.
     */
    public static File getFile() {
        // create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Select File With Baby Names Data.");
        int retval = chooser.showOpenDialog(null);
        File f = null;
        chooser.grabFocus();
        if (retval == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile();
        }
        return f;
    }
}
