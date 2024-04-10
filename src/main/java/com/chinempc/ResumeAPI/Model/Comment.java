package com.chinempc.ResumeAPI.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NonNull
@Entity
public class Comment {
    @Id
    private Long id;
    private String name;
    private String email;
    private String message;
}
