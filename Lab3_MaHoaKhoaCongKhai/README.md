# LAB 3 – MÃ HÓA KHÓA CÔNG KHAI

**Học phần:** An toàn và Bảo mật thông tin  
**Họ và tên:** Hoàng Công Trường Lộc  
**MSSV:** 1150080063  
**Lớp:** CNPM1

## 1. Giới thiệu

Bài thực hành LAB 3 tập trung tìm hiểu và xây dựng các chương trình ứng dụng mật mã khóa công khai, mã hóa dữ liệu, hệ mã lai và chữ ký số.

Chương trình được xây dựng bằng ngôn ngữ Java với giao diện Java Swing trên Apache NetBeans, kết hợp Microsoft SQL Server để lưu trữ và quản lý lịch sử thao tác.

Các kỹ thuật chính bao gồm RSA, ECC, RSA kết hợp AES và chữ ký số ECDSA.

## 2. Nội dung thực hành

### Bài 3.1 – Mật mã RSA (Console)

- Tìm hiểu nguyên lý hoạt động của thuật toán RSA.
- Tạo cặp khóa công khai và khóa riêng RSA.
- Thực hiện mã hóa và giải mã thông điệp.
- Kiểm thử với kích thước khóa 2048 bit và 3072 bit.
- So sánh thời gian tạo khóa, độ dài bản mã và giới hạn dữ liệu đầu vào.
- Sử dụng RSA-OAEP với SHA-256.

### Bài 3.2 – Mật mã RSA với Java Swing

- Thiết kế giao diện `frm_RSA`.
- Tạo cặp khóa RSA 2048/3072 bit.
- Mã hóa dữ liệu bằng khóa công khai.
- Giải mã dữ liệu bằng khóa riêng.
- Hỗ trợ lưu và nạp cặp khóa thử nghiệm.
- Kiểm tra kết quả mã hóa và giải mã.

### Bài 3.3 – Mật mã ECC

- Thiết kế giao diện `frm_ECC`.
- Tạo cặp khóa trên đường cong elliptic `secp256r1` (P-256).
- Sử dụng ECDH để tạo bí mật chung.
- Dẫn xuất khóa bằng HKDF-SHA256.
- Mã hóa và giải mã dữ liệu bằng AES-256-GCM.
- Hỗ trợ lưu và nạp khóa.
- Kiểm tra khả năng phát hiện khóa sai.

### Bài 3.4 – Hệ mã lai RSA + AES

- Thiết kế giao diện `frm_RSA_AES`.
- Kết hợp hai thuật toán RSA và AES.
- Sử dụng AES-256-GCM để mã hóa dữ liệu dài.
- Sử dụng RSA-OAEP để mã hóa khóa AES.
- Thực hiện giải mã và khôi phục dữ liệu ban đầu.
- Kiểm tra khả năng phát hiện bản mã bị thay đổi.

### Bài 3.5 – Chữ ký số ECDSA

- Thiết kế giao diện `frm_ECC_Signature`.
- Tạo cặp khóa ECDSA.
- Ký thông điệp bằng khóa riêng.
- Xác minh chữ ký bằng khóa công khai.
- Hiển thị kết quả VALID hoặc INVALID.
- Kiểm tra chữ ký khi thay đổi nội dung thông điệp hoặc khóa xác minh.

## 3. Công nghệ sử dụng

- **Ngôn ngữ lập trình:** Java
- **IDE:** Apache NetBeans
- **Giao diện:** Java Swing
- **Quản lý dự án:** Apache Maven
- **JDK:** 17 hoặc 21
- **Cơ sở dữ liệu:** Microsoft SQL Server
- **Công cụ quản lý CSDL:** SQL Server Management Studio (SSMS)
- **Kết nối cơ sở dữ liệu:** JDBC
- **Thư viện:** Microsoft JDBC Driver
- **API mật mã:** java.security, javax.crypto

## 4. Các chức năng chính

### 4.1. Mã hóa và giải mã dữ liệu

Cho phép người dùng nhập bản rõ (Plaintext), tạo khóa mã hóa, thực hiện mã hóa và giải mã để khôi phục nội dung ban đầu.

### 4.2. Quản lý khóa

- Tạo khóa công khai và khóa riêng.
- Sử dụng khóa công khai để mã hóa.
- Sử dụng khóa riêng để giải mã.
- Lưu và nạp khóa phục vụ kiểm thử.
- Kiểm tra kết quả khi sử dụng khóa không hợp lệ.

### 4.3. Tạo và xác minh chữ ký số

- Tạo chữ ký số ECDSA.
- Xác minh tính hợp lệ của chữ ký.
- Phát hiện thông điệp bị thay đổi.
- Hiển thị kết quả xác minh VALID/INVALID.

