package ac.za.cput.repository.MPRepo;

import ac.za.cput.domain.MP.ProductBread;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface ProductBreadRepository extends IRepository<ProductBread, String> {
    Set<ProductBread> getAll();
}