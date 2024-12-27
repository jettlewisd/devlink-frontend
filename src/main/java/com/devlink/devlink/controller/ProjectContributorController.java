package com.devlink.devlink.controller;

import com.devlink.devlink.dao.ProjectContributorDao;
import com.devlink.devlink.model.ProjectContributor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project_contributors")
public class ProjectContributorController {

    private final ProjectContributorDao projectContributorDao;

    @Autowired
    public ProjectContributorController(ProjectContributorDao projectContributorDao) {
        this.projectContributorDao = projectContributorDao;
    }


    @GetMapping("/{user_id}/{project_id}")
    public ProjectContributor getContributorById(@PathVariable Long userId, @PathVariable Long projectId) {
        return projectContributorDao.getContributorById(userId, projectId);
    }

    @PostMapping
    public boolean addContributor(@RequestBody ProjectContributor projectContributor) {
        return projectContributorDao.addContributor(projectContributor);
    }

    @PutMapping
    public boolean updateContributor(@RequestBody ProjectContributor projectContributor) {
        return projectContributorDao.updateContributor(projectContributor);
    }

    @DeleteMapping("/{user_id}/{project_id}")
    public boolean removeContributor(@PathVariable Long userId, @PathVariable Long projectId) {
        return projectContributorDao.removeContributor(userId, projectId);
    }

    @GetMapping("/projects/{project_id}")
    public List<ProjectContributor> getContributorsByProjectId(@PathVariable Long projectId) {
        return projectContributorDao.getContributorsByProjectId(projectId);
    }

    @GetMapping("/{user_id}/{project_id}")
   public boolean isUserContributing(@PathVariable Long userId, @PathVariable Long projectId) {
        return projectContributorDao.isUserContributing(userId, projectId);
   }
}
