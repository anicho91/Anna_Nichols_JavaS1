package com.trilogyed.tasker.service;


import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdServerClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class TaskerServiceLayerTest {

    @Autowired
    TaskerServiceLayer service;
    @Autowired
    AdServerClient adClient;
    @Autowired
    TaskerDao dao;

    private static TaskViewModel tvm;
    static {
        tvm = new TaskViewModel();
        tvm.setId(2);
        tvm.setDescription("Description");
        tvm.setCreateDate(LocalDate.of(2019,02, 15));
        tvm.setDueDate(LocalDate.of(2019, 03, 01));
        tvm.setCategory("Todo");
    }

    @Before
    public void setUp(){
        setUpFeignClientMock();
        setUpTaskServiceMock();

        service = new TaskerServiceLayer(dao, adClient);
    }

    @Test
    public void fetchTask() {
        String newAd = adClient.getAd();
        tvm.setAdvertisement(newAd);
        service.newTask(tvm);

        TaskViewModel fromService = service.fetchTask(tvm.getId());
        assertEquals(fromService.getId(), tvm.getId());
    }

    @Test
    public void fetchAllTasks() {
        String newAd = adClient.getAd();
        tvm.setAdvertisement(newAd);
        service.newTask(tvm);

        List<TaskViewModel> tasks = service.fetchAllTasks();
        assertEquals(1, tasks.size());

    }

    @Test
    public void fetchTasksByCategory() {
        String newAd = adClient.getAd();
        tvm.setAdvertisement(newAd);
        service.newTask(tvm);

        List<TaskViewModel> tasks = service.fetchTasksByCategory("Todo");
        assertEquals("Todo", tvm.getCategory());
    }

    @Test
    public void newTask() {
        String newAd = adClient.getAd();
        tvm.setAdvertisement(newAd);
        service.newTask(tvm);

        assertNotNull(tvm);
    }

    @Test
    public void deleteTask() {
        String newAd = adClient.getAd();
        tvm.setAdvertisement(newAd);
        service.newTask(tvm);

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(dao).deleteTask(integerCaptor.capture());

        service.deleteTask(1);

        verify(dao, times(1)).deleteTask(integerCaptor.getValue());
        assertEquals(1, integerCaptor.getValue().intValue());
    }

    @Test
    public void updateTask() {
        String newAd = adClient.getAd();
        tvm.setAdvertisement(newAd);
        service.newTask(tvm);

        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);

        doNothing().when(dao).updateTask(taskCaptor.capture());

        service.updateTask(tvm);
        verify(dao, times(1)).updateTask(taskCaptor.getValue());

        Task task2 = taskCaptor.getValue();

        assertEquals(tvm.getCategory(), task2.getCategory());
    }

    private void setUpFeignClientMock(){
        adClient = mock(AdServerClient.class);
        TaskViewModel ad = new TaskViewModel();
        ad.setAdvertisement("AD!");

//        doReturn(ad).when(adClient).getAd();
    }

    private void setUpTaskServiceMock(){
        dao = mock(TaskerDao.class);

        Task task = new Task();
        task.setId(2);
        task.setDescription("Description");
        task.setCreateDate(LocalDate.of(2019,02, 15));
        task.setDueDate(LocalDate.of(2019, 03, 01));
        task.setCategory("Todo");

        Task task2 = new Task();
        task2.setDescription("Description");
        task2.setCreateDate(LocalDate.of(2019,02, 15));
        task2.setDueDate(LocalDate.of(2019, 03, 01));
        task2.setCategory("Todo");

        List<Task> tasks = new ArrayList<>();
        tasks.add(task);

        doReturn(task).when(dao).createTask(task2);
        doReturn(task).when(dao).getTask(2);
        doReturn(tasks).when(dao).getAllTasks();
        doReturn(tasks).when(dao).getTasksByCategory("Todo");

    }
}
