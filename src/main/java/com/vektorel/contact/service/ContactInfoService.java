package com.vektorel.contact.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.vektorel.contact.data.dto.ContactInfoDto;
import com.vektorel.contact.data.dto.request.ContactInfoCreateReqDto;
import com.vektorel.contact.data.model.ContactInfo;
import com.vektorel.contact.repository.ContactInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactInfoService {
	private final ContactInfoRepository repository;
	private final ModelMapper mapper;
	
	
	public ContactInfoDto create(ContactInfoCreateReqDto dto) {		
		ContactInfo infoEntity=mapper.map(dto, ContactInfo.class);
		ContactInfo infoSaved=repository.save(infoEntity);
		ContactInfoDto respDto=mapper.map(infoSaved, ContactInfoDto.class);
		return respDto;
		//return mapper.map(repository.save(mapper
				//.map(dto, ContactInfo.class)), ContactInfoDto.class);
	}

}
