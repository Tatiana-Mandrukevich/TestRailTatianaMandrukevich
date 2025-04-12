package tests;

import org.testng.annotations.Test;

public class SectionTest extends BaseTest {

    @Test(description = "Add section test and verify section details")
    public void addSectionTest() {
        projectSteps.addProject();
        sectionSteps.addSection()
                .verifySectionDetails();
    }

    @Test(description = "Update section test and verify section details")
    public void updateSectionTest() {
        projectSteps.addProject();
        sectionSteps.addSection()
                .updateSection()
                .verifySectionDetails();
    }

    @Test(description = "Delete section test and verify section deletion")
    public void deleteSectionTest() {
        projectSteps.addProject();
        sectionSteps.addSection()
                .deleteSectionAndVerifyDeletion();
    }
}