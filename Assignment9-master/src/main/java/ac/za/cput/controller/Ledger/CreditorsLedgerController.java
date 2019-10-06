package ac.za.cput.controller.Ledger;


import ac.za.cput.domain.Ledger.CreditorsLedger;
import ac.za.cput.service.LedgerService.CreditorsLedgerService;
import ac.za.cput.service.LedgerService.Impl.CreditorsLedgerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/creditorsledger")
public class CreditorsLedgerController {
    @Autowired
    @Qualifier("CreditorsLedgerServiceImpl")
    private CreditorsLedgerServiceImpl service;

    @PostMapping("/new")
    public CreditorsLedger create(@RequestBody CreditorsLedger accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public CreditorsLedger findById(@PathVariable String id){

        CreditorsLedger accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody CreditorsLedger accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<CreditorsLedger> getAll(){
        return service.getAll();
    }

}
