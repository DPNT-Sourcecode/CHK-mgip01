package befaster.solutions.CHK.befaster.solutions.utility.support;

public class ProductFactory implements IFactory{
    @Override
    public Product createProduct(product productRef) {

        switch (productRef){
            case A:
                return new Product(productRef, 50);
            case B:
                return new Product(productRef, 30);
            case C:
                return new Product(productRef, 20);
            case D:
                return new Product(productRef, 15);
            case E:
                return new Product(productRef, 40);
                default:
                    return null;
        }
    }
}



