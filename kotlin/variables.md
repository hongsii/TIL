# 변수

* [변수 선언](#변수-선언)
    * [val](#val)
    * [var](#var)
* [변수 초기화](#변수-초기화)
* [Nullable 변수](#Nullable-변수)
* [상수](#상수)

## 변수 선언

코틀린에서는 변수를 클래스 외부/내부, 함수 내부에 선언할 수 있습니다. 변수는 `키워드 변수명[: 타입]`와 같은 형태로 선언할 수 있습니다. 여기서 키워드는 읽기 전용 키워드 `val`와 여러 번 할당할 수 있는 키워드 `var`이 존재합니다.

``` kotlin
val num1: Int = 10
var num2 = 11 // 타입 추론
val num3: Int // 초기화하지 않으면 반드시 타입을 선언해야함
num2 = 12 // 지연 할당
```

코틀린에서는 변수의 **타입 추론**이 가능하기 때문에 2번째 라인과 같이 변수 선언시 값을 초기화하는 경우에는 타입을 생략할 수 있습니다. (1번째 라인은 IDE에서 명시적인 타입 선언을 제거하라는 경고 발생)  
그리고 3번째 라인처럼 변수 선언시 **초기화하지 않으면 타입을 추론할 수 없기 때문에 반드시 타입을 선언**해줘야합니다.

### val (value)

`val` 키워드는 _read-only 변수_로 값을 한 번만 할당할 수 있습니다.

``` kotlin
val num = 10
num = 12 // val은 한 번밖에 할당이 안되기 때문에 컴파일 에러
```

### var (variable)

`var` 키워드는 값을 여려 번 할당할 수 있는 변수(Mutable한 변수)입니다.

``` kotlin
val num = 10
num = 12 // 여러 번 재할당 가능
```

## 변수 초기화

코틀린은 **변수를 자동으로 초기화해주지 않습니다.** 그렇기 때문에 변수를 초기화해주지 않고 사용하게 되면 에러가 발생합니다.

``` kotlin
var num: Int
println(num) // 컴파일 에러
```

특정 위치(클래스 외부에 선언한 변수(=Top-lvel 변수), 클래스의 멤버변수)의 변수는 선언과 동시에 초기화해줘야 합니다.

``` kotlin
package dev.hongsii

// 전역 변수
val externalVal1: Int = 10 // O
val externalVal2: Int // 컴파일 에러

class User {
    val name: String = "사용자" // O
    val email: String // 컴파일 에러

    fun print() {
        val localName: String // 함수 내에서는 지연 초기화 가능

        println(localName) // 컴파일 에러 : 사용하려면 반드시 변수를 초기화해야함
    }
}
```

## Nullable 변수

코틀린에서는 **null safety**(null 안전성)을 위해 nullable 변수와 non-nullable 변수로 나뉩니다. null을 변수에 할당하기 위해서는 반드시 `nullable 변수`로 선언해야만 할당할 수 있습니다. nullable 변수는 `물음표 ?` 기호를 사용해 선언할 수 있습니다.

``` kotlin
val num1: Int? = null
var num2: Int? = null
num1 = 1 // 컴파일 에러
num2 = 2 // O
```

nullable 변수의 경우 `val`로 선언하게 되면 null도 한 번의 할당이기 때문에 재할당시 에러가 발생합니다. nullable 변수를 사용해야 한다면 반드시 `var`로 선언해줘야 합니다.

## 상수

변수 선언시 앞에 `const` 키워드를 붙여주면 상수를 선언할 수 있습니다. 다만, `const` 키워드를 사용하려면 반드시 `val` 키워드를 사용해야 합니다. 그 이유는 `var` 키워드는 변수에 값을 여러 번 할당하려고 만들어진 키워드인데 값을 변경하지 않는 `const` 키워드를 선언하는건 모순된 상황이기 때문에 컴파일 에러가 발생하게 됩니다.

``` kotlin
const val NUM1: Int = 1 // O
const var NUM2: Int = 2 // 컴파일 에러
```

그리고 `const` 키워드는 Top-level 변수로만 선언할 수 있습니다. 클래스 내부 또는 함수 내부에 `const`를 선언하면 에러가 발생합니다.
