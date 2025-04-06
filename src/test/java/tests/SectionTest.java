package tests;

import entity.Project;
import entity.Section;
import org.testng.annotations.Test;

public class SectionTest extends BaseTest {

    @Test(description = "Add section test and verify section details")
    public void addSectionTest() {
        Project project = Project.builder()
                .name("Project name value " + java.time.LocalDateTime.now())
                .announcement("Project announcement value")
                .showAnnouncement(true)
                .suiteMode(1)
                .build();

        projectAdapter.addProject(project);

        Section section = Section.builder()
                .name("Section name value " + java.time.LocalDateTime.now())
                .description("Section description value")
                .build();

        sectionAdapter.addSection(projectAdapter.getCreatedProjectId(), section);
        softAssert.assertEquals(sectionAdapter.getCreatedSectionName(), section.getName());
        softAssert.assertEquals(sectionAdapter.getCreatedSectionDescription(), section.getDescription());
        softAssert.assertAll();
    }

    @Test(description = "Update section test and verify project details")
    public void updateSectionTest() {
        Project project = Project.builder()
                .name("Project name value " + java.time.LocalDateTime.now())
                .announcement("Project announcement value")
                .showAnnouncement(true)
                .suiteMode(1)
                .build();

        projectAdapter.addProject(project);

        Section section = Section.builder()
                .name("Section name value " + java.time.LocalDateTime.now())
                .description("Section description value")
                .build();

        sectionAdapter.addSection(projectAdapter.getCreatedProjectId(), section);

        Section sectionNewData = Section.builder()
                .name("Section name value updated " + java.time.LocalDateTime.now())
                .description("Section description value updated")
                .build();

        sectionAdapter.updateSection(sectionAdapter.getCreatedSectionId(), sectionNewData);
        softAssert.assertEquals(sectionAdapter.getCreatedSectionName(), sectionNewData.getName());
        softAssert.assertEquals(sectionAdapter.getCreatedSectionDescription(), sectionNewData.getDescription());
        softAssert.assertAll();
    }

    @Test(description = "Delete section test and verify project deletion")
    public void deleteSectionTest() {
        Project project = Project.builder()
                .name("Project name value " + java.time.LocalDateTime.now())
                .announcement("Project announcement value")
                .showAnnouncement(true)
                .suiteMode(1)
                .build();

        projectAdapter.addProject(project);

        Section section = Section.builder()
                .name("Section name value " + java.time.LocalDateTime.now())
                .description("Section description value")
                .build();

        sectionAdapter.addSection(projectAdapter.getCreatedProjectId(), section);
        softAssert.assertTrue(sectionAdapter.isSectionExist(projectAdapter.getCreatedProjectId(), sectionAdapter.getCreatedSectionSuiteId(), sectionAdapter.getCreatedSectionId()));
        sectionAdapter.deleteSection(sectionAdapter.getCreatedSectionId());
        softAssert.assertFalse(sectionAdapter.isSectionExist(projectAdapter.getCreatedProjectId(), sectionAdapter.getCreatedSectionSuiteId(), sectionAdapter.getCreatedSectionId()));
        softAssert.assertAll();
    }
}