package com.huang.j2ee.ch03;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class HomeControllerTest {
    @Test
    public void showDisplayRecentSpittle() {
        List<Spittle> expectedSpittles = asList(new Spittle(), new Spittle(), new Spittle());

        SpitterService spitterService = mock(SpitterService.class);

        HomeController controller = new HomeController(spitterService);

        HashMap<String, Object> model = new HashMap<String, Object>();
        String viewName = controller.showHomePage(model);

        assertEquals("home", viewName);

        assertSame(expectedSpittles, model.get("spittles"));
        verify(spitterService).getRecentSpittles(HomeController.DEFAULT_SPITTLES_PER_PAGE);
    }
}