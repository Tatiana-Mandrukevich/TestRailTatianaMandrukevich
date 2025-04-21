package tests;

import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(description = "Add project test and verify project details")
    public void addProjectTest() {
        projectSteps.addProject(Preconditions.projectWithDefaultValues)
                .verifyProjectDetails();
    }

    @Test(description = "Get project test and verify project details")
    public void getProjectTest() {
        projectSteps.addProject(Preconditions.projectWithDefaultValues)
                .getProject()
                .verifyProjectDetails();
    }

    @Test(description = "Update project test and verify project details")
    public void updateProjectTest() {
        projectSteps.addProject(Preconditions.projectWithDefaultValues)
                .updateProject(Preconditions.projectWithUpdatedValues)
                .verifyUpdatedProjectDetails();
    }

    @Test(description = "Delete project test and verify project deletion")
    public void deleteProjectTest() {
        projectSteps.addProject(Preconditions.projectWithDefaultValues)
                .deleteProjectAndVerifyDeletion();
    }
}