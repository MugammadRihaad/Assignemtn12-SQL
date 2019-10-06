package ac.za.cput.repository.BellvilleRepo.Impl;

import ac.za.cput.domain.Bellville.ProductCakes;
import ac.za.cput.repository.BellvilleRepo.ProductCakesRepository;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;
@Repository("ProductCakesInMemory")
public class ProductCakesRepositoryImpl implements ProductCakesRepository {
    private static ProductCakesRepositoryImpl repository = null;
    private Set<ProductCakes> prodCakes;

    private ProductCakesRepositoryImpl(){
        this.prodCakes = new HashSet<>();
    }

    public static ProductCakesRepositoryImpl getRepository(){
        if (repository == null) repository = new ProductCakesRepositoryImpl();
        return repository;
    }

    @Override
    public ProductCakes create(ProductCakes cakes){
        this.prodCakes.add(cakes);
        return cakes;
    }
    @Override
    public ProductCakes read(String cakesId){
        return prodCakes.stream().filter(cakes -> cakes.getProductCakeId().equals(cakesId)).findAny().orElse(null);
    }
    @Override
    public void delete(String cakesId) {
        ProductCakes inDelete=read(cakesId);
        prodCakes.remove(inDelete);
    }
    @Override
    public ProductCakes update(ProductCakes cakes){
        ProductCakes inDelete = read(cakes.getProductCakeId());

        if(inDelete != null){
            prodCakes.remove(inDelete);
            prodCakes.add(cakes);
            return cakes;
        }

        return null;
    }

    @Override
    public Set<ProductCakes> getAll(){
        return this.prodCakes;
    }
}
