package sit.int221.projectintegrate.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sit.int221.projectintegrate.DTO.SimpleEventDTO;
import sit.int221.projectintegrate.Entities.Event;
import sit.int221.projectintegrate.Repository.EventRepository;
import sit.int221.projectintegrate.listMapper;

import java.util.List;

@Service
public class eventService {
    @Autowired
    private  EventRepository repository;
    @Autowired
    private  ModelMapper modelMapper;
    @Autowired
    private  listMapper listMapper;
    public SimpleEventDTO getSimpleCustomerById(Integer eventId) {
        Event event = repository.findById(eventId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer id " + eventId + "Does Not Exist !!!"));
        return modelMapper.map(event, SimpleEventDTO.class);
    }

    public  List<SimpleEventDTO> getAllEvent() {
        List<Event> eventList = repository.findAll();
        return listMapper.mapList(eventList, SimpleEventDTO.class, modelMapper);
    }

    public Event save(SimpleEventDTO newEvent) {
        Event e = modelMapper.map(newEvent, Event.class);
        return repository.saveAndFlush(e);
    }
}