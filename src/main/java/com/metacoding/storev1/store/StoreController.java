package com.metacoding.storev1.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // IoC (제어의 역전)컨테이너에 등록 => HashSet
public class StoreController {

    private StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/")
    public String list() {
        return "store/list";
    }

    @GetMapping("/store/save-form")
    public String saveForm() {
        return "store/save-form";
    }

    @GetMapping("/store/{id}")
    public String detail(@PathVariable("id") int id) {
        return "store/detail";
    }

    @GetMapping("/store/{id}/update-form")
    public String updateForm(@PathVariable("id") int id) {
        return "store/update-form";
    }

    @PostMapping("/store/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        return "redirect:/";
    }

    @PostMapping("/store/save")
    public String save(@RequestParam("name") String name, @RequestParam("stock") int stock,
            @RequestParam("price") int price) {
        System.out.println("name : " + name);
        System.out.println("stock : " + stock);
        System.out.println("price : " + price);
        storeService.상품등록(name, stock, price);
        return "redirect:/";
    }

    @PostMapping("/store/{id}/update")
    public String update(@PathVariable("id") int id) {
        return "redirect:/store/1";
    }

}
