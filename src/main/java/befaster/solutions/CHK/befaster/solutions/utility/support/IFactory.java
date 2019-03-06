package befaster.solutions.CHK.befaster.solutions.utility.support;

public interface IFactory {
    public enum product {
        A("A"),
        B("B"),
        C("C"),
        D("D"),
        E("E");

        private String ref;
        product(final String ref){
            this.ref = ref;
        }

        public String getRef(){
            return ref;
        }
    }

    Product createProduct(product productRef);
}



