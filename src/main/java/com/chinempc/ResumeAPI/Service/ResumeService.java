package com.chinempc.ResumeAPI.Service;

import com.chinempc.ResumeAPI.Model.Contact;
import com.chinempc.ResumeAPI.Model.DTO.ContactDTO;
import com.chinempc.ResumeAPI.Model.DTO.EducationDTO;
import com.chinempc.ResumeAPI.Model.DTO.ResumeDTO;
import com.chinempc.ResumeAPI.Model.Education;
import com.chinempc.ResumeAPI.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ContactRepository contactRepository;
    private final EducationRepository educationRepository;
    private final ExperienceRepository experienceRepository;
    private final ProjectRepository projectRepository;
    private final TechnicalSkillsRepository technicalSkillsRepository;
    private final HonorsRepository honorsRepository;

    public ResumeDTO getResume() {
        return convertResumeToDTO();
    }

    private ResumeDTO convertResumeToDTO() {
        return new ResumeDTO(
                convertContactToDTO(),
                convertEducationToDTO(),
                experienceRepository.findAll(),
                projectRepository.findAll(),
                technicalSkillsRepository.findAll().get(0),
                honorsRepository.findAll()
        );
    }

    private ContactDTO convertContactToDTO() {
        Contact contact = contactRepository.findAll().get(0);
        return new ContactDTO(
                contact.getName(),
                contact.getEmail(),
                contact.getGithub()
        );
    }

    private EducationDTO convertEducationToDTO() {
        Education education = educationRepository.findAll().get(0);
        return new EducationDTO(
                education.getUniversity(),
                education.getUniversityAbbreviation(),
                education.getDegree(),
                education.getMajor(),
                education.getMinor(),
                education.getGraduationDate()
        );
    }
}
