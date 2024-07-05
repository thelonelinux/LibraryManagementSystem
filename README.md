# LibraryManagementSystem
SpringBoot Project Using Microservices to learn and build full formed project from scratch

## Requirement : 
Let's Populate and prepare our DB for LibraryManagementSystem as ad-hoc project

create database librarymanagementsystem;

use librarymanagementsystem;

create table IF NOT EXISTS student( studentId INTEGER NOT NULL , firstName varchar(128), lastName varchar(128), PRIMARY KEY (studentId) );

create table IF NOT EXISTS book( bookId INTEGER NOT NULL, bookName varchar(128), author varchar(128), TotalCountOfThisBookInitiallyPresentInLibrary INTEGER NOT NULL, countOfThisBookCurrentlyPresentInLibrary INTEGER NOT NULL, PRIMARY KEY (bookId) );

-- A student can't issue more than 3 book at a time -- Number of book present in library should be also taken care. If a student take a book from library, then count of that book currently present in the llibrary would -- decrese by one, and the count of number of book that single student will increase by one, but never be more than 3. -- If a student is going to get more than 3 book, he can't get. make that sure. -- A student can keep a single book for max 15 days, if he keeps more than 15days, 10 rs per day fine will be paid. -- max 100 rs fine is allowed, after 100 rs fine is reached, authority should call that student and get the book to submit back with fine. -- so before issuing the library, first librarian will check if this book is present and also checks if this student has exceedes his book limit or not.

create table IF NOT EXISTS bookIssued( bookIssueReferenceId INTEGER NOT NULL, -- This reference number will be added in book only, in it's history of issuance issuedBookId INTEGER NOT NULL, issuedToStudentId INTEGER NOT NULL, issueDate date, returnDate date, fine Integer default 0, -- fine should be per book issue, not combine numberOfActiveBookInThisStudentId integer, -- this count tells number of book present with this student id. statusOfThisIssueReferenceId varchar(32), -- Can be true of false, false for those which book is returned after fine is cleared if any finePendingStatusOnThisIssueReferenceId varchar(32), -- default value : paid, unpaid, n/a (when fine is 0) : until the fine is paid, book can't be returned and fine keeps on going per day rule. default false; will be true when library gives him back paymentId INTEGER, PRIMARY KEY (bookIssueReferenceId) );

create table IF NOT EXISTS paymentRecords( paymentId INTEGER NOT NULL, bookIssueReferenceId INTEGER NOT NULL, invoiceDate date, paymentMode varchar(128), invoicePdfUrl varchar(1024), PRIMARY KEY (paymentId) );

============================ INSERTING SOME VALUES IN THIS TABLE TO MAKE API AND UI =================================
insert into student (studentId , firstName , lastName) values (1,'vicky','prasad'), (2,'shashank','chouhan'), (3,'gautam','batra'), (4,'sonali','singh'), (5,'harsh','pandey');

insert into book (bookId , bookName , author, TotalCountOfThisBookInitiallyPresentInLibrary , countOfThisBookCurrentlyPresentInLibrary) values (1,'concept of physics','hc verma',105,104), -- as this book was issued, so one minus (2,'maths','rd sharma',3,2), -- as this book was issue so one minus (3,'sst','batra sahab',30,30), (4,'science','singh sahab',2,2), (5,'evs','pandey ji',10,10);

insert into bookIssued (bookIssueReferenceId,issuedBookId,issuedToStudentId ,issueDate ,returnDate,fine , numberOfActiveBookInThisStudentId, statusOfThisIssueReferenceId ,finePendingStatusOnThisIssueReferenceId,paymentId ) values (101,1,1,'2024-07-01',null,0,1,'Active','n/a',null), (102,2,3,'2024-07-01',null,0,1,'Active','n/a',null);

Here primary key index will be build by default.
UI should have option to login student, check availability of book student wants, check eligibility of student if he can issue, issue book, return book, pay fine. You can simulate this options to update table count, fine etc.
Admin/Librarian has option to add new book, check list of all students who have issued book, check the total count of books are good in issue and those present in library.
