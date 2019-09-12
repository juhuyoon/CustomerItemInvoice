package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dao.ItemRepository;
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
    public void saveGetFindAllDeleteItem() {
        Item item = new Item();
        item.setName("Chomske");
        item.setDescription("It's a Cat!");
        item.setDailyRate(new BigDecimal("88.99"));
        itemRepo.save(item);

        Item item1 = new Item();
        item1.setName("Woofer");
        item1.setDescription("It's a Doggo.");
        item1.setDailyRate(new BigDecimal("77.12"));
        itemRepo.save(item1);

        Item getItem = itemRepo.getOne(item.getId());
        assertEquals(item.getName(), getItem.getName());

        List<Item> itemList = itemRepo.findAll();
        assertEquals(2, itemList.size());

        itemRepo.deleteById(item.getId());
        itemList = itemRepo.findAll();
        assertEquals(item1.getName(), itemList.get(0).getName());
    }

    @Test
    public void updateItem() {
        Item item = new Item();
        item.setName("Chomske");
        item.setDescription("It's a Cat!");
        item.setDailyRate(new BigDecimal("88.99"));
        itemRepo.save(item);

        item.setName("Woofer");
        item.setDescription("It's a Doggo.");
        item.setDailyRate(new BigDecimal("77.12"));
        itemRepo.save(item);

        Item getItem = itemRepo.getOne(item.getId());
        assertEquals(item.getName(), getItem.getName());
    }

}