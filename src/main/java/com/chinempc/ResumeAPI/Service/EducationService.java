package com.chinempc.ResumeAPI.Service;

import com.chinempc.ResumeAPI.Model.DTO.EducationDTO;
import com.chinempc.ResumeAPI.Model.Education;
import com.chinempc.ResumeAPI.Repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EducationService {

    private final EducationRepository educationRepository;

    public List<EducationDTO> getEducationInfo() {
        return educationRepository.findAll()
                .stream()
                .map(this::convertEducationToDTO)
                .collect(Collectors.toList());
    }

    private EducationDTO convertEducationToDTO(Education education) {
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
