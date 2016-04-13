
import java.util.ArrayList;
import java.util.Scanner;


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
public class Names {
    //Instance Var

    private ArrayList<NameRecord> names = new ArrayList();
    private NameRecord record;

    //Constructor
    public Names(Scanner fileScanner) {
        String line;
        while (fileScanner.hasNextLine()) {
            line = fileScanner.nextLine();
//            System.out.println(line);
            record = new NameRecord(line);
//            System.out.println(record);
            if (record.rankSize() > 0) {
                names.add(record);
            }
//            System.out.println(getName(0));
        }



    }
    //Methods

    private String getName(int i) {
        return names.get(i).getName();
    }

    public ArrayList<NameRecord> findNames(String query) {
        ArrayList<NameRecord> matches = new ArrayList();
        query = query.toLowerCase();
        for (int i = 0; i < names.size(); i++) {
//            System.out.println(names.size());
            if (this.getName(i).toLowerCase().indexOf(query) > -1)//||
            //                    getName(i).equalsIgnoreCase(query))
            {
//                System.out.println((this.getName(i)));
                matches.add(names.get(i));
//                System.out.println(((NameRecord)matches.get(0)).getName());

            }

        }

        return matches;


    }

    public NameRecord findName(String query) {
        boolean found = false;
        int index = 0;
        for (int i = 0; i < this.names.size() && !found; i++) {
            found = query.equalsIgnoreCase(this.names.get(i).getName());
            index = i;
        }
        return found ? this.names.get(index) : null;
    }

    public ArrayList<String> rankedEveryDecade() {
        ArrayList<String> foundNames = new ArrayList();
        for (int i = 0; i < this.names.size(); i++) {
            if (this.names.get(i).rankedInAll()) {
                foundNames.add(this.names.get(i).getName());
            }
        }
        return foundNames;
    }

    public ArrayList<String> rankedOnce() {
        ArrayList<String> foundNames = new ArrayList();
        for (int i = 0; i < this.names.size(); i++) {
            if (this.names.get(i).rankedOnlyOnce()) {
                foundNames.add(this.names.get(i).getName());
            }
        }
        return foundNames;
    }

    public ArrayList<String> gettingPop() {
        ArrayList<String> foundNames = new ArrayList();
        for (int i = 0; i < this.names.size(); i++) {
            if (this.names.get(i).isImproving()) {
                foundNames.add(this.names.get(i).getName());
            }
        }
        return foundNames;
    }

    public ArrayList<String> gettingLessPop() {
        ArrayList<String> foundNames = new ArrayList();
        for (int i = 0; i < this.names.size(); i++) {
            if (this.names.get(i).isWorsening()) {
                foundNames.add(this.names.get(i).getName());
            }
        }
        return foundNames;
    }

    public ArrayList<String> Moore() {
        ArrayList<String> foundNames = new ArrayList();
        for (int i = 0; i < this.names.size(); i++) {
            if (this.names.get(i).isDoubling()) {
                foundNames.add(this.names.get(i).getName());
            }
        }
        return foundNames;
    }
}
