package ac.za.cput.controller.MP;

import ac.za.cput.domain.MP.MPDelivery;
import ac.za.cput.service.MPService.Impl.MPDeliveryServiceImpl;
import ac.za.cput.service.MPService.MPDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/mpdelivery")
public class MPDeliveryController {
    @Autowired
    @Qualifier("MPDeliveryServiceImpl")
    private MPDeliveryServiceImpl service;

    @PostMapping("/new")
    public MPDelivery create(@RequestBody MPDelivery accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public MPDelivery findById(@PathVariable String id){

        MPDelivery accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody MPDelivery accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<MPDelivery> getAll(){
        return service.getAll();
    }

}
