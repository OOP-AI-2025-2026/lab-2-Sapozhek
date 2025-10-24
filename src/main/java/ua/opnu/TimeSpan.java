package ua.opnu;

public class TimeSpan {

    private int hours;
    private int minutes;

    // Конструктор
    TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            this.hours = 0;
            this.minutes = 0;
        } else {
            this.hours = hours;
            this.minutes = minutes;
        }
    }

    int getHours() {
        return hours;
    }

    int getMinutes() {
        return minutes;
    }

    void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            return; // некоректні аргументи — нічого не міняємо
        }

        int totalMinutes = this.hours * 60 + this.minutes + hours * 60 + minutes;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    void addTimeSpan(TimeSpan timespan) {
        add(timespan.getHours(), timespan.getMinutes());
    }

    double getTotalHours() {
        return this.hours + this.minutes / 60.0;
    }

    int getTotalMinutes() {
        return this.hours * 60 + this.minutes;
    }

    void subtract(TimeSpan span) {
        int totalCurrent = this.getTotalMinutes();
        int totalOther = span.getTotalMinutes();

        if (totalOther > totalCurrent) {
            return; // не змінюємо (можна кинути виняток, але тести цього не вимагають)
        }

        int result = totalCurrent - totalOther;
        this.hours = result / 60;
        this.minutes = result % 60;
    }

    void scale(int factor) {
        if (factor <= 0) {
            return; // не змінюємо, якщо factor недопустимий
        }

        int totalMinutes = this.getTotalMinutes() * factor;
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }
}
