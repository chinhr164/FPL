-- 1. Lấy các thông tin trên bảng EMPLOYEES
SELECT *
FROM EMPLOYEES

-- 2. Giống câu 1, sắp xếp tăng dần theo tên (FirstName)
SELECT *
FROM EMPLOYEES
ORDER BY FIRSTNAME ASC

-- 3. Giống cầu 1, sắp xếp giảm dần theo tên (FirstName)
SELECT *
FROM EMPLOYEES
ORDER BY FIRSTNAME DESC

-- 4. Lấy thông tin các nhân viên có họ bắt đầu bằng D
--và sắp xếp dữ liệu giảm dần theo tên
SELECT *
FROM EMPLOYEES
WHERE LASTNAME LIKE 'D%'
ORDER BY FIRSTNAME DESC

-- 5. Lấy thông tin về họ tên nhân viên (nối họ và tên)
SELECT LASTNAME + ' ' + FIRSTNAME AS 'Họ và Tên'
FROM EMPLOYEES

--6. Lấy thông tin về họ của nhân viên, loại bỏ các dòng kết quả trùng
SELECT DISTINCT LASTNAME
FROM EMPLOYEES

-- 7. Hiện thị 5 dòng đầu tiên ở bảng Nhân Viên
SELECT TOP 5 *
FROM EMPLOYEES

-- 8. Hiển thị 10% của bảng Chi tiết bán hàng
SELECT TOP 10 PERCENT *
FROM [Order Details]