package com.chinempc.ResumeAPI.Controller;

import com.chinempc.ResumeAPI.Model.*;
import com.chinempc.ResumeAPI.Model.DTO.*;
import com.chinempc.ResumeAPI.Service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ResumeController {

    private final ContactService contactService;
    private final EducationService educationService;
    private final ExperienceService experienceService;
    private final ProjectService projectService;
    private final TechnicalSkillsService technicalSkillsService;
    private final HonorsService honorsService;
    private final ApiRouteService apiRouteService;
    private final ResumeService resumeService;
    private final CommentService commentService;

    // All Available endpoints
    @GetMapping()
    public ResponseEntity<List<ApiRoute>> getIndex() {
        return ResponseEntity.ok()
                .body(apiRouteService.getApiInfo());
    }

    // Full Resume
    @GetMapping("resume")
    public ResponseEntity<ResumeDTO> getResume() {
        return ResponseEntity.ok()
                .body(resumeService.getResume());
    }

    // Contact Information
    @GetMapping("/contact")
    public ResponseEntity<List<ContactDTO>> getContactInfo() {
        return ResponseEntity.ok()
                .body(contactService.getContactInfo());
    }

    // Education
    @GetMapping("/education")
    public ResponseEntity<List<EducationDTO>> getEducationInfo() {
        return ResponseEntity.ok()
                .body(educationService.getEducationInfo());
    }

    // Experiences
    @GetMapping("/experience")
    public ResponseEntity<List<Experience>> getExperienceInfo() {
        return ResponseEntity.ok()
                .body(experienceService.getExperienceInfo());
    }

    // Projects
    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects() {
        return ResponseEntity.ok()
                .body(projectService.getProjects());
    }

    // Technical Skills
    @GetMapping("/technical_skills")
    public ResponseEntity<List<TechnicalSkillsDTO>> getTechnicalSkills() {
        return ResponseEntity.ok()
                .body(technicalSkillsService.getTechSkills());
    }

    // Honors
    @GetMapping("/honors")
    public ResponseEntity<List<Honors>> getHonors() {
        return ResponseEntity.ok()
                .body(honorsService.getHonors());
    }

    // Comments
    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getComments() {
        return ResponseEntity.ok()
                .body(commentService.getComments());
    }

    @PostMapping("/comments")
    public ResponseEntity<Comment> postComment(@RequestBody CommentDTO comment) throws Exception {
        return new ResponseEntity<>(commentService.makeComment(comment), HttpStatus.CREATED);
    }
}
