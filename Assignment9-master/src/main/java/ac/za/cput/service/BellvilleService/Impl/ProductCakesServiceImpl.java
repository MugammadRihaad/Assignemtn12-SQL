package ac.za.cput.service.BellvilleService.Impl;


import ac.za.cput.domain.Bellville.ProductCakes;
import ac.za.cput.repository.BellvilleRepo.Impl.ProductCakesRepositoryImpl;
import ac.za.cput.repository.BellvilleRepo.ProductCakesRepository;
import ac.za.cput.service.BellvilleService.ProductCakesService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("ProductCakesServiceImpl")
public class ProductCakesServiceImpl implements ProductCakesService {
    private  ProductCakesServiceImpl service = null;
    private ProductCakesRepository repository;

    private ProductCakesServiceImpl(){
        this.repository = ProductCakesRepositoryImpl.getRepository();
    }
    public ProductCakesServiceImpl getService(){
        if (service == null){
            service = new ProductCakesServiceImpl();
        }
        return service;
    }



    @Override
    public Set<ProductCakes> getAll() {
        return this.repository.getAll();
    }

    @Override
    public ProductCakes create(ProductCakes cakes) {
        return this.repository.create(cakes);
    }

    @Override
    public ProductCakes read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public ProductCakes update(ProductCakes cakes) {
        return this.repository.update(cakes);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
