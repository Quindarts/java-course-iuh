-- Tạo cơ sở dữ liệu
CREATE DATABASE BookStore;
GO
USE BookStore;
GO

-- Tạo bảng Books
CREATE TABLE Books (
    bookId INT IDENTITY(1,1) PRIMARY KEY,
    code NVARCHAR(10) NOT NULL UNIQUE,
    title NVARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    author NVARCHAR(255) NOT NULL,
    description TEXT,
    imageUrl VARCHAR(255)
);

-- Tạo bảng Orders
CREATE TABLE Orders (
    orderId INT IDENTITY(1,1) PRIMARY KEY,
    fullname VARCHAR(255) NOT NULL,
    shippingAddress VARCHAR(255) NOT NULL,
    paymentMethod VARCHAR(50) NOT NULL,
);

-- Tạo bảng OrderItems
CREATE TABLE OrderItems (
    orderItemId INT IDENTITY(1,1) PRIMARY KEY,
    orderId INT NOT NULL,
    bookId INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (orderId) REFERENCES Orders(orderId) ON DELETE CASCADE,
    FOREIGN KEY (bookId) REFERENCES Books(bookId) ON DELETE CASCADE
);

-- Thêm dữ liệu mẫu vào bảng Books
INSERT INTO Books (code, title, price, quantity, author, description, imageUrl) VALUES
('pro01', N'Sổ tay viết văn', 199000.00, 100, N'Tô Hoài', 'Mô tả sách Một', 'tohoai.png'),
('pro02', N'Nhật ký ma cà rồng', 299000.00, 50, N'CƠN THỊNH NỘ', 'Mô tả sách Hai', 'macarong.png'),
('pro03', N'Billy và Beth', 150000.00, 200, N'3 bí quyết của người thành đạt', 'Mô tả sách Ba', 'biquyet.png'),
('pro04', N'Bí mật một cái tên', 249000.00, 80, N'Dịch giả: Nguyễn Hồng Dung', 'Mô tả sách Bốn', 'bianmotcaiten.png'),
('pro05', N'Kẻ trộm sách', 350000.00, 30, N'Markus Zusak', 'Mô tả sách Năm', 'ketromsach.png'),
('pro06', N'Cơm & phở', 180000.00, 150, N'Xuân Sách', 'Mô tả sách Sáu', 'compho.png');

