public class IceCream2 {

    private int sales;
    private int productProducedperHour;
    private int numofDistributors;
    private int productDemand;
    private String companySoldTo;
    private String ingredients;

    public IceCream2(int sales, int productProducedperHour, int numofDistributors, int productDemand, String companySoldTo, String ingredients) {
        this.sales = sales;
        this.productProducedperHour = productProducedperHour;
        this.numofDistributors = numofDistributors;
        this.productDemand = productDemand;
        this.companySoldTo = companySoldTo;
        this.ingredients = ingredients;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getProductProducedperHour() {
        return productProducedperHour;
    }

    public void setProductProducedperHour(int productProducedperHour) {
        this.productProducedperHour = productProducedperHour;
    }

    public int getNumofDistributors() {
        return numofDistributors;
    }

    public void setNumofDistributors(int numofDistributors) {
        this.numofDistributors = numofDistributors;
    }

    public int getProductDemand() {
        return productDemand;
    }

    public void setProductDemand(int productDemand) {
        this.productDemand = productDemand;
    }

    public String getCompanySoldTo() {
        return companySoldTo;
    }

    public void setCompanySoldTo(String companySoldTo) {
        this.companySoldTo = companySoldTo;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
}
