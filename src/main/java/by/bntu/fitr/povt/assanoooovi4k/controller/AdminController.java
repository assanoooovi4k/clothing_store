package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.model.entity.BoughtItem;
import by.bntu.fitr.povt.assanoooovi4k.model.entity.Item;
import by.bntu.fitr.povt.assanoooovi4k.model.entity.User;
import by.bntu.fitr.povt.assanoooovi4k.repository.BoughtRepository;
import by.bntu.fitr.povt.assanoooovi4k.repository.ItemRepository;
import by.bntu.fitr.povt.assanoooovi4k.repository.UserRepository;
import by.bntu.fitr.povt.assanoooovi4k.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Secured("ROLE_ADMIN")
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BoughtRepository boughtRepository;


    @PostMapping(value = "changeStatusOfItem/{id}/{status}")
    public String changeStatus(@PathVariable Long id, @PathVariable String status){
        Optional<BoughtItem> boughtItem = boughtRepository.findById(id);
        boughtItem.get().setStatus(status);
        boughtRepository.save(boughtItem.get());
        return "redirect:/admin/usersOrders";
    }

    @GetMapping("/removeAndChangeItem")
    public ModelAndView getRemoveAndChangeItemPage(){
        List<Item> items = itemRepository.findAllByIdIsNotNullOrderById();
        System.out.println(items);
        return new ModelAndView(
                "adminItemsPage",
                "items",
                items
        );
    }
    @GetMapping("/usersOrders")
    public ModelAndView getUserOrders(){
        List<BoughtItem> items = boughtRepository.findAll();
        System.out.println(items);
        return new ModelAndView(
                "adminUsersOrders",
                "items",
                items
        );
    }

    @GetMapping(value = "/addItem")
    public String getAddItemPage(){
        return "adminAddItem";
    }

    @PostMapping(value = "/saveItem")
    public String saveItem(Item item, MultipartFile file){
        item.setPathToFile("/img/" + file.getOriginalFilename());
        itemRepository.save(item);
        return "redirect:/product/" + item.getId();
//        try {
//            FileUtil.saveFile(file);
//            Item save = itemRepository.save(item);
//            return "redirect:/product/" + save.getId();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "redirect:/error?message=" + e.getMessage();
//        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editItem(@PathVariable String id){
        Optional<Item> itemById = itemRepository.findById(Long.parseLong(id));
        return new ModelAndView("editItem", "item", itemById.get());
    }

    @PostMapping(value = "/edit/{id}")
    public String updateItemPost(@PathVariable String id, Item item, MultipartFile file){
        if (item!=null){
            try {
                if (!file.getOriginalFilename().equals("")){
                    item.setPathToFile(FileUtil.saveFile(file));
                }else{
                    item.setPathToFile(itemRepository.findById(Long.parseLong(id)).get().getPathToFile());
                }
                itemRepository.save(item);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return "redirect:/admin";
    }

    @GetMapping(value = "")
    public ModelAndView getUsers(){
        List<User> all = userRepository.findAll();
        return new ModelAndView("adminIndex","users",all);
    }

    @PostMapping(value = "/processUser/{id}")
    public String processUser(@PathVariable("id") String userId){
        long id = Long.parseLong(userId);
        Optional<User> userById = userRepository.findById(id);
        userById.get().setStatus(!userById.get().getStatus());
        userRepository.save(userById.get());
        return "redirect:/admin";
    }

    @PostMapping(value = "/remove/{id}")
    public String removeItem(@PathVariable Long id){
        itemRepository.deleteById(id);
        return "redirect:/admin/removeAndChangeItem";
    }
}
