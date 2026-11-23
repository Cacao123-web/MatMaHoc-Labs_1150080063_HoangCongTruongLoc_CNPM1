# LAB 2 – MÃ HÓA ĐỐI XỨNG HIỆN ĐẠI

**Học phần:** An toàn và Bảo mật thông tin  
**Họ và tên:** Hoàng Công Trường Lộc  
**MSSV:** 1150080063  
**Lớp:** CNPM1

## 1. Giới thiệu

Bài thực hành LAB 2 tập trung tìm hiểu và xây dựng các chương trình mã hóa, giải mã dữ liệu bằng các thuật toán mã hóa đối xứng hiện đại.

Ứng dụng chính được xây dựng bằng Java Swing trên Apache NetBeans, sử dụng Maven để quản lý thư viện và Microsoft SQL Server để quản lý tài khoản, lưu lịch sử thao tác.

Ngoài ra, bài thực hành còn có phần nâng cao sử dụng Python và Tkinter.

## 2. Nội dung thực hành

| Bài | Thuật toán | Nội dung |
|---|---|---|
| 2.1 | DES | Mã hóa và giải mã bằng DES-CBC, sử dụng IV ngẫu nhiên. |
| 2.2 | TripleDES | Mã hóa và giải mã bằng TripleDES với khóa 24 byte. |
| 2.3 | AES | AES-256-GCM kết hợp đăng ký, đăng nhập và SQL Server. |
| 2.4 | RC4 | Thực hiện mã hóa dòng RC4 và biểu diễn bản mã dạng HEX. |
| 2.5 | Twofish | Mã hóa Twofish-CBC, tạo IV và lưu/mở tệp mã hóa. |
| 2.6 | AES-CTR | Bài nâng cao bằng Java, sử dụng Key và Nonce. |
| 2.6 | AES-CBC | Bài nâng cao bằng Python với giao diện Tkinter. |

## 3. Công nghệ sử dụng

- Ngôn ngữ: Java, Python.
- Giao diện: Java Swing, Python Tkinter.
- IDE: Apache NetBeans.
- Quản lý thư viện: Apache Maven.
- Cơ sở dữ liệu: Microsoft SQL Server.
- Thư viện: Microsoft JDBC Driver, BouncyCastle, Python cryptography.
- JDK: 17 hoặc 21.
- Python: 3.10 trở lên.

## 4. Các chức năng chính

### 4.1. Mã hóa và giải mã dữ liệu

Thực hiện nhập bản rõ (Plaintext), khóa mã hóa (Key), sau đó mã hóa thành bản mã (Ciphertext) và giải mã khôi phục dữ liệu ban đầu.

### 4.2. Quản lý tài khoản

Sử dụng chức năng đăng ký và đăng nhập trong bài AES. Mật khẩu được xử lý bằng PBKDF2 kết hợp salt trước khi lưu vào SQL Server.

### 4.3. Quản lý lịch sử

Lưu thông tin các thao tác mã hóa, giải mã vào bảng `dbo.crypto_history`, bao gồm thuật toán, thao tác, người dùng, độ dài đầu vào và đầu ra.

### 4.4. Đọc và lưu tệp

Hỗ trợ mở và lưu dữ liệu mã hóa ra tệp văn bản. Đối với Twofish và AES-CTR, tệp lưu thông tin IV hoặc Nonce cần thiết cho quá trình giải mã.

## 5. Hướng dẫn chạy chương trình

### 5.1. Chạy chương trình Java

1. Mở Apache NetBeans.
2. Chọn File → Open Project.
3. Mở project `LAB2_MaHoaHienDai`.
4. Chọn Clean and Build.
5. Nhấn Run Project (F6).
6. Giao diện `frm_Menu` xuất hiện để chọn bài thực hành.

### 5.2. Kết nối SQL Server

1. Khởi động SQL Server Express.
2. Mở SQL Server Management Studio.
3. Chạy `01_Tao_CSDL.sql` để tạo cơ sở dữ liệu `LAB2_MaHoaHienDai`.
4. Chạy `02_Tao_Tai_Khoan_SQL.sql` để cấu hình tài khoản thực hành.
5. Mở chức năng Kết nối SQL Server trên ứng dụng.
6. Nhập thông tin kết nối phù hợp, sử dụng cổng `14333` theo hướng dẫn.
7. Chọn Test Connection để kiểm tra.

Cơ sở dữ liệu bao gồm:

- `dbo.app_users`: Lưu tài khoản người dùng.
- `dbo.crypto_history`: Lưu lịch sử thao tác mã hóa và giải mã.

### 5.3. Chạy chương trình AES-CBC bằng Python

Cài đặt thư viện:

`py -m pip install cryptography`

Mở thư mục chứa `aes_cbc_gui.py`, chạy:

`py aes_cbc_gui.py`

Tự kiểm thử:

`py aes_cbc_gui.py --self-test`

## 6. Kiểm thử chương trình

- **DES:** Mã hóa và giải mã khôi phục đúng dữ liệu ban đầu với khóa `12345678`.
- **TripleDES:** Giải mã đúng với khóa 24 byte; khóa không hợp lệ phải báo lỗi.
- **AES:** Kiểm tra đăng ký, đăng nhập, ticket và lưu dữ liệu SQL Server.
- **RC4:** Kiểm tra với Plaintext `Plaintext` và Key `Key`, bản mã chuẩn `BBF316E8D940AF0AD3`.
- **Twofish:** Mã hóa, giải mã và kiểm tra lưu/mở tệp chứa IV.
- **AES-CTR:** Giải mã đúng, độ dài bản mã bằng độ dài bản rõ theo byte.
- **AES-CBC Python:** Giải mã đúng và kiểm tra chế độ `--self-test`.


