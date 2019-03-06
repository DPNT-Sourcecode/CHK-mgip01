package befaster.solutions.CHK.befaster.solutions.utility.support;

public interface IFactory {
    public enum EProduct {
        A("A"),
        B("B"),
        C("C"),
        D("D"),
        E("E");

        private String ref;
        EProduct(final String ref){
            this.ref = ref;
        }

        public String getRef(){
            return ref;
        }
    }

    Product createProduct(EProduct EProductRef);
}
