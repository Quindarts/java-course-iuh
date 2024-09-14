

## Mục Lục

## I. JAVA CORE

1. **[Các phiên bản Java](#các-phiên-bản-java)**


2. **[Các kiểu dữ liệu](#các-kiểu-dữ-liệu)**


3. **[Style Code Java](#style-code-java)**
  

## II. JDK và Jakarta EE

1. **[JDK (Java Development Kit)](#jdk-java-development-kit)**

2. **[Jakarta EE (trước đây là Java EE)](#jakarta-ee-trước-đây-là-java-ee)**

3. **[Sự khác biệt chính giữa JDK và Jakarta EE](#sự-khác-biệt-chính-giữa-jdk-và-jakarta-ee)**
   
## III. Tổng hợp các loại Project trong Java

1. **[Java Project (Thông thường)](#java-project-thông-thường)**

2. **[Maven Project](#maven-project)**


3. **[Servlet Project](#servlet-project)**


4. **[JPA (Java Persistence API) Project](#jpa-java-persistence-api-project)**

5. **[Kết hợp Maven, JPA và Servlets](#kết-hợp-maven-jpa-và-servlets)**

# I. JAVA CORE

<a name="cac-phien-ban-java"></a>

## 1. Các phiên bản Java

- **Java 1.0**: Ra mắt năm 1996, phiên bản đầu tiên của Java.
- ......1.0 - 16.0
- **Java 17 (Java SE 17)**: Ra mắt năm 2021, phiên bản LTS, giới thiệu nhiều cải tiến và tính năng mới.
- ......18.0 - 20.0
- **Java 21 (Java SE 21)**: Ra mắt năm 2023, phiên bản LTS với nhiều cải tiến quan trọng.


## 2. Các kiểu dữ liệu
<a name="cac-kieu-du-lieu"></a>

### Kiểu dữ liệu nguyên thủy

- **byte**: 8-bit, từ -128 đến 127
- **short**: 16-bit, từ -32,768 đến 32,767
- **int**: 32-bit, từ -2^31 đến 2^31-1
- **long**: 64-bit, từ -2^63 đến 2^63-1
- **float**: 32-bit số thực
- **double**: 64-bit số thực
- **char**: 16-bit ký tự Unicode
- **boolean**: true hoặc false

### Kiểu dữ liệu tham chiếu

- **String**: Chuỗi ký tự
- **Arrays**: Mảng của bất kỳ kiểu dữ liệu nào
- **Classes**: Lớp định nghĩa kiểu dữ liệu mới
- **Interfaces**: Giao diện định nghĩa hợp đồng cho các lớp

## 3. Style Code Java

<a name="style-code-java"></a>

### Quy tắc đặt tên

- **Classes**: Sử dụng CamelCase (e.g., `MyClass`, `StudentRecord`)
- **Methods**: Sử dụng camelCase (e.g., `calculateTotal`, `getName`)
- **Variables**: Sử dụng camelCase (e.g., `totalAmount`, `studentList`)
- **Constants**: Sử dụng ALL_UPPERCASE với dấu gạch dưới (e.g., `MAX_VALUE`, `DEFAULT_TIMEOUT`)

# II. JDK và Jakarta EE

<a name="jdk-jakarta-ee"></a>


## 1. JDK (Java Development Kit)

<a name="jdk"></a>


**JDK** là bộ công cụ phát triển chính thức dành cho Java. Nó bao gồm:

- **JVM (Java Virtual Machine)**: Chạy mã bytecode Java.
- **JRE (Java Runtime Environment)**: Cung cấp môi trường để chạy các ứng dụng Java.
- **Compiler (javac)**: Biên dịch mã nguồn Java thành bytecode.
- **Libraries và Tools**: Các thư viện và công cụ phát triển.

## 2. Jakarta EE (trước đây là Java EE)

<a name="jakarta-ee"></a>

**Jakarta EE** (trước đây gọi là Java EE - Java Platform, Enterprise Edition) là một bộ công nghệ và API để phát triển ứng dụng doanh nghiệp và web với Java. Nó bao gồm các thư viện và API cho:

- **Servlets**: Xử lý các yêu cầu HTTP trong ứng dụng web.
- **JavaServer Pages (JSP)**: Tạo nội dung động cho trang web.
- **Enterprise JavaBeans (EJB)**: Cung cấp dịch vụ cho các ứng dụng phân tán.
- **Java Persistence API (JPA)**: Quản lý và ánh xạ dữ liệu giữa cơ sở dữ liệu và các đối tượng Java.
- **Context and Dependency Injection (CDI)**: Quản lý phụ thuộc và các ngữ cảnh trong ứng dụng.

Vào năm 2017, Oracle đã chuyển giao việc phát triển Java EE cho Eclipse Foundation, và từ đó nó được gọi là Jakarta EE.

## 3. Sự khác biệt chính giữa JDK và Jakarta EE

<a name="su-khac-biet-jdk-jakarta-ee"></a>


- **JDK** là bộ công cụ phát triển cho Java, bao gồm tất cả các công cụ cần thiết để phát triển và chạy các ứng dụng Java nói chung.
- **Jakarta EE** là một tập hợp các API và công nghệ để phát triển các ứng dụng doanh nghiệp và web với Java. `Nó không phải là công cụ phát triển` riêng biệt mà thường được triển khai trên các máy chủ ứng dụng Java EE.

### Ví dụ về Jakarta EE

<a name="jakarta-ee-example"></a>


- **Tomcat** và **WildFly** là các máy chủ ứng dụng hỗ trợ Jakarta EE.
- **Spring** là một framework phổ biến được sử dụng trong cộng đồng Java để xây dựng các ứng dụng tương tự Jakarta EE, nhưng với một cách tiếp cận khác.

# ||| Tổng hợp các loại Project trong Java

<a name="tong-hop-cac-loai-project-trong-java"></a>

<a name="java-project"></a>

## 1. Java Project (Thông thường)

> **Java Project** là một dự án Java cơ bản, có thể sử dụng nhiều công cụ xây dựng khác nhau như Maven, Gradle, hoặc không dùng công cụ nào. Dự án này thường có cấu trúc cơ bản và không sử dụng hệ thống quản lý phụ thuộc tự động.

### Đặc điểm:

- **Cấu trúc tùy chỉnh**: Người dùng có thể tùy chỉnh cấu trúc dự án theo nhu cầu.
- **Quản lý phụ thuộc thủ công**: Không có công cụ tự động để quản lý phụ thuộc.

### Cấu trúc dự án cơ bản:

- **`src`**: Thư mục chứa mã nguồn.
  - **`src/main/java`**: Mã nguồn chính.
  - **`src/test/java`**: Mã nguồn kiểm thử.
- **`lib`**: Thư mục chứa các thư viện bên ngoài (nếu cần).
- **`bin`**: Thư mục chứa các file biên dịch (nếu cần).


<a name="maven-project"></a>

## 2. Maven Project

> **Maven** là một công cụ quản lý dự án và xây dựng dựa trên định dạng POM (Project Object Model). Nó giúp quản lý các phụ thuộc, xây dựng dự án, và thực hiện các tác vụ khác.

### Đặc điểm:

- **Quản lý phụ thuộc**: Maven tự động tải xuống và quản lý các thư viện và phụ thuộc của dự án từ các kho lưu trữ trực tuyến.
- **Xây dựng và phát hành**: Maven sử dụng tệp `pom.xml` để cấu hình quá trình xây dựng và phát hành dự án.
- **Quản lý phiên bản**: Maven hỗ trợ việc quản lý phiên bản của các phụ thuộc và plugin.

### Cấu trúc dự án:

- **`pom.xml`**: Tệp cấu hình chính, định nghĩa phụ thuộc, plugin, và các thiết lập dự án.
- **`src/main/java`**: Mã nguồn chính.
- **`src/test/java`**: Mã nguồn kiểm thử.
- **`src/main/resources`**: Tài nguyên (config files, templates, etc.)


<a name="servlet-project"></a>

## 3. Servlet Project

> **Servlet** là một công nghệ Java cho phép tạo các ứng dụng web động. Servlets chạy trên máy chủ ứng dụng và xử lý các yêu cầu HTTP.

### Đặc điểm:

- **Xử lý yêu cầu HTTP**: Servlets xử lý các yêu cầu từ trình duyệt và trả về phản hồi.
- **Dễ dàng tích hợp với JSP**: Servlets thường được sử dụng cùng với JSP (JavaServer Pages) để tạo các ứng dụng web động.

### Cấu trúc dự án:

- **`WEB-INF`**: Thư mục chứa cấu hình và các lớp của dự án.
  - **`web.xml`**: Tệp cấu hình của ứng dụng web.
  - **`classes`**: Thư mục chứa các lớp biên dịch (Servlets và các lớp khác).
  - **`lib`**: Thư mục chứa các thư viện bên ngoài.
- **`src`**: Mã nguồn của các Servlets.

<a name="jpa-project"></a>

## 3. JPA (Java Persistence API) Project

**JPA** là một API của Java cho phép quản lý dữ liệu trong cơ sở dữ liệu quan hệ bằng cách sử dụng các đối tượng Java.

### Đặc điểm:

- **Quản lý đối tượng**: JPA ánh xạ các đối tượng Java với các bảng trong cơ sở dữ liệu.
- **Tích hợp với các công nghệ khác**: JPA thường được sử dụng với các công nghệ khác như Hibernate hoặc EclipseLink.

### Cấu trúc dự án:

- **`src/main/java`**: Mã nguồn chính, bao gồm các thực thể JPA và repository.
- **`META-INF/persistence.xml`**: Tệp cấu hình JPA, định nghĩa các thực thể và nguồn dữ liệu.
- **`resources`**: Tài nguyên cấu hình khác.

<a name="ket-hop-maven-jpa-servlets"></a>

# Kết hợp Maven, JPA và Servlets

Khi kết hợp Maven, JPA và Servlets, cấu trúc dự án của bạn có thể trông như thế này:

```css
my-web-app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── example/
│   │   │   │       ├── servlet/
│   │   │   │       │   └── MyServlet.java
│   │   │   │       └── entity/
│   │   │   │           └── User.java
│   │   ├── resources/
│   │   │   └── META-INF/
│   │   │       └── persistence.xml
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml
│   │       └── index.jsp
├── target/
│   └── (compiled and packaged files)
├── pom.xml
└── README.md

```
