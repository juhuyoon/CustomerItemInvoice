package com.company.U1M6Summative.service;


public class ItemServiceLayer {

import com.company.U1M6Summative.dao.InvoiceRepository;
import com.company.U1M6Summative.dao.ItemRepository;
import com.company.U1M6Summative.dto.Item;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import com.company.U1M6Summative.viewmodel.ItemViewModel;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemServiceLayer implements ItemViewDao {
    private ItemRepository itemRepository;

    public ItemServiceLayer(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    @Override
    public ItemViewModel addItemView(ItemViewModel itemView) {
        Item item = new Item();
        item.setId(itemView.getItem_id());
        item.setName(itemView.getName());
        item.setDailyRate(itemView.getDaily_rate());
        item.setDescription(itemView.getDescription());

        itemView.setItem_id(item.getId());

        return itemView;
    }

    @Override
    public ItemViewModel getItemView(Integer itemId) {
        Item item = itemRepository.getOne(itemId);

        return buildItemViewModel(item);
    }

    @Override
    public List<ItemViewModel> getAllItemView() {
        List<Item> iList = itemRepository.findAll();

        List<ItemViewModel> ivmList = new ArrayList<>();

        for (Item item : iList) {
            ItemViewModel ivm = buildItemViewModel(item);
            ivmList.add(ivm);
        }

        return ivmList;
    }

    @Transactional
    @Override
    public void updateItemView(ItemViewModel itemView) {
        Item item = new Item();
        item.setId(itemView.getItem_id());
        item.setName(itemView.getName());
        item.setDescription(itemView.getDescription());
        item.setDailyRate(itemView.getDaily_rate());

        itemRepository.save(item);
    }

    @Transactional
    @Override
    public void deleteItemView(Integer itemId) {
        itemRepository.deleteById(itemId);
    }

    private ItemViewModel buildItemViewModel(Item item) {
        ItemViewModel ivm = new ItemViewModel();
        ivm.setItem_id(item.getId());
        ivm.setName(item.getName());
        ivm.setDescription(item.getDescription());
        ivm.setDaily_rate(item.getDailyRate());

        return ivm;
    }
}