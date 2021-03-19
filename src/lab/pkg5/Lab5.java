//C0490418
//William Plummer
//Comp 132, section 1B
//2019-10-21
/*This program asks the user for a distance, speed and time and calculates
how far they've traveled based on that. It then creates a graphic to visually
display how far they've traveled*/

package lab.pkg5;

import java.util.Scanner;

public class Lab5 {

    /*
    *
    *
    */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int speed; //the speed the car is traveling at
        int distanceTotal; //the total distance the user can travel
        int hours; //the akount of time that has passed
        int distanceSoFar; /*distance the user has traveled so far,
        calculated in later method*/
        String graphic; //reference to the graphic from later method
        int scale; //reference to the scale factor from later method

        System.out.println("How fast are you going?"
                + "(Just the number, no units needed)"); /*asking the user
        for speed value*/
        speed = input.nextInt();

        System.out.println("How far do you have to go?"
                + "(must be at least 500)"); /*asking the user
        for distance value*/
        distanceTotal = input.nextInt();

        System.out.println("How long has it been since you started?"
                + "(Just the number, no units needed)");
        //asking the user for time value
        hours = input.nextInt();

        System.out.println(""); /*extra return to seperate the values entered
        from results to make output easier to read*/
        distanceSoFar = calculate(speed, hours); /*activate method calculate
        and set parameters*/
        graphic = graphics(distanceTotal, distanceSoFar); /*activate method
        graphics and set parameters*/
        scale = returnCheck(distanceTotal); /*activate method returnCheck and
        set parameters*/

        System.out.print("\nThe over all distance you needed to travel was: "
                + distanceTotal + "km.\nThe time that passes since you "
                + "left is: " + hours + "hrs.\nThe speed you're traveling"
                + " at is: " + speed + "km/h.\nYou've already traveled: "
                + distanceSoFar + "km.\n"); //display results
    }

    /*Calculates the distance traveled and compare to overall distance
    *Receives the speed and hours values the user enters
    *Returns the distance the user has travel
     */
    public static int calculate(int speed, int hours) {
        int currentDis = speed * hours; /*times speed by hours elapsed
        to find distance traveled*/
        return currentDis; //return how far the user has traveled
    }

    /*Draws out dashes based on the distance the user has entered
    *Receives the total distance and the distance the user has traveled
    *Returns the graphic of multiple dashes that shows how far the user
     has gone so far and how far they still have to go
     */
    public static String graphics(int distanceTotal, int distanceSoFar) {
        String dashes = ""; //just something for the method to return
        int scale = returnCheck(distanceTotal); /*get scale
        info from returnCheck*/
        for (int i = 0; i < distanceSoFar / scale; i++) { /*add dashes
            from start to current position*/
            System.out.print("-");
        }
        System.out.print("C"); //add car graphic

        for (int i = (distanceSoFar / scale) + 1; i < distanceTotal /
                scale; i++) { /*add dashes from current
            position to end of trip*/
            System.out.print("-");
        }
        return dashes; //return dashes
    }

    /*Checks if the dash graphic extends too far off the screen and
    corrects it
    *Receives the total distance the user will travel
    *Returns a scale factor for the graphic to shrink by
     */
    public static int returnCheck(int distanceTotal) {
        int scale = 0;
        if (distanceTotal >= 1000) { //check how long graphic is and...
            scale = distanceTotal / 50; //scale down by this factor
        } else if (distanceTotal >= 500) { //check how long graphic is and...
            scale = distanceTotal / 10; //scale down by this factor
        } else {
            scale = distanceTotal / 1;
        }
        return scale; //return scale factor
    }
}