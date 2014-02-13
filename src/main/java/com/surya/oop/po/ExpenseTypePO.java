package com.surya.oop.po;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the expense_type database table.
 * 
 */
@Entity
@Table(name="expense_type")
@NamedQuery(name="ExpenseTypePO.findAll", query="SELECT e FROM ExpenseTypePO e")
public class ExpenseTypePO extends BasePO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXPENSE_TYPE_ID_GENERATOR", sequenceName="EXPENSE_TYPE_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXPENSE_TYPE_ID_GENERATOR")
	private Long id;

	private String name;

	//bi-directional many-to-one association to ExpensePO
	@OneToMany(mappedBy="expenseType")
	private List<ExpensePO> expenses;

	//bi-directional many-to-one association to UserPO
	@ManyToOne
	@JoinColumn(name="owner_id")
	private UserPO user;

	public ExpenseTypePO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ExpensePO> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(List<ExpensePO> expenses) {
		this.expenses = expenses;
	}

	public ExpensePO addExpens(ExpensePO expens) {
		getExpenses().add(expens);
		expens.setExpenseType(this);

		return expens;
	}

	public ExpensePO removeExpens(ExpensePO expens) {
		getExpenses().remove(expens);
		expens.setExpenseType(null);

		return expens;
	}

	public UserPO getUser() {
		return this.user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}

}