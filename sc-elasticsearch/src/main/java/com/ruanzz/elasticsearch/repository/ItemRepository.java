package com.ruanzz.elasticsearch.repository;

import com.ruanzz.elasticsearch.pojo.Item;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author ruanzz
 * @date 2019/3/17
 * @description item 操作类
 */
public interface ItemRepository extends ElasticsearchRepository<Item, Long> {

  List<Item> findByTitle(String title);
}
