package com.example.codegym.controller;

import com.example.codegym.dto.ProductDTO;
import com.example.codegym.model.Cart;
import com.example.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public Cart setUpCart(){
        return new Cart();
    }

    @GetMapping("")
    public String showProduct(Model model){
        model.addAttribute("productImgDTOList", iProductService.listImg());
        return "/list";
    }

    @GetMapping("/detail")
    public String detailProduct(@RequestParam Integer id, Model model){
        model.addAttribute("productDTO", iProductService.findById(id));
        return "/detail";
    }
    @GetMapping("/shop")
    public String shop(Model model){
        model.addAttribute("productDTOList", iProductService.listAll());
        return "/shop";
    }
    @GetMapping("/add")
    public String addToCart(@RequestParam(required = false) Integer id,
                            @RequestParam(required = false) String action,
                            @ModelAttribute Cart cart){
        ProductDTO productDTO = iProductService.findById(id);
        if (productDTO == null){
            return "/error";
        }
        if (action.equals("show")){
            cart.addProduct(productDTO);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productDTO);
        return "redirect:/product";
    }
    @GetMapping("/decrease")
    public String deleteFromCart(@RequestParam(required = false) Integer id,
                            @RequestParam(required = false) String action,
                            @ModelAttribute Cart cart){
        ProductDTO productDTO = iProductService.findById(id);
        if (productDTO == null){
            return "/error";
        }
        if (action.equals("shows")){
            cart.deleteProduct(productDTO);
            return "redirect:/shopping-cart";
        }
        cart.addProduct(productDTO);
        return "redirect:/product";
    }
}
