package com.vektorel.contact.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import com.vektorel.contact.data.dto.EventDto;
import com.vektorel.contact.data.dto.request.EventCreateReqDto;
import com.vektorel.contact.data.model.Event;
import com.vektorel.contact.repository.EventRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {
	private final EventRepository repository;
	private final ModelMapper mapper;
	
	
	public EventDto create(EventCreateReqDto dto) {
	
		return mapper.map(repository.save(mapper
				.map(dto, Event.class)), EventDto.class);
	}
}
