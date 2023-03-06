package com.example.blogapp.controller;

import com.example.blogapp.model.Blog;
import com.example.blogapp.service.IBlogService;
import com.example.blogapp.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("blogList", iBlogService.listAll());
        return "/list";
    }

    @GetMapping("")
    public String showListAndSearch(Model model, @RequestParam(name = "names", required = false)String title,
                                    @PageableDefault(size = 3)Pageable pageable){
        Page<Blog> blogPage = title == null
                ? this.iBlogService.getBlog(pageable)
                : this.iBlogService.searchBlog(title, pageable);
        model.addAttribute("blogPages", blogPage);
        model.addAttribute("nameSearch", title);
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < blogPage.getTotalPages();i++){
            integers.add(i);
        }
        model.addAttribute("pages", integers);
        return "/list";
    }

    @GetMapping("/create-form")
    public String createForm(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.listAll());
        return "/create";
    }
    @PostMapping("/create")
    public String blogCreate(@ModelAttribute Blog blog, Model model){
        iBlogService.create(blog);
        return "redirect:/blog";
    }
    @GetMapping("/update-form/{id}")
    public  String updateForm(@PathVariable int id, Model model){
        model.addAttribute("blogs", iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.listAll());
        return "/update";
    }
    @PostMapping("/update")
    public String blogUpdate(Blog blog){
        iBlogService.update(blog);
        return "redirect:/blog";
    }
    @GetMapping("/delete/{id}")
    public String delete(@RequestParam int deleteId){
        iBlogService.delete(deleteId);
        return "redirect:/blog";
    }
}
