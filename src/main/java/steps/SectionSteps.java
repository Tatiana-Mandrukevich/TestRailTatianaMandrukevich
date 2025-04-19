package steps;

import adapters.ProjectAdapter;
import adapters.SectionAdapter;
import entity.Section;
import io.qameta.allure.Step;

public class SectionSteps extends BaseSteps {

    SectionAdapter sectionAdapter;
    ProjectAdapter projectAdapter;

    public SectionSteps(SectionAdapter sectionAdapter, ProjectAdapter projectAdapter) {
        this.sectionAdapter = sectionAdapter;
        this.projectAdapter = projectAdapter;
    }

    @Step("Create and add new section with default values")
    public SectionSteps addSection(Section section) {
        sectionAdapter.addSection(projectAdapter.getCreatedProjectId(), section);
        this.section = section;
        return this;
    }

    @Step("Update section with updated values")
    public SectionSteps updateSection(Section section) {
        sectionAdapter.updateSection(sectionAdapter.getCreatedSectionId(), section);
        this.section = section;
        return this;
    }

    @Step("Verify section details")
    public void verifySectionDetails() {
        softAssert.assertEquals(sectionAdapter.getCreatedSectionName(), section.getName());
        softAssert.assertEquals(sectionAdapter.getCreatedSectionDescription(), section.getDescription());
        softAssert.assertAll();
    }

    @Step("Delete section and verify section deletion")
    public void deleteSectionAndVerifyDeletion() {
        softAssert.assertTrue(sectionAdapter.isSectionExist(projectAdapter.getCreatedProjectId(), sectionAdapter.getCreatedSectionSuiteId(), sectionAdapter.getCreatedSectionId()));
        sectionAdapter.deleteSection(sectionAdapter.getCreatedSectionId());
        softAssert.assertFalse(sectionAdapter.isSectionExist(projectAdapter.getCreatedProjectId(), sectionAdapter.getCreatedSectionSuiteId(), sectionAdapter.getCreatedSectionId()));
        softAssert.assertAll();
    }
}
