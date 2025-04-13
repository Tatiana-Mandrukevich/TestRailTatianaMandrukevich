package steps;

import constants.IConstants;
import entity.Project;
import entity.Section;
import entity.TestCase;
import org.testng.asserts.SoftAssert;

public class BaseSteps implements IConstants {
    SoftAssert softAssert = new SoftAssert();
    Project project;
    Section section;
}