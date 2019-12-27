package tr.org.open.seruvent.citybugs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tr.org.open.seruvent.citybugs.model.Event;
import tr.org.open.seruvent.citybugs.model.EventResource;
import tr.org.open.seruvent.citybugs.model.Result;
import tr.org.open.seruvent.citybugs.model.User;
import tr.org.open.seruvent.citybugs.service.EventResourceService;
import tr.org.open.seruvent.citybugs.service.EventService;
import tr.org.open.seruvent.citybugs.service.UserService;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @Autowired
    private EventResourceService eventResourceService;

    @RequestMapping(method = RequestMethod.POST ,value = "/event")
    public ResponseEntity createEvent(@RequestBody Event event){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        event.setUser(userService.getUserByUsername(auth.getName()));
        event=eventService.createEvent(event);

        Iterator<EventResource> iterator = event.getEventResources().iterator();
        while (iterator.hasNext()){
            EventResource eventResource = iterator.next();
            eventResource.setEvent(event);
            eventResourceService.createEventResource(eventResource);
        }

        System.out.println("----- ----- ----- ----- -----");
        System.out.println("EVENT & EVENT RESOURCES CREATED");
        System.out.println("----- ----- ----- ----- -----");

        return ResponseEntity.ok(Result.SUCCESS.setContent("EVENT & EVENT RESOURCES CREATED"));
    }

    @RequestMapping(method = RequestMethod.GET ,value = "/events")
    public ResponseEntity getEventList(){ ;
        return ResponseEntity.ok(Result.SUCCESS.setContent(eventService.getEventList()) );
    }


}
