package ac.za.cput.controller.Town;


import ac.za.cput.domain.Town.TownAccountant;
import ac.za.cput.service.TownService.Impl.TownAccountantServiceImpl;
import ac.za.cput.service.TownService.TownAccountantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/townaccountant")
public class TownAccountController {
    @Autowired
    @Qualifier("TownAccountantServiceImpl")
    private TownAccountantServiceImpl service;

    @PostMapping("/new")
    public TownAccountant create(@RequestBody TownAccountant accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public TownAccountant findById(@PathVariable String id){

        TownAccountant accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody TownAccountant accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<TownAccountant> getAll(){
        return service.getAll();
    }

}
