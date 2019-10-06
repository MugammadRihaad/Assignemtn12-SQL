package ac.za.cput.service.TownService;

import ac.za.cput.domain.Town.ProductBiscuits;
import ac.za.cput.service.IService;

import java.util.Set;

public interface ProductBiscuitsService extends IService<ProductBiscuits, String> {
    Set<ProductBiscuits> getAll();
}