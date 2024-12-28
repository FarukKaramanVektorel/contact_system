package com.vektorel.contact.controller;

import com.vektorel.contact.data.dto.EventDto;
import com.vektorel.contact.data.dto.request.EventCreateReqDto;
import com.vektorel.contact.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/events")
@RestController
public class EventController {
	private final EventService service;
	@PostMapping("/add")
	public EventDto create(@RequestBody EventCreateReqDto dto) {
		return service.create(dto);
	}

	@GetMapping("/{id}")
	public EventDto getById(@PathVariable Long id) {
		return service.getById(id);
	}

	@GetMapping
	public List<EventDto> getAll() {
		return service.getAll();
	}

	@PutMapping("/update")
	public EventDto update(@RequestBody EventCreateReqDto dto) {
		return service.update(dto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
