package befaster.solutions.CHK.befaster.solutions.utility.support;

public class Product {

    private IFactory.product productEnum;
    private Integer price;

    public Product(IFactory.product productEnum, Integer price) {
        this.productEnum = productEnum;
        this.price = price;
    }

    public IFactory.product getProductEnum() {
        return productEnum;
    }

    public Integer getPrice() {
        return price;
    }
}

