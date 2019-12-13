package tr.org.open.seruvent.citybugs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.org.open.seruvent.citybugs.model.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
