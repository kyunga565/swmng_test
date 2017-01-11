select * from company;
select no,coName,address,tel from company order by no;
insert into company(coName,address,tel) values('qkrrud','대구','000-000');
update company set coName='박경',address='대구광역쇼ㅣ',tel='123-123-123' where no = 8;
delete from company where no = 7;
desc company;
select * from company where no =7;
select max(no)+1 from company;