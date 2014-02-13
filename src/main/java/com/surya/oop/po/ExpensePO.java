package com.surya.oop.po;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the expense database table.
 * 
 */
@Entity
@Table(name="expense")
@NamedQuery(name="ExpensePO.findAll", query="SELECT e FROM ExpensePO e")
public class ExpensePO extends BasePO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EXPENSE_ID_GENERATOR", sequenceName="EXPENSE_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EXPENSE_ID_GENERATOR")
	private Long id;

	private double amount;

	@Column(name="invoice_date")
	private Timestamp invoiceDate;

	private String name;

	//bi-directional many-to-one association to ExpenseTypePO
	@ManyToOne
	@JoinColumn(name="exp_type")
	private ExpenseTypePO expenseType;

	//bi-directional many-to-one association to UserPO
	@ManyToOne
	@JoinColumn(name="filed_by")
	private UserPO user;

	//bi-directional many-to-one association to ExpenseGroupPO
	@OneToMany(mappedBy="expense")
	private List<ExpenseGroupPO> expenseGroups;

	public ExpensePO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return this.amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Timestamp getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Timestamp invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExpenseTypePO getExpenseType() {
		return this.expenseType;
	}

	public void setExpenseType(ExpenseTypePO expenseType) {
		this.expenseType = expenseType;
	}

	public UserPO getUser() {
		return this.user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}

	public List<ExpenseGroupPO> getExpenseGroups() {
		return this.expenseGroups;
	}

	public void setExpenseGroups(List<ExpenseGroupPO> expenseGroups) {
		this.expenseGroups = expenseGroups;
	}

	public ExpenseGroupPO addExpenseGroup(ExpenseGroupPO expenseGroup) {
		getExpenseGroups().add(expenseGroup);
		expenseGroup.setExpense(this);

		return expenseGroup;
	}

	public ExpenseGroupPO removeExpenseGroup(ExpenseGroupPO expenseGroup) {
		getExpenseGroups().remove(expenseGroup);
		expenseGroup.setExpense(null);

		return expenseGroup;
	}

}