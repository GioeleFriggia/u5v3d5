package gioelefriggia.u5v3d5.repository;

import gioelefriggia.u5v3d5.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}