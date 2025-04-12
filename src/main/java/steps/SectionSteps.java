package steps;

import adapters.ProjectAdapter;
import adapters.SectionAdapter;
import io.qameta.allure.Step;

public class SectionSteps extends BaseSteps {

    SectionAdapter sectionAdapter;
    ProjectAdapter projectAdapter;

    public SectionSteps(SectionAdapter sectionAdapter, ProjectAdapter projectAdapter) {
        this.sectionAdapter = sectionAdapter;
        this.projectAdapter = projectAdapter;
    }

    @Step("Create and add new section with default values")
    public SectionSteps addSection() {
        section = sectionAdapter.createSection("Section name value ", "Section description value");
        sectionAdapter.addSection(projectAdapter.getCreatedProjectId(), section);
        return this;
    }

    @Step("Update section with updated values")
    public SectionSteps updateSection() {
       section = sectionAdapter.createSection("Section name value updated ", "Section description value updated");
        sectionAdapter.updateSection(sectionAdapter.getCreatedSectionId(), section);
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
