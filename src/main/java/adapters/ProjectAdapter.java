package adapters;

import com.google.gson.Gson;
import entity.Project;
import entity.ProjectResponse;
import entity.Projects;

public class ProjectAdapter extends BaseAdapter {
    ProjectResponse projectResponse;
    Projects projects;

    public ProjectResponse addProject(Project project) {
        projectResponse = new Gson().fromJson(post(ADD_PROJECT_ENDPOINT_API, gson.toJson(project)), ProjectResponse.class);
        return projectResponse;
    }

    public ProjectResponse getProject(int projectId) {
        projectResponse = new Gson().fromJson(get(String.format(GET_PROJECT_ENDPOINT_API, projectId)), ProjectResponse.class);
        return projectResponse;
    }

    public Projects getProjects() {
        return new Gson().fromJson(get(GET_PROJECTS_ENDPOINT_API), Projects.class);
    }

    public boolean isProjectExist(int projectId) {
        projects = getProjects();
        for (Project project : projects.getProjects()) {
            if (project.getId() == projectId) {
                return true;
            }
        }
        return false;
    }

    public ProjectResponse updateProject(int projectId, Project project) {
        projectResponse = new Gson().fromJson(post(String.format(UPDATE_PROJECT_ENDPOINT_API, projectId), gson.toJson(project)), ProjectResponse.class);
        return projectResponse;
    }

    public ProjectResponse deleteProject(int projectId) {
        return new Gson().fromJson(postWithoutBody(String.format(DELETE_PROJECT_ENDPOINT_API, projectId)), ProjectResponse.class);
    }

    public String getCreatedProjectName() {
        return projectResponse.getName();
    }

    public String getCreatedProjectAnnouncement() {
        return projectResponse.getAnnouncement();
    }

    public boolean getCreatedProjectShowAnnouncement() {
        return projectResponse.isShowAnnouncement();
    }

    public int getCreatedProjectSuiteMode() {
        return projectResponse.getSuiteMode();
    }

    public int getCreatedProjectId() {
        return projectResponse.getId();
    }
}