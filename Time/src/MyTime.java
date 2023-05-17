public class MyTime {

    private int hour = 0;
    private int minute = 0;
    private int second = 0;

    public MyTime() {
    }

    public MyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public MyTime nextSecond() {
        if (second == 59 && minute == 59 && hour == 23) {
            second = 0;
            minute = 0;
            hour = 0;
        } else if (second == 59 && minute == 59) {
            second = 0;
            minute = 0;
            hour ++;
        } else if (second == 59) {
            second = 0;
            minute ++;
        } else {
            second ++;
        }

        return this;
    }

    public MyTime nextMinute() {
        if (minute == 59 && hour == 23) {
            minute = 0;
            hour = 0;
        } else if (minute == 59) {
            minute = 0;
            hour ++;
        } else {
            minute ++;
        }

        return this;
    }

    public MyTime nextHour() {
        if (hour == 23) {
            hour = 0;
        } else {
            hour ++;
        }

        return this;
    }

    public MyTime previousSecond() {
        if (second == 0 && minute == 0 && hour == 0) {
            second = 59;
            minute = 59;
            hour = 23;
        } else if (second == 0 && minute == 0) {
            second = 59;
            minute = 59;
            hour --;
        } else if (second == 0) {
            second = 59;
            minute --;
        } else {
            second --;
        }

        return this;
    }

    public MyTime previousMinute() {
        if (minute == 0 && hour == 0) {
            minute = 59;
            hour = 23;
        } else if (minute == 0) {
            minute = 59;
            hour --;
        } else {
            minute --;
        }

        return this;
    }

    public MyTime previousHour() {
        if (hour == 0) {
            hour = 23;
        } else {
            hour --;
        }

        return this;
    }
}
