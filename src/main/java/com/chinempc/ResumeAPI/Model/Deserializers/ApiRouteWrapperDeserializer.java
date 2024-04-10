package com.chinempc.ResumeAPI.Model.Deserializers;

import com.chinempc.ResumeAPI.Model.ApiRoute;
import com.chinempc.ResumeAPI.Model.Wrappers.ApiRouteWrapper;
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
public class ApiRouteWrapperDeserializer extends JsonDeserializer<ApiRouteWrapper> {
    @Override
    public ApiRouteWrapper deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
        JsonNode rootNode = parser.getCodec().readTree(parser);
        JsonNode apiRouteNode = rootNode.get("api_routes");
        List<ApiRoute> apiRouteList = new ArrayList<>();

        if (apiRouteNode.isArray()) {
            for (JsonNode apiRoute : apiRouteNode) {
                if (!apiRoute.isEmpty()) {
                    apiRouteList.add(new ApiRoute(
                            apiRoute.get("id").asLong(),
                            apiRoute.get("description").asText(),
                            apiRoute.get("url").asText()
                    ));
                }
            }
        }
        return new ApiRouteWrapper(apiRouteList);
    }
}
