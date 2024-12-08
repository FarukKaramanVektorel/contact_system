package com.vektorel.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vektorel.contact.data.model.ContactInfo;

public interface ContactInfoRepository extends JpaRepository<ContactInfo, Long>{

}
