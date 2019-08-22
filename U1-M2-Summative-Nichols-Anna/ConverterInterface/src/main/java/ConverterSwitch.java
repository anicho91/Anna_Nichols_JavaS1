public class ConverterSwitch implements Converter {

    private int userNum;
    private int userNum2;

    public ConverterSwitch(int userNum, int userNum2) {
        this.userNum = userNum;
        this.userNum2 = userNum2;
    }

    public ConverterSwitch() {

    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getUserNum2() {
        return userNum2;
    }

    public void setUserNum2(int userNum2) {
        this.userNum2 = userNum2;
    }


    @Override
    public String convertMonth(int monthNumber) {
        switch (userNum) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return null;
        }
    }

    @Override
    public String convertDay(int dayNumber) {
        switch (userNum2) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return null;
        }
    }
}
