package tests;

import org.testng.annotations.Test;

public class SectionTest extends BaseTest {

    @Test(description = "Add section test and verify section details")
    public void addSectionTest() {
        projectSteps.addProject(Preconditions.projectWithDefaultValues);
        sectionSteps.addSection(Preconditions.sectionWithDefaultValues)
                .verifySectionDetails();
    }

    @Test(description = "Update section test and verify section details")
    public void updateSectionTest() {
        projectSteps.addProject(Preconditions.projectWithDefaultValues);
        sectionSteps.addSection(Preconditions.sectionWithDefaultValues)
                .updateSection(Preconditions.sectionWithUpdatedValues)
                .verifySectionDetails();
    }

    @Test(description = "Delete section test and verify section deletion")
    public void deleteSectionTest() {
        projectSteps.addProject(Preconditions.projectWithDefaultValues);
        sectionSteps.addSection(Preconditions.sectionWithDefaultValues)
                .deleteSectionAndVerifyDeletion();
    }
}