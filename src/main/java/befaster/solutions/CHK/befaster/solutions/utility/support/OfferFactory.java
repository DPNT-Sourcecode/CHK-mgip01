package befaster.solutions.CHK.befaster.solutions.utility.support;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OfferFactory implements IOfferFactory {

    private static OfferFactory instance = null;

    public static OfferFactory getInstance() {
        if (instance == null) {
            instance = new OfferFactory();
        }
        return instance;
    }

    @Override
    public List<Offer> createOffer(IFactory.EProduct eProduct) {
        List<IFactory.EProduct> freeEproducts = new ArrayList<IFactory.EProduct>();
        List<Offer> offerList = new ArrayList<Offer>();
        switch (eProduct) {
            case A:
                offerList.add(new Offer(5, 200, freeEproducts));
                offerList.add(new Offer(3, 130, freeEproducts));
                offerList.sort(Comparator.comparing(Offer::getNumItems));
                return offerList;
            case B:
                return new Offer(2, 45, freeEproducts);
            case E:
                freeEproducts.add(IFactory.EProduct.B);
                return new Offer(2, 0, freeEproducts);
            default:
                return null;
        }
    }
}


