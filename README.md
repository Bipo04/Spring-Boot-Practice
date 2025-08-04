## 💼 Spring Boot User Management Project

Dự án Spring Boot đơn giản quản lý người dùng với các tính năng:

---

### 🔐 Tính năng chính

- ✅ Đăng nhập bằng `formLogin` (Spring Security)
- ✅ Phân quyền truy cập theo Role (`ADMIN`, `USER`)
- ✅ Thiết kế RESTful API cho quản lý người dùng:
  - `ADMIN`: thêm, sửa, xoá, xem danh sách user
  - `USER`: xem & cập nhật thông tin cá nhân (`/user/me`)
- ✅ Xác thực & mã hoá mật khẩu bằng `BCrypt`
- ✅ Ghi log hoạt động hệ thống (`SLF4J`, `LoggerFactory`)
- ✅ Sử dụng DTO để truyền dữ liệu (`UserCreateDTO`, `UserUpdateDTO`)
- ✅ Validation đầu vào với annotation (`@Valid`, `@NotBlank`, `@Email`, ...)

---

## 📌 API Endpoints

### 🔐 Authentication

**POST /login**  
Đăng nhập sử dụng `formLogin` (mặc định của Spring Security).  
Gửi `username` và `password` dưới dạng `form-data` hoặc `x-www-form-urlencoded`.

#### 🧪 Tài khoản mặc định đã được khởi tạo:

| Role  | Username | Password |
|-------|----------|----------|
| ADMIN | admin    | 123456   |
| USER  | user     | 123456   |
> Sau khi đăng nhập thành công, hệ thống sẽ lưu session hoặc cookie để xác thực các request sau.

---

### 👤 User APIs (Role: `USER`, `ADMIN`)

#### `GET /user/me`  
Lấy thông tin người dùng hiện tại (đã đăng nhập)

#### `PUT /user/me`  
Cập nhật thông tin cá nhân

**Request Body (JSON):**
```json
{
  "fullName": "Tên mới",
  "email": "email@gmail.com",
  "phone": "0123456789",
  "password": "matkhau_moi"
}
```

### 🛠 Admin APIs (Chỉ dành cho ADMIN)

#### `GET /admin/users`
Lấy danh sách tất cả người dùng

#### `GET /admin/users/{userId}`
Lấy thông tin người dùng theo ID

#### `POST /admin/users`
Thêm mới người dùng

**Request Body (JSON):**

```json
{
  "username": "newuser",
  "password": "123456",
  "fullName": "New User",
  "email": "new@gmail.com",
  "phone": "0123456789"
}
```

#### `PUT /admin/users/{userId}`
Cập nhật thông tin người dùng theo ID

**Request Body (JSON):**

```json
{
  "password": "123456",
  "fullName": "New User",
  "email": "new@gmail.com",
  "phone": "0123456789"
}
```

#### `DELETE /admin/users/{userId}`
Xoá người dùng theo ID
