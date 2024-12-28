package com.vektorel.contact.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vektorel.contact.data.model.Category;
import com.vektorel.contact.data.model.Contact;
@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
	
	List<Contact> findByCategory(Category category);

}
