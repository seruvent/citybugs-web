package tr.org.open.seruvent.citybugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tr.org.open.seruvent.citybugs.model.Event;
import tr.org.open.seruvent.citybugs.model.EventResource;
import tr.org.open.seruvent.citybugs.service.EventResourceService;
import tr.org.open.seruvent.citybugs.service.EventService;

import java.util.Iterator;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private EventResourceService eventResourceService;

    @RequestMapping(method = RequestMethod.POST ,value = "/event")
    public void createEvent(@RequestBody Event event){

        event=eventService.createEvent(event);

        Iterator<EventResource> iterator = event.getEventResources().iterator();
        while (iterator.hasNext()){
            EventResource eventResource = iterator.next();
            eventResource.setEvent(event);
            eventResourceService.createEventResource(eventResource);
        }

        System.out.println("----- ----- ----- ----- -----");
        System.out.println("EVENT & EVENT RESOURCES CREATED");
        System.out.println(event.getDescription());
        System.out.println(event.getTitle());
        System.out.println(event.getId());
    }


}
