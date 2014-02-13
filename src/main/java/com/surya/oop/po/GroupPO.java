package com.surya.oop.po;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the groups database table.
 * 
 */
@Entity
@Table(name="groups")
@NamedQuery(name="GroupPO.findAll", query="SELECT g FROM GroupPO g")
public class GroupPO extends BasePO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GROUPS_ID_GENERATOR", sequenceName="GROUPS_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GROUPS_ID_GENERATOR")
	private Long id;

	private String name;

	//bi-directional many-to-one association to ExpenseGroupPO
	@OneToMany(mappedBy="group")
	private List<ExpenseGroupPO> expenseGroups;

	//bi-directional many-to-one association to GroupMemberPO
	@OneToMany(mappedBy="group")
	private List<GroupMemberPO> groupMembers;

	//bi-directional many-to-one association to UserPO
	@ManyToOne
	@JoinColumn(name="owner_id")
	private UserPO user;

	public GroupPO() {
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

	public List<ExpenseGroupPO> getExpenseGroups() {
		return this.expenseGroups;
	}

	public void setExpenseGroups(List<ExpenseGroupPO> expenseGroups) {
		this.expenseGroups = expenseGroups;
	}

	public ExpenseGroupPO addExpenseGroup(ExpenseGroupPO expenseGroup) {
		getExpenseGroups().add(expenseGroup);
		expenseGroup.setGroup(this);

		return expenseGroup;
	}

	public ExpenseGroupPO removeExpenseGroup(ExpenseGroupPO expenseGroup) {
		getExpenseGroups().remove(expenseGroup);
		expenseGroup.setGroup(null);

		return expenseGroup;
	}

	public List<GroupMemberPO> getGroupMembers() {
		return this.groupMembers;
	}

	public void setGroupMembers(List<GroupMemberPO> groupMembers) {
		this.groupMembers = groupMembers;
	}

	public GroupMemberPO addGroupMember(GroupMemberPO groupMember) {
		getGroupMembers().add(groupMember);
		groupMember.setGroup(this);

		return groupMember;
	}

	public GroupMemberPO removeGroupMember(GroupMemberPO groupMember) {
		getGroupMembers().remove(groupMember);
		groupMember.setGroup(null);

		return groupMember;
	}

	public UserPO getUser() {
		return this.user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}

}