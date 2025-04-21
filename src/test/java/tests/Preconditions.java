package tests;

import adapters.SectionAdapter;
import entity.Project;
import entity.Section;
import entity.TestCase;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

@Log4j2
public class Preconditions extends BaseTest {

    SectionAdapter sectionAdapter;

    protected Preconditions (SectionAdapter sectionAdapter) {
        this.sectionAdapter = sectionAdapter;
    }

    protected static Project projectWithDefaultValues = Project.builder()
            .name("Project name value " + LocalDateTime.now())
            .announcement("Project announcement value")
            .showAnnouncement(true)
            .suiteMode(1)
            .build();

    protected static Project projectWithUpdatedValues = Project.builder()
            .name("Project name value updated " + LocalDateTime.now())
            .announcement("Project announcement value updated")
            .showAnnouncement(false)
            .build();

    protected static Section sectionWithDefaultValues = Section.builder()
            .name("Section name value " + LocalDateTime.now())
            .description("Section description value")
            .build();

    protected static Section sectionWithUpdatedValues = Section.builder()
            .name("Section name value updated " + LocalDateTime.now())
            .description("Section description value updated")
            .build();

    /**
     * This method is used to create a new test case with default values.
     * @return test case with default values.
     */
    protected TestCase getTestCaseWithDefaultValues() {
        log.info("Creating a new test case with default values");
        return TestCase.builder()
            .title("Test Case Title value " + LocalDateTime.now())
            .section(sectionAdapter.getCreatedSectionName())
            .template("Test Case (Steps)")
            .type("Functional")
            .priority("High")
            .assignedTo("Me")
            .estimate("1 hour")
            .references("References value")
            .automationType("Ranorex")
            .preconditions("Preconditions value")
            .stepDescriptionForFirstStep("Step Description value for 1 step")
            .expectedResultForFirstStep("Expected Result value for 1 step")
            .stepDescriptionForSecondStep("Step Description value for 2 step")
            .expectedResultForSecondStep("Expected Result value for 2 step")
            .build();
    }

    /**
     * This method is used to create a new test case with updated values.
     * @return test case with updated values.
     */
    protected TestCase getTestCaseWithUpdatedValues() {
        log.info("Creating a new test case with updated values");
        return TestCase.builder()
                .title("Test Case Title value updated " + LocalDateTime.now())
                .section(sectionAdapter.getCreatedSectionName())
                .template("Test Case (Steps)")
                .type("Automated")
                .priority("Critical")
                .assignedTo("None")
                .estimate("2 hours")
                .references("References value updated")
                .automationType("None")
                .preconditions("Preconditions value updated")
                .stepDescriptionForFirstStep("Step Description value for 1 step updated")
                .expectedResultForFirstStep("Expected Result value for 1 step updated")
                .stepDescriptionForSecondStep("Step Description value for 2 step updated")
                .expectedResultForSecondStep("Expected Result value for 2 step updated")
                .build();
    }
}