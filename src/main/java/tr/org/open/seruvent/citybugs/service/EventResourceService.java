package tr.org.open.seruvent.citybugs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.org.open.seruvent.citybugs.model.EventResource;
import tr.org.open.seruvent.citybugs.repository.EventResourceRepository;

import java.util.Set;

@Service
public class EventResourceService {

    @Autowired
    private EventResourceRepository eventResourceRepository;

    public void createEventResource(EventResource eventResource){
        eventResourceRepository.save(eventResource);
    }

    public void createEventResources(Set<EventResource> eventResources){
        eventResources.forEach((EventResource eventResource) -> {
            this.createEventResource(eventResource);
        });
    }

}
