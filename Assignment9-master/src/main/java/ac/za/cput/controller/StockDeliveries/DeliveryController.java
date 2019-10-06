package ac.za.cput.controller.StockDeliveries;


import ac.za.cput.domain.Bellville.BellvilleAccountant;
import ac.za.cput.domain.StockDeliveries.Deliveries;
import ac.za.cput.service.StockDeliveriesService.DeliveryService;
import ac.za.cput.service.StockDeliveriesService.Impl.DeliveryServiceImpl;
import ac.za.cput.service.StockDeliveriesService.StockDeliveriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    @Qualifier("DeliveryServiceImpl")
    private DeliveryServiceImpl service;

    @PostMapping("/new")
    public Deliveries create(@RequestBody Deliveries accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public Deliveries findById(@PathVariable String id){

        Deliveries accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody Deliveries accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Deliveries> getAll(){
        return service.getAll();
    }

}
