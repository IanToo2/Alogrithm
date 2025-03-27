with recursive hour as(
    select 0 as hour
    union all
    select hour + 1 from hour where hour < 23
)
select h.hour as HOUR, count(ao.ANIMAL_ID) as COUNT
from hour h
left join ANIMAL_OUTS as ao
on hour(ao.DATETIME) = h.hour
group by h.hour
order by h.hour