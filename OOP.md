# Lập trình hướng đối tượng (OOP)

### Mục lục:

#### [Tính đóng gói](#dong-goi)

#### [ Tính kế thừa](#ke-thua)

#### [Tính đa hình](#da-hinh)

#### [Tính trừu tượng](#truu-tuong)

<a name='dong-goi'></a>

### Tính đóng gói

> Đóng gói là việc ẩn các dữ liệu (biến) và phương thức của đối tượng, chỉ cung cấp các phương thức công khai để truy cập và sửa đổi dữ liệu đó.

```java
	public float getmb() {
		return mb;
	}
	public float getmc() {
		return mc;
	}
	public boolean check() {
		boolean checked = true;
		if (getma() + getmb() < getmc() ||getmb() + getmc() < getma()|| getma() + getmc() < getmb())
			checked = false;
		return checked;
	}
```

Việc sử dụng các phương thức "getter" như getma(), getmb(), getmc() giúp kiểm soát việc truy cập các biến thành viên của lớp. Điều này cho phép bạn có thể thay đổi logic bên trong các phương thức getter mà không ảnh hưởng đến mã gọi bên ngoài.

Ví dụ, bạn có thể thêm các kiểm tra hoặc xử lý bổ sung trong các phương thức getter nếu cần trong tương lai.

<a name='ke-thua'></a>

# Tính kế thừa

> Kế thừa là cơ chế cho phép một lớp (lớp con) kế thừa thuộc tính và phương thức từ một lớp khác (lớp cha).
> <a name="vidu-ke-thua"></a>

```java
// Lớp cha (Superclass)
class Animal {
    protected String name;
    // Phương thức khởi tạo (Constructor) của lớp cha
    public Animal(String name) {
        this.name = name;
    }
    // Phương thức của lớp cha
    public void makeSound() {
        System.out.println("The animal makes a sound");
    }
    // Phương thức hiển thị thông tin
    public void showInfo() {
        System.out.println("Name: " + name);
    }
}
// Lớp con (Subclass) kế thừa từ lớp cha Animal
class Dog extends Animal {
    // Phương thức khởi tạo (Constructor) của lớp con
    public Dog(String name) {
        super(name);  // Gọi phương thức khởi tạo của lớp cha
    }
    // Ghi đè (Override) phương thức makeSound của lớp cha
    @Override
    public void makeSound() {
        System.out.println("The dog barks: Woof Woof");
    }
    // Phương thức riêng của lớp con
    public void wagTail() {
        System.out.println("The dog is wagging its tail");
    }
}

// Lớp chính (Main) để kiểm tra kế thừa
public class Main {
    public static void main(String[] args) {
        // Tạo đối tượng lớp cha
        Animal animal = new Animal("Some animal");
        animal.makeSound();  // Gọi phương thức từ lớp cha
        animal.showInfo();   // Gọi phương thức từ lớp cha
        // Tạo đối tượng lớp con
        Dog dog = new Dog("Buddy");
        dog.makeSound();     // Gọi phương thức đã ghi đè từ lớp con
        dog.wagTail();       // Gọi phương thức riêng của lớp con
    }
}
```

### Giải thích:

`Protected` là một mức độ truy cập (access modifier) trong Java, và nó quy định phạm vi mà thành viên của một lớp (biến hoặc phương thức) có thể được truy cập. Protected cho phép truy cập biến (hàm) được khai báo ở cả lớp cha và lớp con được kế thừa.

Đối với `Private`, thì lớp con kế thừa không được quyền truy cập trực tiếp mà cập nhật biến thông qua get, set.

