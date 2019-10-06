package ac.za.cput.service.MPService;

import ac.za.cput.domain.MP.ProductBread;
import ac.za.cput.service.IService;

import java.util.Set;

public interface ProductBreadService extends IService<ProductBread, String> {
    Set<ProductBread> getAll();
}