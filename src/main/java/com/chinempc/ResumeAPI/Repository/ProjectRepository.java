package com.chinempc.ResumeAPI.Repository;

import com.chinempc.ResumeAPI.Model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
}
