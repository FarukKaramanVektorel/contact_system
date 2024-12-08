package com.vektorel.contact.data.dto.response;

import java.util.List;

import com.vektorel.contact.data.dto.CategoryDto;
import com.vektorel.contact.data.dto.ContactInfoDto;
import com.vektorel.contact.data.dto.EventDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponseDto {

	private Long id;
	private String name;
	private String lastname;
	private Boolean status;
	private CategoryDto categoryDto; 
	private ContactInfoDto infoDto;
	private List<EventDto> eventDto;
	
}
