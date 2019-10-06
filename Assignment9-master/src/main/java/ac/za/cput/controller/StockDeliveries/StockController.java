package ac.za.cput.controller.StockDeliveries;

import ac.za.cput.domain.StockDeliveries.Stock;
import ac.za.cput.service.StockDeliveriesService.Impl.StockServiceImpl;
import ac.za.cput.service.StockDeliveriesService.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    @Qualifier("StockServiceImpl")
    private StockServiceImpl service;

    @PostMapping("/new")
    public Stock create(@RequestBody Stock accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public Stock findById(@PathVariable String id){

        Stock accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody Stock accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Stock> getAll(){
        return service.getAll();
    }

}
