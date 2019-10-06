package ac.za.cput.controller.Town;

import ac.za.cput.domain.Town.TownBaker;
import ac.za.cput.service.TownService.Impl.TownBakerServiceImpl;
import ac.za.cput.service.TownService.TownBakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/townbaker")
public class TownBakerController {
    @Autowired
    @Qualifier("TownBakerServiceImpl")
    private TownBakerServiceImpl service;

    @PostMapping("/new")
    public TownBaker create(@RequestBody TownBaker accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public TownBaker findById(@PathVariable String id){

        TownBaker accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody TownBaker accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<TownBaker> getAll(){
        return service.getAll();
    }

}
