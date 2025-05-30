package adapters;

import com.google.gson.Gson;
import entity.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SectionAdapter extends BaseAdapter {
    SectionResponse sectionResponse;
    Sections sections;

    /**
     * This method is used to add a new section.
     * @param projectId - ID of the project.
     * @param section - section to be added.
     * @return section response.
     */
    public SectionResponse addSection(int projectId, Section section) {
        log.info("Adding a new section to project with ID: {}", projectId);
        sectionResponse = new Gson().fromJson(post(String.format(ADD_SECTION_ENDPOINT_API, projectId), gson.toJson(section)), SectionResponse.class);
        return sectionResponse;
    }

    /**
     * This method is used to get a section by project ID and suite ID.
     * @param projectId - ID of the project.
     * @param suiteId - ID of the suite.
     * @return section.
     */
    public Sections getSections(int projectId, int suiteId) {
        log.info("Getting sections for project with ID: {} and suite with ID: {}", projectId, suiteId);
        return new Gson().fromJson(get(String.format(GET_SECTIONS_ENDPOINT_API, projectId, suiteId)), Sections.class);
    }

    /**
     * This method is used to check if a section exists by ID.
     * @param projectId - ID of the project.
     * @param suiteId - ID of the suite.
     * @param sectionId - ID of the section.
     * @return true if section exists, false otherwise.
     */
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

    /**
     * This method is used to update a section by section ID.
     * @param sectionId - ID of the section.
     * @param section - updated section.
     * @return section response.
     */
    public SectionResponse updateSection(int sectionId, Section section) {
        log.info("Updating section with ID: {}", sectionId);
        sectionResponse = new Gson().fromJson(post(String.format(UPDATE_SECTION_ENDPOINT_API, sectionId), gson.toJson(section)), SectionResponse.class);
        return sectionResponse;
    }

    /**
     * This method is used to delete a section by section ID.
     * @param sectionId - ID of the section.
     * @return section response.
     */
    public SectionResponse deleteSection(int sectionId) {
        log.info("Deleting section with ID: {}", sectionId);
        return new Gson().fromJson(postWithoutBody(String.format(DELETE_SECTION_ENDPOINT_API, sectionId)), SectionResponse.class);
    }

    /**
     * This method is used to get a section name from response.
     * @return created section name.
     */
    public String getCreatedSectionName() {
        try {
            log.info("Getting a name from a section response");
            return sectionResponse.getName();
        } catch (NullPointerException e) {
            log.error("Failed to get a name from a section response", e);
            return null;
        }
    }

    /**
     * This method is used to get a section description from response.
     * @return created section description.
     */
    public String getCreatedSectionDescription() {
        try {
            log.info("Getting a description from a section response");
            return sectionResponse.getDescription();
        } catch (NullPointerException e) {
            log.error("Failed to get a description from a section response", e);
            return null;
        }
    }

    /**
     * This method is used to get a section ID from response.
     * @return created section ID.
     */
    public int getCreatedSectionId() {
        try {
            log.info("Getting an ID from a section response");
            return sectionResponse.getId();
        } catch (NullPointerException e) {
            log.error("Failed to get an ID from a section response", e);
            return 0;
        }
    }

    /**
     * This method is used to get a suite ID from response.
     * @return created section suite ID.
     */
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