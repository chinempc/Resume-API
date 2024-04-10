package com.chinempc.ResumeAPI.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDTO {
    private String university;
    private String universityAbbreviation;
    private String degree;
    private String major;
    private String minor;
    private YearMonth graduationDate;
}
