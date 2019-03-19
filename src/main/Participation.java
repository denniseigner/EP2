package main;

/*
This class will be extended in the ad-hoc-assignment, and will be used
in future assignments, so it is highly recommended to solve this
assignment.

This class is part of software for ski racing administration.
 */
public class Participation {

    // Assignment 1.1:

    private String race, racer, runtime;
    private int bibnumber, place;

    // A new object constructed by
    //
    //   new Participation("Lienz 2011 Ladies' Slalom", "Mikaela Shiffrin", 40)
    //
    // shall specify the name of the race, the racer, and the bibnumber.
    public Participation(String race, String racer, int bibnumber) {
        this.race = race;
        this.racer = racer;
        this.bibnumber = bibnumber;
    }

    public Participation(String race, String racer, int bibnumber, int place, String runtime) {
        this(race, racer, bibnumber);
        this.place = place;
        this.runtime = runtime;
    }

    // Returns the 'race' of this participation.
    public String getRace() {
        return race;
    }

    // Returns the 'racer' of this participation.
    public String getRacer() {
        return racer;
    }

    // Returns the 'bibnumber' of this participation.
    public int getBibnumber() {
        return bibnumber;
    }

    public int getPlace() {
        return place;
    }

    public String getRuntime() {
        return runtime;
    }

    // Output the following (without newline at the start or end) for
    // the participation created by the constructor call above:
    //
    // 40 Mikaela Shiffrin (Lienz 2011 Ladies' Slalom)
    //
    public void print() {
        System.out.println(createPrintMessage());
    }

    public void print1() {
        System.out.print(createPrintMessage());
        if(place == 0 && runtime == null) {
            return;
        }

        System.out.println("; " + place + "; " + runtime);
    }

    // Creates the message to be printed
    private String createPrintMessage() {
        return bibnumber + " " + racer + " (" + race + ")";
    }

    // Question:
    
    // Should there also be setter methods for the object variables?
    // Why or why not?
    // No, because the variables do not need to be changed at the moment.

    // This method is only for testing.
    // Alternatively, you can put the tests in additional classes.
    public static void main(String[] args) {
        // TODO: write your own test cases here if necessary.
    }

}
