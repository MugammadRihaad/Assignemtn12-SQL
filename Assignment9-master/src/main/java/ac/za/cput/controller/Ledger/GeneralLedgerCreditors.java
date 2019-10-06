package ac.za.cput.controller.Ledger;


import ac.za.cput.domain.Ledger.GeneralLedger;
import ac.za.cput.service.LedgerService.GeneralLedgerService;
import ac.za.cput.service.LedgerService.Impl.GeneralLedgerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/generalledger")
public class GeneralLedgerCreditors {
    @Autowired
    @Qualifier("GeneralLedgerServiceImpl")
    private GeneralLedgerServiceImpl service;

    @PostMapping("/new")
    public GeneralLedger create(@RequestBody GeneralLedger accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public GeneralLedger findById(@PathVariable String id){

        GeneralLedger accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody GeneralLedger accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<GeneralLedger> getAll(){
        return service.getAll();
    }

}
