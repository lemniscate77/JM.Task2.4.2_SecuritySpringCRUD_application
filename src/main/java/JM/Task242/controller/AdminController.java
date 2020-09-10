package JM.Task242.controller;

import JM.Task242.model.User;
import JM.Task242.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/admin")
public class AdminController {

    private UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userList", this.userService.allUsers());
        return "users";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if(user.getId() == 0){
            this.userService.add(user);
        }else{
            this.userService.edit(user);
        }
        return "redirect:/admin";
    }

//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public ModelAndView deleteUser(@PathVariable("id") Long id) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/admin");
//        User user = userService.getById(id);
//        userService.delete(id);
//        return modelAndView;
//    }

    @RequestMapping("/remove/{id}")
    public String removeUser(@PathVariable("id") Long id) {
        this.userService.delete(id);
        return "redirect:/admin";
    }

//    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
//    public ModelAndView editPage(@PathVariable("id") Long id) {
//        User user = userService.getById(id);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("editPage");
//        modelAndView.addObject("user", user);
//        return modelAndView;
//    }

    @RequestMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editPage";
    }

//    @RequestMapping(value = "/edit", method = RequestMethod.POST)
//    public ModelAndView editUser(@ModelAttribute("user") User user) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("redirect:/admin");
//        userService.edit(user);
//        return modelAndView;
//    }

    @RequestMapping("/update/{id}")
    public String updateUser(@PathVariable("id") Long id, User user, Model model) {
        userService.edit(user);
        model.addAttribute("users", userService.allUsers());
        return "redirect:/admin";
    }


}
