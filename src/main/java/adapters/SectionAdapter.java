package adapters;

import com.google.gson.Gson;
import entity.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SectionAdapter extends BaseAdapter {
    SectionResponse sectionResponse;
    Sections sections;

    public Section createSection(String name, String description) {
        log.info("Creating a new section");
        return Section.builder()
                .name(name + java.time.LocalDateTime.now())
                .description(description)
                .build();
    }

    public SectionResponse addSection(int projectId, Section section) {
        log.info("Adding a new section to project with ID: {}", projectId);
        sectionResponse = new Gson().fromJson(post(String.format(ADD_SECTION_ENDPOINT_API, projectId), gson.toJson(section)), SectionResponse.class);
        return sectionResponse;
    }

    public Sections getSections(int projectId, int suiteId) {
        log.info("Getting sections for project with ID: {} and suite with ID: {}", projectId, suiteId);
        return new Gson().fromJson(get(String.format(GET_SECTIONS_ENDPOINT_API, projectId, suiteId)), Sections.class);
    }

    public boolean isSectionExist(int projectId, int suiteId, int sectionId) {
        sections = getSections(projectId, suiteId);
        for (Section section : sections.getSections()) {
            if (section.getId() == sectionId) {
                log.info("Section with ID: {} exists in project with ID: {} and suite with ID: {}", sectionId, projectId, suiteId);
                return true;
            }
        }
        log.info("Section with ID: {} does not exist in project with ID: {} and suite with ID: {}", sectionId, projectId, suiteId);
        return false;
    }

    public SectionResponse updateSection(int sectionId, Section section) {
        log.info("Updating section with ID: {}", sectionId);
        sectionResponse = new Gson().fromJson(post(String.format(UPDATE_SECTION_ENDPOINT_API, sectionId), gson.toJson(section)), SectionResponse.class);
        return sectionResponse;
    }

    public SectionResponse deleteSection(int sectionId) {
        log.info("Deleting section with ID: {}", sectionId);
        return new Gson().fromJson(postWithoutBody(String.format(DELETE_SECTION_ENDPOINT_API, sectionId)), SectionResponse.class);
    }

    public String getCreatedSectionName() {
        try {
            log.info("Getting a name from a section response");
            return sectionResponse.getName();
        } catch (NullPointerException e) {
            log.error("Failed to get a name from a section response", e);
            return null;
        }
    }

    public String getCreatedSectionDescription() {
        try {
            log.info("Getting a description from a section response");
            return sectionResponse.getDescription();
        } catch (NullPointerException e) {
            log.error("Failed to get a description from a section response", e);
            return null;
        }
    }

    public int getCreatedSectionId() {
        try {
            log.info("Getting an ID from a section response");
            return sectionResponse.getId();
        } catch (NullPointerException e) {
            log.error("Failed to get an ID from a section response", e);
            return 0;
        }
    }

    public int getCreatedSectionSuiteId() {
        try {
            log.info("Getting a suite ID from a section response");
            return sectionResponse.getSuiteId();
        } catch (NullPointerException e) {
            log.error("Failed to get a suite ID from a section response", e);
            return 0;
        }
    }
}