package tests.constants;

import utils.PropertyReader;

public interface ITestConstants {
    String EMAIL = PropertyReader.getProperty("EMAIL");
    String PASSWORD = PropertyReader.getProperty("PASSWORD");
}