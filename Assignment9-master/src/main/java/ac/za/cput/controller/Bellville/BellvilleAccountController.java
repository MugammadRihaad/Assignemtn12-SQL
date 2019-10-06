package ac.za.cput.controller.Bellville;

import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.service.BellvilleService.BellvilleAccountantService;
import ac.za.cput.service.BellvilleService.Impl.BellvilleAccountantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/bellaccountant")
public class BellvilleAccountController {
    @Autowired
    @Qualifier("BellvilleAccountantServiceImpl")
    private BellvilleAccountantServiceImpl service;

    @PostMapping("/new")
    public BellvilleAccountant create(@RequestBody BellvilleAccountant accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public BellvilleAccountant findById(@PathVariable String id){

        BellvilleAccountant accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody BellvilleAccountant accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<BellvilleAccountant> getAll(){
        return service.getAll();
    }

}
