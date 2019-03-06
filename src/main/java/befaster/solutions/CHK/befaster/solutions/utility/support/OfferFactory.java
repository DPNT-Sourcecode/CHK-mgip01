package befaster.solutions.CHK.befaster.solutions.utility.support;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OfferFactory implements IOfferFactory {

    @Override
    public Offer createOffer(EOffer eOffer) {
        List<IFactory.EProduct> freeEproducts = new ArrayList<IFactory.EProduct>();
        switch (eOffer) {
            case A:
                return new Offer(3, 130, null);
            case B:
                return new Offer(2, 45, null);
            case E:
                freeEproducts.add(IFactory.EProduct.B);
                return new Offer(2, 0, freeEproducts);
            default:
                return null;
        }
    }
}


