package com.chinempc.ResumeAPI.Repository;

import com.chinempc.ResumeAPI.Model.TechnicalSkills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalSkillsRepository extends JpaRepository<TechnicalSkills, Long> {
}
