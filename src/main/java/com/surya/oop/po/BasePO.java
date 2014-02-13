package com.surya.oop.po;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: BasePO
 *
 */
@MappedSuperclass
public class BasePO implements Serializable {
	private static final long serialVersionUID = 1L;

	public BasePO() {
		super();
	}  
}
