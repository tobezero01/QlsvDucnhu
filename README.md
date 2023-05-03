# QlsvDucnhu
- A Java Basement Project
- Maven Project For Manage Many Student
## About
Student management software is an important application in the field of education. It helps universities, colleges, and high schools to manage student information effectively. Student management includes many tasks such as storing student information, grades, courses, timetables, tuition fees, information on academic performance, student activities, and much more
![](https://drive.google.com/file/d/1zpqzs5MFUjOiDU0_l7otz0KBCE52lcqJ/view?usp=share_link)
### This App is built for following purpose :
- Applying the knowledge learned about Java.
- Building a simple project with all the programming knowledge components.
- Allowing teachers to manage students.
- Allowing students to track information.
- This is a Mini-project developed using Java, Swing , And Maven.

### Some functions and privileges of the administrator include :
- Viewing displayed student information
- Adding students
- Deleting designated students
- Editing designated students
- Sorting students as required.

### Technologies used : 
- Javacore (JDK 17+ in Eclipse)
- Maven Project
- MySql in Database(if any)
- JavaSwing

## ============= Software And Tools Required =============
- JavaCore : [[https://viettuts.vn/javahttps://viettuts.vn/java](https://viettuts.vn/java)]
- Git :[ [https://www.youtube.com/watch?v=4xqVv2lTo40](https://www.youtube.com/watch?v=4xqVv2lTo40)]
- Java JDK 17+ : [[https://www.youtube.com/watch?v=cL4GcZ6GJV8](https://www.youtube.com/watch?v=cL4GcZ6GJV8)]
- JavaSwing : [[https://shareprogramming.net/danh-sach-cac-bai-hoc-java-swing/](https://shareprogramming.net/danh-sach-cac-bai-hoc-java-swing/)]
- Apache Maven : [[https://shareprogramming.net/xay-dung-va-quan-ly-du-an-hieu-qua-voi-apache-maven/](https://shareprogramming.net/xay-dung-va-quan-ly-du-an-hieu-qua-voi-apache-maven/)] 
- MySQL : [[https://www.youtube.com/watch?v=2c2fUOgZMmY](https://www.youtube.com/watch?v=2c2fUOgZMmY)]

## ============== Dummy Database Initialization ==============
I haven't really finished it yet, but you might as well give it a go.

STEP 1: Open MySQL Command Prompt or MySQL Workbench

STEP 2: Login to the administrator with your pasword

STEP 3: Copy
```Sql
use studentmanage;

create table if not exists `student` (
    `id` int(255) not null,
    `name` nvarchar(50) not null,
    `lastName` nvarchar(50) not null,
    `age` int(255) not null,
    `gender` nvarchar(50) not null,
    `address` nvarchar(50) not null,
    `phoneNumber` nvarchar(50) not null,
    `email` nvarchar(50) not null,
    `major` nvarchar(50) not null,
    `date` nvarchar(50) not null,
    `gpa` double not null,
    primary key (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO student (id, name, lastName, age, gender, address, phoneNumber, email, major, date, gpa) VALUES
(1, 'John', 'Smith', 20, 'Male', '123 Main St, Anytown USA', '555-555-1234', 'john.smith@email.com', 'Computer Science', '2022-05-01', 3.8),
(2, 'Jane', 'Doe', 19, 'Female', '456 Maple Ave, Anytown USA', '555-555-5678', 'jane.doe@email.com', 'Biology', '2023-08-15', 3.5),
(3, 'David', 'Jones', 21, 'Male', '789 Oak St, Anytown USA', '555-555-2468', 'david.jones@email.com', 'Psychology', '2022-05-01', 3.2),
(4, 'Emily', 'Brown', 18, 'Female', '321 Elm St, Anytown USA', '555-555-3698', 'emily.brown@email.com', 'History', '2023-08-15', 3.9),
(5, 'Michael', 'Johnson', 22, 'Male', '567 Pine Ave, Anytown USA', '555-555-1357', 'michael.johnson@email.com', 'Engineering', '2022-05-01', 3.6),
(6, 'Sarah', 'Davis', 19, 'Female', '890 Cedar Rd, Anytown USA', '555-555-7890', 'sarah.davis@email.com', 'Political Science', '2023-08-15', 3.4),
(7, 'William', 'Garcia', 20, 'Male', '147 Walnut St, Anytown USA', '555-555-2468', 'william.garcia@email.com', 'Sociology', '2022-05-01', 3.1),
(8, 'Megan', 'Rodriguez', 21, 'Female', '258 Oak St, Anytown USA', '555-555-1234', 'megan.rodriguez@email.com', 'Journalism', '2023-08-15', 3.8),
(9, 'Matthew', 'Wilson', 18, 'Male', '369 Maple Ave, Anytown USA', '555-555-5678', 'matthew.wilson@email.com', 'Education', '2022-05-01', 3.5),
(10, 'Amanda', 'Lopez', 22, 'Female', '468 Oak St, Anytown USA', '555-555-3698', 'amanda.lopez@email.com', 'Mathematics', '2023-08-15', 3.9),
(11, 'Christopher', 'Lee', 20, 'Male', '579 Cedar Rd, Anytown USA', '555-555-1357', 'christopher.lee@email.com', 'Chemistry', '2022-05-01', 3.6);


create table if not exists `user` (
    `idUser` int(255) not null,
    `userName` nvarchar(50) not null,
    `password` nvarchar(50) not null,
    primary key (`idUser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into user (idUser, userName, password) values
(1, 'ducnhuad', 'ducnhu090323'),
(2, 'trungdz', 'trungmegai'),
(3, 'tungdz', 'tungtien123');
```
## ======== Importing and Running The Project In Eclipse ========
Step 0: Open Eclipse,if package javax.swing is not accessible , Right Click On Project > Build Path > Configure Build Path > Libraries > Add Libraries > j2se-1.5 > apply > Finish. You must use Jre System Library [j2se-1.5] or more.

Step 1: Click On File > Import > Git > Projects From Git > Clone Uri > Paste The Repository Url as: https://github.com/tobezero01/QLSVDucnhu.git> Select master Branch > Next > Next > Finish.

Step 2: Right Click on Project > Run as > Maven Build > In the goals field enter "clean install" > apply > run

Step 2.b: If you use Mysql , install Mysql Connection J, create databse , Right Click On Project > Build Path > Configure Build Path > Libraries > Add Extenal Jars > mysql-connector-j-8.0.33.jar > apply > Finish . You must remmember file jar path to connect.

Step 2.c: If your Eclipse don't support xml file ,  Click Helps > Eclipse Marketplace , search and download it.

Step 3: Right Click On Project > Run As > Java Application and all done.

### "Suggestions and project improvement ideas are welcomed!"
Thanks a lot.
