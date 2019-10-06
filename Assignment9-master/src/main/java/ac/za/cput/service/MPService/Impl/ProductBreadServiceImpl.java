package ac.za.cput.service.MPService.Impl;


import ac.za.cput.domain.MP.ProductBread;
import ac.za.cput.repository.MPRepo.Impl.ProductBreadRepositoryImpl;
import ac.za.cput.repository.MPRepo.ProductBreadRepository;
import ac.za.cput.service.MPService.ProductBreadService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("ProductBreadServiceImpl")
public class ProductBreadServiceImpl implements ProductBreadService {
    private  ProductBreadServiceImpl service = null;
    private ProductBreadRepository repository;

    private ProductBreadServiceImpl(){
        this.repository = ProductBreadRepositoryImpl.getRepository();
    }
    public ProductBreadServiceImpl getService(){
        if (service == null){
            service = new ProductBreadServiceImpl();
        }
        return service;
    }



    @Override
    public Set<ProductBread> getAll() {
        return this.repository.getAll();
    }

    @Override
    public ProductBread create(ProductBread bread) {
        return this.repository.create(bread);
    }

    @Override
    public ProductBread read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public ProductBread update(ProductBread bread) {
        return this.repository.update(bread);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
