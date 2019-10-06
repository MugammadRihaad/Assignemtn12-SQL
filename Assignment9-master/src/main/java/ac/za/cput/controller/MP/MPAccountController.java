package ac.za.cput.controller.MP;

import ac.za.cput.domain.MP.MPAccountant;
import ac.za.cput.service.MPService.Impl.MPAccountantServiceImpl;
import ac.za.cput.service.MPService.MPAccountantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/mpaccountant")
public class MPAccountController {
    @Autowired
    @Qualifier("MPAccountantServiceImpl")
    private MPAccountantServiceImpl service;

    @PostMapping("/new")
    public  MPAccountant create(@RequestBody  MPAccountant accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public  MPAccountant findById(@PathVariable String id){

        MPAccountant accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody  MPAccountant accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set< MPAccountant> getAll(){
        return service.getAll();
    }

}
