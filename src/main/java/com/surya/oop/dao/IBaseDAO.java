package com.surya.oop.dao;

import java.util.List;

import com.surya.oop.po.BasePO;

public interface IBaseDAO<PO extends BasePO> {
	PO findById(long id);
	List<PO> findAll();
	PO persist(PO po);
	void delete(PO po);
}
