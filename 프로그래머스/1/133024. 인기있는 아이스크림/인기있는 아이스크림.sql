-- 코드를 입력하세요
SELECT FLAVOR
FROM FIRST_HALF
GROUP BY FLAVOR
ORDER BY TOTAL_ORDER DESC, SHIPMENT_ID ASC;