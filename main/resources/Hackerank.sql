DECLARE @CC AS INT = (SELECT COUNT(CITY) FROM STATION) DECLARE @CDC AS INT = (SELECT COUNT(DISTINCT CITY) FROM STATION); SELECT @CC - @CDC;

SELECT * FROM( ( SELECT * FROM ( select CITY, LENGTH(CITY) K FROM STATION WHERE LENGTH(CITY) = ( SELECT MIN(LENGTH(CITY)) FROM STATION ) ORDER BY CITY ASC ) WHERE ROWNUM=1 ) UNION (SELECT * FROM ( select CITY, LENGTH(CITY) K FROM STATION WHERE LENGTH(CITY) = ( SELECT MAX(LENGTH(CITY)) FROM STATION ) ORDER BY CITY ASC ) WHERE ROWNUM=1 ) );

(SELECT CITY, LENGTH(CITY) FROM STATION ORDER BY LENGTH(CITY), CITY LIMIT 1) UNION (SELECT CITY, LENGTH(CITY) FROM STATION ORDER BY LENGTH(CITY) DESC, CITY ASC LIMIT 1);

select distinct city from station where city REGEXP "^[aeiou].*";

select distinct city from station where city REGEXP ".[aeiou]$";

select distinct city from station where city REGEXP "^[aeiou].*.[aeiou]$";

select distinct city from station where city NOT REGEXP  "^[aeiou].*";

select distinct city from station where city NOT REGEXP ".[aeiou]$";

select distinct city from station where city NOT REGEXP "^[aeiou].*.[aeiou]$";

select distinct city from station where city REGEXP "^[^aeiou].*.[^aeiou]$";

SELECT NAME FROM STUDENTS WHERE MARKS > 75 ORDER BY RIGHT(NAME, 3), ID ASC;

select name from students where marks>75 order by substring(name,len(name)-2, 3) , id asc;

SELECT h.hacker_id, 
       h.name, 
       COUNT(c.challenge_id) AS c_count
FROM Hackers h
JOIN Challenges c ON c.hacker_id = h.hacker_id
GROUP BY h.hacker_id, h.name
HAVING c_count = 
    (SELECT COUNT(c2.challenge_id) AS c_max
     FROM challenges as c2 
     GROUP BY c2.hacker_id 
     ORDER BY c_max DESC limit 1)
OR c_count IN 
    (SELECT DISTINCT c_compare AS c_unique
     FROM (SELECT h2.hacker_id, 
                  h2.name, 
                  COUNT(challenge_id) AS c_compare
           FROM Hackers h2
           JOIN Challenges c ON c.hacker_id = h2.hacker_id
           GROUP BY h2.hacker_id, h2.name) counts
     GROUP BY c_compare
     HAVING COUNT(c_compare) = 1)
ORDER BY c_count DESC, h.hacker_id;




SELECT 
CASE 
	WHEN A + B > C THEN 
	CASE 
		WHEN A = B AND B = C THEN 'Equilateral' 
		WHEN A = B OR B = C OR A = C THEN 'Isosceles' 
		WHEN A != B OR B != C OR A != C THEN 'Scalene' 
	END 
ELSE 'Not A Triangle' 
END 
FROM TRIANGLES;

select sum(population) from CITY where District = 'California';

select round(avg(population)) from CITY;

select sum(population) from CITY where COUNTRYCODE = 'JPN';

select (MAX(population) - MIN(population)) from CITY;

select max(months*salary), count(months*salary) from Employee where (months*salary) = (select max(months*salary) from Employee);

select round(sum(LAT_N), 2), round(sum(LONG_W), 2) from STATION;

select TRUNCATE(sum(LAT_N), 4) from STATION where LAT_N > 38.7880 and LAT_N < 137.2345;

select Truncate(max(LAT_N), 4) from STATION where LAT_N < 137.2345 ;

