package com.example.warehouseprofi.web;

import com.example.warehouseprofi.dtos.add.AddUserDto;
import com.example.warehouseprofi.services.RoleService;
import com.example.warehouseprofi.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    private RoleService roleService;



    @GetMapping("/add")
    public String addUser(Model model){
        model.addAttribute("availableRoles", roleService.allRoles());

        return "user-add";
    }


    @ModelAttribute("userModel")
    public AddUserDto initUser() {
        return new AddUserDto();
    }


    @PostMapping("/add")
    public String addUser(@Valid AddUserDto userModel, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
                    bindingResult);
            return "redirect:/users/add";
        }

        userService.addUser(userModel);

        return "redirect:/";
    }


    @GetMapping("/all")
    public String showAllUsers(Model model){
        model.addAttribute("allUsers", userService.allUsers());

        return "user-all";
    }

    @GetMapping("/user-delete/{username}")
    public String deleteUser(@PathVariable("username") String username){
        userService.deleteUser(username);

        return "redirect:/users/all";
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
