
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
public class NameRecord {
    //instance vars

    private String name = "";
    private ArrayList<Integer> ranks = new ArrayList();
    private Scanner lineScanner;
    private int rank;
    public final static int[] DECADES = new int[]{1900, 1910, 1920,
        1930, 1940, 1950, 1960,
        1970, 1980, 1990, 2000};

    //constructor
    //pre: line!=null
    public NameRecord(String line) {
        try {
            lineScanner = new Scanner(line);
            while (!lineScanner.hasNextInt() && lineScanner.hasNext()) {
                name += lineScanner.next();
            }
//        System.out.println(name);
            this.storeRanks();
            lineScanner.close();
        } catch (NullPointerException e) {
            System.out.println("String is null");

        }

    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Integer> getRanks() {
        return this.ranks;
    }

    public int rankSize() {
        assert ranks.size() > 1 : "Violation of precondition: no ranks exist in record line";
        return ranks.size();
    }

    private void storeRanks() {
        if (ranks.isEmpty()) {
            while (lineScanner.hasNextInt()) {
                ranks.add(lineScanner.nextInt());
            }
        }
    }

    public int getRank(int decade) {
        assert decade >= 0 : "Violation of precondition: no ranks exist in record line";
        return ranks.get(decade);
    }

    public int bestDecade() {
        int min = 1000;
        for (int i = 0; i < ranks.size(); i++) {

            if (getRank(i) != 0 && getRank(i) < min) {
                min = getRank(i);
                rank = i;
            }
        }
        return DECADES[rank];
    }

    public int countRanks() {
        int count = 0;
        for (int decade : ranks) {
            if (decade > 0) {
                count++;
            }
        }
        return count;
    }

    public boolean rankedInAll() {
        if (this.countRanks() == 11) {
            return true;
        } else {
            return false;
        }
    }

    public boolean rankedOnlyOnce() {
        if (this.countRanks() == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isImproving() {
        int index = 0;
//        int index = this.cleanClutter(0);
        boolean isDecreasing = this.getRank(index) == 0
                || this.getRank(index) > this.getRank(index + 1);

        int min = this.getRank(index) == 0
                ? 1000 : Math.min(1000, this.getRank(index));
//   System.out.print(min);
        index++;

//        System.out.print(isDecreasing);
//         System.out.print(index);
        while (isDecreasing && index < this.ranks.size()) {

            isDecreasing = (this.getRank(index) != 0
                    && min > Math.min(min, this.getRank(index)));
//            System.out.print(this.getRank(index));
            min = Math.min(min, this.getRank(index));
            index++;
        }
        return isDecreasing;
    }

    public boolean isWorsening() {
        int backIndex = this.ranks.size() - 1;


        boolean isIncreasing = this.getRank(backIndex) == 0
                || this.getRank(backIndex) > this.getRank(backIndex - 1);

        int min = this.getRank(backIndex) == 0
                ? 1000 : Math.min(1000, this.getRank(backIndex));

//        System.out.print(min);

        backIndex--;

//        System.out.print(isIncreasing);
//        System.out.print(backIndex);
        while (isIncreasing && backIndex > 0) {
//            System.out.print(min);
            isIncreasing = (this.getRank(backIndex) != 0
                    && min > Math.min(min, this.getRank(backIndex)));
//            System.out.print(this.getRank(backIndex));
            min = Math.min(min, this.getRank(backIndex));
            backIndex--;
        }

        return isIncreasing;
    }

    public boolean isDoubling() {
        boolean isMoore = true; //as in Moore's law
        for (int i = 0; isMoore && i + 1 < this.ranks.size(); i++) {
            if (this.getRank(i) == 0) {
                isMoore = false;
            } else {
                isMoore = this.getRank(i + 1) / this.getRank(i) == 2;
            }
        }

        return isMoore;

    }
}
