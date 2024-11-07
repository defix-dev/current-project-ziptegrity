package com.elemply.controllers.vueRedirector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class VueRedirector {
    @GetMapping("/services/{path:[^.]*}") // Все пути без точки (файлы) будут обрабатываться
    public String redirect(@PathVariable String path) {
        return "index";
    }
}
