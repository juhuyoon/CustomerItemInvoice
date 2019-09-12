package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.dao.ItemRepository;
import com.company.U1M6Summative.dto.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ItemController {
    @Autowired
    ItemRepository itemRepo;

    private List<Item> itemList = new ArrayList<>();

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Item postItem(@RequestBody @Valid Item item) {
        return itemRepo.save(item);
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Item> getItems() {

        return itemRepo.findAll();
    }

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Item getOneItem(@PathVariable int itemId) {
        Optional<Item> item = itemRepo.findById(itemId);
        if(!item.isPresent())
            throw new IllegalArgumentException("Item not found");

        return item.get();
    }

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteItem(@PathVariable int itemId) {

        itemRepo.deleteById(itemId);
    }

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateItem(@PathVariable int itemId, @RequestBody Item item) {
        Optional<Item> itemOp = itemRepo.findById(itemId);

        item.setId(itemId);
        itemRepo.save(item);
    }
}
