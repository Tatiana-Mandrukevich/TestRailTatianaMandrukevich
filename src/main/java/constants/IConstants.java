package constants;

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
    String SECTION_ENDPOINT_API = "";
}