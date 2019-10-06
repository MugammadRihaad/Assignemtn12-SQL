package ac.za.cput.controller.Ledger;


import ac.za.cput.domain.Ledger.Ledger;
import ac.za.cput.service.LedgerService.Impl.LedgerServiceImpl;
import ac.za.cput.service.LedgerService.LedgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/ledger")
public class LedgerController {
    @Autowired
    @Qualifier("LedgerServiceImpl")
    private LedgerServiceImpl service;

    @PostMapping("/new")
    public Ledger create(@RequestBody Ledger accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public Ledger findById(@PathVariable String id){

        Ledger accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody Ledger accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Ledger> getAll(){
        return service.getAll();
    }

}
