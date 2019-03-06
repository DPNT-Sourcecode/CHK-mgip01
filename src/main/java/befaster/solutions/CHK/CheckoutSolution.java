package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

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

        // have items, creation of list
        List<String> products = Stream.of(skus.split("")).collect(Collectors.toList());


        return 0;
        //throw new SolutionNotImplementedException();
    }
}


