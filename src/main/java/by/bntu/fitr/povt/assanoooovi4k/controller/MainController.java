package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.domain.Item;
import by.bntu.fitr.povt.assanoooovi4k.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
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



