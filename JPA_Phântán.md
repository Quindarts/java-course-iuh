# Lesson 1: Jakarta Persistence API (JPA)

![alt text](image.png)

# 0. Basic type:

## Enum

## Khởi tạo 1 enum:

```java

public enum Size {
	LARGE("LARGE"), MEDIUM("MEDIUM"), SMALL("SMALL");

	private String name;

	Size(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
```

## Sử dụng Enum:

```java 

@Entity
@Table(name = "beverages")
public class Beverage extends Item implements Serializable {

@Enumerated(EnumType.STRING)
private Size size;

}

```

# 1. Element Collection:

![alt text](image-1.png)

![alt text](image-2.png)
#### Example:

```java
@ElementCollection
@CollectionTable(name = "phones", joinColumns = @JoinColumn(name = "staff_id"))
@Column(name = "number", nullable = false)
private Set<String> phoneNumbers;
```

#### Description:

`@ElementCollection`: Được sử dụng để khai báo một tập hợp các yếu tố (elements) `mà không phải là thực thể (entity)`. Trong trường hợp này, phoneNumbers là một tập hợp các chuỗi.

`@CollectionTable(name = "phones", joinColumns = @JoinColumn(name = "staff_id"))`: Định nghĩa bảng con phones và cột dùng để liên kết (foreign key) với bảng cha. Trong trường hợp này, bảng phones sẽ có một cột staff_id để tham chiếu tới bảng cha.

`@Column(name = "number", nullable = false)`: Xác định tên cột và các thuộc tính của cột trong bảng con phones. Trong trường hợp này, các số điện thoại sẽ được lưu trong cột number và cột này không được phép null (nullable = false).

# 2. Inheritance Relationship (Quan hệ kế thừa)

## InheritanceType:

### SINGLE_TABLE

Mô tả: Tất cả các lớp con được lưu trong một bảng duy nhất với một cột phân biệt để xác định lớp của mỗi hàng.

Ưu điểm: Hiệu suất tốt nhất về mặt truy vấn vì tất cả dữ liệu nằm trong một bảng.

Nhược điểm: Bảng có thể trở nên rất rộng (nhiều cột) nếu các lớp con có nhiều thuộc tính khác nhau.

#### Example:

```java
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Vehicle {
    @Id
    private Long id;
    private String manufacturer;
    // getters and setters
}

@Entity
@DiscriminatorValue("Car")
public class Car extends Vehicle {
    private int numberOfDoors;
    // getters and setters
}

@Entity
@DiscriminatorValue("Bike")
public class Bike extends Vehicle {
    private boolean hasCarrier;
    // getters and setters
}

```
### TABLE_PER_CLASS

Mô tả: Mỗi lớp con có một bảng riêng chứa tất cả các thuộc tính của lớp cơ sở và lớp con đó.

Ưu điểm: Thiết kế đơn giản và bảng không chứa nhiều giá trị null.

Nhược điểm: Truy vấn dữ liệu từ lớp cơ sở hoặc truy vấn bao gồm nhiều lớp con có thể tốn kém.

#### Example:

```java
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String manufacturer;
    // getters and setters
}

@Entity
public class Car extends Vehicle {
    private int numberOfDoors;
    // getters and setters
}

@Entity
public class Bike extends Vehicle {
    private boolean hasCarrier;
    // getters and setters
}

```
### JOINED

Mô tả: Các thuộc tính của lớp cơ sở được lưu trong một bảng riêng và các thuộc tính của lớp con được lưu trong các bảng riêng biệt. `Các bảng này được nối (join) với nhau bằng các khóa ngoại.`

Ưu điểm: Thiết kế bảng hợp lý, không có nhiều giá trị null, và dễ mở rộng.

Nhược điểm: Truy vấn chậm hơn so với SINGLE_TABLE.

#### Example:

```java
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String manufacturer;
    // getters and setters
}

@Entity
public class Car extends Vehicle {
    private int numberOfDoors;
    // getters and setters
}

@Entity
public class Bike extends Vehicle {
    private boolean hasCarrier;
    // getters and setters
}

```

# 3. One to One (Mối quan hệ 1 - 1)

### Trường hợp 1: Khóa chính bên bảng phụ thuộc chính là khóa chính bên chủ thể.

```java
@Table(name = "classe_profiles")
public class ClazzProfile {
@Id 
@OneToOne
@JoinColumn(name = "class_id")
private Clazz clazz;
private LocalDate createDate;
private String description;
}

```

### Trường hợp 2: Bảng phía phụ thuộc có khóa chính riêng, khóa ngoại trong bảng này phải đồng thời là unique.

