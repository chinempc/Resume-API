package com.chinempc.ResumeAPI.Service;

import com.chinempc.ResumeAPI.Model.DTO.EducationDTO;
import com.chinempc.ResumeAPI.Model.DTO.TechnicalSkillsDTO;
import com.chinempc.ResumeAPI.Model.Education;
import com.chinempc.ResumeAPI.Model.TechnicalSkills;
import com.chinempc.ResumeAPI.Repository.TechnicalSkillsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnicalSkillsService {
    private final TechnicalSkillsRepository technicalSkillsRepository;

    public TechnicalSkillsService(TechnicalSkillsRepository technicalSkillsRepository) {
        this.technicalSkillsRepository = technicalSkillsRepository;
    }

    public List<TechnicalSkillsDTO> getTechSkills() {
        return technicalSkillsRepository.findAll()
                .stream()
                .map(this::convertTechSkillsToDTO)
                .collect(Collectors.toList());
    }

    private TechnicalSkillsDTO convertTechSkillsToDTO(TechnicalSkills education) {
        return new TechnicalSkillsDTO(
                education.getProgrammingLanguages(),
                education.getDatabases(),
                education.getJavaStack(),
                education.getWebDevelopment(),
                education.getOperatingSystems(),
                education.getVersionControl(),
                education.getIdes()
        );
    }
}
