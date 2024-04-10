package com.chinempc.ResumeAPI.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TechnicalSkillsDTO {
    private List<String> programmingLanguages;
    private List<String> databases;
    private List<String> javaStack;
    private List<String> webDevelopment;
    private List<String> operatingSystems;
    private List<String> versionControl;
    private List<String> ides;
}
