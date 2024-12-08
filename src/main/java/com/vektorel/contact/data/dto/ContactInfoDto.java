package com.vektorel.contact.data.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfoDto {
	private Long id;
	 @JsonBackReference
	private ContactDto contact;
	private String phone;
	private String eMail;
	private LocalDate birthDate;
	private Integer gender;
	private String address;
	private String description;
}
