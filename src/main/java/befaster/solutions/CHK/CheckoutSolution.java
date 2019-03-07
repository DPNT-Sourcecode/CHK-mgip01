package befaster.solutions.CHK;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Enums constants to represent the items and the attributes of these items such as offers and special offers
 */

// item representation


public class CheckoutSolution {

    private Integer totalPrice;

    public CheckoutSolution() {
        totalPrice = 0;
    }

    private void sum(Integer price) {
        totalPrice = totalPrice + price;
    }

    private Integer getTotalPrice() {
        return totalPrice;
    }

    private void resetPrice() {
        totalPrice = 0;
    }

    public Integer checkout(String skus) {

        resetPrice();

        // skus control, null is a illegal input
        if (skus == null) {
            return -1;
        } else if (skus.length() <= 0) {
            return 0;
        }

        // have items, creation of list
        List<String> products = Stream.of(skus.split("")).collect(Collectors.toList());

        // validation
        List<String> cloneProducts = products.stream().collect(Collectors.toList());

        // remove all legal products, if the size of list is greater than 0, exist illegal reference of products
        for (ProductsDB.item i : ProductsDB.item.values()) {
            cloneProducts.removeIf(p -> p.equals(i.getItemRef()));
        }

        if (cloneProducts.size() > 0) {
            return -1;
        }


        for (ProductsDB.item i : ProductsDB.item.values()) {
            if (i.isHaveCombOffer()) {
                //products = processCombinationOffer(products, i, i.getListCombinationItems());
                List<List<String>> permComb = GDOPermutation.getInstance().process(products, i, i.getListCombinationItems());
                // get unique combination
                List<List<String>> uniqueComb = permComb.stream().distinct().collect(Collectors.toList());
                // calculate the best comb to apply the discount (the most expensive comb to favor the customer)
                List<String> bestComb = getBestComb(uniqueComb, uniqueComb.size(), 0)

            }
        }

        for (ProductsDB.item i : ProductsDB.item.values()) {
            if (i.isHaveFreeItemOffer()) {
                // calculate price by item/product and get the remain items in the collection
                products = processFreeItemOffer(products, i);
            }
        }

        for (ProductsDB.item i : ProductsDB.item.values()) {
            if (i.isHaveOffer()) {
                // calculate price by item/product and get the remain items in the collection
                products = processOffer(products, i);
            }
        }

        for (ProductsDB.item i : ProductsDB.item.values()) {
            if (!i.isHaveFreeItemOffer() && !i.isHaveOffer()) {
                // calculate price by item/product and get the remain items in the collection
                products = processItems(products, i);
            }
        }


        return getTotalPrice();
    }

    private List<String> processCombinationOffer(List<String> items, final ProductsDB.item product, List<String> combinationItems) {
        List<String> collect = items.stream().filter(i -> i.equals(product.getItemRef())).collect(Collectors.toList());
        // must be order the items by price first to always favor the customer when applying special offers

        // remove from combination list the root item
        //combinationItems.removeIf(p -> p.equals(product.getItemRef()));
        List<String> foundIt = new ArrayList<String>();
        List<Integer> foundIndex = new ArrayList<Integer>();
        if (!collect.isEmpty()) {
            for (String p : collect) {
                foundIt.clear();
                for (String c : combinationItems) {
                    if (items.contains(c)) {
                        foundIt.add(items.get(items.indexOf(c)));
                        //items.remove(items.indexOf(c));
                    }

                    if (foundIt.size() == 2) {
                        sum(45);
                        items.remove(p);
                        for (String s : foundIt) {
                            items.remove(s);
                        }
                        foundIt.clear();
                    }

                }
                //foundIt.clear();
            }
        }

        return items;
    }

    private List<String> processFreeItemOffer(List<String> items, final ProductsDB.item product) {
        List<String> collect = items.stream().filter(i -> i.equals(product.getItemRef())).collect(Collectors.toList());

        // if the list not empty process the product, if the list is empty the total
        // price of item/product will be zero
        // and then will not be necessary add the product price to the total price of
        // basket
        if (!collect.isEmpty()) {
            product.getSpecialOffers().forEach(so -> {
                if (so.getFreeItem().getItemRef().equals(product.getItemRef())) {
                    // calculate packs
                    List<String> remainItems = collect.subList(0, collect.size());
                    while (remainItems.iterator().hasNext() && ((remainItems.size() / so.getNumItems()) > 0)) {
                        if (remainItems.size() > so.getNumItems()) {
                            // sublist of items remain, remove 3 (2 pack and 1 free)
                            remainItems = remainItems.subList(0, remainItems.size() - (so.getNumItems() + 1));
                        } else {
                            break;
                        }
                        // add price of two items of pack to total price until finish the loop
                        sum(so.getNumItems() * product.getPrice());
                    }
                    // remain items out pack
                    sum(remainItems.size() * product.getPrice());
                } else {
                    for (int i = (collect.size() / so.getNumItems()); i > 0; i--) {
                        items.remove(so.getFreeItem().getItemRef());
                    }
                    // because the product passed don't have a pack offer
                    // will be calculate de price by normal way after remove the free items
                    sum(items.stream().filter(i -> i.equals(product.getItemRef()))
                            .collect(Collectors.toList()).size() * product.getPrice());
                }
            });
        }
        return items;
    }

    private List<String> processOffer(List<String> items, final ProductsDB.item product) {
        List<String> collect = items.stream().filter(i -> i.equals(product.getItemRef())).collect(Collectors.toList());

        // if the list not empty process the product, if the list is empty the total
        // price of item/product will be zero
        // and then will not be necessary add the product price to the total price of
        // basket
        if (!collect.isEmpty()) {
            int remainItems = collect.size();
            for (ProductsDB.offer o : product.getOffers()) {
                sum((remainItems / o.getNumItems()) * o.getPrice());
                // local remain items by product
                remainItems = remainItems % o.getNumItems();
            }

            // sum the price of local remain items by product
            sum(remainItems * product.getPrice());
        }
        return items;
    }

    private List<String> processItems(List<String> items, ProductsDB.item product) {
        List<String> collect = items.stream().filter(i -> i.equals(product.getItemRef())).collect(Collectors.toList());

        // if the list not empty process the product, if the list is empty the total
        // price of item/product will be zero
        // and then will not be necessary add the product price to the total price of
        // basket
        if (!collect.isEmpty()) {
            sum(collect.size() * product.getPrice());
        }
        return items;
    }
}
