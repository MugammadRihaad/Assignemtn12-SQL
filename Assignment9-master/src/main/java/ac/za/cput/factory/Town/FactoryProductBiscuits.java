package ac.za.cput.factory.Town;

import ac.za.cput.domain.Town.ProductBiscuits;
import ac.za.cput.util.IDGenerator;

public class FactoryProductBiscuits {
    public static ProductBiscuits getProductBiscuits( String category, int amount){
        return new ProductBiscuits.Builder()
                .productBiscuitsId(IDGenerator.generateId())
                .category(category)
                .amount(amount)
                .build();
    }
}
