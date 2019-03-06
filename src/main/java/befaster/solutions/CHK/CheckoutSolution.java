package befaster.solutions.CHK;

import befaster.runner.SolutionNotImplementedException;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        // skus control
        if (skus == null){
            return -1;
        } else if(skus.length()<=0){
            return 0;
        }
        return 0;
        //throw new SolutionNotImplementedException();
    }
}

