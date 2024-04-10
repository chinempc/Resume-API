package com.chinempc.ResumeAPI.Service;

import com.chinempc.ResumeAPI.Model.Comment;
import com.chinempc.ResumeAPI.Model.DTO.CommentDTO;
import com.chinempc.ResumeAPI.Repository.CommentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ObjectMapper objectMapper;

    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    public Comment makeComment(CommentDTO comment) throws Exception {
        // Verify each part of the comment
        if (comment.getEmail() != null && comment.getEmail().contains("@") && comment.getName() != null
                && comment.getMessage() != null) {

            Comment convertedComment = convertCommentFromDTO(comment);
            commentRepository.save(convertedComment);
            saveCommentToJson(convertedComment);

            return convertedComment;
        }
        return null;
    }

    private Comment convertCommentFromDTO(CommentDTO commentDTO) {
        return new Comment(
                commentRepository.count()+1,
                commentDTO.getName(),
                commentDTO.getEmail(),
                commentDTO.getMessage()
        );
    }

    private void saveCommentToJson(Comment comment) throws Exception {
        URL res = getClass().getClassLoader().getResource("data/Comments.json");
        if (res != null) {
            File file = ResourceUtils.getFile("classpath:data/Comments.json");
            Path path = Paths.get(res.toURI());
            String jsonString = Files.readString(path);

            try (FileWriter fileWriter = new FileWriter(file, false)) {

                JSONObject jsonObject = new JSONObject(objectMapper.writeValueAsString(comment));
                JSONArray jsonArray = new JSONArray(jsonString);
                jsonArray.put(jsonObject);

                fileWriter.write(jsonArray.toString());
                fileWriter.flush();
            } catch(IOException ioException) {
                ioException.printStackTrace();
            }
        }

    }
}
