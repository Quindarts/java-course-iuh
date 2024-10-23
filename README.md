# setup pom.xml
```java
<dependencies>
		<!-- JSP and Servlets API-->
		<dependency>
			<groupId>jakarta.servlet</groupId>
			<artifactId>jakarta.servlet-api</artifactId>
			<version>6.0.0</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>jakarta.servlet.jsp</groupId>
			<artifactId>jakarta.servlet.jsp-api</artifactId>
			<version>3.1.1</version>
			<scope>provided</scope>
		</dependency>

		<!-- JSTL -->
		<dependency>
			<groupId>jakarta.servlet.jsp.jstl</groupId>
			<artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
			<version>3.0.0</version>
		</dependency>
		<dependency>
			<groupId>org.glassfish.web</groupId>
			<artifactId>jakarta.servlet.jsp.jstl</artifactId>
			<version>3.0.1</version>
		</dependency>

		<!-- Jakarta Persistence API -->
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>6.4.4.Final</version>
		</dependency>

		<!-- Hibernate validator -->
		<dependency>
			<groupId>org.hibernate.validator</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>8.0.0.Final</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-validator</artifactId>
			<version>8.0.0.Final</version>
		</dependency>
		<!-- Jakarta Enterprise Beans phiên bean hay entity bean.-->
		<dependency>
			<groupId>jakarta.ejb</groupId>
			<artifactId>jakarta.ejb-api</artifactId>
			<version>4.0.1</version>
		</dependency>
		<!-- Cung cấp các chú thích chuẩn của Jakarta cho quản lý vòng đời và
		tài nguyên. -->
		<dependency>
			<groupId>jakarta.annotation</groupId>
			<artifactId>jakarta.annotation-api</artifactId>
			<version>3.0.0</version>
			<scope>provided</scope>
		</dependency>
		<!-- Cung cấp CDI cho môi trường Servlet -->
		<dependency>
			<groupId>org.jboss.weld.servlet</groupId>
			<artifactId>weld-servlet-core</artifactId>
			<version>5.1.2.Final</version>
		</dependency>
		<!-- MySQL JDBC driver -->
		<dependency>
			<groupId>com.microsoft.sqlserver</groupId>
			<artifactId>mssql-jdbc</artifactId>
			<version>12.3.0.jre17-preview</version>
		</dependency>
	</dependencies>
```
# setup persistence
```java
<persistence-unit name="gk_02">
		<provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
		<properties>
			<property name="jakarta.persistence.jdbc.driver"
				value="com.microsoft.sqlserver.jdbc.SQLServerDriver" />
			<property name="jakarta.persistence.jdbc.dialect"
				value="org.hibernate.dialect.SQLServerDialect" />
			<property name="hibernate.connection.url"
				value="jdbc:sqlserver://localhost:1433;databaseName=gk_02;trustServerCertificate=true;encrypt=true;" />
			<property name="hibernate.connection.username" value="sa" />
			<property name="hibernate.connection.password"
				value="sapassword" />
			<property name="hibernate.hbm2ddl.auto" value="update" />
			<property name="hibernate.show_sql" value="false" />
			<property name="hibernate.format_sql" value="true" />
		</properties>
	</persistence-unit>
```
# setup jsp

```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
```
# setup URL Pattern
```java
@WebServlet(urlPatterns = { "/thuoc", "/loai-thuoc" })
```
# setup JPA

```java
@Table(name = "LOAITHUOC")
@Entity
public class LoaiThuoc {
	@Id
	@Column(name = "MALOAI")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maLoai;
	@Column(name = "TENLOAI", columnDefinition = "NVARCHAR(255)")
	private String tenLoai;

	@OneToMany(mappedBy = "loaiThuoc", cascade = CascadeType.ALL)
	private List<Thuoc> dsThuoc;
}
@Entity
@Table(name = "THUOC")
public class Thuoc {
	@Id
	@Column(name = "MATHUOC")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maThuoc;
	@Column(name = "TENTHUOC", columnDefinition = "NVARCHAR(255)")
	private String tenThuoc;
	@Column(name = "GIA")
	private double gia;
	@Column(name = "NAMSX")
	private int namsx;

	@ManyToOne
	@JoinColumn(name = "MALOAI")
	private LoaiThuoc loaiThuoc;
}
```
