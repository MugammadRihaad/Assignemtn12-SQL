package ac.za.cput.service.BellvilleService;

import ac.za.cput.domain.Bellville.bellvilleBaker;
import ac.za.cput.service.IService;

import java.util.Set;

public interface  BellvilleBakerService extends IService<bellvilleBaker, String> {
    Set<bellvilleBaker> getAll();
}
