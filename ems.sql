select * from employee;
select * from department;

show tables;
create database ems3;
use ems3;
drop table department;
drop table employee;
insert into department values(1,'IT','2022-09-10','2');

-- Insert 25 entries into the Employee table with variations
INSERT INTO Employee (id,name, date_of_birth, address, salary, role, joining_date, bonus_percentage, department_id, reporting_manager)
VALUES
(1,'Anitha', '1994-01-01', 'G M Road', 40000, 'Sales Executive', '2024-05-16', 5.0, 2, 'Ram'),
(2,'John', '1990-03-15', 'Main Street', 45000, 'HR Manager', '2024-05-16', 7.5, 1, 'Alice'),
(3,'Emily', '1988-09-22', 'Oak Avenue', 60000, 'IT Specialist', '2024-05-16', 8.0, 3, 'David'),
(4,'Michael', '1992-07-10', 'Elm Street', 55000, 'Sales Associate', '2024-05-16', 6.0, 2, 'Sarah'),
(5,'Daniel', '1985-05-05', 'Pine Street', 50000, 'HR Assistant', '2024-05-16', 5.5, 1, 'Jessica'),
(6,'Samantha', '1993-12-03', 'Cedar Avenue', 48000, 'IT Technician', '2024-05-16', 4.5, 3, 'James'),
(7,'Olivia', '1991-08-18', 'Maple Road', 42000, 'Sales Manager', '2024-05-16', 6.5, 2, 'Sophia'),
(8,'William', '1989-04-25', 'Cherry Lane', 58000, 'HR Director', '2024-05-16', 8.5, 1, 'Ethan'),
(9,'Liam', '1995-06-20', 'Birch Street', 47000, 'IT Analyst', '2024-05-16', 5.0, 3, 'Ava'),
(10,'Emma', '1997-02-14', 'Sycamore Avenue', 43000, 'Sales Representative', '2024-05-16', 5.5, 2, 'Noah'),
-- Add 15 more entries with different values for department_id, role, and reportingManager
(11,'Sophie', '1996-11-08', 'Willow Lane', 52000, 'HR Coordinator', '2024-05-16', 6.0, 1, 'Benjamin'),
(12,'Aiden', '1998-10-04', 'Fir Street', 49000, 'IT Manager', '2024-05-16', 7.0, 3, 'Charlotte'),
(13,'Mia', '1987-07-29', 'Juniper Road', 54000, 'Sales Consultant', '2024-05-16', 6.5, 2, 'Elijah'),
(14,'Ella', '1986-09-11', 'Cypress Avenue', 46000, 'HR Consultant', '2024-05-16', 5.0, 1, 'Amelia'),
(15,'Henry', '1990-12-20', 'Poplar Lane', 51000, 'IT Director', '2024-05-16', 7.5, 3, 'Mason'),
(16,'Lily', '1994-03-28', 'Hemlock Street', 44000, 'Sales Coordinator', '2024-05-16', 5.0, 2, 'Oliver'),
(17,'Ethan', '1988-06-15', 'Spruce Avenue', 53000, 'HR Specialist', '2024-05-16', 6.5, 1, 'Ella'),
(18,'Lucas', '1992-08-07', 'Aspen Road', 57000, 'IT Support', '2024-05-16', 6.0, 3, 'Aria'),
(19,'Ava', '1993-05-16', 'Palm Street', 48000, 'Sales Director', '2024-05-16', 7.0, 2, 'Liam'),
(20,'Noah', '1989-01-30', 'Acacia Lane', 50000, 'HR Representative', '2024-05-16', 6.0, 1, 'Emma'),
(21,'Charlotte', '1997-04-02', 'Hickory Avenue', 51000, 'IT Consultant', '2024-05-16', 6.5, 3, 'Aiden'),
(22,'Mason', '1991-10-10', 'Sycamore Lane', 52000, 'Sales Analyst', '2024-05-16', 6.0, 2, 'Mia'),
(23,'Amelia', '1985-11-24', 'Cedar Lane', 53000, 'HR Coordinator', '2024-05-16', 6.5, 1, 'Henry'),
(24,'Amrin', '1985-04-15', 'Cedar Lane', 485555, 'Sales Analyst', '2024-05-16', 6.5, 2, 'Mia'),
(25,'Alish', '1985-04-19', 'Victoria Lane', 789999, 'IT Analyst', '2024-05-16', 6.5, 3, 'Aiden'),
(26,'Alish', '1985-08-19', 'Victoria Lane', 450000, 'IT Analyst', '2024-05-16', 6.5, 3, 'Aiden');

