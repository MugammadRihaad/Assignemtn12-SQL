package ac.za.cput.factory.MP;

import ac.za.cput.domain.MP.ProductBread;
import ac.za.cput.util.IDGenerator;

public class FactoryProductBread {
    public static ProductBread getProductBread( String category, int amount){
        return new ProductBread.Builder()
                .productBreadId(IDGenerator.generateId())
                .category(category)
                .amount(amount)
                .build();
    }
}
