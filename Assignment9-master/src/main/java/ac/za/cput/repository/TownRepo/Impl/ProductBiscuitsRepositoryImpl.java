package ac.za.cput.repository.TownRepo.Impl;

import ac.za.cput.domain.Town.ProductBiscuits;
import ac.za.cput.repository.TownRepo.ProductBiscuitsRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("ProductBiscuitsInMemory")
public class ProductBiscuitsRepositoryImpl implements ProductBiscuitsRepository {
    private static ProductBiscuitsRepositoryImpl repository = null;
    private Set<ProductBiscuits> prodBiscuits;

    private ProductBiscuitsRepositoryImpl(){
        this.prodBiscuits = new HashSet<>();
    }

    public static ProductBiscuitsRepositoryImpl getRepository(){
        if (repository == null) repository = new ProductBiscuitsRepositoryImpl();
        return repository;
    }

    @Override
    public ProductBiscuits create(ProductBiscuits biscuits){
        this.prodBiscuits.add(biscuits);
        return biscuits;
    }
    @Override
    public ProductBiscuits read(String biscuitsId){
        return prodBiscuits.stream().filter(biscuits -> biscuits.getProductBiscuitsId().equals(biscuitsId)).findAny().orElse(null);
    }
    @Override
    public void delete(String biscuitsId) {
        ProductBiscuits toDelete = read(biscuitsId);
        prodBiscuits.remove(toDelete);
    }
    @Override
    public ProductBiscuits update(ProductBiscuits biscuits){
        ProductBiscuits toDelete = read(biscuits.getProductBiscuitsId());
        if(toDelete != null) {
            prodBiscuits.remove(toDelete);
            prodBiscuits.add(biscuits);
            return biscuits;
        }
        return null;
    }

    @Override
    public Set<ProductBiscuits> getAll(){
        return this.prodBiscuits;
    }
}
