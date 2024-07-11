insert into student
values
(1,'vicky','prasad',"abc@gmai.com"),
(2,'shashank','chouhan',"abc@gmai.com"),
(3,'gautam','batra',"abc@gmai.com"),
(4,'sonali','singh',"abc@gmai.com"),
(5,'harsh','pandey',"abc@gmai.com");


insert into book
(bookId , bookName , author, TotalCountOfThisBookInitiallyPresentInLibrary ,     countOfThisBookCurrentlyPresentInLibrary)
values
(1,'concept of physics','hc verma',105,104), -- as this book was issued, so one minus
(2,'maths','rd sharma',3,2), -- as this book was issue so one minus
(3,'sst','batra sahab',30,30),
(4,'science','singh sahab',2,2),
(5,'evs','pandey ji',10,10);

insert into bookIssued
(bookIssueReferenceId,issuedBookId,issuedToStudentId ,issueDate ,returnDate,fine , numberOfActiveBookInThisStudentId,
    statusOfThisIssueReferenceId ,finePendingStatusOnThisIssueReferenceId,paymentId )
 values
(101,1,1,'2024-07-01',null,0,1,'Active','n/a',null),
(102,2,3,'2024-07-01',null,0,1,'Active','n/a',null);