package CalendarTest;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class CalendarTest {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now(); // get today(year, month, day)
        int month = date.getMonthValue(); // get which month
        int today = date.getDayOfMonth(); // get which day of month

        date = date.minusDays(today - 1); // the first day of this month
        DayOfWeek weekday = date.getDayOfWeek(); // get which week value of date
        int value = weekday.getValue(); // week value

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++)
            System.out.print("    ");
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1)
                System.out.println();
        }
        if (date.getDayOfWeek().getValue() != 1)
            System.out.println();
    }
}
