package com.company.U1M6Summative.service;

import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import com.company.U1M6Summative.viewmodel.ItemViewModel;

import java.util.List;

public interface ItemViewDao {
    ItemViewModel addItemView(ItemViewModel itemView);

    ItemViewModel getItemView(Integer itemId);

    List<ItemViewModel> getAllItemView();

    void updateItemView(ItemViewModel itemView);

    void deleteItemView(Integer itemId);

}