```java
@Entity
@Table(name = "classe_profiles")
public class ClazzProfile {
@Id
@Column(name = "profile_id")
private String id;
@OneToOne
@JoinColumn(name = "class_id", unique = true, nullable = false)
private Clazz clazz;
private LocalDate createDate;
private String description;
}
```
# 4. One to Many or Many to One (Mối quan hệ 1 – n)

``Phía One (Department): Sử dụng @OneToMany với thuộc tính mappedBy.``

```java
import javax.persistence.*;
import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Employee> employees;
}
```

``Phía Many (Employee): Sử dụng @ManyToOne và @JoinColumn``

```java
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
```

# 5. Many to Many (Mối quan hệ n – n)

## Trường hợp 1: Khi không có thuộc tính nào khác ngoại trừ các khoái ngoại 

Trong Hibernate, mối quan hệ nhiều-nhiều (N-N) giữa hai thực thể có thể được cấu hình bằng cách sử dụng annotation @ManyToMany. Khi không có các thuộc tính bổ sung cho mối quan hệ, bạn có thể sử dụng @JoinTable để xác định bảng liên kết trung gian.

```java
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}

--------------------------------------------

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "course_id"),
        inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private Set<Student> students;
}
```

## Trường hợp 2: Mối quan hệ N-N với lớp mô tả khóa riêng (Composite Key)

Trong trường hợp bạn cần lưu trữ các thuộc tính bổ sung cho mối quan hệ nhiều-nhiều, bạn có thể tạo một thực thể mới để đại diện cho mối quan hệ này. Thực thể này sẽ có khóa chính là một khóa composite.


### Lớp EnrollmentId


```java
@Embeddable
public class EnrollmentId implements Serializable {

    private Long studentId;
    private Long courseId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrollmentId that = (EnrollmentId) o;
        return Objects.equals(studentId, that.studentId) &&
               Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}
```

### Lớp Enrollment

```java
public class Enrollment {

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private String grade;
}
```

### Lớp Student

```java
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student")
    private Set<Enrollment> enrollments;
```

### Lớp Course
```java
    @Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "course")
    private Set<Enrollment> enrollments;
}
```

# Lesson 2: Implement Data Structure Map and Set in Java

## 1. Map

- Trong Java, Map là một interface trong gói java.util đại diện cho một tập hợp các cặp khóa-giá trị.

- Các khóa trong một Map là duy nhất, tức là mỗi khóa chỉ ánh xạ đến một giá trị duy nhất.

###  Các phương thức thông dụng của Map

`put(K key, V value)`: Thêm một cặp khóa-giá trị vào map.

`get(Object key)` Lấy giá trị liên kết với khóa.

`remove(Object key)`: Xóa phần tử với khóa cụ thể.

`containsKey(Object key)`: Kiểm tra sự tồn tại của khóa.

`containsValue(Object value)`: Kiểm tra sự tồn tại của giá trị.

`keySet()`: Trả về tập hợp các khóa.

`values()`: Trả về tập hợp các giá trị.

`entrySet()`: Trả về tập hợp các cặp khóa-giá trị.

### 1.1 HashMap

- HashMap là một triển khai của Map sử dụng bảng băm để lưu trữ các phần tử. Nó không đảm bảo thứ tự của các phần tử khi duyệt

- Syntax: 

    ` Map<String, Integer> hashMap = new HashMap<>();`

####  Độ phức tạp thuật toán: 

- Thêm (put): Trung bình 
O(1), nhưng 
O(n) trong trường hợp tồi tệ nhất (nếu có quá nhiều xung đột băm).

- Tìm kiếm (get): Trung bình 
O(1), nhưng 
O(n) trong trường hợp tồi tệ nhất.

- Xóa (remove): Trung bình 
O(1), nhưng 
O(n) trong trường hợp tồi tệ nhất.




#### Example:

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        // Thêm phần tử
        hashMap.put("one", 1);
        hashMap.put("two", 2);
        hashMap.put("three", 3);

        // Lấy giá trị theo khóa
        System.out.println("Value for key 'one': " + hashMap.get("one"));

        // Kiểm tra sự tồn tại của khóa
        System.out.println("Contains key 'two': " + hashMap.containsKey("two"));

        // Kiểm tra sự tồn tại của giá trị
        System.out.println("Contains value 3: " + hashMap.containsValue(3));

        // Xóa phần tử theo khóa
        hashMap.remove("three");

        // Duyệt qua các phần tử
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

### 1.2 LinkedHashMap

LinkedHashMap là một triển khai của HashMap nhưng duy trì thứ tự chèn các phần tử. Điều này có nghĩa là khi duyệt qua các phần tử, chúng sẽ xuất hiện theo thứ tự chúng được chèn vào.

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Thêm phần tử
        linkedHashMap.put("one", 1);
        linkedHashMap.put("two", 2);
        linkedHashMap.put("three", 3);

        // Duyệt qua các phần tử theo thứ tự chèn
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

