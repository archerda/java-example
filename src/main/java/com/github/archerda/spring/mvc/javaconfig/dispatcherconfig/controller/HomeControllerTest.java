// package com.github.archerda.spring.mvc.javaconfig.dispatcherconfig.controller;
//
// import org.junit.Test;
// import org.springframework.test.web.servlet.MockMvc;
//
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
// import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
// /**
//  * Created by archerda on 2017/11/24.
//  */
// public class HomeControllerTest {
//
//     @Test
//     public void testHome() throws Exception {
//         HomeController homeController = new HomeController();
//         MockMvc mockMvc = standaloneSetup(homeController).build();
//         mockMvc.perform(get("/")).andExpect(view().name("home"));
//     }
//
// }