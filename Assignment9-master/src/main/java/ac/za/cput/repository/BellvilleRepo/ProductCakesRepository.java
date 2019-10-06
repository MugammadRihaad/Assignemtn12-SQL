package ac.za.cput.repository.BellvilleRepo;

import ac.za.cput.domain.Bellville.ProductCakes;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface ProductCakesRepository extends IRepository<ProductCakes, String> {
    Set<ProductCakes> getAll();
}
