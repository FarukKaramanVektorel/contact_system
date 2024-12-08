package com.vektorel.contact.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.vektorel.contact.data.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
