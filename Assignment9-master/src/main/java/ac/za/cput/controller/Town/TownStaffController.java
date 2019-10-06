package ac.za.cput.controller.Town;

import ac.za.cput.domain.Town.TownStaff;
import ac.za.cput.service.TownService.Impl.TownStaffServiceImpl;
import ac.za.cput.service.TownService.TownStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/townstaff")
public class TownStaffController {
    @Autowired
    @Qualifier("TownStaffServiceImpl")
    private TownStaffServiceImpl service;

    @PostMapping("/new")
    public TownStaff create(@RequestBody TownStaff accountant){

        return service.create(accountant);
    }

    @GetMapping(path = "/find/{id}")
    public TownStaff findById(@PathVariable String id){

        TownStaff accountant = service.read(id);
        return accountant;
    }

    @PutMapping("/update")
    public void update(@RequestBody TownStaff accountant){

        service.update(accountant);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getAll")
    public Set<TownStaff> getAll(){
        return service.getAll();
    }
}