select round(LONG_W, 4) from STATION WHERE LAT_N=(SELECT MAX(LAT_N) FROM STATION WHERE LAT_N<137.2344);

select round(LAT_N, 4) from STATION WHERE LAT_N = (SELECT min(LAT_N) FROM STATION WHERE LAT_N > 38.7780);

select sum(c1.population) from CITY c1, COUNTRY c2 where c1.CountryCode = c2.Code and c2.CONTINENT = 'Asia';

select c2.Continent, floor(avg(c1.population)) from CITY c1, COUNTRY c2 where c1.CountryCode = c2.Code group by c2.Continent;

SELECT 
REPEAT('* ', @NUMBER := @NUMBER - 1) 
FROM information_schema.tables, (SELECT @NUMBER:=21) T LIMIT 20;

SELECT 
REPEAT('* ', @NUMBER := @NUMBER + 1) 
FROM information_schema.tables, (SELECT @NUMBER:=0) T LIMIT 20;



select concat(Name,"(",Substring(Occupation,1,1),")") as Name
from occupations
Order by Name;

select concat("There are a total of ",count(occupation)," ",lower(occupation),"s.") as total
from occupations
group by occupation
order by total;


set @r1=0, @r2=0, @r3=0, @r4=0;
select min(Doctor), min(Professor), min(Singer), min(Actor)
from(
  select case 
            when Occupation='Doctor' then (@r1:=@r1+1)
            when Occupation='Professor' then (@r2:=@r2+1)
            when Occupation='Singer' then (@r3:=@r3+1)
            when Occupation='Actor' then (@r4:=@r4+1) 
         end as RowNumber,
    case  
    when Occupation='Doctor' then Name 
    end as Doctor,
    case 
    when Occupation='Professor' then Name 
    end as Professor,
    case 
    when Occupation='Singer' then Name 
    end as Singer,
    case 
    when Occupation='Actor' then Name 
    end as Actor
  from OCCUPATIONS
  order by Name
) Temp
group by RowNumber;


select N, IF(P IS NULL,'Root', IF((SELECT COUNT(*) FROM BST WHERE P=B.N)>0,'Inner','Leaf')) from BST B order by N;

select C.company_code, C.founder, count(distinct L.lead_manager_code), count(distinct S.senior_manager_code), count(distinct M.manager_code), count(distinct E.employee_code) from  Company C, Lead_Manager L, Senior_Manager S, Manager M, Employee E  where C.company_code = L.company_code and L.lead_manager_code = S.lead_manager_code and S.senior_manager_code = M.senior_manager_code and M.manager_code = E.manager_code group by C.company_code, C.founder  Order by C.company_code;


select round(max(lat_n)- min(lat_n) + max(long_w)-min(long_w),4) from station

select ROUND(pow(pow(abs(Max(Lat_n)-min(Lat_n)),2)+pow(abs(Max(long_w)-min(long_w)),2),1/2),4) from station;

SELECT (CASE g.grade>=8 
        WHEN TRUE 
        THEN s.name 
        ELSE null END)
,g.grade,s.marks FROM students s INNER JOIN grades g ON s.marks BETWEEN min_mark AND max_mark ORDER BY g.grade DESC,s.name,s.marks;


select h.hacker_id, h.name
from submissions s
inner join challenges c
on s.challenge_id = c.challenge_id
inner join difficulty d
on c.difficulty_level = d.difficulty_level 
inner join hackers h
on s.hacker_id = h.hacker_id
where s.score = d.score and c.difficulty_level = d.difficulty_level
group by h.hacker_id, h.name
having count(s.hacker_id) > 1
order by count(s.hacker_id) desc, s.hacker_id asc


SELECT temp2.I, temp2.A, temp2.WNN, temp2.P FROM (SELECT MIN(W1.COINS_NEEDED) AS WN, WP1.AGE as AG, W1.POWER AS PW FROM WANDS W1 INNER JOIN WANDS_PROPERTY WP1 ON W1.CODE=WP1.CODE 
 GROUP BY W1.POWER, WP1.AGE ORDER BY W1.POWER DESC, WP1.AGE DESC) temp1
