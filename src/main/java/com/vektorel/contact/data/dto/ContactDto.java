package com.vektorel.contact.data.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
	private Long id;
	private String name;
	private String lastname;
	private Boolean status;	
	private CategoryDto categoryDto; 	
	private List<EventDto> event;
	@JsonManagedReference
	private ContactInfoDto info;
}
