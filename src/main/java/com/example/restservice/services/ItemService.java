package com.example.restservice.services;

import java.util.Date;

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

		// var columnResult = columnService.findById(itemModel.getColumn().getId());

		// var columnIds = new ArrayList<Long>();
		// item.getColumn().forEach((column) -> columnIds.add(column.getId()));
		// var columsResult = new ArrayList<ColumnModel>();
		// columnRepository.findAllById(columnIds).forEach(column ->
		// columsResult.add(colum));
		// item.setColumn(columnResult==null ? null : columnResult);
		// columnRepository.findById(item.getColumn().getId()).orElseThrow(() -> new
		// Exception("Not found"))
		
		var columsResult = columnRepository.findById(item.getColumn().getId())
				.orElseThrow(() -> new Exception("Not found"));
		
		// userMapper.mapToDto(userRepository.findById(id).orElseThrow(() -> new
		// Exception("Not found")));
		
		
		//current.setId(item.getId());
		current.setBody(item.getBody());
		current.setTitle(item.getTitle());
		current.setDueDate(item.getDueDate());
		current.setColumn(columsResult);
		
		
		// item.setColumn(columnResult==null ? null : columnResult);
		// this.saveItem(current);
		itemRepository.save(current);
		return itemForListMapper.mapToDto(current);

	}

	public Item saveItem(Item item) {
		var entity = itemMapper.mapFromDto(item);
		var newEntity = itemRepository.save(entity);// this.saveItem(entity);
		return itemMapper.mapToDto(newEntity);

	}

	/*
	 * public Item mapToDto(ItemModel itemModel) { var item = new Item(); // var
	 * columnResult = columnService.findById(itemModel.getColumn().getId());
	 * item.setId(itemModel.getId()); item.setBody(itemModel.getBody());
	 * item.setTitle(itemModel.getTitle()); item.setDueDate(itemModel.getDueDate());
	 * // item.setColumn(columnResult==null ? null : columnResult); return item; }
	 * 
	 * public ItemModel mapFromDto(Item teamDto) { var item = new ItemModel(); //
	 * var columnResult = columnService.findById(teamDto.getColumn().getId());
	 * item.setId(teamDto.getId()); item.setBody(teamDto.getBody());
	 * item.setTitle(teamDto.getTitle()); item.setDueDate(teamDto.getDueDate()); //
	 * item.setColumn(columnResult==null ? null : columnResult); return item; }
	 */
}
