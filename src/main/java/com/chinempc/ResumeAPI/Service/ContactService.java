package com.chinempc.ResumeAPI.Service;

import com.chinempc.ResumeAPI.Model.Contact;
import com.chinempc.ResumeAPI.Model.DTO.ContactDTO;
import com.chinempc.ResumeAPI.Repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactService {

    ContactRepository contactRepository;

    public List<ContactDTO> getContactInfo() {
        return contactRepository.findAll()
                .stream()
                .map(this::convertcontactDTO)
                .collect(Collectors.toList());
    }

    private ContactDTO convertcontactDTO(Contact contact) {
        return new ContactDTO(
                contact.getName(),
                contact.getEmail(),
                contact.getGithub());
    }
}
