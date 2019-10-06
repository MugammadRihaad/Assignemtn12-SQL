package ac.za.cput.service.LedgerService.Impl;

import ac.za.cput.domain.Ledger.BusinessLedger;
import ac.za.cput.repository.LedgerRepo.BusinessLedgerRepository;
import ac.za.cput.repository.LedgerRepo.Impl.BusinessLedgerRepositoryImpl;
import ac.za.cput.service.LedgerService.BusinessLedgerService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service("BusinessLedgerServiceImpl")
public class BusinessLedgerServiceImpl implements BusinessLedgerService {
    private  BusinessLedgerServiceImpl service = null;
    private BusinessLedgerRepository repository;

    private BusinessLedgerServiceImpl(){
        this.repository = BusinessLedgerRepositoryImpl.getRepository();
    }
    public BusinessLedgerServiceImpl getService(){
        if (service == null){
            service = new BusinessLedgerServiceImpl();
        }
        return service;
    }



    @Override
    public Set<BusinessLedger> getAll() {
        return this.repository.getAll();
    }

    @Override
    public BusinessLedger create(BusinessLedger busLedger) {
        return this.repository.create(busLedger);
    }

    @Override
    public BusinessLedger read(String integer) {
        return this.repository.read(integer);
    }

    @Override
    public BusinessLedger update(BusinessLedger busLedger) {
        return this.repository.update(busLedger);
    }

    @Override
    public void delete(String integer) {

        repository.delete(integer);
    }
}
