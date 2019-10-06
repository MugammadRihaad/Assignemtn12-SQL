package ac.za.cput.controller.MP;

import ac.za.cput.domain.MP.ProductBread;
import ac.za.cput.service.MPService.Impl.ProductBreadServiceImpl;
import ac.za.cput.service.MPService.ProductBreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/mpbread")
public class ProductBreadController {
    @Autowired
    @Qualifier("ProductBreadServiceImpl")
    private ProductBreadServiceImpl service;

    @PostMapping("/new")
    public ProductBread create(@RequestBody ProductBread accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public ProductBread findById(@PathVariable String id){

        ProductBread accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody ProductBread accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<ProductBread> getAll(){
        return service.getAll();
    }
}
