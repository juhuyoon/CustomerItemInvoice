//package com.company.U1M6Summative.controller;
//
//import com.company.U1M6Summative.dao.ItemRepository;
//import com.company.U1M6Summative.service.CustomerServiceLayer;
//import com.company.U1M6Summative.service.InvoiceServiceLayer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//public class ItemController {
//    @Autowired
//    ItemRepository itemRepo;
//    @Autowired
//    private CustomerServiceLayer customerService;
//    @Autowired
//    private InvoiceServiceLayer invoiceService;
//
//    @RequestMapping(value="/item", method = RequestMethod.POST)
//    public ItemViewModel createItem(@RequestBody ItemViewModel item){
//
//        return itemService.addItemVM(item);
//    }
//
//    @RequestMapping(value="/item", method = RequestMethod.GET)
//    public List<ItemViewModel> getAllItems(){
//
//        return itemService.getAllItemsVM();
//    }
//
//    @RequestMapping(value="/item/{itemId}", method = RequestMethod.GET)
//    public ItemViewModel getItemById(@PathVariable int itemId){
//        return itemService.getItemVM(itemId);
//    }
//
//    @RequestMapping(value="/item/{itemId}", method = RequestMethod.PUT)
//    public void updateItem(@PathVariable int itemId, @RequestBody ItemViewModel item){
//
//        itemService.updateItemVM(item);
//
//    }
//
//    @RequestMapping(value="/item/{itemId}", method = RequestMethod.DELETE)
//    public void deleteItem(@PathVariable int itemId){
//
//        itemService.deleteItemVM(itemId);
//
//    }
//
//}
