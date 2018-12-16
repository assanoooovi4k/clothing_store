package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.model.entity.User;
import by.bntu.fitr.povt.assanoooovi4k.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Secured("ROLE_USER")
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/me")
    public ModelAndView getUserPage(){
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User userEntity = userRepository.findByUsername(name);
//        User  user;
//        if (userEntity!=null){
//            user = new User(userEntity, userPostsDao.findArticlesByUser(userEntity.getId()));
//        }else{
//            return new ModelAndView("redirect:/auth");
//        }
        return new ModelAndView("userPage", "user", userEntity);
    }
}