### 1.3 TreeMap
TreeMap là một triển khai của Map trong Java sử dụng cấu trúc cây đỏ-đen (red-black tree  là một loại cây nhị phân tìm kiếm tự cân bằng).

Nó sắp xếp theo thứ tự tăng dần.
Ta có thể  tùy chỉnh sắp xếp giảm dần bằng cách gọi phương thức `Comparator.reverseOrder()`

```java
Comparator<String> reverseOrder = Comparator.reverseOrder();
        Map<String, Integer> treeMap = new TreeMap<>(reverseOrder);
```

Chèn, xóa và tìm kiếm phần tử có độ phức tạp là  O(logn).

```java
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        Map<String, Integer> treeMap = new TreeMap<>();

        // Thêm phần tử
        treeMap.put("one", 1);
        treeMap.put("two", 2);
        treeMap.put("three", 3);

        // Duyệt qua các phần tử theo thứ tự tự nhiên của khóa
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
```

## 2. Set
Set là một phần của Java Collections Framework và được sử dụng để lưu trữ một tập hợp các phần tử duy nhất. 

Giao diện Set mở rộng từ giao diện Collection và không cho phép các phần tử trùng lặp.

### Các loại set

- HashSet: Không đảm bảo thứ tự của các phần tử.
- LinkedHashSet: Duy trì thứ tự chèn vào.
- TreeSet: Duy trì thứ tự sắp xếp.

### 2.1 HashSet
HashSet được hỗ trợ bởi một bảng băm (thực ra là một thể hiện của HashMap). Khong sap xep thu tu.

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        // Thêm phần tử vào HashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Apple"); // Phần tử trùng lặp, sẽ không được thêm

        // Duyệt qua các phần tử
        for (String fruit : set) {
            System.out.println(fruit);
        }

        // Kiểm tra nếu một phần tử tồn tại
        if (set.contains("Apple")) {
            System.out.println("Set chứa Apple");
        }

        // Xóa một phần tử
        set.remove("Banana");

        // Kiểm tra kích thước của tập hợp
        System.out.println("Kích thước của Set: " + set.size());
    }
}
```

### 2.2 LinkedHashSet

LinkedHashSet tương tự như HashSet, nhưng nó duy trì một danh sách liên kết của các mục trong tập hợp, `theo thứ tự chúng được chèn vào`. Điều này cho phép duyệt qua các phần tử theo thứ tự chèn.

```java
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<String> set = new LinkedHashSet<>();

        // Thêm phần tử vào LinkedHashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Apple"); // Phần tử trùng lặp, sẽ không được thêm

        // Duyệt qua các phần tử
        for (String fruit : set) {
            System.out.println(fruit);
        }

        // Kiểm tra nếu một phần tử tồn tại
        if (set.contains("Apple")) {
            System.out.println("Set chứa Apple");
        }

        // Xóa một phần tử
        set.remove("Banana");

        // Kiểm tra kích thước của tập hợp
        System.out.println("Kích thước của Set: " + set.size());
    }
}

```

### 2.3 TreeSet

TreeSet là một triển khai của giao diện NavigableSet và được hỗ trợ bởi một TreeMap.

Các phần tử trong TreeSet được sắp xếp theo thứ tự tự nhiên của chúng, hoặc bởi một Comparator được cung cấp tại thời điểm tạo tập hợp.

```java
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();

        // Thêm phần tử vào TreeSet
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Apple"); // Phần tử trùng lặp, sẽ không được thêm

        // Duyệt qua các phần tử
        for (String fruit : set) {
            System.out.println(fruit);
        }

        // Kiểm tra nếu một phần tử tồn tại
        if (set.contains("Apple")) {
            System.out.println("Set chứa Apple");
        }

        // Xóa một phần tử
        set.remove("Banana");

        // Kiểm tra kích thước của tập hợp
        System.out.println("Kích thước của Set: " + set.size());
    }
}

```


# Lesson 3: Truy vấn SQL

# 3.1 Kết hợp bảng:

## 1. Inner join

INNER JOIN trả về các hàng từ các bảng khi có ít nhất một cặp dòng từ mỗi bảng mà thỏa mãn điều kiện join.
### Example:

```sql
SELECT columns
FROM table1
INNER JOIN table2 ON table1.column = table2.column;

/**
Giả sử bạn có hai bảng: employees và departments, và bạn muốn lấy thông tin về các nhân viên cùng với phòng ban mà họ làm việc
**/

SELECT employees.*, departments.department_name
FROM employees
INNER JOIN departments ON employees.department_id = departments.department_id;

