public class DateTime {

    private int day;
    private int month;
    private int year;
    private int time;

    DateTime(String DMY, String Time) throws NumberFormatException {
        String[] split_DMY = DMY.split("/");

        try {
            day = Integer.parseInt(split_DMY[0]);
            month = Integer.parseInt(split_DMY[1]);
            year = Integer.parseInt(split_DMY[2]);
            time = Integer.parseInt(Time);
        }

        catch (NumberFormatException e) {
            throw new NumberFormatException();
        }

    }

    private String getDate_long() {

        return day + " " +
                MONTHS.values()[month] + " " +
                year;
    }

    private String getTime_Long() {
        if (time == 0 || time == 2400) {
            return "12AM";
        }



        return Integer.toString((time >= 1300) ? (time - 1200) / 100 : time / 100) +
                ((time % 100 == 0) ? "": Integer.toString(time % 100)) +
                (time >= 1200 ? "PM" : "AM");

    }

    public String toString() {
        return getDate_long() + " " + getTime_Long();
    }

    public String getDate_short() {
        return day + "/" + month + "/" + year + " " + time;
    }


    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getTime() {
        return time;
    }

    public int getYear() {
        return year;
    }
}
