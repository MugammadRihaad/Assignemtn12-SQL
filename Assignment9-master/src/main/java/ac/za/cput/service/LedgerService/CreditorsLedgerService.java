package ac.za.cput.service.LedgerService;

import ac.za.cput.domain.Ledger.CreditorsLedger;
import ac.za.cput.service.IService;

import java.util.Set;

public interface CreditorsLedgerService extends IService<CreditorsLedger, String> {
    Set<CreditorsLedger> getAll();
}
