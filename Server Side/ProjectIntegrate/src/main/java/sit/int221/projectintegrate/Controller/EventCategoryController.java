package sit.int221.projectintegrate.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.projectintegrate.Entities.Event;
import sit.int221.projectintegrate.Entities.EventCategory;
import sit.int221.projectintegrate.Repository.EventCategoryRepository;

import java.util.List;

@RestController
@RequestMapping("/api/eventCategory")
@CrossOrigin
public class EventCategoryController {
    @Autowired
    private EventCategoryRepository repository;

    @GetMapping("")
    public List<EventCategory> getEventCategoryAll() {
        return repository.findAll();
    }


    @GetMapping("/{categoryName}")
    public List<EventCategory> getEventCategoryName(@PathVariable String categoryName) {
        return repository.findByeventCategoryName(categoryName);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public EventCategory create(@RequestBody EventCategory newEvent) {
        return repository.saveAndFlush(newEvent);
    }

    @DeleteMapping("/{eventCategoryId}")
    public void delete(@PathVariable Integer eventCategoryId) {
        repository.findById(eventCategoryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, eventCategoryId + " does not exist !!!"));
        repository.deleteById(eventCategoryId);
    }

}

