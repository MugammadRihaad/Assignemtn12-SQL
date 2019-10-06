package ac.za.cput.service.HeadOfficeService;

import ac.za.cput.domain.HeadOffice;
import ac.za.cput.service.IService;

import java.util.Set;

public interface HeadOfficeService extends IService<HeadOffice, String> {
    Set<HeadOffice> getAll();
}