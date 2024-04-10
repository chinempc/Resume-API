package com.chinempc.ResumeAPI.Repository;

import com.chinempc.ResumeAPI.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
