package com.chinempc.ResumeAPI.Service;

import com.chinempc.ResumeAPI.Model.Project;
import com.chinempc.ResumeAPI.Repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }
}
