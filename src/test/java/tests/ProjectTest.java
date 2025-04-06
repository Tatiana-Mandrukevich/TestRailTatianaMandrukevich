package tests;

import entity.Project;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(description = "Add project test and verify project details")
    public void addProjectTest() {
        Project project = Project.builder()
                .name("Project name value " + java.time.LocalDateTime.now())
                .announcement("Project announcement value")
                .showAnnouncement(true)
                .suiteMode(1)
                .build();

        projectAdapter.addProject(project);
        softAssert.assertEquals(projectAdapter.getCreatedProjectName(), project.getName());
        softAssert.assertEquals(projectAdapter.getCreatedProjectAnnouncement(), project.getAnnouncement());
        softAssert.assertEquals(projectAdapter.getCreatedProjectShowAnnouncement(), project.isShowAnnouncement());
        softAssert.assertEquals(projectAdapter.getCreatedProjectSuiteMode(), project.getSuiteMode());
        softAssert.assertAll();
    }

    @Test(description = "Get project test and verify project details")
    public void getProjectTest() {
        Project project = Project.builder()
                .name("Project name value " + java.time.LocalDateTime.now())
                .announcement("Project announcement value")
                .showAnnouncement(true)
                .suiteMode(1)
                .build();

        projectAdapter.addProject(project);
        projectAdapter.getProject(projectAdapter.getCreatedProjectId());
        softAssert.assertEquals(projectAdapter.getCreatedProjectName(), project.getName());
        softAssert.assertEquals(projectAdapter.getCreatedProjectAnnouncement(), project.getAnnouncement());
        softAssert.assertEquals(projectAdapter.getCreatedProjectShowAnnouncement(), project.isShowAnnouncement());
        softAssert.assertEquals(projectAdapter.getCreatedProjectSuiteMode(), project.getSuiteMode());
        softAssert.assertAll();
    }

    @Test(description = "Update project test and verify project details")
    public void updateProjectTest() {
        Project project = Project.builder()
                .name("Project name value " + java.time.LocalDateTime.now())
                .announcement("Project announcement value")
                .showAnnouncement(true)
                .suiteMode(1)
                .build();

        projectAdapter.addProject(project);

        Project projectNewData = Project.builder()
                .name("Project name value updated " + java.time.LocalDateTime.now())
                .announcement("Project announcement value updated ")
                .showAnnouncement(false)
                .build();

        projectAdapter.updateProject(projectAdapter.getCreatedProjectId(), projectNewData);
        softAssert.assertEquals(projectAdapter.getCreatedProjectName(), projectNewData.getName());
        softAssert.assertEquals(projectAdapter.getCreatedProjectAnnouncement(), projectNewData.getAnnouncement());
        softAssert.assertEquals(projectAdapter.getCreatedProjectShowAnnouncement(), projectNewData.isShowAnnouncement());
        softAssert.assertAll();
    }

    @Test(description = "Delete project test and verify project deletion")
    public void deleteProjectTest() {
        Project project = Project.builder()
                .name("Project name value " + java.time.LocalDateTime.now())
                .announcement("Project announcement value")
                .showAnnouncement(true)
                .suiteMode(1)
                .build();

        projectAdapter.addProject(project);
        softAssert.assertTrue(projectAdapter.isProjectExist(projectAdapter.getCreatedProjectId()));
        projectAdapter.deleteProject(projectAdapter.getCreatedProjectId());
        softAssert.assertFalse(projectAdapter.isProjectExist(projectAdapter.getCreatedProjectId()));
        softAssert.assertAll();
    }
}