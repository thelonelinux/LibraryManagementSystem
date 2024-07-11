create database librarymanagementsystem;
use librarymanagementsystem;
create table IF NOT EXISTS student(
	id INTEGER NOT NULL ,
    first_name varchar(128),
    last_name varchar(128),
    email varchar(128),
    PRIMARY KEY (id)
);
create table IF NOT EXISTS book(
	bookId INTEGER NOT NULL,
    bookName varchar(128),
    author varchar(128),
    TotalCountOfThisBookInitiallyPresentInLibrary INTEGER NOT NULL,
    countOfThisBookCurrentlyPresentInLibrary INTEGER NOT NULL,
    PRIMARY KEY (bookId)
);
-- A student can't issue more than 3 book at a time
-- Number of book present in library should be also taken care. If a student take a book from library, then count of that book currently present in the llibrary would
-- decrese by one, and the count of number of book that single student will increase by one, but never be more than 3. 
-- If a student is going to get more than 3 book, he can't get. make that sure.
-- A student can keep a single book for max 15 days, if he keeps more than 15days, 10 rs per day fine will be paid.
-- max 100 rs fine is allowed, after 100 rs fine is reached, authority should call that student and get the book to submit back with fine.
-- so before issuing the library, first librarian will check if this book is present and also checks if this student has exceedes his book limit or not.
create table IF NOT EXISTS bookIssued(
	bookIssueReferenceId INTEGER NOT NULL, -- This reference number will be added in book only, in it's history of issuance
	issuedBookId INTEGER NOT NULL,
    issuedToStudentId INTEGER NOT NULL,
    issueDate date,
    returnDate date,
    fine Integer default 0,  -- fine should be per book issue, not combine
    numberOfActiveBookInThisStudentId integer,  -- this count tells number of book present with this student id.
    statusOfThisIssueReferenceId varchar(32), -- Can be true of false, false for those which book is returned after fine is cleared if any
    finePendingStatusOnThisIssueReferenceId varchar(32),  -- default value : paid, unpaid, n/a (when fine is 0) : until the fine is paid, book can't be returned and fine keeps on going per day rule. default false; will be true when library gives him back
    paymentId INTEGER,
    PRIMARY KEY (bookIssueReferenceId)
);

create table IF NOT EXISTS paymentRecords(
	paymentId INTEGER NOT NULL,
    bookIssueReferenceId INTEGER NOT NULL,
    invoiceDate date,
    paymentMode varchar(128),
    invoicePdfUrl varchar(1024),
	PRIMARY KEY (paymentId)
);

