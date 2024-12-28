package com.vektorel.contact.data.dto.request;

import java.time.LocalDate;

import com.vektorel.contact.data.dto.CategoryDto;
import com.vektorel.contact.data.dto.ContactInfoDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequestDto {
    private Long id;
    private String name;
    private String lastname;
    private Boolean status;
    private CategoryDto category;
    private ContactInfoCreateReqDto info;


}
