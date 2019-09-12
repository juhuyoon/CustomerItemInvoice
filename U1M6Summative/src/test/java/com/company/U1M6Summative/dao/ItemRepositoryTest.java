package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

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
    public void addGetDeleteItem() {
        Item item = new Item();
        item.setName("Chomske");
        item.setDescription("It's a Cat!");
        item.setDailyRate(new BigDecimal("89.89"));
        itemRepo.save(item);
    }
}