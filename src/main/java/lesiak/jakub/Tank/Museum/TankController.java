package lesiak.jakub.Tank.Museum;

import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
public class TankController {

    private final TankRepository repository;

    TankController(TankRepository repository){
        this.repository = repository;
    }

    @GetMapping
    List<Tank> all(){
        List<Tank> list = repository.findAll();
        list.sort(new SortAsc());
        return list;
    }

    @PostMapping
    String newTank(@RequestBody Tank tank){
        String name = tank.getName();
        String id = name.replace(" ","_").toLowerCase();

        if(repository.findById(id).isPresent()){
            return "W bazie jest już czołg o nazwie: " + name + ".\n";
        } else {
            tank.setId(id);
            repository.save(tank);
            return "Id czołgu " + name + " to: " + id + ".\n";
        }
    }

    @GetMapping("/{id}")
    Tank one(@PathVariable String id){
        return repository.findById(id).orElseThrow(() -> new TankNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    void deleteTank(@PathVariable String id){
        repository.deleteById(id);
    }

    static class SortAsc implements Comparator<Tank>{

        @Override
        public int compare(Tank t1, Tank t2) {
            return t1.getId().compareTo(t2.getId());
        }
    }
}