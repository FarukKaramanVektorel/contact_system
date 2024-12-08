package com.vektorel.contact.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.vektorel.contact.data.dto.CategoryDto;
import com.vektorel.contact.data.model.Category;
import com.vektorel.contact.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	private final CategoryRepository repository;
	public final ModelMapper mapper;
	
	public List<CategoryDto> getFindByNameAll(String name){
		List<Category> cats=repository.findByNameLike(name);			
		return cats.stream().map(c->mapper
				.map(c,CategoryDto.class)).toList();
	}
	
	
	public CategoryDto getByName(String name) {
		return mapper.map(repository.findByName(name), CategoryDto.class);
	}
	
	public List<CategoryDto> getAll(){
		List<Category> cats=repository.findAll();			
		return cats.stream().map(c->mapper
				.map(c,CategoryDto.class)).toList();
	}
	

	public CategoryDto create(CategoryDto dto) {	
//dto yu entity kayıt entityi dto 
		return mapper.map(repository.save(mapper
				.map(dto, Category.class)), CategoryDto.class);
	}

	public CategoryDto update(CategoryDto dto) {
		/*
		 * Dto entitye dönüşerek update yapılacak update ile dönen entity dto ya
		 * dönüşerek geri dönülecek
		 */
		return mapper.map(repository.save(mapper
				.map(dto, Category.class)), CategoryDto.class);
	}

	public String delete(Long id) {

		if (repository.findById(id).orElse(null) == null) {
			return id + " ID'li kayıt bulunamadı";
		} else {
			repository.delete(repository.findById(id).orElse(null));
			return "Silme işlemi başarılı";
		}
	}
	public CategoryDto getById(Long id) {		
		return mapper.map(repository.findById(id).orElse(null), CategoryDto.class);		
	}
	

	public boolean findByIdCategory(Long id) {
		return repository.existsById(id);
	}

}
