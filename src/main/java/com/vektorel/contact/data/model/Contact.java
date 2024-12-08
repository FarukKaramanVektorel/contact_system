package com.vektorel.contact.data.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="contacts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lastname;
	private Boolean status;
	@ManyToOne
	@JoinColumn(name="category_id", referencedColumnName = "id")
	private Category category; 
	@OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
	private List<Event> event;	
	@OneToOne(mappedBy = "contact", cascade = CascadeType.ALL)
	  @JsonManagedReference
	private ContactInfo info;
	
}
