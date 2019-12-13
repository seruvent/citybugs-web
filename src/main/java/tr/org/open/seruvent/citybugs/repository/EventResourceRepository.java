package tr.org.open.seruvent.citybugs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.org.open.seruvent.citybugs.model.EventResource;

public interface EventResourceRepository extends JpaRepository<EventResource,Integer> {

}
