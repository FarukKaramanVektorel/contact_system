package com.vektorel.contact.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vektorel.contact.data.dto.EventDto;
import com.vektorel.contact.data.dto.request.EventCreateReqDto;
import com.vektorel.contact.service.EventService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/events")
@RestController
public class EventController {
	private final EventService service;
	@PostMapping("/add")
	public EventDto create(EventCreateReqDto dto) {
		return service.create(dto);
	}

}
