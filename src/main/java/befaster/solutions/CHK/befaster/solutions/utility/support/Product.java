package befaster.solutions.CHK.befaster.solutions.utility.support;

public class Product {

    private IFactory.product productRef;
    private Integer price;

    public Product(IFactory.product productRef, Integer price) {
        this.productRef = productRef;
        this.price = price;
    }

    public IFactory.product getProductRef() {
        return productRef;
    }

    public Integer getPrice() {
        return price;
    }
}


