// package com.github.archerda.spring.mvc.javaconfig.dispatcherconfig.controller;
//
// import com.github.archerda.spring.mvc.javaconfig.dispatcherconfig.model.Spittle;
// import com.github.archerda.spring.mvc.javaconfig.dispatcherconfig.respository.SpitterRepository;
// import org.junit.Test;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.web.servlet.view.InternalResourceView;
//
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
//
// import static org.junit.matchers.JUnitMatchers.hasItems;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
// import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
// /**
//  * Created by archerda on 2017/11/24.
//  */
// public class SpittleControllerTest {
//     @Test
//     public void testSpittles() throws Exception {
//         List<Spittle> expectedSpittles = createSpittleList(20);
//         SpitterRepository mockRepository = mock(SpitterRepository.class);
//         when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
//                 .thenReturn(expectedSpittles);
//
//         SpittleController controller = new SpittleController(mockRepository);
//
//         // Mock SpringMVC
//         MockMvc mockMvc = standaloneSetup(controller)
//                 .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
//                 .build();
//
//         mockMvc.perform(get("/spittels"))
//                 .andExpect(view().name("spittels"))
//                 .andExpect(model().attributeExists("spittleList"))
//                 .andExpect(model().attribute("sppittleList", hasItems(expectedSpittles.toArray())));
//     }
//
//     private List<Spittle> createSpittleList(int count) {
//         List<Spittle> spittles = new ArrayList<Spittle>(count);
//         for (int i = 0; i < count; ++i) {
//             spittles.add(new Spittle("Spittle" + i, new Date()));
//         }
//
//         return spittles;
//     }
//
// }package com.github.archerda.spring.mvc.javaconfig.dispatcherconfig.controller;
//
// import com.github.archerda.spring.mvc.javaconfig.dispatcherconfig.model.Spittle;
// import com.github.archerda.spring.mvc.javaconfig.dispatcherconfig.respository.SpitterRepository;
// import org.junit.Test;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.web.servlet.view.InternalResourceView;
//
// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;
//
// import static org.junit.matchers.JUnitMatchers.hasItems;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
// import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
// /**
//  * Created by archerda on 2017/11/24.
//  */
// public class SpittleControllerTest {
//     @Test
//     public void testSpittles() throws Exception {
//         List<Spittle> expectedSpittles = createSpittleList(20);
//         SpitterRepository mockRepository = mock(SpitterRepository.class);
//         when(mockRepository.findSpittles(Long.MAX_VALUE, 20))
//                 .thenReturn(expectedSpittles);
//
//         SpittleController controller = new SpittleController(mockRepository);
//
//         // Mock SpringMVC
//         MockMvc mockMvc = standaloneSetup(controller)
//                 .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
//                 .build();
//
//         mockMvc.perform(get("/spittels"))
//                 .andExpect(view().name("spittels"))
//                 .andExpect(model().attributeExists("spittleList"))
//                 .andExpect(model().attribute("sppittleList", hasItems(expectedSpittles.toArray())));
//     }
//
//     private List<Spittle> createSpittleList(int count) {
//         List<Spittle> spittles = new ArrayList<Spittle>(count);
//         for (int i = 0; i < count; ++i) {
//             spittles.add(new Spittle("Spittle" + i, new Date()));
//         }
//
//         return spittles;
//     }
//
// }