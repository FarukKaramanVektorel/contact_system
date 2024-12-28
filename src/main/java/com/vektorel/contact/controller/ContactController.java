package com.vektorel.contact.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vektorel.contact.data.dto.ContactDto;
import com.vektorel.contact.data.dto.request.ContactRequestDto;
import com.vektorel.contact.data.dto.response.ContactResponseDto;
import com.vektorel.contact.service.ContactService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
@CrossOrigin
public class ContactController {
	private final ContactService service;
	
	@PostMapping("/add")
	public ContactResponseDto create(@RequestBody ContactRequestDto dto) {
		return service.create(dto);
	}
	
	@GetMapping("/{id}")
	public ContactResponseDto getById(@PathVariable Long id) {
		return service.getById(id);
	}
	@GetMapping
	public List<ContactResponseDto> getAll() {
		return service.getByAll();
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		return service.delete(id);
	}
	
	@GetMapping("/cat/{categoryId}")
	public List<ContactDto> getByCategory(@PathVariable Long categoryId){
		return service.findByCategory(categoryId);
	}

}
