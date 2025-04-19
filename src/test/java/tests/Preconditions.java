package tests;

import adapters.SectionAdapter;
import entity.TestCase;

import java.time.LocalDateTime;

public class Preconditions extends BaseTest {

    SectionAdapter sectionAdapter;

    public Preconditions (SectionAdapter sectionAdapter) {
        this.sectionAdapter = sectionAdapter;
    }

    public TestCase testCaseWithDefaultValues = TestCase.builder()
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

    public TestCase testCaseWithUpdatedValues = TestCase.builder()
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
