package ac.za.cput.controller.Town;

import ac.za.cput.domain.Town.TownDelivery;
import ac.za.cput.service.TownService.Impl.TownDeliveryServiceImpl;
import ac.za.cput.service.TownService.TownDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/towndelivery")
public class TownDeliveryController {
    @Autowired
    @Qualifier("TownDeliveryServiceImpl")
    private TownDeliveryServiceImpl service;

    @PostMapping("/new")
    public TownDelivery create(@RequestBody TownDelivery accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public TownDelivery findById(@PathVariable String id){

        TownDelivery accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody TownDelivery accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<TownDelivery> getAll(){
        return service.getAll();
    }

}
