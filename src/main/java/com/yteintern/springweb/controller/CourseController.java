package com.yteintern.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CourseController {

    @RequestMapping("/course/{courseId}")
    public void course(@PathVariable String courseId,
                       @RequestParam String name,
                       @RequestParam String instructor) {

        System.out.println("Id: " + courseId + " Course name: " + name + " Instructor: " + instructor);
    }
}
