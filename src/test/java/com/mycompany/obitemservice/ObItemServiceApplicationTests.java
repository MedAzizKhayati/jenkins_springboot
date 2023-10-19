package com.mycompany.obitemservice;

import com.mycompany.obitemservice.controller.ItemCategoryController;
import com.mycompany.obitemservice.controller.ItemController;
import com.mycompany.obitemservice.model.ItemCategoryModel;
import com.mycompany.obitemservice.model.ItemModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObItemServiceApplicationTests {

    @Autowired
    private ItemCategoryController itemCategoryController;
    @Autowired
    private ItemController itemController;
    private static String categoryId, itemId;

    @Test
    void contextLoads() {
    }

    @Test
    void testItemCategoryController() {
        itemCategoryController.getAllItemCategory();
    }

    @Test
    void testItemController() {
        itemController.getAllItems();
    }

    @Test
    void testAddItemCategory() {
        ItemCategoryModel itemCategoryModel = new ItemCategoryModel();
        itemCategoryModel.setName("Test Category");
        categoryId = itemCategoryController.saveItemCategory(itemCategoryModel).toString();
        categoryId = categoryId.substring(categoryId.lastIndexOf("/") + 1);
        categoryId = categoryId.substring(0, categoryId.length() - 3);
    }

    @Test
    void testAddItem() {
        ItemModel itemModel = new ItemModel();
        itemModel.setName("Test Item");
        itemModel.setDescription("Test Item Description");
        itemModel.setPrice(100.00);
        itemModel.setCategoryId(categoryId);
        itemId = itemController.saveItem(itemModel).toString();
        itemId = itemId.substring(itemId.lastIndexOf("/") + 1);
        itemId = itemId.substring(0, itemId.length() - 3);
    }

    @Test
    void testDeleteItemCategoryAndItem() {
        itemController.deleteItem(itemId);
        itemCategoryController.deleteItemCategory(categoryId);
    }
}
