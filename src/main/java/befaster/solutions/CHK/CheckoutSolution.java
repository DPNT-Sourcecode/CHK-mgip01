package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        // skus control, null is a illegal input
        if (skus == null){
            return -1;
        } else if(skus.length()<=0){
            return 0;
        }
        // legal products
        List<String> references = new ArrayList<String>();
        references.add("A");
        references.add("B");
        references.add("C");
        references.add("D");

        // have items, creation of list
        List<String> products = Stream.of(skus.split("")).collect(Collectors.toList());

        // validation
        List<String> cloneProducts = products.stream().collect(Collectors.toList());

        // remove all legal products, if the size of list is greater than 0, exist illegal reference of products
        for(String ref : references) {
            cloneProducts.removeIf(p -> p.equals(ref));
        }

        if(cloneProducts.size()>0){
            return -1;
        }

        // calculation of prices
        Integer priceProductA = ((Collections.frequency(products, "A") / 3)*130) + ((Collections.frequency(products, "A") % 3)*50);

        Integer priceProductB = ((Collections.frequency(products, "B") / 2)*45) + ((Collections.frequency(products, "B") % 2)*30);

        Integer priceProductC = Collections.frequency(products, "C")*20;

        Integer priceProductD = Collections.frequency(products, "D")*15;

        return priceProductA + priceProductB + priceProductC + priceProductD;
        //throw new SolutionNotImplementedException();
    }
}

