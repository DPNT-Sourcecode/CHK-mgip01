package befaster.solutions.CHK.befaster.solutions.utility.support;

import java.util.Arrays;

public class OfferFactory implements IOfferFactory {

    @Override
    public Offer createOffer(EOffer eOffer) {
        switch (eOffer){
            case A:
                return new Offer(3,130,null);
            case B:
                return new Offer(2,45, null);
            case E:
                return new Offer(2, 0, Arrays.asList())
        }
    }
}

