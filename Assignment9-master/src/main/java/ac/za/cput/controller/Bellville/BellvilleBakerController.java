package ac.za.cput.controller.Bellville;


import ac.za.cput.domain.Bellville.bellvilleBaker;
import ac.za.cput.service.BellvilleService.BellvilleBakerService;
import ac.za.cput.service.BellvilleService.Impl.BellvilleBakerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/bellbaker")
public class BellvilleBakerController {
    @Autowired
    @Qualifier("BellvilleBakerServiceImpl")
    private BellvilleBakerServiceImpl service;

    @PostMapping("/new")
    public bellvilleBaker create(@RequestBody bellvilleBaker baker){

        return service.create(baker);
    }

    @GetMapping(path = "/find/{id}")
    public bellvilleBaker findById(@PathVariable String id){

        bellvilleBaker baker = service.read(id);
        return baker;
    }

    @PutMapping("/update")
    public void update(@RequestBody bellvilleBaker baker){

        service.update(baker);

    }

    @DeleteMapping(path = "/delete/{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }

    @GetMapping("/getall")
    public Set<bellvilleBaker> getAll(){
        return service.getAll();
    }

}
