package com.vektorel.contact.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import com.vektorel.contact.data.dto.CategoryDto;
import com.vektorel.contact.data.dto.ContactInfoDto;
import com.vektorel.contact.data.dto.EventDto;
import com.vektorel.contact.data.dto.request.ContactRequestDto;
import com.vektorel.contact.data.dto.response.ContactResponseDto;
import com.vektorel.contact.data.model.Contact;
import com.vektorel.contact.data.model.ContactInfo;
import com.vektorel.contact.repository.ContactRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactService {
	private final ContactRepository conRepository;
	private final CategoryService catService;
	private final ContactInfoService infoService;
	private final ModelMapper mapper;
	
	
	public ContactResponseDto create(ContactRequestDto dto) {		
		if(!catService.findByIdCategory(dto.getCategory().getId())) {
			catService.create(dto.getCategory());
		}	
		Contact con=mapper.map(dto, Contact.class);
		Contact conSaved=conRepository.save(con);
		if(dto.getInfo()!=null) {
			dto.getInfo().setContactId(conSaved.getId());;			
			ContactInfoDto infoDto=infoService.create(dto.getInfo());
		}
		return mapper.map(conSaved, ContactResponseDto.class);
	}
	
	public ContactResponseDto getById(Long id) {
		Contact con=conRepository.findById(id).orElse(null);
		return convetDto(con);
	}
	
	public List<ContactResponseDto> getByAll(){
		List<Contact> cons=conRepository.findAll();
		List<ContactResponseDto> dtos=new ArrayList<>();
		for (Contact con : cons) {
			dtos.add(convetDto(con));			
		}		
		return dtos;
	}
	
	private ContactResponseDto convetDto(Contact con) {
		ContactResponseDto returnDto=mapper.map(con, ContactResponseDto.class);
		ContactInfoDto infoDto=mapper.map(con.getInfo(), ContactInfoDto.class);
		CategoryDto catdto=mapper.map(con.getCategory(), CategoryDto.class);
		List<EventDto> eventDto=con.getEvent().stream()
				.map(e->mapper.map(e, EventDto.class)).toList();
		returnDto.setInfoDto(infoDto);
		returnDto.setCategoryDto(catdto);
		returnDto.setEventDto(eventDto);
		return returnDto;
	}
	
	

}
