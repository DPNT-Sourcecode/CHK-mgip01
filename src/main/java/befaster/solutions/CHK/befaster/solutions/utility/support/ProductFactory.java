package befaster.solutions.CHK.befaster.solutions.utility.support;

public class ProductFactory implements IFactory{
    @Override
    public Product createProduct(EProduct EProductRef) {

        switch (EProductRef){
            case A:
                return new Product(EProductRef, 50);
            case B:
                return new Product(EProductRef, 30);
            case C:
                return new Product(EProductRef, 20);
            case D:
                return new Product(EProductRef, 15);
            case E:
                return new Product(EProductRef, 40);
                default:
                    return null;
        }
    }
}




