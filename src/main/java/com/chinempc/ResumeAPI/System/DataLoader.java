package com.chinempc.ResumeAPI.System;

import com.chinempc.ResumeAPI.Model.Comment;
import com.chinempc.ResumeAPI.Model.Contact;
import com.chinempc.ResumeAPI.Model.Education;
import com.chinempc.ResumeAPI.Model.TechnicalSkills;
import com.chinempc.ResumeAPI.Model.Wrappers.*;
import com.chinempc.ResumeAPI.Repository.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ObjectMapper objectMapper;
    private final ContactRepository contactRepository;
    private final EducationRepository educationRepository;
    private final ExperienceRepository experienceRepository;
    private final ProjectRepository projectRepository;
    private final TechnicalSkillsRepository technicalSkillsRepository;
    private final HonorsRepository honorsRepository;
    private final ApiRouteRepository apiRouteRepository;
    private final CommentRepository commentRepository;

    @Override
    public void run(String... args) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("data/Data.json");
        String resumeJSON = convertStreamToJson(classPathResource);
        ClassPathResource commentClassPathResource = new ClassPathResource("data/Comments.json");
        String commentsJSON = convertStreamToJson(commentClassPathResource);
        loadData(resumeJSON, commentsJSON);
    }

    private String convertStreamToJson(ClassPathResource classPathResource) {
        String jsonString = null;
        try {
            byte[] binaryData = FileCopyUtils.copyToByteArray(classPathResource.getInputStream());
            jsonString = new String(binaryData, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    private void loadData(String resumeJSON, String commentsJSON) throws Exception {
        if (contactRepository.findAll().isEmpty()) {
            loadContact(resumeJSON);
        }

        if (educationRepository.findAll().isEmpty()) {
            loadEducation(resumeJSON);
        }

        if (experienceRepository.findAll().isEmpty()) {
            loadExperience(resumeJSON);
        }

        if (projectRepository.findAll().isEmpty()) {
            loadProjects(resumeJSON);
        }

        if (technicalSkillsRepository.findAll().isEmpty()) {
            loadTechnicalSkills(resumeJSON);
        }

        if (honorsRepository.findAll().isEmpty()) {
            loadHonors(resumeJSON);
        }

        if (apiRouteRepository.findAll().isEmpty()) {
            loadApiRoutes(resumeJSON);
        }

        commentLoader(commentsJSON);
    }

    private void loadContact(String json) throws Exception {
        log.info("Loading Contact data into Database form JSON file...");
        Contact contact = objectMapper.readValue(json, Contact.class);
        contactRepository.save(contact);
    }

    private void loadEducation(String json) throws Exception {
        log.info("Loading Education data into Database form JSON file...");
        Education education = objectMapper.readValue(json, Education.class);
        educationRepository.save(education);
    }

    private void loadExperience(String json) throws Exception {
        log.info("Loading Experience data into Database from JSON file...");
        ExperienceWrapper wrappedExperiences = objectMapper.readValue(json, ExperienceWrapper.class);
        experienceRepository.saveAll(wrappedExperiences.experiences());
    }

    private void loadProjects(String json) throws Exception {
        log.info("Loading Project data into Database from JSON file...");
        ProjectsWrapper wrappedProjects = objectMapper.readValue(json, ProjectsWrapper.class);
        projectRepository.saveAll(wrappedProjects.projects());
    }

    private void loadTechnicalSkills(String json) throws Exception {
        log.info("Loading Technical Skills into Database from JSON file...");
        TechnicalSkills technicalSkills = objectMapper.readValue(json, TechnicalSkills.class);
        technicalSkillsRepository.save(technicalSkills);
    }

    private void loadHonors(String json) throws Exception {
        log.info("Loading Honors and Affiliations into Database from JSON file...");
        HonorsWrapper wrappedHonors = objectMapper.readValue(json, HonorsWrapper.class);
        honorsRepository.saveAll(wrappedHonors.honors());
    }

    private void loadApiRoutes(String json) throws Exception {
        log.info("Loading API Routes into Database from JSON file...");
        ApiRouteWrapper wrappedApiRoute = objectMapper.readValue(json, ApiRouteWrapper.class);
        apiRouteRepository.saveAll(wrappedApiRoute.apiRoutes());
    }

    private void commentLoader(String commentsJSON) throws Exception {
        int commentCount = objectMapper.readValue(commentsJSON, CommentWrapper.class).comments().size();
        if (commentRepository.findAll().isEmpty()) {
            // If this does not work, manually create the first comment. Nothing works if it can't read
            loadComments(commentsJSON);
        } else if (commentRepository.count() < commentCount) {
            commentRepository.deleteAll();
            loadComments(commentsJSON);
        } /*else if (commentRepository.count() > commentCount) {
            writeCommentsTableToJSON();
        }*/

    }

    private void loadComments(String json) throws Exception {
        log.info("Loading Comments into Database from JSON file...");
        CommentWrapper wrappedComments = objectMapper.readValue(json, CommentWrapper.class);
        commentRepository.saveAll(wrappedComments.comments());
    }

    private void writeCommentsTableToJSON() throws IOException {
        File file = ResourceUtils.getFile("classpath:data/Comments.json");
        String jsonString = "[]";
        JSONArray jsonArray = new JSONArray(jsonString);
        List<Comment> commentList = commentRepository.findAll();

        try (FileWriter fileWriter = new FileWriter(file, false)) {
            for (Comment comment : commentList) {
                JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(comment));
                jsonArray.put(jsonObject);
            }

            fileWriter.write(jsonArray.toString());
            fileWriter.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
