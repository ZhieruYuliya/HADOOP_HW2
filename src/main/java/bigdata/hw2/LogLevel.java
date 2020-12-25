package bigdata.hw2;

import java.util.Objects;

public class LogLevel {
    private int date;
    private int hour;
    private int logLevel;


    public LogLevel( int date, int hour,int logLevel) {
        this.date = date;
        this.hour = hour;
        this.logLevel = logLevel;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogLevel logLevel1 = (LogLevel) o;
        return logLevel == logLevel1.logLevel &&
                hour == logLevel1.hour && date==logLevel1.date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(logLevel, hour, date);
    }

    @Override
    public String toString() {
        return date + "," + hour + "," + logLevel;
    }

}
