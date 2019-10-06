package ac.za.cput.service.LedgerService;

import ac.za.cput.domain.Ledger.Ledger;
import ac.za.cput.service.IService;

import java.util.Set;

public interface LedgerService extends IService<Ledger, String> {
    Set<Ledger> getAll();
}
