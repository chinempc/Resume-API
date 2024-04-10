package com.chinempc.ResumeAPI.Repository;

import com.chinempc.ResumeAPI.Model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience, String> {
}
