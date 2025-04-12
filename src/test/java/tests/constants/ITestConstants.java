package tests.constants;

import tests.PropertyReader;

public interface ITestConstants {
    String EMAIL = PropertyReader.getProperty("EMAIL");
    String PASSWORD = PropertyReader.getProperty("PASSWORD");
}