`Ghi đè (Override)` là khi một lớp con cung cấp một phiên bản cụ thể của phương thức đã được định nghĩa trong lớp cha. Khi một phương thức bị ghi đè, phương thức của lớp con sẽ được ưu tiên gọi thay vì phương thức từ lớp cha.
=> [Đa hình (Polymorphism)](#Runtime-Polymorphism): Ghi đè phương thức giúp thực hiện tính đa hình trong OOP

`Các quy tắc của ghi đè phương thức:`

Phương thức ghi đè phải có cùng tên, cùng kiểu trả về và cùng danh sách tham số như phương thức trong lớp cha.

Mức độ truy cập của phương thức ghi đè phải tương tự hoặc rộng hơn (ví dụ: phương thức protected có thể ghi đè thành public nhưng không thể hạ mức thành private).

<a name='da-hinh'></a>

# Tính đa hình (Polymorphism)

> Đa hình cho phép các đối tượng khác nhau được xử lý thông qua cùng một giao diện (interface) hoặc phương thức, mặc dù chúng có thể có cách thực hiện khác nhau.

### Loại 1: Đa hình lúc biên dịch (Compile-time Polymorphism) - Còn gọi là đa hình tĩnh.

Xảy ra khi phương thức được xác định `trước khi chương trình chạy`, điều này chủ yếu được `thực hiện qua nạp chồng phương thức (method overloading) hoặc nạp chồng toán tử (operator overloading)` (trong ngôn ngữ khác như C++, nhưng Java không hỗ trợ nạp chồng toán tử).

Ví dụ về nạp chồng phương thức (Method Overloading):

```java
class Calculator {
    // Phương thức cộng hai số nguyên
    public int add(int a, int b) {
        return a + b;
    }
    // Phương thức cộng hai số thực
    public double add(double a, double b) {
        return a + b;
    }
    // Phương thức cộng ba số nguyên
    public int add(int a, int b, int c) {
        return a + b + c;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.add(5, 10));         // Gọi phương thức add
        System.out.println(calc.add(5.5, 10.3));     // Gọi phương thức add
        System.out.println(calc.add(5, 10, 15));     // Gọi phương thức add
    }
}
```

<a name="Runtime-Polymorphism"></a>

### Loại 2: Đa hình lúc chạy (Runtime Polymorphism) - Còn gọi là đa hình động.

Đa hình lúc chạy `xảy ra khi quyết định phương thức nào được gọi chỉ được xác định trong quá trình chương trình thực thi`. Điều này đạt được `thông qua ghi đè phương thức (method overriding)` và thường `xảy ra trong các lớp kế thừa.`

[Xem lại ví dụ ở tính kế thừa](#vidu-ke-thua)

<a name='truu-tuong'></a>

# Tính trừu tượng (Abstraction)

> Tập trung vào việc che giấu các chi tiết phức tạp của hệ thống, chỉ hiển thị các phần quan trọng và cần thiết cho người dùng. Tính trừu tượng cho phép tạo ra các cấu trúc chung mà không cần cung cấp đầy đủ chi tiết cài đặt, giúp giảm độ phức tạp của hệ thống và tăng tính bảo trì.

Trong Java, tính trừu tượng được thực hiện thông qua:

### 1. Lớp trừu tượng (Abstract Class).

Đặc điểm của lớp trừu tượng:

- Được khai báo với từ khóa abstract.

- Có thể chứa cả phương thức trừu tượng (không có thân hàm) và phương thức thông thường (đã có cài đặt).

- `Không thể khởi tạo đối tượng từ lớp trừu tượng.`

- Các lớp con phải ghi đè (override) và cài đặt các phương thức trừu tượng của lớp cha.

Ví dụ về lớp trừu tượng:

```java
// Khai báo lớp trừu tượng
abstract class Animal {
    public abstract void makeSound();
    public void sleep() {
        System.out.println("This animal is sleeping...");
    }
}
// Lớp Dog kế thừa từ lớp trừu tượng Animal
class Dog extends Animal {
    // Ghi đè phương thức trừu tượng từ lớp cha
    @Override
    public void makeSound() {
        System.out.println("The dog barks: Woof Woof");
    }
}
// Lớp Cat kế thừa từ lớp trừu tượng Animal
class Cat extends Animal {
    // Ghi đè phương thức trừu tượng từ lớp cha
    @Override
    public void makeSound() {
        System.out.println("The cat meows: Meow Meow");
    }
}
public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();  // Gọi phương thức đã được ghi đè của lớp Dog
        dog.sleep();      // Gọi phương thức thông thường từ lớp trừu tượng

        Animal cat = new Cat();
        cat.makeSound();  // Gọi phương thức đã được ghi đè của lớp Cat
        cat.sleep();      // Gọi phương thức thông thường từ lớp trừu tượng
    }
}

```

### 2. Interface (Giao diện).

Ví dụ về Interface:

```java
interface Animal {
    void makeSound();  // Phương thức trừu tượng
}

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("The dog barks: Woof Woof");
    }
}

class Cat implements Animal {
    @Override
    public void makeSound() {
        System.out.println("The cat meows: Meow Meow");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound();

        Animal cat = new Cat();
        cat.makeSound();
    }
}
```

Sự khác biệt giữa lớp trừu tượng và interface:

| **Lớp trừu tượng**                                                 | **Interface**                                                                  |
| ------------------------------------------------------------------ | ------------------------------------------------------------------------------ |
| Có thể chứa cả phương thức trừu tượng và phương thức cài đặt.      | Chỉ chứa các phương thức trừu tượng (trừ khi sử dụng `default` hoặc `static`). |
| Có thể có các biến (biến instance).                                | Chỉ chứa hằng số (`public static final`).                                      |
| Một lớp có thể kế thừa từ **một** lớp trừu tượng.                  | Một lớp có thể triển khai **nhiều** interface.                                 |
| Được sử dụng khi bạn muốn chia sẻ một phần logic giữa các lớp con. | Được sử dụng để định nghĩa các hành vi mà các lớp phải tuân theo.              |
| `Một lớp chỉ có thể kế thừa từ một lớp trừu tượng.`                | `Một lớp có thể triển khai nhiều interface.`                                   |

### Core Abstract class vs Interface

`Lớp trừu tượng (abstract class) thường biểu thị danh từ. Xác định những thứ "là gì" (What it is).` – nó đại diện cho một thực thể, một đối tượng trong thế giới thực, có những đặc điểm và hành vi chung. Ví dụ: Vehicle (Phương tiện), Animal (Động vật).

`Interface thường biểu thị động từ. Xác định những thứ "có thể làm" (What it can do)` – nó đại diện cho một hành động hoặc khả năng mà một đối tượng có thể thực hiện, bất kể đối tượng đó là gì. Ví dụ: Chargeable (Có thể sạc), Flyable (Có thể bay), Runnable (Có thể chạy).
