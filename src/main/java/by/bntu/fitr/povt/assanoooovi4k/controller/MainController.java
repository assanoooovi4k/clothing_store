package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.model.entity.Item;
import by.bntu.fitr.povt.assanoooovi4k.model.entity.User;
import by.bntu.fitr.povt.assanoooovi4k.repository.ItemRepository;
import by.bntu.fitr.povt.assanoooovi4k.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public ModelAndView indexPage(){
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
        return new ModelAndView(
                "index", "items", itemRepository.findAllByIdIsNotNullOrderById()
        );
    }

    @GetMapping(value = "/auth")
    public String getAuthPage(){
        return "auth";
    }

    @GetMapping(value = "/registration")
    public String getRegistrationPage(){
        return "registration";
    }

    @PostMapping(value = "/registration")
    public String registerUser(User user){
        System.out.println(user);
        int length = user.getPassword().length();
        if (length >= 6 && length <= 15){
            user.setStatus(false);
            user.setRole("ROLE_USER");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
        return "redirect:/auth";
    }


    @GetMapping(value = "/product/{id}")
    public ModelAndView findProductById(@PathVariable Long id){
        Optional<Item> byId = itemRepository.findById(id);
        return byId.map(item -> new ModelAndView("itemPage", "item", item))
                .orElseGet(() -> new ModelAndView("redirect:/"));
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Item> items = itemRepository.findAll();

        model.put("items", items);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam Integer price,
                      Map<String, Object> model) {
        Item item = new Item(name, price);

        itemRepository.save(item);

        Iterable<Item> items = itemRepository.findAll();

        model.put("items", items);

        return "main";
    }


    @PostMapping("filter")
    public  String filter(@RequestParam String filter,
                          Map<String, Object> model) {
        Iterable<Item> items;

        if(filter != null && !filter.isEmpty()) {
            items = itemRepository.findByName(filter);
        } else {
            items = itemRepository.findAll();
        }


        model.put("items", items);

        return "main";
    }
}



