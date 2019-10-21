package com.company.AnnaNicholsU1Capstone.controller;

import com.company.AnnaNicholsU1Capstone.service.GameServiceLayer;
import com.company.AnnaNicholsU1Capstone.viewmodel.GameViewModel;
import com.company.AnnaNicholsU1Capstone.viewmodel.GameViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(GameController.class)
public class GameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GameServiceLayer gameService;

    @MockBean
    DataSource dataSource;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    @WithAnonymousUser
    public void createGameTest() throws Exception {
        GameViewModel gvm = new GameViewModel();
        gvm.setTitle("God of War");
        gvm.setEsrbRating("M");
        gvm.setDescription("Action Adventure");
        gvm.setPrice(new BigDecimal("30.00"));
        gvm.setStudio("Santa Monica");
        gvm.setQuantity(new BigDecimal("6"));

        String inputJson = mapper.writeValueAsString(gvm);

        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("God of War");
        gvm2.setEsrbRating("M");
        gvm2.setDescription("Action Adventure");
        gvm2.setPrice(new BigDecimal("30.00"));
        gvm2.setStudio("Santa Monica");
        gvm2.setQuantity(new BigDecimal("6"));
        gvm2.setId(2);

        String outputJson = mapper.writeValueAsString(gvm2);

        when(gameService.addGameVm(gvm)).thenReturn(gvm2);

        this.mockMvc.perform(post("/game")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockNewUser
    public void createGameTestWithNewUser() throws Exception {
        GameViewModel gvm = new GameViewModel();
        gvm.setTitle("God of War");
        gvm.setEsrbRating("M");
        gvm.setDescription("Action Adventure");
        gvm.setPrice(new BigDecimal("30.00"));
        gvm.setStudio("Santa Monica");
        gvm.setQuantity(new BigDecimal("6"));

        String inputJson = mapper.writeValueAsString(gvm);

        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("God of War");
        gvm2.setEsrbRating("M");
        gvm2.setDescription("Action Adventure");
        gvm2.setPrice(new BigDecimal("30.00"));
        gvm2.setStudio("Santa Monica");
        gvm2.setQuantity(new BigDecimal("6"));
        gvm2.setId(2);

        String outputJson = mapper.writeValueAsString(gvm2);

        when(gameService.addGameVm(gvm)).thenReturn(gvm2);

        this.mockMvc.perform(post("/game")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockStaffMember
    public void createGameTestWithStaffMember() throws Exception {
        GameViewModel gvm = new GameViewModel();
        gvm.setTitle("God of War");
        gvm.setEsrbRating("M");
        gvm.setDescription("Action Adventure");
        gvm.setPrice(new BigDecimal("30.00"));
        gvm.setStudio("Santa Monica");
        gvm.setQuantity(new BigDecimal("6"));

        String inputJson = mapper.writeValueAsString(gvm);

        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("God of War");
        gvm2.setEsrbRating("M");
        gvm2.setDescription("Action Adventure");
        gvm2.setPrice(new BigDecimal("30.00"));
        gvm2.setStudio("Santa Monica");
        gvm2.setQuantity(new BigDecimal("6"));
        gvm2.setId(2);

        String outputJson = mapper.writeValueAsString(gvm2);

        when(gameService.addGameVm(gvm)).thenReturn(gvm2);

        this.mockMvc.perform(post("/game")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockManager
    public void createGameTestWithManager() throws Exception {
        GameViewModel gvm = new GameViewModel();
        gvm.setTitle("God of War");
        gvm.setEsrbRating("M");
        gvm.setDescription("Action Adventure");
        gvm.setPrice(new BigDecimal("30.00"));
        gvm.setStudio("Santa Monica");
        gvm.setQuantity(new BigDecimal("6"));

        String inputJson = mapper.writeValueAsString(gvm);

        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("God of War");
        gvm2.setEsrbRating("M");
        gvm2.setDescription("Action Adventure");
        gvm2.setPrice(new BigDecimal("30.00"));
        gvm2.setStudio("Santa Monica");
        gvm2.setQuantity(new BigDecimal("6"));
        gvm2.setId(2);

        String outputJson = mapper.writeValueAsString(gvm2);

        when(gameService.addGameVm(gvm)).thenReturn(gvm2);

        this.mockMvc.perform(post("/game")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    @WithMockAdmin
    public void createGameTestWithAdmin() throws Exception {
        GameViewModel gvm = new GameViewModel();
        gvm.setTitle("God of War");
        gvm.setEsrbRating("M");
        gvm.setDescription("Action Adventure");
        gvm.setPrice(new BigDecimal("30.00"));
        gvm.setStudio("Santa Monica");
        gvm.setQuantity(new BigDecimal("6"));

        String inputJson = mapper.writeValueAsString(gvm);

        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("God of War");
        gvm2.setEsrbRating("M");
        gvm2.setDescription("Action Adventure");
        gvm2.setPrice(new BigDecimal("30.00"));
        gvm2.setStudio("Santa Monica");
        gvm2.setQuantity(new BigDecimal("6"));
        gvm2.setId(2);

        String outputJson = mapper.writeValueAsString(gvm2);

        when(gameService.addGameVm(gvm)).thenReturn(gvm2);

        this.mockMvc.perform(post("/game")
                            .with(csrf().asHeader())
                            .content(inputJson)
                            .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllGamesTest() throws Exception {
        GameViewModel gvm = new GameViewModel();
        gvm.setTitle("God of War");
        gvm.setEsrbRating("M");
        gvm.setDescription("Action Adventure");
        gvm.setPrice(new BigDecimal("30.00"));
        gvm.setStudio("Santa Monica");
        gvm.setQuantity(new BigDecimal("6"));
        gvm.setId(2);

        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("Quest for Glory");
        gvm2.setEsrbRating("T");
        gvm2.setDescription("Point and Click Action Adventure");
        gvm2.setPrice(new BigDecimal("10.00"));
        gvm2.setStudio("Sierra");
        gvm2.setQuantity(new BigDecimal("16"));
        gvm2.setId(3);

        List<GameViewModel> gvmList = new ArrayList<>();
        gvmList.add(gvm);
        gvmList.add(gvm2);

        when(gameService.getAllGamesVm()).thenReturn(gvmList);

        List<GameViewModel> gvmList2 = new ArrayList<>();
        gvmList2.addAll(gvmList);

        String outputJson = mapper.writeValueAsString(gvmList2);

        this.mockMvc.perform(get("/game"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getGameByIdTest() throws Exception {
        GameViewModel gvm = new GameViewModel();
        gvm.setTitle("God of War");
        gvm.setEsrbRating("M");
        gvm.setDescription("Action Adventure");
        gvm.setPrice(new BigDecimal("30.00"));
        gvm.setStudio("Santa Monica");
        gvm.setQuantity(new BigDecimal("6"));
        gvm.setId(2);

        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("Quest for Glory");
        gvm2.setEsrbRating("T");
        gvm2.setDescription("Point and Click Action Adventure");
        gvm2.setPrice(new BigDecimal("10.00"));
        gvm2.setStudio("Sierra");
        gvm2.setQuantity(new BigDecimal("16"));
        gvm2.setId(3);

        String outputJson = mapper.writeValueAsString(gvm);

        when(gameService.getGameVm(2)).thenReturn(gvm);

        this.mockMvc.perform(get("/game/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    @WithAnonymousUser
    public void updateGameTestWithAnon() throws Exception {
        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("Quest for Glory");
        gvm2.setEsrbRating("T");
        gvm2.setDescription("Point and Click Action Adventure");
        gvm2.setPrice(new BigDecimal("10.00"));
        gvm2.setStudio("Sierra");
        gvm2.setQuantity(new BigDecimal("16"));
        gvm2.setId(3);

        String inputJson = mapper.writeValueAsString(gvm2);

        this.mockMvc.perform(put("/game")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isUnauthorized());

    }

    @Test
    @WithMockNewUser
    public void updateGameTestWithNewUser() throws Exception {
        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("Quest for Glory");
        gvm2.setEsrbRating("T");
        gvm2.setDescription("Point and Click Action Adventure");
        gvm2.setPrice(new BigDecimal("10.00"));
        gvm2.setStudio("Sierra");
        gvm2.setQuantity(new BigDecimal("16"));
        gvm2.setId(3);

        String inputJson = mapper.writeValueAsString(gvm2);

        this.mockMvc.perform(put("/game")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isForbidden());

    }

    @Test
    @WithMockStaffMember
    public void updateGameTestWithStaffMember() throws Exception {
        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("Quest for Glory");
        gvm2.setEsrbRating("T");
        gvm2.setDescription("Point and Click Action Adventure");
        gvm2.setPrice(new BigDecimal("10.00"));
        gvm2.setStudio("Sierra");
        gvm2.setQuantity(new BigDecimal("16"));
        gvm2.setId(3);

        String inputJson = mapper.writeValueAsString(gvm2);

        this.mockMvc.perform(put("/game")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    @WithMockManager
    public void updateGameTestWithManager() throws Exception {
        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("Quest for Glory");
        gvm2.setEsrbRating("T");
        gvm2.setDescription("Point and Click Action Adventure");
        gvm2.setPrice(new BigDecimal("10.00"));
        gvm2.setStudio("Sierra");
        gvm2.setQuantity(new BigDecimal("16"));
        gvm2.setId(3);

        String inputJson = mapper.writeValueAsString(gvm2);

        this.mockMvc.perform(put("/game")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    @WithMockAdmin
    public void updateGameTestWithAdmin() throws Exception {
        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("Quest for Glory");
        gvm2.setEsrbRating("T");
        gvm2.setDescription("Point and Click Action Adventure");
        gvm2.setPrice(new BigDecimal("10.00"));
        gvm2.setStudio("Sierra");
        gvm2.setQuantity(new BigDecimal("16"));
        gvm2.setId(3);

        String inputJson = mapper.writeValueAsString(gvm2);

        this.mockMvc.perform(put("/game")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    @WithAnonymousUser
    public void deleteGameTestWithAnon() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/game/2")
                .with(csrf().asHeader()))
                .andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockNewUser
    public void deleteGameTestWithNewMember() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/game/2")
                .with(csrf().asHeader()))
                .andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    @WithMockStaffMember
    public void deleteGameTestWithStaffMember() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/game/2")
                .with(csrf().asHeader()))
                .andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    @WithMockManager
    public void deleteGameTestWithManager() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/game/2")
                .with(csrf().asHeader()))
                .andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    @WithMockAdmin
    public void deleteGameTestWithAdmin() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/game/2")
                .with(csrf().asHeader()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    @WithMockAdmin
    public void test400ErrorWhenPostingGame() throws Exception{
        GameViewModel gvm = new GameViewModel();

        this.mockMvc.perform(post("/game")
                .with(csrf().asHeader()))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getGame422ErrorTest() throws Exception{

        String id422Game = "z";

        this.mockMvc.perform(get("/game/" + id422Game))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void getGame404ErrorTest() throws Exception{
        GameViewModel gvm = new GameViewModel();

        int id404Game = 10;

        when(gameService.getGameVm(id404Game)).thenReturn(gvm);

        this.mockMvc.perform(get("/game" + id404Game))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockAdmin
    public void postGame405ErrorTest() throws Exception{

        int id405Game = 10;

        this.mockMvc.perform(post("/game/" + id405Game)
                .with(csrf().asHeader()))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());

    }

    @Test
    @WithMockAdmin
    public void putGame415ErrorTest() throws Exception{

        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("Quest for Glory");
        gvm2.setEsrbRating("T");
        gvm2.setDescription("Point and Click Action Adventure");
        gvm2.setPrice(new BigDecimal("10.00"));
        gvm2.setStudio("Sierra");
        gvm2.setQuantity(new BigDecimal("16"));
        gvm2.setId(3);

        String inputJson = mapper.writeValueAsString(gvm2);

        this.mockMvc.perform(put("/game")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_XML))
                .andDo(print())
                .andExpect(status().isUnsupportedMediaType());

    }

    @Test
    public void getAllGamesByStudio() throws Exception {
        GameViewModel gvm = new GameViewModel();
        gvm.setTitle("God of War");
        gvm.setEsrbRating("M");
        gvm.setDescription("Action Adventure");
        gvm.setPrice(new BigDecimal("30.00"));
        gvm.setStudio("Santa Monica");
        gvm.setQuantity(new BigDecimal("6"));
        gvm.setId(2);

        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("Quest for Glory");
        gvm2.setEsrbRating("T");
        gvm2.setDescription("Point and Click Action Adventure");
        gvm2.setPrice(new BigDecimal("10.00"));
        gvm2.setStudio("Sierra");
        gvm2.setQuantity(new BigDecimal("16"));
        gvm2.setId(3);

        List<GameViewModel> gvmList = new ArrayList<>();
        gvmList.add(gvm);
        gvmList.add(gvm2);

        when(gameService.getAllGamesByStudioVm(gvm2.getStudio())).thenReturn(gvmList);

        List<GameViewModel> gvmList2 = new ArrayList<>();
        gvmList2.addAll(gvmList);

        String outputJson = mapper.writeValueAsString(gvmList2);

        this.mockMvc.perform(get("/game/studio/Sierra"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllGamesByRating() throws Exception {
        GameViewModel gvm = new GameViewModel();
        gvm.setTitle("God of War");
        gvm.setEsrbRating("M");
        gvm.setDescription("Action Adventure");
        gvm.setPrice(new BigDecimal("30.00"));
        gvm.setStudio("Santa Monica");
        gvm.setQuantity(new BigDecimal("6"));
        gvm.setId(2);

        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("Quest for Glory");
        gvm2.setEsrbRating("T");
        gvm2.setDescription("Point and Click Action Adventure");
        gvm2.setPrice(new BigDecimal("10.00"));
        gvm2.setStudio("Sierra");
        gvm2.setQuantity(new BigDecimal("16"));
        gvm2.setId(3);

        List<GameViewModel> gvmList = new ArrayList<>();
        gvmList.add(gvm);
        gvmList.add(gvm2);

        when(gameService.getAllGamesByRatingVm(gvm.getEsrbRating())).thenReturn(gvmList);

        List<GameViewModel> gvmList2 = new ArrayList<>();
        gvmList2.addAll(gvmList);

        String outputJson = mapper.writeValueAsString(gvmList2);

        this.mockMvc.perform(get("/game/rating/M"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllGamesByTitle() throws Exception {
        GameViewModel gvm = new GameViewModel();
        gvm.setTitle("God of War");
        gvm.setEsrbRating("M");
        gvm.setDescription("Action Adventure");
        gvm.setPrice(new BigDecimal("30.00"));
        gvm.setStudio("Santa Monica");
        gvm.setQuantity(new BigDecimal("6"));
        gvm.setId(2);

        GameViewModel gvm2 = new GameViewModel();
        gvm2.setTitle("Quest for Glory");
        gvm2.setEsrbRating("T");
        gvm2.setDescription("Point and Click Action Adventure");
        gvm2.setPrice(new BigDecimal("10.00"));
        gvm2.setStudio("Sierra");
        gvm2.setQuantity(new BigDecimal("16"));
        gvm2.setId(3);

        List<GameViewModel> gvmList = new ArrayList<>();
        gvmList.add(gvm);
        gvmList.add(gvm2);

        when(gameService.getAllGamesByTitleVm(gvm2.getTitle())).thenReturn(gvmList);

        List<GameViewModel> gvmList2 = new ArrayList<>();
        gvmList2.addAll(gvmList);

        String outputJson = mapper.writeValueAsString(gvmList2);

        this.mockMvc.perform(get("/game/title/Quest for Glory"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
}