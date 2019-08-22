public class ConverterIf implements Converter {

    private int userNum;
    private int userNum2;

    public ConverterIf(int userNum, int userNum2) {
        this.userNum = userNum;
        this.userNum2 = userNum2;
    }

    public ConverterIf() {

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
        if(userNum == 1){
            return "January";
        }else if(userNum == 2){
            return "February";
        }else if(userNum == 3){
            return "March";
        }else if(userNum == 4){
            return "April";
        }else if(userNum == 5){
            return "May";
        }else if(userNum == 6){
            return "June";
        }else if(userNum == 7){
            return "July";
        }else if(userNum == 8){
            return "August";
        }else if(userNum == 9){
            return "September";
        }else if(userNum == 10){
            return "October";
        }else if(userNum == 11){
            return "November";
        }else if(userNum == 12){
            return "December";
        }else{
            return null;
        }
    }

    @Override
    public String convertDay(int dayNumber) {
        if(userNum2 == 1){
            return "Monday";
        }else if(userNum2 == 2){
            return "Tuesday";
        }else if(userNum2 == 3){
            return "Wednesday";
        }else if(userNum2 == 4){
            return "Thursday";
        }else if(userNum2 == 5){
            return "Friday";
        }else if(userNum2 == 6){
            return "Saturday";
        }else if(userNum2 == 7){
            return "Sunday";
        }else{
            return null;
        }
    }
}
