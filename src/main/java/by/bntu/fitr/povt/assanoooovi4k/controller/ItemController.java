package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.model.entity.Item;
import by.bntu.fitr.povt.assanoooovi4k.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping(value = "/item/{id}")
    public ModelAndView checkArticle(@PathVariable Long id){
        Optional<Item> itemById = itemRepository.findById(id);
        return new ModelAndView("singleItem", "item", itemById.get());
    }

    @GetMapping(value = "/items/{type}")
    public ModelAndView searchByType(@PathVariable String type){
        List<Item> itemsByType = itemRepository.findByType(type);
        return new ModelAndView("index", "items",itemsByType);
    }

    @GetMapping(value = "/items/{name}")
    public ModelAndView searchByName(@PathVariable String name){
        List<Item> itemsByName = itemRepository.findByName(name);
        return new ModelAndView("index", "items",itemsByName);
    }

    @GetMapping(value = "/items/{price}")
    public ModelAndView searchByPrice(@PathVariable Integer price){
        List<Item> itemsByPrice = itemRepository.findByPrice(price);
        return new ModelAndView("index", "items",itemsByPrice);
    }
}
