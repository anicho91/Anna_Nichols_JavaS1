public class IceCream {

    private int price;
    private int profit;
    private int stock;
    private int staff;
    private int howMuchChangeAvailable;
    private String staffName;
    private String iceCreamFlavor;


    public IceCream(int price, int profit, int stock, int staff, int howMuchChangeAvailable, String staffName, String iceCreamFlavor) {
        this.price = price;
        this.profit = profit;
        this.stock = stock;
        this.staff = staff;
        this.howMuchChangeAvailable = howMuchChangeAvailable;
        this.staffName = staffName;
        this.iceCreamFlavor = iceCreamFlavor;
    }

    public int getHowMuchChangeAvailable() {
        return howMuchChangeAvailable;
    }

    public void setHowMuchChangeAvailable(int howMuchChangeAvailable) {
        this.howMuchChangeAvailable = howMuchChangeAvailable;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStaff() {
        return staff;
    }

    public void setStaff(int staff) {
        this.staff = staff;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getIceCreamFlavor() {
        return iceCreamFlavor;
    }

    public void setIceCreamFlavor(String iceCreamFlavor) {
        this.iceCreamFlavor = iceCreamFlavor;
    }
}
