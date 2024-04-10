package com.chinempc.ResumeAPI.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class Honors {
    @Id
    private String name;
    private String acronym;
    private String description;
}
