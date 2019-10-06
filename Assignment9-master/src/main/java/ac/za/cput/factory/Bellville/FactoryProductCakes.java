package ac.za.cput.factory.Bellville;

import ac.za.cput.domain.Bellville.ProductCakes;
import ac.za.cput.util.IDGenerator;

public class FactoryProductCakes {
    public static ProductCakes getProductCakes( String category,int amount){
        return new ProductCakes.Builder()
                                .productCakeId(IDGenerator.generateId())
                                .category(category)
                                .amount(amount)
                                .build();
    }
}
