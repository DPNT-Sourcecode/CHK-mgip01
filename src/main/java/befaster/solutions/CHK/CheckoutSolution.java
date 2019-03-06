package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;
import befaster.solutions.CHK.befaster.solutions.utility.support.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckoutSolution {

    private Integer totalPrice;

    public CheckoutSolution(){
        totalPrice = 0;
    }

    private void sum(Integer price){
        totalPrice = totalPrice + price;
    }

    private Integer getTotalPrice(){
        return totalPrice;
    }

    private void resetPrice(){
        totalPrice = 0;
    }

    public Integer checkout(String skus) {

        resetPrice();

        // skus control, null is a illegal input
        if (skus == null){
            return -1;
        } else if(skus.length()<=0){
            return 0;
        }

        // have items, creation of list
        List<String> products = Stream.of(skus.split("")).collect(Collectors.toList());

        // validation
        List<String> cloneProducts = products.stream().collect(Collectors.toList());

        // remove all legal products, if the size of list is greater than 0, exist illegal reference of products
        for(IFactory.EProduct product : IFactory.EProduct.values()) {
            cloneProducts.removeIf(p -> p.equals(product.getRef()));
        }

        if(cloneProducts.size()>0){
            return -1;
        }

        for(String p : products){

            Product product = ProductFactory.getInstance().createProduct(IFactory.EProduct.valueOf(p));
            Offer offer = OfferFactory.getInstance().createOffer(IFactory.EProduct.valueOf(p));
            List<String> productList = products.stream().filter(prd -> prd.equals(p)).collect(Collectors.toList());
            if(offer!=null && offer.getFreeEproducts().size()==0){
                if(Collections.frequency(products, p) / offer.getNumItems() > 0){
                    sum((productList.size() / offer.getNumItems()) * offer.getPrice());
                    sum((productList.size() % offer.getNumItems()) * offer.getPrice());
                    break;
                }
            }else {
                sum(product.getPrice());
            }
        }

        // offers by frecuency

        return getTotalPrice();
    }
}


