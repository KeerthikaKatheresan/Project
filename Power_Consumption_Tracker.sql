CREATE DATABASE PowerConsumptionDB;
USE PowerConsumptionDB;
CREATE TABLE Customer(
CustomerId INT PRIMARY KEY,
Name VARCHAR(30) NOT NULL,
Address VARCHAR(40) NOT NULL,
PhoneNumber VARCHAR(10) NOT NULL,
Email VARCHAR(50) UNIQUE
);
INSERT INTO  Customer(CustomerId,Name,Address,PhoneNumber,Email)
VALUES(1, 'Alice Johnson', '123 Main Street, Chennai', '9876543210', 'alice.johnson@example.com'),
(2, 'Ravi Kumar', '45 Gandhi Road, Bangalore', '9123456780', 'ravi.kumar@example.com'),
(3, 'Sophia Lee', '78 MG Road, Mumbai', '9988776655', 'sophia.lee@example.com'),
(4, 'David Smith', '12 Park Avenue, Delhi', '9765432109', 'david.smith@example.com'),
(5, 'Meera Nair', '56 Lotus Street, Kochi', '9345678901', 'meera.nair@example.com'),
(6, 'Arjun Mehta', '22 Lake View Road, Pune', '9812345678', 'arjun.mehta@example.com'),
(7, 'Priya Sharma', '89 Rose Garden, Jaipur', '9823456789', 'priya.sharma@example.com'),
(8, 'Carlos Fernandez', '15 Ocean Drive, Goa', '9834567890', 'carlos.fernandez@example.com'),
(9, 'Emily Davis', '77 Hilltop Lane, Hyderabad', '9845678901', 'emily.davis@example.com'),
(10, 'Karan Patel', '34 Sunshine Colony, Ahmedabad', '9856789012', 'karan.patel@example.com'),
(11, 'Fatima Khan', '101 Pearl Street, Lucknow', '9867890123', 'fatima.khan@example.com'),
(12, 'George Wilson', '65 Maple Avenue, Kolkata', '9878901234', 'george.wilson@example.com'),
(13, 'Neha Verma', '48 Orchid Road, Chandigarh', '9889012345', 'neha.verma@example.com'),
(14, 'James Brown', '29 Green Park, Delhi', '9890123456', 'james.brown@example.com'),
(15, 'Ananya Iyer', '73 Lotus Enclave, Chennai', '9901234567', 'ananya.iyer@example.com');


CREATE TABLE Meter(
MeterId INT PRIMARY KEY,
CustomerId INT,
Installationdate DATE NOT NULL,
LastReadingDate DATE NOT NULL,
CONSTRAINT fk_customer 
	FOREIGN KEY (CustomerId)
    REFERENCES Customer(CustomerId)
    ON DELETE CASCADE
);

INSERT INTO Meter(MeterId,CustomerId,Installationdate,LastReadingDate)VALUES
(101, 1,  '2023-01-15', '2023-11-20'),
(102, 2,  '2023-02-10', '2023-11-21'),
(103, 3,  '2023-03-05', '2023-11-22'),
(104, 4,  '2023-04-12', '2023-11-23'),
(105, 5,  '2023-05-18', '2023-11-24'),
(106, 6,  '2023-06-01', '2023-11-25'),
(107, 7,  '2023-06-15', '2023-11-26'),
(108, 8,  '2023-07-05', '2023-11-27'),
(109, 9,  '2023-07-20', '2023-11-28'),
(110, 10, '2023-08-10', '2023-11-29'),
(111, 11, '2023-08-25', '2023-11-30'),
(112, 12, '2023-09-05', '2023-12-01'),
(113, 13, '2023-09-18', '2023-12-02'),
(114, 14, '2023-10-01', '2023-12-03'),
(115, 15, '2023-10-15', '2023-12-04');

