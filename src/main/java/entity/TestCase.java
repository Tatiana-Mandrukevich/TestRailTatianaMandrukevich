package entity;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TestCase {

    private String title;
    private String section;
    private String template;
    private String type;
    private String priority;
    private String assignedTo;
    private String estimate;
    private String references;
    private String automationType;
    private String preconditions;
    private String stepDescriptionForFirstStep;
    private String expectedResultForFirstStep;
    private String stepDescriptionForSecondStep;
    private String expectedResultForSecondStep;
}