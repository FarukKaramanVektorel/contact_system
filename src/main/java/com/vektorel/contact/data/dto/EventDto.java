package com.vektorel.contact.data.dto;

import java.time.LocalDate;

import com.vektorel.contact.data.model.Contact;
import com.vektorel.contact.data.model.Event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {
	private Long id;	
	private ContactDto contactDto;
	private LocalDate date;
	private String description;
	private String summary;
	private Boolean status;
}
