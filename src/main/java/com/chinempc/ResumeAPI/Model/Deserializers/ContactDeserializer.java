package com.chinempc.ResumeAPI.Model.Deserializers;

import com.chinempc.ResumeAPI.Model.Contact;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class ContactDeserializer extends JsonDeserializer<Contact> {

    @Override
    public Contact deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
        JsonNode rootNode = parser.getCodec().readTree(parser);
        JsonNode contactNode = rootNode.get("personal_info");

        if (contactNode != null) {
            return new Contact(
                    contactNode.get("id").asLong(),
                    contactNode.get("name").asText(),
                    contactNode.get("email").asText(),
                    contactNode.get("github").asText()
            );
        }

        return null;
    }
}
