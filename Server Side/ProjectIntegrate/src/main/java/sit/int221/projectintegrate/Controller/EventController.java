package sit.int221.projectintegrate.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.projectintegrate.DTO.SimpleEventDTO;
import sit.int221.projectintegrate.Entities.Event;
import sit.int221.projectintegrate.Repository.EventRepository;
import sit.int221.projectintegrate.Services.eventService;


import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
@CrossOrigin
public class EventController {
    @Autowired
    private eventService eventService;
    @Autowired
    private EventRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    public EventController(EventRepository repository) {
        this.repository = repository;
    }
//    @GetMapping("")
//    public List<Event> getEventAll() {
//        return repository.findAll();
//    }
    @GetMapping("")
    public List<SimpleEventDTO> getAllEvent() {
        return eventService.getAllEvent();
    }
    @GetMapping("/{eventId}")
    public SimpleEventDTO getCustomerById(@PathVariable Integer eventId) {
        return eventService.getSimpleCustomerById(eventId);
    }

//    @PostMapping("")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Event create(@Valid @RequestBody Event newEvent) {
//       return repository.saveAndFlush(newEvent);
//    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Event create(@Valid @RequestBody SimpleEventDTO newEvent){
        return eventService.save(newEvent);
    }

    @DeleteMapping("/{eventId}")
    public void delete(@PathVariable Integer eventId) {
        repository.findById(eventId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, eventId + " does not exist !!!"));
        repository.deleteById(eventId);
    }

    @PutMapping("/{eventId}")
    public Event updateEvent(@RequestBody Event updateEvent, @PathVariable Integer eventId) {
        Event event = repository.findById(eventId).map(o -> mapEvent(o, updateEvent)).orElseGet(() -> {
            updateEvent.setId(eventId);
            return updateEvent;
        });
        return repository.saveAndFlush(event);
    }

    private Event mapEvent(Event existingEvent,Event updateEvent){
        existingEvent.setStartTime(updateEvent.getStartTime());
        existingEvent.setEventNotes(updateEvent.getEventNotes());
        return existingEvent;
    }

}
