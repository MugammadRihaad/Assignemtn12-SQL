package ac.za.cput.controller.Town;

import ac.za.cput.domain.Town.ProductBiscuits;
import ac.za.cput.service.TownService.Impl.ProductBiscuitsServiceImpl;
import ac.za.cput.service.TownService.Impl.TownAccountantServiceImpl;
import ac.za.cput.service.TownService.ProductBiscuitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/biscuits")
public class ProductBiscuitsController {
    @Autowired
    @Qualifier("ProductBiscuitsServiceImpl")
    private ProductBiscuitsServiceImpl service;

    @PostMapping("/new")
    public ProductBiscuits create(@RequestBody ProductBiscuits accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public ProductBiscuits findById(@PathVariable String id){

        ProductBiscuits accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody ProductBiscuits accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<ProductBiscuits> getAll(){
        return service.getAll();
    }
}
