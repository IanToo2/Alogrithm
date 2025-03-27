SELECT 
    YEAR(os.sales_date) as YEAR, 
    MONTH(os.sales_date) as MONTH, 
    UI.GENDER, 
    count(DISTINCT OS.USER_ID) as USERS
FROM ONLINE_SALE AS OS 
JOIN USER_INFO AS UI 
ON OS.USER_ID = UI.USER_ID
group by YEAR(os.sales_date), MONTH(os.sales_date), UI.gender
HAVING UI.GENDER is not null
order by YEAR(os.sales_date), MONTH(os.sales_date), UI.gender