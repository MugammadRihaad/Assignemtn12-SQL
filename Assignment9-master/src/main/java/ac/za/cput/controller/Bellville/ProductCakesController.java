package ac.za.cput.controller.Bellville;


import ac.za.cput.domain.Bellville.ProductCakes;
import ac.za.cput.service.BellvilleService.Impl.ProductCakesServiceImpl;
import ac.za.cput.service.BellvilleService.ProductCakesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/administrator")
public class ProductCakesController {
    @Autowired
    @Qualifier("ProductCakesServiceImpl")
    private ProductCakesServiceImpl service;

    @PostMapping("/new")
    public ProductCakes create(@RequestBody ProductCakes cakes){

        return service.create(cakes);
    }

    @GetMapping(path = "/find/{id}")
    public ProductCakes findById(@PathVariable String id){

        ProductCakes cakes = service.read(id);

        return cakes;
    }

    @PutMapping("/update")
    public void update(@RequestBody ProductCakes cakes){

        service.update(cakes);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getall")
    public Set<ProductCakes> getAll(){
        return service.getAll();
    }
}
