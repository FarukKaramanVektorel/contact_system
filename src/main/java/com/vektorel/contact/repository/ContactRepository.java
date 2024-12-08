package com.vektorel.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vektorel.contact.data.model.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
