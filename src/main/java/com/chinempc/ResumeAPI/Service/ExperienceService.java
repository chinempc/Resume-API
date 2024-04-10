package com.chinempc.ResumeAPI.Service;

import com.chinempc.ResumeAPI.Model.Experience;
import com.chinempc.ResumeAPI.Repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public List<Experience> getExperienceInfo() {
        return experienceRepository.findAll();
    }
}
