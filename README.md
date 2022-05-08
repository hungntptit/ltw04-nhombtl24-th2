# ltw04-nhombtl24-th2

Mô tả cách làm
- Dependencies
	- spring-boot-starter-data-jpa
	- spring-boot-starter-thymeleaf
	- spring-boot-starter-web
	- spring-boot-devtools
	- lombok
	- spring-boot-starter-test
	- mysql-connector-java
	- spring-boot-starter-validation
- Application.properties chứa thông tin kết nối CSDL.
- Lớp Product
- Các view:
	- index.html
	- display.html
	- add.html
	- edit.html
	- delete.html
- Kiểm tra lỗi:
	- Sử dụng annotation trong lớp Product và hiển thị lỗi với Thymeleaf 
- WebController
	- getIndex(): chuyển trang index
	- getDisplay(): chuyển trang danh sách sản phẩm
	- getAdd(): chuyển trang thêm sản phẩm
	- addProduct(): kiểm tra lỗi và thực hiện lưu sản phẩm
	- confirmDelete(): chuyển trang xác nhận xoá sản phẩm
	- deleteProcess(): thực hiện xoá sản phẩm 
	- editProduct(): chuyển trang sửa sản phẩm
	- doEditProduct(): kiểm tra lỗi và thực hiện cập nhật sản phẩm
Thành viên:
	- Làm chung: hiển thị danh sách sản phẩm
	- Đỗ Ngọc Cường: xoá sản phẩm
	- Nguyễn Thanh Hùng: thêm sản phẩm, kiểm tra dữ liệu
	- Nguyễn Như Mạnh: sửa sản phẩm
