

create table EmployeeInfo(
emp_id number(4),
emp_fname varchar2(20),
emp_lname varchar2(20),
emp_Ssn varchar2(25),
emp_position number(4),
emp_hireDate date,
emp_QualId number(4),
d_id number(4),
constraint EmployeeInfo_emp_id_pk primary key (emp_id)
);

create table Department(
d_id number(4),
d_name varchar2(20),
d_location varchar2(30),
constraint Department_d_id_pk primary key (d_id)
);

create table Position(
PositionId number(4),
PosDesc varchar2(40),
constraint Position_PositionId_pk primary key (PositionId)
);

create table Qualification(
QualId number(4),
QualDesc varchar2(40),
constraint Qualification_QualId_pk primary key (QualId)
);

create table ItemsPay(
ItemPay_No number(4),
ItemPay_title varchar2(50),
ItemPay_rate number(6,4),
constraint ItemsPay_ItemPay_No_pk primary key (ItemPay_No)
);

create table EmpPayDetails(
EmployeeId number(5),
ItemPay_No number(3),
NHhr number(6,2),
HourlyRate number(8,2),
ItemPay_rate number(6,5),
Amount number(8,2),
pay_month number(2),
pay_year number(4),
constraint EmpPayDetails_pk primary key (EmployeeId,ItemPay_No,pay_month,pay_year)
);

ALTER TABLE EmployeeInfo
		ADD CONSTRAINT EmployeeInfo_empPosition_fk  FOREIGN 	KEY (emp_position) REFERENCES Position(PositionId);
ALTER TABLE EmployeeInfo    
    ADD CONSTRAINT EmployeeInfo_empQualId_fk  FOREIGN 	KEY (emp_QualId) REFERENCES Qualification(QualId);
ALTER TABLE EmployeeInfo    
    ADD CONSTRAINT EmployeeInfo_d_ID_fk  FOREIGN 	KEY (d_id) REFERENCES Department(d_id);
    
ALTER TABLE EmpPayDetails    
    ADD CONSTRAINT EmpPayDetail_EmployeeId_fk  FOREIGN 	KEY (EmployeeId) REFERENCES EmployeeInfo(emp_id);    
ALTER TABLE EmpPayDetails    
    ADD CONSTRAINT EmpPayDetail_ItemPayNo_fk  FOREIGN 	KEY (ItemPay_No) REFERENCES ItemsPay(ItemPay_No);

insert into Position values(1,'manager');
insert into Qualification values(1,'Master');
insert into Department values(1,'Accouting','NewYork');
insert into ItemsPay values(100,'Total Income',0);
insert into ItemsPay values(200,'Provincial Tax Deduction',0.09);
insert into ItemsPay values(201,'Federal Tax Deduction',0.07);
insert into ItemsPay values(202,'QPIP Deduction',0.0055);
insert into ItemsPay values(203,'EI Deduction',0.014);
insert into ItemsPay values(204,'QPP Deduction',0.045);
insert into ItemsPay values(205,'Union Fee Deduction',0.0165);
insert into ItemsPay values(101,'Net Income',0);

select * from EmpPayDetails;
DELETE from EmpPayDetails;

select ItemPay_No,sum(Amount) from EmpPayDetails where EmployeeId=1 group by ItemPay_No order by itempay_no;

 

