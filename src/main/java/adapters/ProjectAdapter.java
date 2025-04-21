package adapters;

import com.google.gson.Gson;
import entity.Project;
import entity.ProjectResponse;
import entity.Projects;
import lombok.extern.log4j.Log4j2;
import java.util.Objects;

@Log4j2
public class ProjectAdapter extends BaseAdapter {
    ProjectResponse projectResponse;
    Projects projects;

    /**
     * This method is used to add a new project.
     * @param project - project to be added.
     * @return project response.
     */
    public ProjectResponse addProject(Project project) {
        log.info("Adding a new project");
        projectResponse = new Gson().fromJson(post(ADD_PROJECT_ENDPOINT_API, gson.toJson(project)), ProjectResponse.class);
        return projectResponse;
    }

    /**
     * This method is used to get a project by ID.
     * @param projectId - ID of the project.
     * @return project response.
     */
    public ProjectResponse getProject(int projectId) {
        log.info("Getting project with ID: {}", projectId);
        projectResponse = new Gson().fromJson(get(String.format(GET_PROJECT_ENDPOINT_API, projectId)), ProjectResponse.class);
        return projectResponse;
    }

    /**
     * This method is used to get all projects.
     * @return projects.
     */
    public Projects getProjects() {
        log.info("Getting all projects");
        return new Gson().fromJson(get(GET_PROJECTS_ENDPOINT_API), Projects.class);
    }

    /**
     * This method is used to check if a project exists by ID.
     * @param projectId - ID of the project.
     * @return true if project exists, false otherwise.
     */
    public boolean isProjectExist(int projectId) {
        projects = getProjects();
        for (Project project : projects.getProjects()) {
            if (project.getId() == projectId) {
                log.info("Project with ID: {} exists", projectId);
                return true;
            }
        }
        log.info("Project with ID: {} does not exist", projectId);
        return false;
    }

    /**
     * This method is used to update a project by project ID.
     * @param projectId - ID of the project to be updated.
     * @param project - updated project.
     * @return project response.
     */
    public ProjectResponse updateProject(int projectId, Project project) {
        log.info("Updating project with ID: {}", projectId);
        projectResponse = new Gson().fromJson(post(String.format(UPDATE_PROJECT_ENDPOINT_API, projectId), gson.toJson(project)), ProjectResponse.class);
        return projectResponse;
    }

    /**
     * This method is used to delete a project.
     * @param projectId - ID of the project to be deleted.
     * @return project response.
     */
    public ProjectResponse deleteProject(int projectId) {
        log.info("Deleting project with ID: {}", projectId);
        return new Gson().fromJson(postWithoutBody(String.format(DELETE_PROJECT_ENDPOINT_API, projectId)), ProjectResponse.class);
    }

    /**
     * This method is used to get the project name from response.
     * @return created project name.
     */
    public String getCreatedProjectName() {
        try {
            log.info("Getting a name from a project response");
            return projectResponse.getName();
        }
        catch (NullPointerException e) {
            log.error("Failed to get a name from a project response", e);
            return null;
        }
    }

    /**
     * This method is used to get the project announcement from response.
     * @return created project announcement.
     */
    public String getCreatedProjectAnnouncement() {
        try {
            log.info("Getting an announcement from a project response");
            return projectResponse.getAnnouncement();
        }
        catch (NullPointerException e) {
            log.error("Failed to get an announcement from a project response", e);
            return null;
        }
    }

    /**
     * This method is used to get the project show announcement from response.
     * @return created project show announcement.
     */
    public boolean getCreatedProjectShowAnnouncement() {
        log.info("Getting a show announcement from a project response");
        return projectResponse.isShowAnnouncement();
    }

    /**
     * This method is used to get the project suite mode from response.
     * @return created project suite mode.
     */
    public int getCreatedProjectSuiteMode() {
        try {
            log.info("Getting a suite mode from a project response");
            return projectResponse.getSuiteMode();
        }
        catch (NullPointerException e) {
            log.error("Failed to get a suite mode from a project response", e);
            return 0;
        }
    }

    /**
     * This method is used to get the project ID from response.
     * @return created project ID.
     */
    public int getCreatedProjectId() {
        try {
            log.info("Getting an ID from a project response");
            return projectResponse.getId();
        }
        catch (NullPointerException e) {
            log.error("Failed to get an ID from a project response", e);
            return 0;
        }
    }

    /**
     * This method is used to delete test projects by announcement value.
     * @param announcementValue1 - first announcement value.
     * @param announcementValue2 - second announcement value.
     */
    public void deleteTestProjectsByAnnouncementValue(String announcementValue1, String announcementValue2) {
        Projects projects = getProjects();
        for (Project project : projects.getProjects()) {
            if (Objects.equals(project.getAnnouncement(), announcementValue1) ||
                    Objects.equals(project.getAnnouncement(), announcementValue2)) {
                deleteProject(project.getId());
            }
        }
    }
}