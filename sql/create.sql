
create table USERS
(
	id bigserial PRIMARY KEY,
	first_name varchar(50),
	last_name varchar(50),
	email varchar(100),
	login_token varchar(100),
	passwd varchar(2048),
	account_type varchar(10),
	is_active varchar(1)
)
;

create table GROUPS
(
	id bigserial PRIMARY KEY,
	name varchar(100),
	owner_id bigint REFERENCES USERS(ID)
)
;

create table GROUP_MEMBERS
(
	id bigserial PRIMARY KEY,
	group_id bigint REFERENCES GROUPS(ID),
	member_id bigint REFERENCES USERS(ID)
)
;

create table EXPENSE_TYPE
(
	id bigserial PRIMARY KEY,
	name varchar(100),
	owner_id bigint REFERENCES USERS(ID)
)
;

create table EXPENSE
(
	id bigserial PRIMARY KEY,
	name varchar(100),
	amount money,
	exp_type bigint REFERENCES EXPENSE_TYPE(ID),
	invoice_date timestamp,
	filed_by bigint REFERENCES USERS(ID)
)
;

create table EXPENSE_GROUP
(
	id bigserial PRIMARY KEY,
	expense_id bigint REFERENCES EXPENSE(ID),
	group_id bigint REFERENCES GROUPS(ID)
)
;

