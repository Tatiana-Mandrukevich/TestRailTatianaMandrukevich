package tests;

import entity.Project;
import entity.Section;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {

    @Test(description = "Add test case test and verify test case details")
    public void addTestCaseTest() {
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

        softAssert.assertAll();
    }
}
