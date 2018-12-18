package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.dto.OrderDto;
import by.bntu.fitr.povt.assanoooovi4k.model.entity.BoughtItem;
import by.bntu.fitr.povt.assanoooovi4k.model.entity.Item;
import by.bntu.fitr.povt.assanoooovi4k.model.entity.User;
import by.bntu.fitr.povt.assanoooovi4k.repository.BoughtRepository;
import by.bntu.fitr.povt.assanoooovi4k.repository.ItemRepository;
import by.bntu.fitr.povt.assanoooovi4k.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Secured("ROLE_USER")
@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BoughtRepository boughtRepository;

    @GetMapping(value = "/order")
    public ModelAndView orderItemPage(@RequestParam Long item) {
        Optional<Item> byId = itemRepository.findById(item);
        return byId.map(item1 -> new ModelAndView("orderPage", "item", item1))
                .orElseGet(() -> new ModelAndView("redirect:/"));
    }

    @PostMapping(value = "/order")
    public ModelAndView orderItem(OrderDto orderDto) {
        Optional<Item> byId = itemRepository.findById(orderDto.getItemId());
        Item item;
        User byUsername = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if (byId.isPresent()) {
            item = byId.get();
        } else {
            return new ModelAndView("redirect:/");
        }
        boughtRepository.saveItem(byUsername.getId(),item.getId(),"payed");
        return new ModelAndView("redirect:/ordered");
    }

    @GetMapping(value = "/ordered")
    public ModelAndView orderedPage() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        User byUsername = userRepository.findByUsername(name);
        List<BoughtItem> boughtItemsByUser = boughtRepository.findByUserId(byUsername.getId());
        System.out.println(boughtItemsByUser);
        return new ModelAndView(
                "orderedPage",
                "items",
                boughtItemsByUser
        );
    }

}
