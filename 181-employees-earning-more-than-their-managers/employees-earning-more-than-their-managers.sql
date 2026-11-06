# Write your MySQL query statement below
select eid.name as Employee
from employee as eid
inner join employee as mid
on eid.managerId = mid.Id
where eid.salary> mid.salary
;