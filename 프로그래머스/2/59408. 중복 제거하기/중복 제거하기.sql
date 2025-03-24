-- 코드를 입력하세요
select count(*) as count
from (
    SELECT distinct name 
    from animal_ins
    where name is not null
    ) as test