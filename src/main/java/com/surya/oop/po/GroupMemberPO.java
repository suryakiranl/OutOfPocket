package com.surya.oop.po;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the group_members database table.
 * 
 */
@Entity
@Table(name="group_members")
@NamedQuery(name="GroupMemberPO.findAll", query="SELECT g FROM GroupMemberPO g")
public class GroupMemberPO extends BasePO implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GROUP_MEMBERS_ID_GENERATOR", sequenceName="GROUP_MEMBERS_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GROUP_MEMBERS_ID_GENERATOR")
	private Long id;

	//bi-directional many-to-one association to GroupPO
	@ManyToOne
	private GroupPO group;

	//bi-directional many-to-one association to UserPO
	@ManyToOne
	@JoinColumn(name="member_id")
	private UserPO user;

	public GroupMemberPO() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GroupPO getGroup() {
		return this.group;
	}

	public void setGroup(GroupPO group) {
		this.group = group;
	}

	public UserPO getUser() {
		return this.user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}

}