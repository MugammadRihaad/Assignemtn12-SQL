package ac.za.cput.service.LedgerService;

import ac.za.cput.domain.Ledger.GeneralLedger;
import ac.za.cput.service.IService;

import java.util.Set;

public interface GeneralLedgerService extends IService<GeneralLedger, String> {
    Set<GeneralLedger> getAll();
}
