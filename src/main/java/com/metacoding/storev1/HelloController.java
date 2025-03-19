package com.metacoding.storev1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// @Controller
public class HelloController {

    @GetMapping("/log/list")
    public String t1() {
        return "log/list";
    }

    @GetMapping("/store/list")
    public String t2() {
        return "store/list";
    }

    @GetMapping("/store/detail")
    public String t3() {
        return "store/detail";
    }

    @GetMapping("/store/save-form")
    public String t4() {
        return "store/save-form";
    }

    @GetMapping("/store/update-form")
    public String t5() {
        return "store/update-form";
    }

}