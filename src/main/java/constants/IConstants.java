package constants;

import adapters.PropertyReader;

public interface IConstants {
    String BASE_URL_UI = "https://tatianamandrukevich.testrail.io/index.php?/";
    String LOGIN_URL_UI = BASE_URL_UI + "auth/login/";
    String ALL_PROJECTS_URL_UI = BASE_URL_UI + "dashboard";
    String AUTHORIZATION = "Authorization";
    String CONTENT_TYPE = "Content-type";
    String CONTENT_TYPE_VALUE = "application/json";
    String BASE_URL_API = BASE_URL_UI + "api/v2/";
    String ADD_PROJECT_ENDPOINT_API = "add_project";
    String GET_PROJECT_ENDPOINT_API = "get_project/%s";
    String GET_PROJECTS_ENDPOINT_API = "get_projects";
    String UPDATE_PROJECT_ENDPOINT_API = "update_project/%s";
    String DELETE_PROJECT_ENDPOINT_API = "delete_project/%s";
    String ADD_SECTION_ENDPOINT_API = "add_section/%s";
    String GET_SECTIONS_ENDPOINT_API = "get_sections/%s&suite_id=%s";
    String UPDATE_SECTION_ENDPOINT_API = "update_section/%s";
    String DELETE_SECTION_ENDPOINT_API = "delete_section/%s";
    String TEST_CASES_URL_UI = BASE_URL_UI + "suites/view/%s&group_by=cases:section_id&group_order=asc&display_deleted_cases=0";
    String API_KEY = PropertyReader.getProperty("API_KEY");
}