package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.service.CustomerServiceLayer;
import com.company.U1M6Summative.service.InvoiceServiceLayer;
import com.company.U1M6Summative.service.ItemServiceLayer;
import com.company.U1M6Summative.viewmodel.ItemViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemServiceLayer itemService;
    @Autowired
    private CustomerServiceLayer customerService;
    @Autowired
    private InvoiceServiceLayer invoiceService;

    @RequestMapping(value="/item", method = RequestMethod.POST)
    public ItemViewModel createItem(@RequestBody ItemViewModel item){

        return itemService.addItemView(item);
    }

    @RequestMapping(value="/item", method = RequestMethod.GET)
    public List<ItemViewModel> getAllItems(){

        return itemService.getAllItemView();
    }

    @RequestMapping(value="/item/{itemId}", method = RequestMethod.GET)
    public ItemViewModel getItemById(@PathVariable int itemId){
        return itemService.getItemView(itemId);
    }

    @RequestMapping(value="/item/{itemId}", method = RequestMethod.PUT)
    public void updateItem(@PathVariable int itemId, @RequestBody ItemViewModel item){

        itemService.updateItemView(item);

    }

    @RequestMapping(value="/item/{itemId}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable int itemId){

        itemService.deleteItemView(itemId);

    }

}
