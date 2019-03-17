package com.ruanzz.elasticsearch;

import com.ruanzz.elasticsearch.pojo.Item;
import com.ruanzz.elasticsearch.repository.ItemRepository;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ruanzz
 * @date 2019/3/17
 * @description elasticsearch 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchTest {

  @Autowired
  ElasticsearchTemplate elasticsearchTemplate;

  @Autowired
  ItemRepository itemRepository;


  @Test
  public void createIndex() {
    elasticsearchTemplate.createIndex(Item.class);
    elasticsearchTemplate.putMapping(Item.class);
  }


  @Test
  public void save() {
    Item item = new Item();
    item.setTitle("22");
    itemRepository.save(item);
  }

  @Test
  public void query() {
    List<Item> items = itemRepository.findByTitle("22");
    System.out.println(items.size());
    for (Item item : items) {
      System.out.println(item);
    }
  }

  @Test
  public void deleteIndex() {
    elasticsearchTemplate.deleteIndex(Item.class);
  }

}
