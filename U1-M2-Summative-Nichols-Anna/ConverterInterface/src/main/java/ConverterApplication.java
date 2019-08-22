public class ConverterApplication{
    public static void main(String[] args) {

        ConverterSwitch switchTest = new ConverterSwitch();
        ConverterIf ifTest = new ConverterIf();

        switchTest.setUserNum(4);
        switchTest.setUserNum2(2);

        ifTest.setUserNum(6);
        ifTest.setUserNum2(5);

        System.out.println(switchTest.convertMonth(switchTest.getUserNum()) + " " +
        switchTest.convertDay(switchTest.getUserNum2()));

        System.out.println(ifTest.convertMonth(ifTest.getUserNum()) + " " +
        ifTest.convertDay(ifTest.getUserNum2()));

    }
}
