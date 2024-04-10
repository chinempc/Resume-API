package com.chinempc.ResumeAPI.Model.Deserializers;

import com.chinempc.ResumeAPI.Model.Comment;
import com.chinempc.ResumeAPI.Model.Wrappers.CommentWrapper;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@JsonComponent
public class CommentWrapperDeserializer extends JsonDeserializer<CommentWrapper> {
    @Override
    public CommentWrapper deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
        JsonNode rootNode = parser.getCodec().readTree(parser);
        List<Comment> commentList = new ArrayList<>();

        if (rootNode.isArray()) {
            for (JsonNode commentNode : rootNode) {
                if (!commentNode.isEmpty()) {
                    commentList.add(new Comment(
                            commentNode.get("id").asLong(),
                            commentNode.get("name").asText(),
                            commentNode.get("email").asText(),
                            commentNode.get("message").asText()
                    ));
                }
            }
        }
        return new CommentWrapper(commentList);
    }
}
