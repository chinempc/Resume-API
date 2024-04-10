package com.chinempc.ResumeAPI.Model.Deserializers;

import com.chinempc.ResumeAPI.Model.Education;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.time.YearMonth;

@JsonComponent
public class EducationDeserializer extends JsonDeserializer<Education> {
    @Override
    public Education deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
        JsonNode rootNode = parser.getCodec().readTree(parser);
        JsonNode educationNode = rootNode.get("education");

        if (educationNode != null) {
            return new Education(
                    educationNode.get("id").asLong(),
                    educationNode.get("university").asText(),
                    educationNode.get("university_abbreviation").asText(),
                    educationNode.get("degree").asText(),
                    educationNode.get("major").asText(),
                    educationNode.get("minor").asText(),
                    YearMonth.parse(educationNode.get("graduation_date").asText())
            );
        }

        return null;
    }
}
