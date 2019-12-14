package tr.org.open.seruvent.citybugs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.org.open.seruvent.citybugs.model.Event;
import tr.org.open.seruvent.citybugs.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserService userService;

    public Event createEvent(Event event){
        event.setState(1);
        event.setUser(userService.getUserById(1));
        return eventRepository.save(event);
    }

    public List<Event> getEventList(){
        List<Event> eventList = new ArrayList<>();
        eventRepository.findAll().forEach(eventList::add);
        return eventList;
    }
}
