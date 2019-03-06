package befaster.solutions.CHK.befaster.solutions.utility.support;

import java.util.List;

public class Offer {

    private Integer numItems;
    private Integer Price;
    private List<IFactory.EProduct> freeEproducts;

    public Offer(Integer numItems, Integer price, List<IFactory.EProduct> freeEproducts) {
        this.numItems = numItems;
        Price = price;
        this.freeEproducts = freeEproducts;
    }

    public Integer getNumItems() {
        return numItems;
    }

    public Integer getPrice() {
        return Price;
    }

    public List<IFactory.EProduct> getFreeEproducts() {
        return freeEproducts;
    }
}
