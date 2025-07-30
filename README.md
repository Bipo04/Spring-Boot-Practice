## 📘 User API
Base URL: `api/users`

---
### 1. Lấy danh sách tất cả người dùng

- **Method:** `GET`
- **Endpoint:** `/api/users`
- **Mô tả:** Trả về danh sách tất cả người dùng trong hệ thống.

---

### 2. Lấy thông tin người dùng theo id

- **Method:** `GET`
- **Endpoint:** `/api/users/:id`
- **Mô tả:** Trả về thông tin người dùng theo id.

---

### 3. Thêm người dùng mới

- **Method:** `POST`
- **Endpoint:** `/api/users`
- **Mô tả:** Thêm người người dùng mới vào trong hệ thống.
- **Input:**

```json
[
  {
    "username": "ledang",
    "password": "ledang123",
    "email": "ledang@example.com",
    "fullName": "Le Dang",
    "phone": "0123456789"
  }
]
```
---

### 4. Cập nhật thông tin người dùng

- **Method:** `PUT`
- **Endpoint:** `/api/users/:id`
- **Mô tả:** Cập nhật thông tin người dùng trong hệ thống.
- **Input:**

```json
[
  {
    "password": "ledang123",
    "email": "ledang@example.com",
    "fullName": "Le Dang",
    "phone": "0123456789"
  }
]


