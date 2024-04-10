package com.chinempc.ResumeAPI.Model.Deserializers;

import com.chinempc.ResumeAPI.Model.TechnicalSkills;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@JsonComponent
public class TechnicalSkillsDeserializer extends JsonDeserializer<TechnicalSkills> {
    @Override
    public TechnicalSkills deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
        JsonNode rootNode = parser.getCodec().readTree(parser);
        JsonNode technicalSkillsNode = rootNode.get("technical_skills");

        if (technicalSkillsNode != null) {
            return new TechnicalSkills(
                    technicalSkillsNode.get("id").asLong(),
                    extractList(technicalSkillsNode, "programming_languages"),
                    extractList(technicalSkillsNode, "databases"),
                    extractList(technicalSkillsNode, "java_stack"),
                    extractList(technicalSkillsNode, "web_development"),
                    extractList(technicalSkillsNode, "operating_systems"),
                    extractList(technicalSkillsNode, "version_control"),
                    extractList(technicalSkillsNode, "IDEs")
            );
        }

        return null;
    }

    private List<String> extractList(JsonNode technicalSkillsNode, String fieldName) {
        List<String> fieldList = new ArrayList<>();
        ArrayNode fieldNode = (ArrayNode) technicalSkillsNode.get(fieldName);
        for (JsonNode field : fieldNode) {
            fieldList.add(field.textValue());
        }
        return fieldList;
    }

}
