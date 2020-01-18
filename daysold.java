/**
 * Name: Ze Hui Peng
 * ID: 1594884
 * Class: ECE 325
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 */

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;

public class daysold {
    /**
     * check if the birthday is valid(i.e. check if the birth date is beyond current date);
     * @param b_year {@code int} birth year
     * @param b_month {@code int} birth month
     * @param b_day   {@code int} birth day
     * @param c_year  {@code int} current year
     * @param c_month {@code int} current month
     * @param c_day   {@code int} current day
     * @return true if the birthday is valid, false otherwise
     */
    public static boolean validBday(int b_year, int b_month, int b_day, int c_year, int c_month, int c_day) {
        // check if the baby is born in the future
        if (b_year > c_year) {
            return false;
        }
        else if (b_year == c_year) {
            if (b_month > c_month) {
                return false;
            }
            else if (b_month == c_month) {
                if (b_day > c_day) {
                    return false;
                }
            }
        }
        return true;
    } // public static boolean validBday(int b_year, int b_month, int b_day, int c_year, int c_month, int c_day)


    /**
     * get the number of days difference given two GregorianCalendar class objects of the start and end date 
     * Idea obtained from: https://stackoverflow.com/questions/19462912/how-to-get-number-of-days-between-two-calendar-instance
     * Some Notes: This method will take account of leap years and assumes the timezone of both calendars are the same
     * @param bCal  {@code GregorianCalendar} the calendar for the start date, i.e. birthday of whoever wants to calculate how old they are in days
     * @param cCal  {@code GregorianCalendar} the calendar for the end date, i.e. today, the date whenever someone runs this program
     * @return day  {@code long} the number of days passed since the person is born
     */
    public static long getDiffinDays(GregorianCalendar bCal, GregorianCalendar cCal) {
        // set both the start and end timezone to the same timezone to avoid off by one error
        bCal.setTimeZone(TimeZone.getTimeZone("GMT-7:00"));
        cCal.setTimeZone(TimeZone.getTimeZone("GMT-7:00"));
        
        // set the time to midnight for both calendars
        bCal.set(Calendar.HOUR_OF_DAY, 0);
        cCal.set(Calendar.HOUR_OF_DAY, 0);
        
        long start_time = bCal.getTimeInMillis();
        long end_time = cCal.getTimeInMillis();
        return TimeUnit.MILLISECONDS.toDays(end_time - start_time);
    } // public static long getDiffinDays(GregorianCalendar bCal, GregorianCalendar cCal)


    /**
     * Calculate how many days between today and the date
     * @param birthday      {@code String} The start date, assumed in the format of "yyyy-mm-dd"
     */
    public static void days(String birthday) {
        String[] bdays = birthday.split("-");
        // b -> birth
        int b_year = Integer.parseInt(bdays[0]);
        // Calendar Month is 0-based, which January = month 0, to change it to 0-based we need to subtract 1
        // 0-based is needed to perform the difference calculation, otherwise there might be off by one errors
        int b_month = Integer.parseInt(bdays[1]) - 1;
        int b_day = Integer.parseInt(bdays[2]);
        GregorianCalendar bCal = new GregorianCalendar(b_year, b_month, b_day);
        
        /* Note: you can put constructor arguments to calculate days difference with a different end date than current date
                 but you must use 0-based system for the month section.
                 e.g. for June you should enter 5 as the 2nd argument instead of 6
        */    
        GregorianCalendar cCal = new GregorianCalendar(); // without a argument in the consturctor will set the calendar to current time
        
        // c -> current
        int c_year = cCal.get(Calendar.YEAR);
        int c_month = cCal.get(Calendar.MONTH);
        int c_day = cCal.get(Calendar.DATE);

        long daysold = getDiffinDays(bCal, cCal);
        SimpleDateFormat startdate = new SimpleDateFormat("MMMM d YYYY");
        SimpleDateFormat enddate = new SimpleDateFormat("MMMM d YYYY");
        String formatted_startdate = startdate.format(bCal.getTime());
        String formatted_enddate = enddate.format(cCal.getTime());
        System.out.print("Birthday: " + formatted_startdate + "; Today: " + formatted_enddate + " -- ");
        // check if the birthday entered is validS
        if (validBday(b_year, b_month, b_day, c_year, c_month, c_day) == false) {
            System.out.println("Wrong Birthday!");
        }
        else {
            System.out.println("You are " + Long.toString(daysold) + " days old.");
        }
    } // public static void days(String birthday)


    /**
     * Main entry
     * @param args   {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        days("2000-1-1");
        days("2000-2-9");
        days("3000-1-1");           // This is a wrong birthday
    } // public static void main(String[] args)

}
