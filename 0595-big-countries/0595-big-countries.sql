# Write your MySQL query statement below
# select name, population, area from World where area >= 3000000 or population >= 25000000
select area,population,name
from world
where area>=3000000
union
select area,population,name
from world
where population>=25000000
