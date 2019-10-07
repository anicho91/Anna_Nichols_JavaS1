package com.trilogyed.tasker.service;

import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {

    private TaskerDao dao;
    private AdServerClient adClient;

    public TaskerServiceLayer(TaskerDao dao, AdServerClient adClient) {
        this.dao = dao;
        this.adClient = adClient;
    }

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getId());
        tvm.setDescription(task.getDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        tvm.setAdvertisement(adClient.getAd());

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        List<Task> tasks = dao.getAllTasks();
        List<TaskViewModel> tvmList = new ArrayList<>();

        for (Task task : tasks){
            TaskViewModel taskViewModel = buildTaskViewModel(task);
            tvmList.add(taskViewModel);
        }

        return tvmList;
    }

    public List<TaskViewModel> fetchTasksByCategory(String category) {
        List<Task> tasks = dao.getTasksByCategory(category);
        List<TaskViewModel> tvmList = new ArrayList<>();

        for (Task task : tasks){
            TaskViewModel taskViewModel = buildTaskViewModel(task);
            tvmList.add(taskViewModel);
        }

        return tvmList;

    }

    public TaskViewModel newTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getId());
        taskViewModel.setAdvertisement(adClient.getAd());
        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {
        Task task = new Task();
        task.setId(taskViewModel.getId());
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());
        taskViewModel.setAdvertisement(adClient.getAd());

        dao.updateTask(task);
    }

    private TaskViewModel buildTaskViewModel(Task task) {
        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setId(task.getId());
        taskViewModel.setDescription(task.getDescription());
        taskViewModel.setCreateDate(task.getCreateDate());
        taskViewModel.setDueDate(task.getDueDate());
        taskViewModel.setCategory(task.getCategory());
        taskViewModel.setAdvertisement(adClient.getAd());

        return taskViewModel;


    }
}
