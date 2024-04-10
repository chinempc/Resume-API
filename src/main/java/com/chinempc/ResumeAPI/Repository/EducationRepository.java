package com.chinempc.ResumeAPI.Repository;

import com.chinempc.ResumeAPI.Model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
}
