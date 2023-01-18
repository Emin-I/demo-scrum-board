package com.example.restservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.restservice.dtos.*;
import com.example.restservice.mappers.ItemForListMapper;
import com.example.restservice.mappers.ItemMapper;
import com.example.restservice.repositories.ColumnRepository;
import com.example.restservice.repositories.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ItemMapper itemMapper;

	@Autowired
	private ItemForListMapper itemForListMapper;

	@Autowired
	private ColumnRepository columnRepository;

	public Page<Item> findAll(Pageable query) {
		return this.itemRepository.findAll(query).map(p -> itemMapper.mapToDto(p));
	}

	public Page<ItemForList> findAllForList(Pageable query) {
		return this.itemRepository.findAll(query).map(p -> itemForListMapper.mapToDto(p));
	}

	public ItemForList findById(Long id) throws Exception {
		return itemForListMapper.mapToDto(itemRepository.findById(id).orElseThrow(() -> new Exception("Not found")));
	}

	public void deleteById(Long id) {
		itemRepository.deleteById(id);
	}

	public ItemForList updateItem(Long id, Item item) throws Exception {
		var current = itemRepository.findById(id).orElseThrow(() -> new Exception("Not found"));

		var columsResult = columnRepository.findById(item.getColumn().getId())
				.orElseThrow(() -> new Exception("Not found"));

		current.setBody(item.getBody());
		current.setTitle(item.getTitle());
		current.setDueDate(item.getDueDate());
		current.setColumn(columsResult);

		itemRepository.save(current);
		return itemForListMapper.mapToDto(current);

	}

	public Item saveItem(Item item) {
		var entity = itemMapper.mapFromDto(item);
		var newEntity = itemRepository.save(entity);
		return itemMapper.mapToDto(newEntity);

	}

}
