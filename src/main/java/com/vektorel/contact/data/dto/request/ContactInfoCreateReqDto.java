package com.vektorel.contact.data.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfoCreateReqDto {		
	private Long contactId;
	private String phone;
	private String eMail;
	private LocalDate birthDate;
	private Integer gender;
	private String address;
	private String description;
}
