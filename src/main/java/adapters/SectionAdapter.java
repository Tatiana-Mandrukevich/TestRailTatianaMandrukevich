package adapters;

import com.google.gson.Gson;
import entity.*;

public class SectionAdapter extends BaseAdapter {
    SectionResponse sectionResponse;
    Sections sections;

    public SectionResponse addSection(int projectId, Section section) {
        sectionResponse = new Gson().fromJson(post(String.format(ADD_SECTION_ENDPOINT_API, projectId), gson.toJson(section)), SectionResponse.class);
        return sectionResponse;
    }

    public Sections getSections(int projectId, int suiteId) {
        return new Gson().fromJson(get(String.format(GET_SECTIONS_ENDPOINT_API, projectId, suiteId)), Sections.class);
    }

    public boolean isSectionExist(int projectId, int suiteId, int sectionId) {
        sections = getSections(projectId, suiteId);
        for (Section section : sections.getSections()) {
            if (section.getId() == sectionId) {
                return true;
            }
        }
        return false;
    }

    public SectionResponse updateSection(int sectionId, Section section) {
        sectionResponse = new Gson().fromJson(post(String.format(UPDATE_SECTION_ENDPOINT_API, sectionId), gson.toJson(section)), SectionResponse.class);
        return sectionResponse;
    }

    public SectionResponse deleteSection(int sectionId) {
        return new Gson().fromJson(postWithoutBody(String.format(DELETE_SECTION_ENDPOINT_API, sectionId)), SectionResponse.class);
    }

    public String getCreatedSectionName() {
        return sectionResponse.getName();
    }

    public String getCreatedSectionDescription() {
        return sectionResponse.getDescription();
    }

    public int getCreatedSectionId() {
        return sectionResponse.getId();
    }

    public int getCreatedSectionSuiteId() {
        return sectionResponse.getSuiteId();
    }
}