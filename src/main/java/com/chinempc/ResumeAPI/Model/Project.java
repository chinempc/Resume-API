package com.chinempc.ResumeAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.YearMonth;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class Project {
    @Id
    private String projectName;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> techStack;
    private String githubRepo;
    private YearMonth createdOn;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> notes;
}
