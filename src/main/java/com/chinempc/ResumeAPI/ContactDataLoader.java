package com.chinempc.ResumeAPI;

import com.chinempc.ResumeAPI.Model.Contact;
import com.chinempc.ResumeAPI.Model.Education;
import com.chinempc.ResumeAPI.Model.Experience;
import com.chinempc.ResumeAPI.Repository.ContactRepository;
import com.chinempc.ResumeAPI.Repository.EducationRepository;
import com.chinempc.ResumeAPI.Repository.ExperienceRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/*
@Slf4j
@Component
public class ContactDataLoader implements CommandLineRunner {

    ObjectMapper objectMapper;
    ContactRepository contactRepository;
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    public ContactDataLoader(ObjectMapper objectMapper, ContactRepository contactRepository) {
        this.objectMapper = objectMapper;
        this.contactRepository = contactRepository;
    }

    @Override
    public void run(String... args) {
        // Check if the DB is empty
        if (contactRepository.count() == 0) {
            String contactJSON = "/data/Comments.json";
            JsonNode node;
            log.info("Loading Contact into DB");

            try (InputStream inputStream = TypeReference.class.getResourceAsStream(contactJSON)) {
                node = objectMapper.readValue(inputStream, JsonNode.class);
            } catch (Exception e) {
                throw new RuntimeException("Failed to read from Contact JSON.");
            }

            loadContact(node);
            loadEducation(node);
            loadExperience(node);
            loadProjects(node);
            loadTechnicalSkills(node);
            loadHonorsAndAffiliations(node);
        }
    }

    private void loadContact(JsonNode node) {
        JsonNode contactNode = getContactNode(node);
        contactRepository.save(new Contact(
                contactNode.get("id").asLong(),
                contactNode.get("name").asText(),
                contactNode.get("address").asText(),
                contactNode.get("email").asText(),
                contactNode.get("phone_number").asText(),
                contactNode.get("github").asText()
        ));
    }

    private JsonNode getContactNode(JsonNode node) {
        return Optional.ofNullable(node)
                .map(n -> n.get("personal_info"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Contact JSON Object."));
    }
    private void loadEducation(JsonNode node) {
        JsonNode educationNode = getEducationNode(node);
        educationRepository.save(new Education(
                educationNode.get("id").asLong(),
                educationNode.get("university").asText(),
                educationNode.get("university_abbreviation").asText(),
                educationNode.get("degree").asText(),
                educationNode.get("major").asText(),
                educationNode.get("minor").asText(),
                YearMonth.parse(educationNode.get("graduation_date").asText())
        ));
    }

    private JsonNode getEducationNode(JsonNode node) {
        return Optional.ofNullable(node)
                .map(n -> n.get("education"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Contact JSON Object."));
    }

    private void loadExperience(JsonNode node) {
        JsonNode experienceNode = getExperienceNode(node);
        List<Experience> experiences = null;

        for (int i = 0; i < experienceNode.size(); i++) {
            Experience experience = new Experience(
                    experienceNode.get("company_name").asText(),
                    experienceNode.get("occupation").asText(),
                    YearMonth.parse(experienceNode.get("start_date").asText()),
                    YearMonth.parse(experienceNode.get("end_date").asText()),
                    extractNotes(experienceNode.get("notes"))
            );
            experiences.add(experience);
        }
    }

    private JsonNode getExperienceNode(JsonNode node) {
        return Optional.ofNullable(node)
                .map(n -> n.get("experience"))
                .orElseThrow(() -> new IllegalArgumentException("Invalid Contact JSON Object."));
    }

    private List<String> extractNotes(JsonNode notes) {
        List<String> noteList = new ArrayList<>();
        return noteList;
    }

    private void loadProjects(JsonNode node) {
    }

    private void loadHonorsAndAffiliations(JsonNode node) {
    }

    private void loadTechnicalSkills(JsonNode node) {
    }

}
 */