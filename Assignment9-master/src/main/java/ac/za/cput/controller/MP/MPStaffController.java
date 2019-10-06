package ac.za.cput.controller.MP;

import ac.za.cput.domain.MP.MPStaff;
import ac.za.cput.service.BellvilleService.BellvilleStaffService;
import ac.za.cput.service.MPService.Impl.MPStaffServiceImpl;
import ac.za.cput.service.MPService.MPStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/mpstaff")
public class MPStaffController {
    @Autowired
    @Qualifier("MPStaffServiceImpl")
    private MPStaffServiceImpl service;

    @PostMapping("/new")
    public MPStaff create(@RequestBody MPStaff accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public MPStaff findById(@PathVariable String id){

        MPStaff accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody MPStaff accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<MPStaff> getAll(){
        return service.getAll();
    }
}
