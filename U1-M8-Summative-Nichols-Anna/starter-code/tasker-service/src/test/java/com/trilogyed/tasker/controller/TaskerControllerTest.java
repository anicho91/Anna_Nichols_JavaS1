package com.trilogyed.tasker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.uitoolkit.ui.ConsoleController;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskerController.class)
public class TaskerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TaskerServiceLayer service;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void postTask() throws Exception {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(2);
        tvm.setDescription("Description");
        tvm.setCreateDate(LocalDate.of(2019,02, 15));
        tvm.setDueDate(LocalDate.of(2019, 03, 01));
        tvm.setCategory("Todo");
//        tvm.setAdvertisement("AD");

        String inputJson = mapper.writeValueAsString(tvm);

        TaskViewModel tvm2 = new TaskViewModel();
        tvm2.setDescription("Description");
        tvm2.setCreateDate(LocalDate.of(2019,02, 15));
        tvm2.setDueDate(LocalDate.of(2019, 03, 01));
        tvm2.setCategory("Todo");
//        tvm2.setAdvertisement("AD");
        tvm2.setId(2);

        String outputJson = mapper.writeValueAsString(tvm2);

        when(service.newTask(tvm)).thenReturn(tvm2);

        mockMvc.perform(post("/tasks")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                        .andDo(print())
                        .andExpect(status().isCreated())
                        .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllTasks() throws Exception {
        TaskViewModel tvm2 = new TaskViewModel();
        tvm2.setDescription("Description");
        tvm2.setCreateDate(LocalDate.of(2019,02, 15));
        tvm2.setDueDate(LocalDate.of(2019, 03, 01));
        tvm2.setCategory("Todo");
        tvm2.setId(2);

        List<TaskViewModel> tasks = new ArrayList<>();
        tasks.add(tvm2);

        when(service.fetchAllTasks()).thenReturn(tasks);

        List<TaskViewModel> tasks2 = new ArrayList<>();
        tasks2.addAll(tasks);

        String outputJson = mapper.writeValueAsString(tasks2);

        this.mockMvc.perform(get("/tasks"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTaskById() throws Exception {

        TaskViewModel tvm2 = new TaskViewModel();
        tvm2.setDescription("Description");
        tvm2.setCreateDate(LocalDate.of(2019,02, 15));
        tvm2.setDueDate(LocalDate.of(2019, 03, 01));
        tvm2.setCategory("Todo");
        tvm2.setId(2);

        String outputJson = mapper.writeValueAsString(tvm2);

        when(service.fetchTask(2)).thenReturn(tvm2);

        this.mockMvc.perform(get("/tasks/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTaskByCategory() throws Exception {
        TaskViewModel tvm2 = new TaskViewModel();
        tvm2.setDescription("Description");
        tvm2.setCreateDate(LocalDate.of(2019,02, 15));
        tvm2.setDueDate(LocalDate.of(2019, 03, 01));
        tvm2.setCategory("Todo");
        tvm2.setId(2);

        String inputJson = mapper.writeValueAsString(tvm2);

        List<TaskViewModel> tasks = new ArrayList<>();
        tasks.add(tvm2);

        when(service.fetchTasksByCategory("Todo")).thenReturn(tasks);

        this.mockMvc.perform(get("/tasks/category/todo"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(inputJson));
    }

    @Test
    public void updateTask() throws Exception {
        TaskViewModel tvm2 = new TaskViewModel();
        tvm2.setDescription("Description");
        tvm2.setCreateDate(LocalDate.of(2019,02, 15));
        tvm2.setDueDate(LocalDate.of(2019, 03, 01));
        tvm2.setCategory("Todo");
        tvm2.setId(2);

        String inputJson = mapper.writeValueAsString(tvm2);

        this.mockMvc.perform(put("/tasks")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteTask() throws Exception {
        this.mockMvc.perform(delete("/tasks/2"))
                .andDo(print())
                .andExpect(status().isNoContent())
                .andExpect(content().string(""));
    }
}