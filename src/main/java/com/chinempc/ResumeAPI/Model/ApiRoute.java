package com.chinempc.ResumeAPI.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRoute {
    @Id
    private Long id;
    private String description;
    private String url;
}
