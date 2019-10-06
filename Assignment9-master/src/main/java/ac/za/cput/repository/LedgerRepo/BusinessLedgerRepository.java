package ac.za.cput.repository.LedgerRepo;

import ac.za.cput.domain.Ledger.BusinessLedger;
import ac.za.cput.repository.IRepository;

import java.util.Set;

public interface BusinessLedgerRepository extends IRepository<BusinessLedger, String> {
    Set<BusinessLedger> getAll();
}
