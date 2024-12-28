package com.vektorel.contact.validation;

import com.vektorel.contact.data.dto.request.ContactInfoCreateReqDto;
import com.vektorel.contact.utils.ValidationException;

public class ContactInfoValidator {
    public static void validate(ContactInfoCreateReqDto dto) {
        if (dto.getPhone() != null && !dto.getPhone().matches("\\d{10}")) {
            throw new ValidationException("Invalid phone number format");
        }

        if (dto.getEMail() != null && !dto.getEMail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new ValidationException("Invalid email format");
        }

        if (dto.getGender() != null && (dto.getGender() < 0 || dto.getGender() > 2)) {
            throw new ValidationException("Invalid gender value");
        }
    }
}