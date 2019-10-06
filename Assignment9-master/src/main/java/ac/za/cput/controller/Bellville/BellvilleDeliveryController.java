package ac.za.cput.controller.Bellville;


import ac.za.cput.domain.Bellville.BellvilleDelivery;
import ac.za.cput.service.BellvilleService.BellvilleDeliveryService;
import ac.za.cput.service.BellvilleService.Impl.BellvilleDeliveryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/belldelivery")
public class BellvilleDeliveryController {
    @Autowired
    @Qualifier("BellvilleDeliveryServiceImpl")
    private BellvilleDeliveryServiceImpl service;

    @PostMapping("/new")
    public BellvilleDelivery create(@RequestBody BellvilleDelivery delivery){

        return service.create(delivery);
    }

    @GetMapping(path = "/find/{id}")
    public BellvilleDelivery findById(@PathVariable String id){

        BellvilleDelivery delivery = service.read(id);

        return delivery;
    }

    @PutMapping("/update")
    public void update(@RequestBody BellvilleDelivery delivery){

        service.update(delivery);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<BellvilleDelivery> getAll(){
        return service.getAll();
    }
}
