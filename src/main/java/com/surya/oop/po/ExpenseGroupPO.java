package com.surya.oop.po;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the expense_group database table.
 * 
 */
@Entity
@Table(name="expense_group")
@NamedQuery(name="ExpenseGroupPO.findAll", query="SELECT e FROM ExpenseGroupPO e")
public class ExpenseGroupPO extends BasePO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXPENSE_GROUP_ID_GENERATOR", sequenceName="EXPENSE_GROUP_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXPENSE_GROUP_ID_GENERATOR")
	private Long id;

	//bi-directional many-to-one association to ExpensePO
	@ManyToOne
	private ExpensePO expense;

	//bi-directional many-to-one association to GroupPO
	@ManyToOne
	private GroupPO group;

	public ExpenseGroupPO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExpensePO getExpense() {
		return this.expense;
	}

	public void setExpense(ExpensePO expense) {
		this.expense = expense;
	}

	public GroupPO getGroup() {
		return this.group;
	}

	public void setGroup(GroupPO group) {
		this.group = group;
	}

}