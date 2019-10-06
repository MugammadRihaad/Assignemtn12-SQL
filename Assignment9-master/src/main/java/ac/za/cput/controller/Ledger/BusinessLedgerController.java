package ac.za.cput.controller.Ledger;

import ac.za.cput.domain.Ledger.BusinessLedger;
import ac.za.cput.service.LedgerService.BusinessLedgerService;
import ac.za.cput.service.LedgerService.Impl.BusinessLedgerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/businessledger")
public class BusinessLedgerController {
    @Autowired
    @Qualifier("BusinessLedgerServiceImpl")
    private BusinessLedgerServiceImpl service;

    @PostMapping("/new")
    public BusinessLedger create(@RequestBody BusinessLedger businessLedger){

        return service.create(businessLedger);
    }

    @GetMapping(path = "/find/{id}")
    public BusinessLedger findById(@PathVariable String id){

        BusinessLedger businessLedger = service.read(id);
        return businessLedger;
    }

    @PutMapping("/update")
    public void update(@RequestBody BusinessLedger businessLedger){

        service.update(businessLedger);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<BusinessLedger> getAll(){
        return service.getAll();
    }

}
