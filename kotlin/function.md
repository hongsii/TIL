# 함수

* [함수 선언](#함수-선언)
* [Parameter & Argument](#parameter-&-argument)
    * [Default Arguments](#default-arguments)
    * [Named Arguments](#named-arguments)
    * [가변인수](#가변인수)
* [중위 표기법](#중위-표기법)

----

## 함수 선언

코틀린에서는 함수를 선언할 때 `fun` 키워드를 사용합니다. 아래는 함수를 선언 포맷입니다.

> fun 함수명(매개변수명: 타입[, 매개변수명: 타입...]): 반환형 {
>   ...
> }

함수의 매개변수는 기존 변수의 키워드(`val`, `var`)을 사용할 수 없고,  무조건 `val`로 선언됩니다. 즉, 매개변수는 한 번만 할당되는 _read-only_ 변수로 값을 변경할 수 없습니다.  

두 개의 숫자를 받아 더한 결과를 반환하는 함수는 아래와 같이 선언할 수 있습니다.

``` kotlin
fun sum(a: Int, b: Int): Int {
    return a + b
}
```

코틀린에서는 단일 표현 함수(single expression fucntion)라고 함수의 반환값이 하나라면 아래와 같이 중괄호(`{}`)를 생략할 수 있습니다.

``` kotlin
fun sum(a: Int, b: Int): Int = a + b
```

단일 표현 함수에서는 반환형을 생략해도 타입을 추론할 수 있습니다.

``` kotlin
fun sum(a: Int, b: Int) = a + b
```

코틀린에서는 함수에서 반환되는 결과값이 없다면 `Unit` 키워드를 반환형에 명시합니다.

``` kotlin
fun printSum(a: Int, b: Int): Unit {
    println(a + b)
}
```

`Unit`은 생략할 수 있습니다.

``` kotlin
fun printSum(a: Int, b: Int) {
    println(a + b)
}
```

----

## 함수 오버로딩

같은 이름의 함수를 매개변수만 다르게해 여러 개를 정의할 수 있습니다. 이를 함수 오버로딩(function overloading)이라고 합니다. 여기서 매개변수가 다르다는 것은 매개변수의 타입 또는 개수를 의미합니다.

``` kotlin
fun print(a: Int) {
    println("Int 매개변수의 print함수 : $a")
}

fun print(a: String) {
    println("String 매개변수의 print함수 : $a")
}

fun print(a: Int, b: Int) {
    println("2개의 Int 매개변수의 print함수 : a - $a, b - $b")
}

fun print(a: Int, b: String) {
    println("Int, String 매개변수의 print함수 : a - $a, b - $b")
}

fun main() {
    print(1)
    print("문자")
    print(1, 2)
    print(1, "문자")

}
```

실행 결과

```
Int 매개변수의 print함수 : 1
String 매개변수의 print함수 : 문자
2개의 Int 매개변수의 print함수 : a - 1, b - 2
Int, String 매개변수의 print함수 : a - 1, b - 문자
```

----

## Parameter & Argument

코틀린에서는 아래와 같이 함수의 name: String과 같이 함수의 매개변수를 `paramter` 라고 합니다. 그리고 main() 함수에서 print 함수를 호출할 때, 넘기는 값을 인수 `argument` 라고 합니다.

``` kotlin
fun printName(name: String) { // 함수명 옆의 괄호안의 매개변수가 parameter
    println("Hello, $name")
}

fun main() {
    printName("World") // "World"가 argument
}
```

### Default Arguments

함수의 매개변수에는 전달되는 파라미터가 없을 때 기본으로 적용할 값을 선언할 수 있습니다. 변수 옆에 `=` 기호와 기본으로 할당될 값을 선언해주면 됩니다. 그러면 함수를 호출할 때, 별도의 인수를 함수로 전달하지 않는다면 기본값을 파라미터로 설정하게 됩니다.

``` kotlin
fun printName(name: String = "hongsii") {
    println("Hello, $name")
}

fun main() {
    printName()
    printName("World")
}
```

실행 결과, 첫번째로 함수 호출시 인수를 생략했기 때문에 기본값인 "hongsii"가 사용되었습니다.

```
Hello, hongsii
Hello, World
```

### Named Arguments

매개변수가 여러 개인 경우는 아래와 같이 인수에 파라미터명을 명시해줄 수 있습니다. 이름을 명시하지 않은 인수는 순서대로 파라미터와 매핑됩니다.

``` kotlin
fun printName(name: String = "hongsii", no: Int = 10) {
    println("Hello, $name ($no)")
}

fun main() {
    printName()
    printName("World")
    printName(no = 20)
    printName(name = "World", no = 20)
}
```

실행 결과

```
Hello, hongsii (10)
Hello, World (10)
Hello, hongsii (20)
Hello, World (20)
```

### 가변인수

매개변수 개수가 함수를 호출할 때마다 다를 수 있는 경우에 가변인수(variable number of arguments)를 사용할 수 있습니다.
예를 들어, 함수 호출시 숫자가 1개일 수도 있고, 10개... n개까지 있을 수 있다면 아래와 같이 `vararg` 키워드를 사용해서 가변인수를 사용하면 됩니다.

``` kotlin
fun printNumbers(vararg numbers: Int) {
    for (number in numbers) {
        print("$number ")
    }
}

fun main() {
    printNumbers(1, 2, 3, 4)
}
```

가변인수를 사용하는 함수를 호출할 때 `콤마 ,`를 사용해 파라미터를 여러 개를 전달할 수 있습니다.

----

## 중위 표기법

일반적으로 함수를 사용할 때 `변수명.함수(인수)`와 같이 사용합니다.

``` kotlin
class Calculator {
    fun square(x: Int): Int {
        return x * x
    }
}

fun main() {
    var calculator = Calculator()
    var squareVal = calculator.square(2)
}
```

코틀린에서는 함수의 `중위 표기법(infix notation)` 을 지원합니다. `infix` 키워드를 `fun` 키워드 앞에 선언해주면 중위 표기법을 사용할 수 있습니다. 중위 표기법을 사용하면 함수 호출시 필요한 `.`과 `()`를 생략할 수 있습니다.

``` kotlin
class Calculator {
    infix fun square(x: Int): Int {
        return x * x
    }
}

fun main() {
    var calculator = Calculator()
    var squareVal = calculator square 2
}
```

중위 표기법을 사용하려면 아래와 같은 조건을 만족해야 합니다.

> - 클래스의 멤버함수 또는 확장된 함수 (extension function)여야 합니다.
> - 함수의 매개변수(parameter)는 반드시 1개여야 합니다.
> - 함수의 매개변수가 가변인수(vararg)가 아니여야 합니다.
> - 함수의 매개변수는 기본 값(Default Arguments)이 없어야 합니다.


----

# 참고

* [Kotlin docs - Functions](https://kotlinlang.org/docs/reference/functions.html)
* [깡샘의 코틀린 프로그래밍](http://www.yes24.com/Product/goods/59017138)
