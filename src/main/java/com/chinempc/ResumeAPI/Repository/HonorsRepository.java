package com.chinempc.ResumeAPI.Repository;

import com.chinempc.ResumeAPI.Model.Honors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HonorsRepository extends JpaRepository<Honors, String> {
}
