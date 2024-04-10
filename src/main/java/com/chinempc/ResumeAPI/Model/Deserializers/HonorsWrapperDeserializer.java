package com.chinempc.ResumeAPI.Model.Deserializers;

import com.chinempc.ResumeAPI.Model.Honors;
import com.chinempc.ResumeAPI.Model.Wrappers.HonorsWrapper;
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
public class HonorsWrapperDeserializer extends JsonDeserializer<HonorsWrapper> {
    @Override
    public HonorsWrapper deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
        JsonNode rootNode = parser.getCodec().readTree(parser);
        JsonNode honorsNode = rootNode.get("Honors & Affiliations");
        List<Honors> honorsList = new ArrayList<>();

        if (honorsNode.isArray()) {
            for (JsonNode honor : honorsNode) {
                if (honor != null) {
                    Honors newHonor = new Honors(
                            honor.get("name").asText(),
                            honor.get("acronym").asText(),
                            honor.get("description").asText()
                    );
                    honorsList.add(newHonor);
                }
            }
        }
        return new HonorsWrapper(honorsList);
    }
}
