package com.chinempc.ResumeAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class TechnicalSkills {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> programmingLanguages;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> databases;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> javaStack;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> webDevelopment;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> operatingSystems;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> versionControl;
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    private List<String> ides;
}
