package com.example.restservice.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.restservice.dtos.Column;
import com.example.restservice.dtos.ColumnForList;
import com.example.restservice.dtos.ColumnNoItem;
import com.example.restservice.mappers.ColumnForListMapper;
import com.example.restservice.mappers.ColumnMapper;
import com.example.restservice.mappers.ColumnNoItemMapper;
import com.example.restservice.models.ItemModel;
import com.example.restservice.repositories.ColumnRepository;
import com.example.restservice.repositories.ItemRepository;
import com.example.restservice.repositories.TeamRepository;

@Service
public class ColumnService {

	@Autowired
	private ColumnRepository columnRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private TeamRepository teamRepository;

	@Autowired
	private ColumnForListMapper columnForListMapper;

	@Autowired
	private ColumnMapper columnMapper;

	@Autowired
	private ColumnNoItemMapper columnNoItemMapper;

	public Page<ColumnForList> findAllForList(Pageable query) {
		return this.columnRepository.findAll(query).map(p -> columnForListMapper.mapToDto(p));
	}

	public Page<Column> findAll(Pageable query) {
		return this.columnRepository.findAll(query).map(p -> columnMapper.mapToDto(p));
	}

	public ColumnForList findById(Long id) throws Exception {
		return columnForListMapper
				.mapToDto(columnRepository.findById(id).orElseThrow(() -> new Exception("Not found")));
	}

	public Column saveColumn(Column column) {
		var entity = columnMapper.mapFromDto(column);
		var newEntity = columnRepository.save(entity);
		return columnMapper.mapToDto(newEntity);

	}

	/*
	 * private ColumnModel saveColumn(ColumnModel column) {
	 * columnRepository.save(column); return column; }
	 */
	public void deleteById(Long id) {
		columnRepository.deleteById(id);
	}

	public ColumnForList updateColumn(Long id, Column column) throws Exception {

		var currentModel = columnRepository.findById(id).orElseThrow(() -> new Exception("Not found"));

		var itemIds = new ArrayList<Long>();
		if (column.getItems() != null) {
			column.getItems().forEach((item) -> itemIds.add(item.getId()));
		}

		var itemsResult = new ArrayList<ItemModel>();
		itemRepository.findAllById(itemIds).forEach(item -> itemsResult.add(item));

		var team = columnMapper.mapFromDto(column).getTeam();

		currentModel.setItems(itemsResult);
		currentModel.setName(column.getName());
		currentModel.setTeam(team);
		var columnForList= columnForListMapper.mapToDto(columnRepository.save(currentModel));
		return columnForList;

	}

	public List<ColumnNoItem> findByTeamId(Long teamId) throws Exception {

		return this.columnRepository.findByTeamId(teamId).stream().map(p -> columnNoItemMapper.mapToDto(p)).toList();

	}
}
