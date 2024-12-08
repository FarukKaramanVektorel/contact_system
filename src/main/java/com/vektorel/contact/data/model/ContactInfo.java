package com.vektorel.contact.data.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.vektorel.contact.data.dto.request.EventRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="contact_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	@OneToOne
	@JoinColumn(name="contact_id",referencedColumnName = "id")
	 @JsonBackReference
	private Contact contact;
	private String phone;
	private String eMail;
	private LocalDate birthDate;
	private Integer gender;
	private String address;
	private String description;
	
}