CREATE TABLE ElectricityUsage(
UsageId INT PRIMARY KEY,
MeterId INT ,
ReadingDate DATE NOT NULL,
UsageUnits NUMERIC CHECK (UsageUnits>=0),
CONSTRAINT fk_meter 
FOREIGN KEY (MeterId)
REFERENCES Meter(MeterId)
ON DELETE CASCADE);

INSERT INTO ElectricityUsage(UsageId,MeterId,ReadingDate,UsageUnits)
VALUES
(1, 101, '2025-01-05', 120),
(2, 101, '2025-02-05', 135),
(3, 101, '2025-03-05', 140),
(4, 102, '2025-01-10', 200),
(5, 102, '2025-02-10', 180),
(6, 102, '2025-03-10', 190),
(7, 103, '2025-01-15', 95),
(8, 103, '2025-02-15', 110),
(9, 103, '2025-03-15', 105),
(10, 104, '2025-01-20', 250),
(11, 104, '2025-02-20', 260),
(12, 104, '2025-03-20', 270),
(13, 105, '2025-01-25', 300),
(14, 105, '2025-02-25', 310),
(15, 105, '2025-03-25', 320);

CREATE TABLE Bill(
BillId INT PRIMARY KEY,
MeterId INT,
BillDate DATE NOT NULL,
AmountDue NUMERIC CHECK (AmountDue>=0),
DueDate DATE NOT NULL,
Paid BOOLEAN NOT NULL DEFAULT 0,
CONSTRAINT fk_bill
FOREIGN KEY (MeterId)
REFERENCES Meter(MeterId)
ON DELETE CASCADE
);

INSERT INTO Bill(BillId,MeterId,BillDate,AmountDue,DueDate,Paid)
VALUES
(1, 101, '2025-01-05', 1200, '2025-01-20', 0),
(2, 102, '2025-01-10', 1500, '2025-01-25', 1),
(3, 103, '2025-01-15', 900,  '2025-01-30', 0),
(4, 104, '2025-01-20', 2000, '2025-02-05', 1),
(5, 105, '2025-01-25', 2500, '2025-02-10', 0),
(6, 106, '2025-02-01', 1100, '2025-02-15', 0),
(7, 107, '2025-02-05', 1300, '2025-02-20', 1),
(8, 108, '2025-02-10', 1700, '2025-02-25', 0),
(9, 109, '2025-02-15', 800,  '2025-03-01', 0),
(10, 110, '2025-02-20', 2200, '2025-03-05', 1),
(11, 111, '2025-02-25', 1400, '2025-03-10', 0),
(12, 112, '2025-03-01', 1600, '2025-03-15', 0),
(13, 113, '2025-03-05', 1900, '2025-03-20', 1),
(14, 114, '2025-03-10', 2100, '2025-03-25', 0),
(15, 115, '2025-03-15', 2300, '2025-03-30', 1);

CREATE TABLE Payment(
PaymentId INT PRIMARY KEY,
BillId INT,
PaymentDate DATE NOT NULL,
AmountPaid NUMERIC CHECK (AmountPaid>=0),
CONSTRAINT fk_payment
	FOREIGN KEY (BillId)
	REFERENCES Bill(BillId)
	ON DELETE CASCADE
);

INSERT INTO Payment(PaymentId,BillId,PaymentDate,AmountPaid)
VALUES
(1, 1,  '2025-01-15', 1200),
(2, 2,  '2025-01-20', 1500),
(3, 3,  '2025-01-25', 900),
(4, 4,  '2025-02-01', 2000),
(5, 5,  '2025-02-05', 2500),
(6, 6,  '2025-02-10', 1100),
(7, 7,  '2025-02-15', 1300),
(8, 8,  '2025-02-20', 1700),
(9, 9,  '2025-02-25', 800),
(10, 10, '2025-03-01', 2200),
(11, 11, '2025-03-05', 1400),
(12, 12, '2025-03-10', 1600),
(13, 13, '2025-03-15', 1900),
(14, 14, '2025-03-20', 2100),
(15, 15, '2025-03-25', 2300);