```

## 2. Left join

LEFT JOIN trả về tất cả các hàng từ bảng bên trái (bảng đầu tiên được liệt kê trong câu lệnh SQL), kể cả các hàng không có cặp từ bảng bên phải. 

`Nếu không có cặp nào từ bảng bên phải, các cột từ bảng bên phải sẽ có giá trị NULL trong kết quả.`

```sql
SELECT columns
FROM table1
LEFT JOIN table2 ON table1.column = table2.column;

/**Nếu bạn muốn lấy tất cả thông tin về nhân viên cùng với phòng ban mà họ làm việc.

Kể cả những nhân viên không có phòng ban (ví dụ: nhân viên mới và chưa được gán phòng ban), **/

SELECT employees.*, departments.department_name
FROM employees
LEFT JOIN departments ON employees.department_id = departments.department_id;

```

## 3. Right join

RIGHT JOIN tương tự như LEFT JOIN, nhưng nó trả về tất cả các hàng từ bảng bên phải (bảng thứ hai được liệt kê trong câu lệnh SQL), kể cả các hàng không có cặp từ bảng bên trái. 

Nếu không có cặp nào từ bảng bên trái, các cột từ bảng bên trái sẽ có giá trị NULL trong kết quả.

```sql
SELECT columns
FROM table1
RIGHT JOIN table2 ON table1.column = table2.column;

SELECT employees.*, departments.department_name
FROM employees
RIGHT JOIN departments ON employees.department_id = departments.department_id;

```
# 3.2 Làm việc với dữ liệu Date

`CURDATE()`
Trả về ngày hiện tại.

`NOW()`
Trả về thời điểm hiện tại (bao gồm cả ngày và thời gian).

`DATE()`
Trích xuất ngày từ một giá trị datetime.

`YEAR(date) , MONTH(date) , DAY(date)`
Trích xuất năm, tháng, ngày từ một giá trị datetime.

`DATEDIFF(date1, date2)`
Trả về số ngày giữa hai ngày.

Ex:

```sql
SELECT DATEDIFF('2024-05-20', '2024-05-15') AS days_difference;
```

`DATE_FORMAT(date, format)`
Chuyển đổi một ngày hoặc thời điểm thành một chuỗi theo định dạng cụ thể.

# Lesson 4: Truy vấn JPQL

## JPQL vs SQL, một số ví dụ

### Ex1: Select

```sql

/**JPQL**/
@Query("SELECT u FROM User u WHERE u.status = 1")
Collection<User> findAllActiveUsers();
-------------------------------------------------------------
/**Đây là SQL**/
@Query(
  value = "SELECT * FROM USERS u WHERE u.status = 1", 
  nativeQuery = true)
Collection<User> findAllActiveUsersNative();
```
Tham khảo: https://www.baeldung.com/spring-data-jpa-query



## Cú pháp cơ bản:

### SELECT Clause

`SELECT`: Chọn các trường hoặc đối tượng để trả về.

`FROM:` Xác định lớp Entity hoặc bảng cơ sở dữ liệu để truy vấn.

`WHERE:` Điều kiện để lọc các bản ghi.

### JOIN Clause

`INNER JOIN`: Kết hợp hai bảng dựa trên điều kiện và chỉ trả về các hàng khi có ít nhất một kết quả trong cả hai bảng.

`LEFT JOIN`: Kết hợp hai bảng dựa trên điều kiện và trả về tất cả các hàng từ bảng bên trái cùng với các hàng từ bảng bên phải mà phù hợp với điều kiện.

`RIGHT JOIN`: Kết hợp hai bảng dựa trên điều kiện và trả về tất cả các hàng từ bảng bên phải cùng với các hàng từ bảng bên trái mà phù hợp với điều kiện.

### WHERE Clause:

`LIKE`: Sử dụng để so sánh một chuỗi với một mẫu.

`BETWEEN`: Sử dụng để chọn các hàng trong một phạm vi giá trị.

`IN`: Sử dụng để kiểm tra một giá trị có nằm trong một tập hợp hay không.

### ORDER BY Clause

`ORDER BY`: Sắp xếp các kết quả dựa trên một hoặc nhiều trường.

### Aggregate Functions:

`COUNT()`: Đếm số lượng hàng trả về.

`SUM()`: Tính tổng của các giá trị.

`AVG()`: Tính giá trị trung bình.

### Lưu ý:

- Tên Entity và Trường: Trong JPQL, bạn phải sử dụng tên Entity và các trường được định nghĩa trong lớp Entity, không phải tên bảng trong cơ sở dữ liệu.

- Tham số: Sử dụng tham số được đặt tên (ví dụ: ":name") để tránh tấn công SQL Injection và tạo các truy vấn parametrized.

- Kiểm tra Tính Đồng Nhất: Đảm bảo tên các trường, tham số và lớp Entity trong JPQL phản ánh chính xác cấu trúc của cơ sở dữ liệu và lớp Entity.