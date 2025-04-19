package steps;

import adapters.ProjectAdapter;
import entity.Project;
import io.qameta.allure.Step;

public class ProjectSteps extends BaseSteps {

    ProjectAdapter projectAdapter;

    public ProjectSteps(ProjectAdapter projectAdapter) {
        this.projectAdapter = projectAdapter;
    }

    @Step("Create and add new project with default values")
    public ProjectSteps addProject(Project project) {
        projectAdapter.addProject(project);
        this.project = project;
        return this;
    }

    @Step("Update project with updated values")
    public ProjectSteps updateProject(Project project) {
        projectAdapter.updateProject(projectAdapter.getCreatedProjectId(), project);
        this.project = project;
        return this;
    }

    @Step("Get project by ID")
    public ProjectSteps getProject() {
        projectAdapter.getProject(projectAdapter.getCreatedProjectId());
        return this;
    }

    @Step("Verify project details")
    public void verifyProjectDetails() {
        softAssert.assertEquals(projectAdapter.getCreatedProjectName(), project.getName());
        softAssert.assertEquals(projectAdapter.getCreatedProjectAnnouncement(), project.getAnnouncement());
        softAssert.assertEquals(projectAdapter.getCreatedProjectShowAnnouncement(), project.isShowAnnouncement());
        softAssert.assertEquals(projectAdapter.getCreatedProjectSuiteMode(), project.getSuiteMode());
        softAssert.assertAll();
    }

    @Step("Verify updated project details: without suite mode")
    public void verifyUpdatedProjectDetails() {
        softAssert.assertEquals(projectAdapter.getCreatedProjectName(), project.getName());
        softAssert.assertEquals(projectAdapter.getCreatedProjectAnnouncement(), project.getAnnouncement());
        softAssert.assertEquals(projectAdapter.getCreatedProjectShowAnnouncement(), project.isShowAnnouncement());
        softAssert.assertAll();
    }

    @Step("Delete project and verify project deletion")
    public void deleteProjectAndVerifyDeletion() {
        softAssert.assertTrue(projectAdapter.isProjectExist(projectAdapter.getCreatedProjectId()));
        projectAdapter.deleteProject(projectAdapter.getCreatedProjectId());
        softAssert.assertFalse(projectAdapter.isProjectExist(projectAdapter.getCreatedProjectId()));
        softAssert.assertAll();
    }
}