package com.trilogyed.tasker.controller;

import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class TaskerController {

    @Autowired
    TaskerServiceLayer service;

    @Autowired
    private final AdServerClient client;

    public TaskerController(TaskerServiceLayer service, AdServerClient client) {
        this.service = service;
        this.client = client;
    }


    @RequestMapping(value="/tasks", method = RequestMethod.POST)
    public TaskViewModel postTask(@RequestBody TaskViewModel taskViewModel){

        return service.newTask(taskViewModel);

    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public List<TaskViewModel> getAllTasks(){

        return service.fetchAllTasks();

    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    public TaskViewModel getTaskById(@PathVariable int id){

        return service.fetchTask(id);
    }

    @RequestMapping(value = "/tasks/category/{category}", method = RequestMethod.GET)
    public List<TaskViewModel> getTaskByCategory(@PathVariable String category){
        return service.fetchTasksByCategory(category);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    public void updateTask(@RequestBody TaskViewModel taskViewModel){

        service.updateTask(taskViewModel);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    public void deleteTask(@PathVariable int id) {
        service.deleteTask(id);
    }


    @RequestMapping(value="/tasks/ad", method = RequestMethod.GET)
    public String getAd(){
        return client.getAd();
    }
}
