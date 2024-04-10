package com.chinempc.ResumeAPI.Model.Deserializers;

import com.chinempc.ResumeAPI.Model.Experience;
import com.chinempc.ResumeAPI.Model.Wrappers.ExperienceWrapper;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

@JsonComponent
public class ExperienceWrapperDeserializer extends JsonDeserializer<ExperienceWrapper> {

    @Override
    public ExperienceWrapper deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
        JsonNode rootNode = parser.getCodec().readTree(parser);
        JsonNode experienceNode = rootNode.get("experience");
        List<Experience> experienceList = new ArrayList<>();

        if (experienceNode.isArray()) {
            for (JsonNode experience : experienceNode) {
                if (experience.get("notes") != null) {
                    Experience newExperience = new Experience(
                            experience.get("company_name").asText(),
                            experience.get("occupation").asText(),
                            YearMonth.parse(experience.get("start_date").asText()),
                            YearMonth.parse(experience.get("end_date").asText()),
                            extractNotes(experience)
                    );
                    experienceList.add(newExperience);
                }
            }
        }
        return new ExperienceWrapper(experienceList);
    }

    private List<String> extractNotes(JsonNode experience) {
        List<String> noteList = new ArrayList<>();
        ArrayNode notes = (ArrayNode) experience.get("notes");

        for (JsonNode note : notes) {
            noteList.add(note.textValue());
        }
        return noteList;
    }
}
