package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dto.Item;
import com.company.U1M6Summative.dao.ItemRepository;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


public class ItemServiceLayerTest {

   ItemServiceLayer itemService;
   ItemRepository itemRepository;

    @Before
    public void setUp() throws Exception {
        setUpItemRepositoryMock();


    }

    @Test
    public void saveFindAllItems() {
    }

    // Helper methods
    private void setUpItemRepositoryMock() {
    }
}