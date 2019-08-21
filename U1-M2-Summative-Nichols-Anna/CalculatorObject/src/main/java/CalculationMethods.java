public class CalculationMethods {

    private int num1;
    private int num2;

    public CalculationMethods(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public CalculationMethods() {

    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public double addition(double num1, double num2){
        double sum;

        System.out.println(num1 + "+" + num2);
        sum = num1 + num2;

        System.out.println(sum + "\n");
        return sum;
    }

    public double multiplication(double num1, double num2){
        double sum;

        System.out.println(num1 + "*" + num2);
        sum = num1 * num2;

        System.out.println(sum+ "\n");
        return sum;
    }

    public double subtraction(double num1, double num2){
        double sum;

        System.out.println(num1 + "-" + num2);
        sum = num1 - num2;

        System.out.println(sum + "\n");
        return sum;
    }

    public double division(double num1, double num2){
        double sum;

        System.out.println(num1 + "/" + num2);
        sum = num1 / num2;

        System.out.println(sum + "\n");
        return sum;
    }

    public int addition(int num1, int num2){
        int sum;

        System.out.println(num1 + "+" + num2);
        sum = num1 + num2;

        System.out.println(sum + "\n");
        return sum;
    }

    public int multiplication(int num1, int num2){
        int sum;

        System.out.println(num1 + "*" + num2);
        sum = num1 * num2;

        System.out.println(sum + "\n");
        return sum;
    }

    public int subtraction(int num1, int num2){
        int sum;

        System.out.println(num1 + "-" + num2);
        sum = num1 - num2;

        System.out.println(sum + "\n");
        return sum;
    }

    public int division(int num1, int num2){
        int sum;

        System.out.println(num1 + "/" + num2);
        sum = num1 / num2;

        System.out.println(sum + "\n");
        return sum;
    }


}
