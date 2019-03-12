# 조건문

## if문

if문은 조건에 따라 특정 코드를 실행할 수 있는 구문입니다. 사용법은 아래와 같습니다.  

``` kotlin
val num = 4
if (num < 5) {
    println("num은 5보다 작다")
} else {
    println("num은 5보다 크거나 같다")
}
```

소괄호에는 실행 조건을 작성하며, 조건이 만족하면 중괄호 안의 내용이 실행됩니다. else는 if문의 조건을 만족하지 않을 때 실행됩니다.
그래서 위의 if문의 조건은 `num < 5`로 변수 `num`이 5보다 작은 경우 실행됩니다.

조건을 연속적으로 확인해야할 때는 `else if`를 사용합니다. 아래와 같이 `num < 5`가 아니면 `num >= 5 && num < 10`을 체크합니다.

``` kotlin
val num = 8
if (num < 5) {
    println("num은 5보다 작다")
} else if (num >= 5 && num < 10) {
    println("num은 5보다 크거나 같고, 10보다 작다")
}
```

코틀린에서는 일반적인 if문과 다르게 표현식으로 사용할 수 있습니다. 표현식이란 특정값이 반환되는 것을 의미하며, 아래 예시처럼 조건문에 따라 문자열이 반환되는 형태입니다.

``` kotlin
val num = 5
val result = if (num == 5) "num은 5이다" else "num은 5가 아니다"
println(result) // "num은 5이다" 출력
```

표현식은 일반적으로 사용하는 if구문과 달리 **반드시 else문이 있어야 합니다.** else문을 사용하지 않으면 컴파일 에러가 발생합니다.

``` kotlin
val result = if (num == 5) "num은 5이다" // 컴파일 에러
```

그리고 한가지 더 주의할 점은 중괄호를 사용하는 경우에는 **반드시 표현식의 데이터를 중괄호의 마지막에 작성해야 합니다.**

``` kotlin
val num = 5
val sum = if (num == 5) {
    println("if 실행")
    num + 5
} else {
    println("else 실행")
    num + 10
}
println(sum)
```

## when 표현식

코틀린의 when은 다른 프로그래밍 언어의 switch-case 구문과 비슷하며, 특정값과 일치하는 분기 조건을 실행합니다. 다른 점은 특정값은 어떠한 타입의 값도 사용할 수 있습니다.

``` kotlin
val str = "hello"
when (str) {
    "hello" -> println("str is hello")
    "world" -> println("str is world")
    else -> println("str is other word")
}
```

코틀린에서는 콤마(,)를 사용해 여러 값을 사용해 분기 조건을 표현할 수 있습니다.

``` kotlin
when (num) {
    10, 20 -> println("num is 10 or 20")
    30, 40 -> println("num is 30 or 40")
    else -> println("other")
}
```

그리고 분기 조건으로 상수값 외에도 함수의 반환값을 사용할 수 있습니다. 아래처럼 someFunc()가 5를 리턴한다면 num과 같기 때문에 분기 조건이 실행됩니다.

``` kotlin
val num = 5
when (num) {
    someFunc() -> println("someFunc() returns 5")
    else -> println("someFunc() doesn't return 5")
}
```

코틀린에서는 분기 조건의 값을 범위를 사용할 수 있습니다. `in` 또는 `!in` 키워드를 사용해 범위를 나타낼 수 있습니다. `in`은 범위의 경계값을 포함하며, `!in`은 포함하지 않습니다. 그리고 범위에는 `collection`도 사용할 수 있습니다.

``` kotlin
val validNumbers = listOf(1, 2, 3, 4)
val num = 10
when (num) {
    in validNumbers -> println("num is valid")
    in 1..10 -> println("1 <= num <= 10")
    !in 10..20-> println("num is outside the range")
}
```

위에서는 동일한 타입으로만 분기했지만 코틀린에서는 정수, 문자열 등 다른 타입으로 분기가 가능합니다. `is` 또는 `!is` 를 사용하면 타입 체크가 가능합니다.

``` kotlin
fun check(data: Any) {
    when (data) {
        1 -> println("data is number")
        "hello, world" -> println("data is string")
        is Boolean -> println("data is Boolean type")
    }
}
```

when 의 중괄호값을 생략하면 if-else 를 대체할 수 있습니다.

``` kotlin
when {
    num % 2 != 0 -> println("num is odd")
    num % 2 == 0 -> println("num is even")
    else -> println("error")
}
```

if-else를 대체하는거처럼 when 또한 표현식으로 사용해 변수에 대입하거나 함수의 파라미터로 사용할 수 있습니다.

``` kotlin
val num = 5
val result = when (num) {
    5 -> "num is 5"
    else -> "num is not 5"
}
println(result)
```

# 반복문

// TODO
