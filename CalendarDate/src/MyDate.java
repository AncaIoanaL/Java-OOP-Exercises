public class MyDate {

    private int year;
    private int month;
    private int day;

    private static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final int[] DAYS_IN_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static final int[] NON_LEAP_YEAR = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};

    private static final int[] LEAP_YEAR = {6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};

    public MyDate(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException();
        }

        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isLeapYear(int year) {
         return ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0);
    }

    public boolean isValidDate(int year, int month, int day) {
        if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1 || year > 9999) {
            return false;
        }

        if (day > DAYS_IN_MONTHS[month - 1]) {
            return isLeapYear(year) && day == 29;
        }

        return true;
    }

    public int getDayOfWeek(int year, int month, int day) {
        int lastTwoDigits = year % 100;
        return (getCenturyNumber(year) + lastTwoDigits + lastTwoDigits / 4 + getMonthNumber(year, month) + day) % 7;
    }

    private int getCenturyNumber(int year) {
        int firstTwoDigits = year / 100;

        switch (firstTwoDigits % 4) {
            case 0 -> {
                return 6;
            }
            case 1 -> {
                return 4;
            }
            case 2 -> {
                return 2;
            }
            default -> {
                return 0;
            }
        }
    }

    private int getMonthNumber(int year, int month) {
        if (isLeapYear(year)) {
            return LEAP_YEAR[month - 1];
        } else {
            return NON_LEAP_YEAR[month - 1];
        }
    }

    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String toString() {
        return String.format("%s %s %s %s", DAYS[getDayOfWeek(year, month, day)], day, MONTHS[month-1], year);
    }

    public MyDate nextDay() {
        if (day == 31 && month == 12) {
            day = 1;
            month = 1;
            year ++;
        } else if (day == 31) {
            day = 1;
            month ++;
        } else if (isLeapYear(year) && day == 29) {
            day = 1;
            month++;
        } else {
            day ++;
        }

        return this;
    }

    public MyDate nextMonth() {
        if (day > DAYS_IN_MONTHS[month % 12]) {
            if (isLeapYear(year) && month == 1) {
                day = 29;
            } else {
                day = DAYS_IN_MONTHS[month % 12];
            }
        }

        if (month == 12) {
            year++;
            month = 1;
        } else {
            month ++;
        }

        return this;
    }

    public MyDate nextYear() {
        if (isLeapYear(year) && month == 2 && day == 29) {
            day = 28;
        }
        year++;

        return this;
    }

    public MyDate previousDay() {
        if (day == 1 && month == 1) {
            day = 31;
            month = 12;
            year--;

            if (isLeapYear(year)) {
                day = 29;
                month--;
            } else if (day == 1) {
                day = DAYS_IN_MONTHS[month - 2];
                month--;
            }
        } else {
            day--;
        }

        return this;
    }

    public MyDate previousMonth() {
        if (month == 1 && day == DAYS_IN_MONTHS[month - 1]) {
            month = 12;
            year--;
        }

        if (month == 3 && isLeapYear(year)) {
            day = 29;
            month--;
        } else if (month == 3) {
            day = 28;
            month--;
        }

        if (DAYS_IN_MONTHS[month - 1] > DAYS_IN_MONTHS[month - 2]) {
            day = 30;
        }

        month--;

        return this;
    }

    public MyDate previousYear() {
        if (isLeapYear(year) && month == 2 && day == 29) {
            day = 28;
            year--;
        } else {
            year--;
        }

        return this;
    }
}
