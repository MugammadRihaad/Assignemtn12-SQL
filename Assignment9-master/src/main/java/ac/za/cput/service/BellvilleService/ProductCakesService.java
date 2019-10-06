package ac.za.cput.service.BellvilleService;

import ac.za.cput.domain.Bellville.ProductCakes;
import ac.za.cput.service.IService;

import java.util.Set;

public interface ProductCakesService extends IService<ProductCakes, String> {
    Set<ProductCakes> getAll();
}
