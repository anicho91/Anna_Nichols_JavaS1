package com.trilogyed.tasker.dao;

import com.trilogyed.tasker.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoTest {

    @Autowired
    TaskerDao dao;

    @Before
    public void setUp() throws Exception {

        List<Task> tasks = dao.getAllTasks();
        tasks.stream().forEach(Task -> dao.deleteTask(Task.getId()));

    }

    private static Task task;
        static {
            task = new Task();
            task.setId(1);
            task.setDescription("Description");
            task.setCreateDate(LocalDate.of(2019,3,20));
            task.setDueDate(LocalDate.of(2019,10,1));
            task.setCategory("Todo");
        }

    @Test
    public void createTask() {
        task.setId(0);

        dao.createTask(task);

        List<Task> tasks = dao.getAllTasks();
        assertEquals(1, tasks.size());
    }

    @Test
    public void getTask() {
        dao.createTask(task);
        Task task1 = dao.getTask(task.getId());
        assertEquals(task1, task);
    }

    @Test
    public void getAllTasks() {
        dao.createTask(task);
        List<Task> tasks = dao.getAllTasks();
        assertEquals(1,tasks.size());
    }

    @Test
    public void getTasksByCategory() {
        dao.createTask(task);

        List<Task> tasks = dao.getTasksByCategory(task.getCategory());
        assertEquals("Todo", task.getCategory());
    }

    @Test
    public void updateTask() {
        dao.createTask(task);
        task.setCategory("Task");

        dao.updateTask(task);

        Task task1 = dao.getTask(task.getId());

        assertEquals(task1, task);

    }

    @Test
    public void deleteTask() {
        dao.createTask(task);

        dao.deleteTask(task.getId());

        Task task1 = dao.getTask(task.getId());

        assertNull(task1);
    }
}