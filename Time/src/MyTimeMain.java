import java.util.Scanner;

public class MyTimeMain {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("Enter hour: ");
        int hour = inputScanner.nextInt();
        while (hour < 0 || hour > 23) {
            System.out.println("This is not a valid hour!");
            System.out.print("Enter hour: ");
            hour = inputScanner.nextInt();
        }

        System.out.print("Enter minute: ");
        int minute = inputScanner.nextInt();
        while (minute < 0 || minute > 59) {
            System.out.println("This is not a valid minute!");
            System.out.print("Enter minute: ");
            minute = inputScanner.nextInt();
        }

        System.out.print("Enter second: ");
        int second = inputScanner.nextInt();
        while (second < 0 || second > 59) {
            System.out.println("This is not a valid second!");
            System.out.print("Enter second: ");
            second = inputScanner.nextInt();
        }

        MyTime time1 = new MyTime(hour, minute, second);
        System.out.println(time1);

        System.out.println("next second is: " + time1.nextSecond());
        System.out.println("next hour is: " + time1.nextHour());
        System.out.println("next minute is: " + time1.nextMinute());

        System.out.println("previous hour is: " + time1.previousHour());
        System.out.println("previous second is: " + time1.previousSecond());
        System.out.println("previous minute is: " + time1.previousMinute());
    }
}
