package befaster.solutions.CHK.befaster.solutions.utility.support;

public interface IOfferFactory {

    public enum EOffer {
        A("A"),
        B("B"),
        E("E");

        private String ref;
        EOffer(final String ref){
            this.ref = ref;
        }

        public String getRef(){
            return ref;
        }
    }

    Offer createOffer(IFactory.EProduct eProduct);

}
