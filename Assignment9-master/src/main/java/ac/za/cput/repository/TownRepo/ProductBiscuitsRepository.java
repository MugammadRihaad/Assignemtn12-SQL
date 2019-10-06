package ac.za.cput.repository.TownRepo;

import ac.za.cput.domain.MP.ProductBread;
import ac.za.cput.domain.Town.ProductBiscuits;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface ProductBiscuitsRepository extends IRepository<ProductBiscuits, String> {
    Set<ProductBiscuits> getAll();
}