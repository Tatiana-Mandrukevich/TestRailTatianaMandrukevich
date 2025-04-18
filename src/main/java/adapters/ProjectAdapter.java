package adapters;

import com.google.gson.Gson;
import entity.Project;
import entity.ProjectResponse;
import entity.Projects;
import lombok.extern.log4j.Log4j2;
import java.time.LocalDateTime;
import java.util.Objects;

@Log4j2
public class ProjectAdapter extends BaseAdapter {
    ProjectResponse projectResponse;
    Projects projects;

    public Project createProject(String name, String announcement, boolean showAnnouncement, int suiteMode) {
        log.info("Creating a new project");
        return Project.builder()
                .name(name + LocalDateTime.now())
                .announcement(announcement)
                .showAnnouncement(showAnnouncement)
                .suiteMode(suiteMode)
                .build();
    }

    public Project createProject(String name, String announcement, boolean showAnnouncement) {
        log.info("Creating a new project without suite mode");
        return Project.builder()
                .name(name + LocalDateTime.now())
                .announcement(announcement)
                .showAnnouncement(showAnnouncement)
                .build();
    }

    public ProjectResponse addProject(Project project) {
        log.info("Adding a new project");
        projectResponse = new Gson().fromJson(post(ADD_PROJECT_ENDPOINT_API, gson.toJson(project)), ProjectResponse.class);
        return projectResponse;
    }

    public ProjectResponse getProject(int projectId) {
        log.info("Getting project with ID: {}", projectId);
        projectResponse = new Gson().fromJson(get(String.format(GET_PROJECT_ENDPOINT_API, projectId)), ProjectResponse.class);
        return projectResponse;
    }

    public Projects getProjects() {
        log.info("Getting all projects");
        return new Gson().fromJson(get(GET_PROJECTS_ENDPOINT_API), Projects.class);
    }

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

    public ProjectResponse updateProject(int projectId, Project project) {
        log.info("Updating project with ID: {}", projectId);
        projectResponse = new Gson().fromJson(post(String.format(UPDATE_PROJECT_ENDPOINT_API, projectId), gson.toJson(project)), ProjectResponse.class);
        return projectResponse;
    }

    public ProjectResponse deleteProject(int projectId) {
        log.info("Deleting project with ID: {}", projectId);
        return new Gson().fromJson(postWithoutBody(String.format(DELETE_PROJECT_ENDPOINT_API, projectId)), ProjectResponse.class);
    }

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

    public boolean getCreatedProjectShowAnnouncement() {
        log.info("Getting a show announcement from a project response");
        return projectResponse.isShowAnnouncement();
    }

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