### 4.4. Kết nối SQL Server

Chương trình sử dụng cơ sở dữ liệu `LAB3_MaHoaKhoaCongKhai` và bảng `dbo.History` để lưu trữ lịch sử thao tác.

Thông tin lưu trữ bao gồm:

- Thuật toán sử dụng.
- Loại thao tác: ENCRYPT, DECRYPT, SIGN, VERIFY.
- Độ dài dữ liệu đầu vào.
- Trạng thái thành công hoặc thất bại.
- Thời gian thực hiện.

### 4.5. Xem lịch sử thao tác

- Hiển thị danh sách lịch sử từ SQL Server.
- Xem thông tin các lần mã hóa, giải mã, ký và xác minh.
- Hỗ trợ tải lại dữ liệu lịch sử.

## 5. Hướng dẫn chạy chương trình

### 5.1. Chạy chương trình Java

1. Mở Apache NetBeans.
2. Chọn File → Open Project.
3. Mở project `LAB3_MaHoaKhoaCongKhai`.
4. Nhấn chuột phải vào project và chọn Clean and Build.
5. Nhấn Run Project (F6).
6. Giao diện chính `frm_Menu` xuất hiện.
7. Chọn chức năng cần thực hành.

Riêng bài 3.1 RSA Console, chạy file `RSADemo.java` bằng Run File (Shift + F6).

### 5.2. Cấu hình SQL Server

1. Khởi động SQL Server Express.
2. Mở SQL Server Management Studio.
3. Chạy file `01_Tao_CSDL.sql` để tạo cơ sở dữ liệu.
4. Chạy file `02_Tao_TaiKhoan_LAB.sql` để tạo tài khoản thực hành.
5. Mở chức năng Kết nối SQL Server trong ứng dụng.
6. Nhập thông tin kết nối theo cấu hình máy.
7. Nhấn Test Connection để kiểm tra.

Thông tin kết nối mặc định theo tài liệu thực hành:

- Server: `127.0.0.1`
- Port: `14333`
- Database: `LAB3_MaHoaKhoaCongKhai`
- User: `lab3_user`
- Password: Nhập mật khẩu tài khoản thực hành đã cấu hình trong SQL Server.

**Lưu ý:** Không công khai mật khẩu SQL Server hoặc khóa riêng thực tế lên GitHub.

## 6. Kiểm thử chương trình

### Kiểm thử RSA

- Plaintext: `HELLO RSA`
- Khóa: RSA 2048 bit và 3072 bit.
- Kết quả mong đợi: Giải mã khôi phục đúng thông điệp ban đầu.
- Giới hạn bản rõ với OAEP-SHA256: 190 byte (RSA-2048) và 318 byte (RSA-3072).

### Kiểm thử ECC

- Plaintext: `HELLO ECC`
- Kết quả mong đợi: Giải mã đúng bằng khóa hợp lệ.
- Khi sử dụng khóa riêng không tương ứng, giải mã phải thất bại.

### Kiểm thử RSA + AES

- Plaintext: Văn bản dài trên 1.000 ký tự.
- Kết quả mong đợi: Giải mã khôi phục toàn bộ nội dung.
- Khi bản mã bị thay đổi, thao tác giải mã phải thất bại.

### Kiểm thử ECDSA

- Thông điệp: `THONG DIEP A`
- Ký và xác minh bằng đúng cặp khóa: VALID.
- Thay đổi thành `THONG DIEP B`: INVALID.
- Thay đổi khóa xác minh: INVALID.

### Kiểm thử SQL Server

- Kết nối thành công với cơ sở dữ liệu.
- Thực hiện thao tác mã hóa, giải mã, ký hoặc xác minh.
- Kiểm tra các bản ghi trong bảng `dbo.History`.
- Hiển thị lịch sử trên giao diện Java Swing.

## 7. Hình ảnh minh chứng

Các hình ảnh cần chuẩn bị theo yêu cầu thực hành:

1. Kết quả chạy RSA Console với khóa 2048 và 3072 bit.
2. Giao diện RSA Swing khi mã hóa và giải mã.
3. Giao diện ECC khi giải mã thành công và khi sử dụng khóa sai.
4. Giao diện RSA + AES với văn bản dài và kiểm tra bản mã bị thay đổi.
5. Giao diện ECDSA với kết quả VALID và INVALID.
6. Giao diện kết nối SQL Server.
7. Giao diện lịch sử thao tác.
8. Kết quả truy vấn dữ liệu trong SQL Server Management Studio.


Ngoài ra, việc tích hợp Microsoft SQL Server giúp sinh viên làm quen với quá trình lưu trữ, quản lý và truy vấn lịch sử thao tác trong ứng dụng bảo mật thông tin.
