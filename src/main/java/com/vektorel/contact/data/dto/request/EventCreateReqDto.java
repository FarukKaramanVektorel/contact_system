package com.vektorel.contact.data.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventCreateReqDto {
	private Long id;
	private Long contactId;
	private LocalDate date;
	private String description;
	private String summary;
	private Boolean status;
}
