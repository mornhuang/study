package com.huang.j2ee.ch03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import java.util.Map;

/**
 * Created By User : Morn
 * Created DateTime: 2015/4/7 21:25
 * Descriptions    : 学习Spring MVC
 */
@Controller
public class HomeController {
    public static final int DEFAULT_SPITTLES_PER_PAGE = 25;

    private SpitterService spitterService;

    @Inject
    public HomeController(SpitterService spitterService) {
        this.spitterService = spitterService;
    }

    @RequestMapping({"/", "/home"})
    public String showHomePage(Map<String, Object> model) {
        model.put("spittles",
                spitterService.getRecentSpittles(DEFAULT_SPITTLES_PER_PAGE));

        return "home";
    }
}
