package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.dto.Item;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemController {
    private List<Item> itemsList = new ArrayList<>();

    @RequestMapping(value = "/item", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Item postItem(@RequestBody @Valid Item item) {
        itemsList.add(item);

        return item;
    }

    @RequestMapping(value = "/item", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Item> getItems() {

        return itemsList;
    }

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Item getOneItem(@PathVariable int itemId) {
        for (Item item : itemsList) {
            if (item.getId().equals(itemId)) {
                return item;
            }
        }

        throw new IllegalArgumentException("Item not found");
    }

    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteItem(@PathVariable int itemId) {

        itemsList.remove(itemId);
    }

//    @RequestMapping(value = "/item/{itemId}", method = RequestMethod.PUT)
//    @ResponseStatus(value = HttpStatus.OK)
//    public void updateItem(@PathVariable int itemId, @RequestBody Item item) {
//
//    }
}