INNER JOIN
(SELECT W.ID AS I, MIN(W.COINS_NEEDED) AS WNN, WP.AGE as A, W.POWER AS P  FROM WANDS W INNER JOIN WANDS_PROPERTY WP ON W.CODE=WP.CODE 
WHERE WP.IS_EVIL=0
GROUP BY W.POWER, WP.AGE, W.ID ORDER BY W.POWER DESC, WP.AGE DESC) temp2
ON temp1.WN=temp2.WNN AND temp1.PW=temp2.P AND temp1.AG=temp2.A;


select H.hacker_id, H.name, sum(score) as TOTAL from Hackers as H inner join (select hacker_id,  max(score) as score from Submissions group by challenge_id, hacker_id) S where H.hacker_id = S.hacker_id group by H.hacker_id, name having TOTAL > 0 order by TOTAL desc, H.hacker_id;


SET sql_mode = '';
SELECT Start_Date, End_Date
FROM 
    (SELECT Start_Date FROM Projects WHERE Start_Date NOT IN (SELECT End_Date FROM Projects)) a,
    (SELECT End_Date FROM Projects WHERE End_Date NOT IN (SELECT Start_Date FROM Projects)) b 
WHERE Start_Date < End_Date
GROUP BY Start_Date 
ORDER BY DATEDIFF(End_Date, Start_Date), Start_Date


Select S.Name
From ( Students S join Friends F Using(ID)
       join Packages P1 on S.ID=P1.ID
       join Packages P2 on F.Friend_ID=P2.ID)
Where P2.Salary > P1.Salary
Order By P2.Salary;



Select distinct a.x as w, a.y from functions a ,functions b Where a.x =b.y and b.x = a.y and a.x < b.x Union all Select a1.x as w,a1.y from functions a1 where a1.x = a1.y group by a1.x,a1.y having count(*)>1 Order by w;

select con.contest_id,
        con.hacker_id, 
        con.name, 
        sum(total_submissions), 
        sum(total_accepted_submissions), 
        sum(total_views), sum(total_unique_views)
from contests con 
join colleges col on con.contest_id = col.contest_id 
join challenges cha on  col.college_id = cha.college_id 
left join
(select challenge_id, sum(total_views) as total_views, sum(total_unique_views) as total_unique_views
from view_stats group by challenge_id) vs on cha.challenge_id = vs.challenge_id 
left join
(select challenge_id, sum(total_submissions) as total_submissions, sum(total_accepted_submissions) as total_accepted_submissions from submission_stats group by challenge_id) ss on cha.challenge_id = ss.challenge_id
    group by con.contest_id, con.hacker_id, con.name
        having sum(total_submissions)!=0 or 
                sum(total_accepted_submissions)!=0 or
                sum(total_views)!=0 or
                sum(total_unique_views)!=0
            order by contest_id;
			
			


select big_1.submission_date, big_1.hkr_cnt, big_2.hacker_id, h.name
from
(select submission_date, count(distinct hacker_id) as hkr_cnt
from 
(select s.*, dense_rank() over(order by submission_date) as date_rank, 
dense_rank() over(partition by hacker_id order by submission_date) as hacker_rank 
from submissions s ) a 
where date_rank = hacker_rank 
group by submission_date) big_1 
join 
(select submission_date,hacker_id, 
 rank() over(partition by submission_date order by sub_cnt desc, hacker_id) as max_rank 
from (select submission_date, hacker_id, count(*) as sub_cnt 
      from submissions 
      group by submission_date, hacker_id) b ) big_2
on big_1.submission_date = big_2.submission_date and big_2.max_rank = 1 
join hackers h on h.hacker_id = big_2.hacker_id 
order by 1 




