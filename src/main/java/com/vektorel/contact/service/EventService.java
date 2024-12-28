package com.vektorel.contact.service;

import com.vektorel.contact.utils.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import com.vektorel.contact.data.dto.EventDto;
import com.vektorel.contact.data.dto.request.EventCreateReqDto;
import com.vektorel.contact.data.model.Event;
import com.vektorel.contact.repository.EventRepository;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventService {
	private final EventRepository repository;
	private final ModelMapper mapper;
	
	
	public EventDto create(EventCreateReqDto dto) {
	
		return mapper.map(repository.save(mapper
				.map(dto, Event.class)), EventDto.class);
	}

	public EventDto getById(Long id) {
		Event event = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Event not found"));
		return mapper.map(event, EventDto.class);
	}

	public List<EventDto> getAll() {
		return repository.findAll().stream()
				.map(event -> mapper.map(event, EventDto.class))
				.collect(Collectors.toList());
	}

	public EventDto update(EventCreateReqDto dto) {
		Event existingEvent = repository.findById(dto.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Event not found"));

		mapper.map(dto, existingEvent);
		Event updatedEvent = repository.save(existingEvent);
		return mapper.map(updatedEvent, EventDto.class);
	}

	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Event not found");
		}
		repository.deleteById(id);
	}
}
