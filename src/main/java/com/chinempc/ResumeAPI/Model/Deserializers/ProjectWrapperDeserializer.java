package com.chinempc.ResumeAPI.Model.Deserializers;

import com.chinempc.ResumeAPI.Model.Project;
import com.chinempc.ResumeAPI.Model.Wrappers.ProjectsWrapper;
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
public class ProjectWrapperDeserializer extends JsonDeserializer<ProjectsWrapper> {
    @Override
    public ProjectsWrapper deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
        JsonNode rootNode = parser.getCodec().readTree(parser);
        JsonNode projectNode = rootNode.get("projects");
        List<Project> projectList = new ArrayList<>();

        if (projectNode.isArray()) {
            for (JsonNode project : projectNode) {
                if (project.get("notes") != null) {
                    Project newProject = new Project(
                            project.get("name").asText(),
                            extractTechStack(project),
                            project.get("github_repo").asText(),
                            YearMonth.parse(project.get("created").asText()),
                            extractNotes(project)
                    );
                    projectList.add(newProject);
                }
            }
        }

        return new ProjectsWrapper(projectList);
    }

    private List<String> extractTechStack(JsonNode projectNode) {
        List<String> techStacks = new ArrayList<>();
        ArrayNode techStackArray = (ArrayNode) projectNode.get("tech_stack");

        for (JsonNode techStack : techStackArray) {
            techStacks.add(techStack.textValue());
        }
        return techStacks;
    }

    private List<String> extractNotes(JsonNode projectNode) {
        List<String> notes = new ArrayList<>();
        ArrayNode notesNode = (ArrayNode) projectNode.get("notes");

        for (JsonNode note : notesNode) {
            notes.add(note.textValue());
        }
        return notes;
    }
}
