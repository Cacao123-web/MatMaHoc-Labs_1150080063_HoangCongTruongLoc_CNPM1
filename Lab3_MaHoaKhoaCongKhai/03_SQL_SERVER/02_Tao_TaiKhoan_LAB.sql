-- SSMS: Query > SQLCMD Mode. Cung cap LAB3_PASSWORD qua sqlcmd/SQLCMD.
USE master;
GO
IF SUSER_ID(N'lab3_user') IS NULL
    CREATE LOGIN lab3_user WITH PASSWORD = '$(LAB3_PASSWORD)', CHECK_POLICY = ON;
GO
USE LAB3_MaHoaKhoaCongKhai;
GO
IF DATABASE_PRINCIPAL_ID(N'lab3_user') IS NULL
    CREATE USER lab3_user FOR LOGIN lab3_user;
GO
GRANT SELECT, INSERT ON OBJECT::dbo.History TO lab3_user;
GO
