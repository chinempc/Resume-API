package com.chinempc.ResumeAPI.Model.DTO;

import com.chinempc.ResumeAPI.Model.Experience;
import com.chinempc.ResumeAPI.Model.Honors;
import com.chinempc.ResumeAPI.Model.Project;
import com.chinempc.ResumeAPI.Model.TechnicalSkills;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class ResumeDTO {
    private ContactDTO contact;
    private EducationDTO education;
    private List<Experience> experiences;
    private List<Project> projects;
    private TechnicalSkills technicalSkills;
    private List<Honors> honors;
}
