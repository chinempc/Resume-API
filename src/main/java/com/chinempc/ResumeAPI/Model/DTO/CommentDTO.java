package com.chinempc.ResumeAPI.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class CommentDTO {
    private String name;
    private String email;
    private String message;
}
