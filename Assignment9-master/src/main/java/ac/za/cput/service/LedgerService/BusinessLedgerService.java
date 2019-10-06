package ac.za.cput.service.LedgerService;

import ac.za.cput.domain.Ledger.BusinessLedger;
import ac.za.cput.service.IService;

import java.util.Set;

public interface BusinessLedgerService extends IService<BusinessLedger, String> {
    Set<BusinessLedger> getAll();
}
