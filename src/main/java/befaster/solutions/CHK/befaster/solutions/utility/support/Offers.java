package befaster.solutions.CHK.befaster.solutions.utility.support;

import java.util.List;

public class Offers {

    private Integer numItems;
    private Integer Price;
    private List<IFactory.EProduct> freeEProducts;

    public Offers(Integer numItems, Integer price, List<IFactory.EProduct> freeEProducts) {
        this.numItems = numItems;
        Price = price;
        this.freeEProducts = freeEProducts;
    }

    public Integer getNumItems() {
        return numItems;
    }

    public Integer getPrice() {
        return Price;
    }

    public List<IFactory.EProduct> getFreeEProducts() {
        return freeEProducts;
    }
}

