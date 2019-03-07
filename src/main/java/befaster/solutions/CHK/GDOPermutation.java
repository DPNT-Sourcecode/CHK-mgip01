package befaster.solutions.CHK;

import befaster.solutions.CHK.befaster.solutions.utility.support.Product;

import java.util.ArrayList;
import java.util.List;

public class GDOPermutation {

    List<List<String>> cList = new ArrayList<List<String>>();
    public static final int _numGroupItems = 3;

    private static GDOPermutation instance = null;

    public List<List<String>> getcList() {
        return cList;
    }

    public static GDOPermutation getInstance() {
        if (instance == null) {
            instance = new GDOPermutation();
        }
        return instance;
    }

    protected List<List<String>> process(List<String> items, final ProductsDB.item product, List<String> combinationList) {
        String[] itemList = new String[items.size()];
        itemList = items.toArray(itemList);
        combination(itemList, _numGroupItems);
        return getcList();
    }

    private void combination(String[] elements, final int k) {
        int len = elements.length;
        if (k > len) {
            return;
        }
        // calculate the factorial of k and len to possible combinations
        //factorial(len, k);

        // combination by index
        int combination[] = new int[k];
        // current position
        int r = 0;
        int index = 0;

        while (r >= 0) {
            if (index <= (len + (r - k))) {
                combination[r] = index;
                // last position, increase the index
                if (r == k - 1) {
                    cList.add(addToCList(combination, elements));
                    index++;
                } else {
                    index = combination[r] + 1;
                    r++;
                }
            } else {
                r--;
                if (r > 0) {
                    index = combination[r] + 1;
                } else {
                    index = combination[0] + 1;
                }
            }
        }
    }

    private List<String> addToCList(int[] combination, String[] elements){
        List<String> comb = new ArrayList<String>();
        for(int z = 0; z < combination.length; z++){
            comb.add(elements[combination[z]]);
        }
        return comb;
    }
}

