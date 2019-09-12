package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepo;

    @Before
    public void setUp() throws Exception {
        itemRepo.deleteAll();
    }

    @Test
    public void addGetFindAllDeleteItem() {
        Item item = new Item();
        item.setName("Chomske");
        item.setDescription("It's a Cat!");
        item.setDailyRate(new BigDecimal("89.89"));
        itemRepo.save(item);

        Item item1 = new Item();
        item1.setName("Woofer");
        item1.setDescription("It's a Doggo.");
        item1.setDailyRate(new BigDecimal("55.55"));
        itemRepo.save(item1);

        Item getItem = itemRepo.getOne(item.getId());
        assertEquals("Chomske", getItem.getName());

        List<Item> itemList = itemRepo.findAll();
        assertEquals(2, itemList.size());

        itemRepo.deleteById(item.getId());
        itemList = itemRepo.findAll();
        assertEquals("Woofer", itemList.get(0).getName());
    }
}