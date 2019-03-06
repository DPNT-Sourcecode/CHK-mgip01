package befaster.solutions.CHK.befaster.solutions.utility.support;

public class ProductFactory implements IFactory{
    @Override
    public Product createProduct(EProduct eProduct) {

        switch (eProduct){
            case A:
                return new Product(eProduct, 50);
            case B:
                return new Product(eProduct, 30);
            case C:
                return new Product(eProduct, 20);
            case D:
                return new Product(eProduct, 15);
            case E:
                return new Product(eProduct, 40);
                default:
                    return null;
        }
    }
}
