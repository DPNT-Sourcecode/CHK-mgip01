package befaster.solutions.CHK.befaster.solutions.utility.support;

public class Product {

    private IFactory.EProduct eProduct;
    private Integer price;

    public Product(IFactory.EProduct eProduct, Integer price) {
        this.eProduct = eProduct;
        this.price = price;
    }

    public IFactory.EProduct geteProduct() {
        return eProduct;
    }

    public Integer getPrice() {
        return price;
    }
}



