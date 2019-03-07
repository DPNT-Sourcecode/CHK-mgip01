package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductsDB {

    enum item {
        // itemRef, price, haveOffer, haveFreeItemOffer, haveCombOffer
        A("A", 50, true, false, false), // 3A for 130, 5A for 200
        B("B", 30, true, false, false), // 2B for 45
        C("C", 20, false, false, false),
        D("D", 15, false, false, false),
        E("E", 40, false, true, false), // 2E get one B

        // free
        F("F", 10, false, true, false), // 2F get one F free

        G("G", 20, false, false, false),
        H("H", 10, true, false, false), // 5H for 45, 10H for 80 |
        I("I", 35, false, false, false),
        J("J", 60, false, false, false),
        K("K", 70, true, false, false), // | 2K for 120 |
        L("L", 90, false, false, false),
        M("M", 15, false, false, false),
        N("N", 40, false, true, false), // | 3N get one M
        // free |
        O("O", 10, false, false, false),
        P("P", 50, true, false, false), // | 5P for 200 |
        Q("Q", 30, true, false, false), // | 3Q for 80 |
        R("R", 50, false, true, false), // | 3R get one Q free |

        U("U", 40, false, true, false), // | 3U get one U free |
        V("V", 50, true, false, false), // | 2V for 90, 3V for 130 |
        W("W", 20, false, false, false),

        Z("Z", 21, false, false, true), // buy any 3 of (S,T,X,Y,Z) for 45, 3Z = 45
        S("S", 20, false, false, true), // buy any 3 of (S,T,X,Y,Z) for 45, 3S = 45
        T("T", 20, false, false, true), // buy any 3 of (S,T,X,Y,Z) for 45, 3T = 45

        Y("Y", 20, false, false, true), // buy any 3 of (S,T,X,Y,Z) for 45, 3Y = 45
        X("X", 17, false, false, true); // buy any 3 of (S,T,X,Y,Z) for 45, 3X = 45

        private String itemRef;
        private int price;
        private boolean haveOffer;
        private boolean haveFreeItemOffer;
        private boolean haveCombOffer;

        // contructor
        item(final String itemRef, final int price, final boolean haveOffer, final boolean haveFreeItemOffer,
             final boolean haveCombOffer) {
            this.itemRef = itemRef;
            this.price = price;
            this.haveOffer = haveOffer;
            this.haveFreeItemOffer = haveFreeItemOffer;
            this.haveCombOffer = haveCombOffer;
        }

        public String getItemRef() {
            return itemRef;
        }

        public int getPrice() {
            return price;
        }

        public boolean isHaveOffer() {
            return haveOffer;
        }

        public boolean isHaveFreeItemOffer() {
            return haveFreeItemOffer;
        }

        public boolean isHaveCombOffer() {
            return haveCombOffer;
        }

        // get offers by item
        public ArrayList<offer> getOffers() {
            ArrayList<offer> offers = new ArrayList<offer>();
            if (this.equals(A)) {
                offers.add(offer.A1);
                offers.add(offer.A2);
            } else if (this.equals(B)) {
                offers.add(offer.B);
            } else if (this.equals(H)) {
                offers.add(offer.H1);
                offers.add(offer.H2);
            } else if (this.equals(K)) {
                offers.add(offer.K);
            } else if (this.equals(P)) {
                offers.add(offer.P);
            } else if (this.equals(Q)) {
                offers.add(offer.Q);
            } else if (this.equals(V)) {
                offers.add(offer.V1);
                offers.add(offer.V2);
            }
        /*
        } else if (this.equals(S)) {
            offers.add(offer.S);
        } else if (this.equals(T)) {
            offers.add(offer.T);
        } else if (this.equals(X)) {
            offers.add(offer.X);
        } else if (this.equals(Y)) {
            offers.add(offer.Y);
        } else if (this.equals(Z)) {
            offers.add(offer.Z);
        }
        */
            return offers;
        }

        // get specialOffers by item

        public ArrayList<freeItemOffer> getSpecialOffers() {
            ArrayList<freeItemOffer> freeItemOffers = new ArrayList<freeItemOffer>();
            if (this.equals(E)) {
                freeItemOffers.add(freeItemOffer.E);

            } else if (this.equals(F)) {
                freeItemOffers.add(freeItemOffer.F);

            } else if (this.equals(N)) {
                freeItemOffers.add(freeItemOffer.N);
            } else if (this.equals(R)) {
                freeItemOffers.add(freeItemOffer.R);
            } else if (this.equals(U)) {
                freeItemOffers.add(freeItemOffer.U);
            }
            return freeItemOffers;
        }

        // get combination offers

        public ArrayList<combinationOffer> getCombinationOffers() {
            ArrayList<combinationOffer> combOffers = new ArrayList<combinationOffer>();
            if (this.equals(S)) {
                combOffers.add(combinationOffer.S);
            } else if (this.equals(T)) {
                combOffers.add(combinationOffer.T);
            } else if (this.equals(X)) {
                combOffers.add(combinationOffer.X);
            } else if (this.equals(Y)) {
                combOffers.add(combinationOffer.Y);
            } else if (this.equals(Z)) {
                combOffers.add(combinationOffer.Z);
            }
            return combOffers;
        }

        public ArrayList<String> getListCombinationItems() {
            ArrayList<String> combinationItems = new ArrayList<String>();
            combinationItems.add("Z");
            combinationItems.add("S");
            combinationItems.add("T");
            combinationItems.add("Y");
            combinationItems.add("X");

            return combinationItems;
        }
    }

    // offer linked to item
    enum offer {
        // to manage the groups of items of the same item
        // will be necessary manage the groups in descendent order by numItems
        // numItems, price
        A1(5, 200), A2(3, 130), B(2, 45),
        H1(10, 80), H2(5, 45), K(2, 120), P(5, 200), Q(3, 80), V1(3, 130), V2(2, 90);
        /*
        S(3, 45), T(3, 45), X(3, 45), Y(3, 45), Z(3, 45);
        */
        private int numItems;
        private int price;

        // constructor
        offer(final int numItems, final int price) {
            this.numItems = numItems;
            this.price = price;
        }

        public int getNumItems() {
            return numItems;
        }

        public int getPrice() {
            return price;
        }
    }

    // freeItemOffer linked to item
    enum freeItemOffer {
        // numItems, free item object
        E(2, item.B),

        F(2, item.F),

        N(3, item.M), R(3, item.Q), U(3, item.U);


        private int numItems;
        private item freeItem;

        // constructor
        freeItemOffer(final int numItems, final item freeItem) {
            this.numItems = numItems;
            this.freeItem = freeItem;
        }

        public int getNumItems() {
            return numItems;
        }

        public item getFreeItem() {
            return freeItem;
        }
    }

    enum combinationOffer {
        S(3, 45, Arrays.asList(item.T, item.X, item.Y, item.Z)), T(3, 45, Arrays.asList(item.S, item.X, item.Y, item.Z)),
        X(3, 45, Arrays.asList(item.T, item.S, item.Y, item.Z)), Y(3, 45, Arrays.asList(item.T, item.X, item.S, item.Z)),
        Z(3, 45, Arrays.asList(item.T, item.X, item.Y, item.S));
        private int numItems;
        private int price;
        private List<item> itemsRefList;

        combinationOffer(final int numItems, final int price, final List<item> itemsRefList) {
            this.numItems = numItems;
            this.price = price;
            this.itemsRefList = itemsRefList;
        }

        public int getNumItems() {
            return numItems;
        }

        public int getPrice() {
            return price;
        }

        public List<item> getItemsRefList() {
            return itemsRefList;
        }
    }
}
