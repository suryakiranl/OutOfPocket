package com.surya.oop.po;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="UserPO.findAll", query="SELECT u FROM UserPO u")
public class UserPO extends BasePO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERS_ID_GENERATOR", sequenceName="USERS_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERS_ID_GENERATOR")
	private Long id;

	@Column(name="account_type")
	private String accountType;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="is_active")
	private String isActive;

	@Column(name="last_name")
	private String lastName;

	@Column(name="login_token")
	private String loginToken;

	private String passwd;

	//bi-directional many-to-one association to ExpensePO
	@OneToMany(mappedBy="user")
	private List<ExpensePO> expenses;

	//bi-directional many-to-one association to ExpenseTypePO
	@OneToMany(mappedBy="user")
	private List<ExpenseTypePO> expenseTypes;

	//bi-directional many-to-one association to GroupMemberPO
	@OneToMany(mappedBy="user")
	private List<GroupMemberPO> groupMembers;

	//bi-directional many-to-one association to GroupPO
	@OneToMany(mappedBy="user")
	private List<GroupPO> groups;

	public UserPO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLoginToken() {
		return this.loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public List<ExpensePO> getExpenses() {
		return this.expenses;
	}

	public void setExpenses(List<ExpensePO> expenses) {
		this.expenses = expenses;
	}

	public ExpensePO addExpens(ExpensePO expens) {
		getExpenses().add(expens);
		expens.setUser(this);

		return expens;
	}

	public ExpensePO removeExpens(ExpensePO expens) {
		getExpenses().remove(expens);
		expens.setUser(null);

		return expens;
	}

	public List<ExpenseTypePO> getExpenseTypes() {
		return this.expenseTypes;
	}

	public void setExpenseTypes(List<ExpenseTypePO> expenseTypes) {
		this.expenseTypes = expenseTypes;
	}

	public ExpenseTypePO addExpenseType(ExpenseTypePO expenseType) {
		getExpenseTypes().add(expenseType);
		expenseType.setUser(this);

		return expenseType;
	}

	public ExpenseTypePO removeExpenseType(ExpenseTypePO expenseType) {
		getExpenseTypes().remove(expenseType);
		expenseType.setUser(null);

		return expenseType;
	}

	public List<GroupMemberPO> getGroupMembers() {
		return this.groupMembers;
	}

	public void setGroupMembers(List<GroupMemberPO> groupMembers) {
		this.groupMembers = groupMembers;
	}

	public GroupMemberPO addGroupMember(GroupMemberPO groupMember) {
		getGroupMembers().add(groupMember);
		groupMember.setUser(this);

		return groupMember;
	}

	public GroupMemberPO removeGroupMember(GroupMemberPO groupMember) {
		getGroupMembers().remove(groupMember);
		groupMember.setUser(null);

		return groupMember;
	}

	public List<GroupPO> getGroups() {
		return this.groups;
	}

	public void setGroups(List<GroupPO> groups) {
		this.groups = groups;
	}

	public GroupPO addGroup(GroupPO group) {
		getGroups().add(group);
		group.setUser(this);

		return group;
	}

	public GroupPO removeGroup(GroupPO group) {
		getGroups().remove(group);
		group.setUser(null);

		return group;
	}

}