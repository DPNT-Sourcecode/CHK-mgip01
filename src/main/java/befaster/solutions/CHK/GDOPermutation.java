package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.List;

public class GDOPermutation {

    List<List<String>> cList = new ArrayList<List<String>>();

    private static GDOPermutation instance = null;

    public List<List<String>> getcList() {
        return cList;
    }

    public static GDOPermutation getInstance() {
        if(instance == null){
            instance = new GDOPermutation();
        }
        return instance;
    }
}
