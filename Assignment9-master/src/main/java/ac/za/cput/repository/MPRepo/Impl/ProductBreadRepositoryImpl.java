package ac.za.cput.repository.MPRepo.Impl;

import ac.za.cput.domain.MP.ProductBread;
import ac.za.cput.repository.BellvilleRepo.ProductCakesRepository;
import ac.za.cput.repository.MPRepo.ProductBreadRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("ProductBreadInMemory")
public class ProductBreadRepositoryImpl implements ProductBreadRepository {
    private static ProductBreadRepositoryImpl repository = null;
    private Set<ProductBread> prodBread;

    private ProductBreadRepositoryImpl(){
        this.prodBread = new HashSet<>();
    }

    public static ProductBreadRepositoryImpl getRepository(){
        if (repository == null) repository = new ProductBreadRepositoryImpl();
        return repository;
    }

    @Override
    public ProductBread create(ProductBread bread){
        this.prodBread.add(bread);
        return bread;
    }
    @Override
    public ProductBread read(String breadId){
        return prodBread.stream().filter(bread -> bread.getProductBreadId().equals(breadId)).findAny().orElse(null);
    }
    @Override
    public void delete(String breadId) {
        ProductBread toDelete = read(breadId);
        prodBread.remove(toDelete);
    }
    @Override
    public ProductBread update(ProductBread bread){
        ProductBread toDelete = read(bread.getProductBreadId());
        if(toDelete != null) {
            prodBread.remove(toDelete);
            prodBread.add(bread);
            return bread;
        }
        return null;
    }

    @Override
    public Set<ProductBread> getAll(){
        return this.prodBread;
    }
}
