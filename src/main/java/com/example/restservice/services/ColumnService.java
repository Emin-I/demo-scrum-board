package com.example.restservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.restservice.dtos.Column;
import com.example.restservice.models.ColumnModel;
import com.example.restservice.repositories.ColumnRepository;

@Service
public class ColumnService {

	@Autowired
	private ColumnRepository columnRepository;

	public Page<Column> findAll(Pageable query) {
		return this.columnRepository.findAll(query).map(p -> mapToDto(p));
	}

	public Column findById(Long id) throws Exception {
		return mapToDto(columnRepository.findById(id).orElseThrow(() -> new Exception("Not found")));
	}

	public Column saveColumn(Column column) {
		var entity = mapFromDto(column);
		var newEntity = this.saveColumn(entity);

		return mapToDto(newEntity);
	}

	private ColumnModel saveColumn(ColumnModel column) {
		columnRepository.save(column);
		return column;
	}

	public void deleteById(Long id) {
		columnRepository.deleteById(id);
	}

	public Column updateColumn(Long id, Column column) throws Exception {
		var current = columnRepository.findById(id).orElseThrow(() -> new Exception("Not found"));
		current.setName(column.getName());
		this.saveColumn(current);
		return mapToDto(current);
	}

	public Column mapToDto(ColumnModel columnModel) {
		var column = new Column();
		column.setId(columnModel.getId());
		column.setName(columnModel.getName());
		column.setSequence(columnModel.getSequence());
		return column;
	}

	public ColumnModel mapFromDto(Column columnDto) {
		var column = new ColumnModel();
		column.setId(columnDto.getId());
		column.setName(columnDto.getName());
		column.setSequence(columnDto.getSequence());
		return column;
	}

	public Page<Column> findByTeamId(long teamId) {
		return null;
	}
}
