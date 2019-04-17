# 스칼라 Scala

* [설치](./스칼라-설치.md)

함수지향 프로그래밍 언어


## 변수 선언

변수는 2가지 방법으로 선언할 수 있음

* `val` : 값을 한번만 할당할 수 있는 변수
* `var` : 값을 여러번 할당할 수 있는 변수

`val`로 변수를 선언시 한번만 할당할 수 있기 때문에 재할당시 에러 발생

``` scala
val msg = "Hello, Scala"
msg = "Bye, Scala" // error: reassignment to val 발생
```

변수에 값을 여러번 할당하고 싶다면 `var` 사용

``` scala
var msg = "Hello, Scala"
msg = "Bye, Scala" // OK
```

## 함수 선언

함수는 `def` 키워드로 시작하며 함수명, 파라미터, 반환타입, 함수 내용순으로 선언

``` scala
def 함수명(파라미터...): 반환타입 = {
    함수 내용
}
```

아래는 파라미터로 `Int` 타입의 파라미터 2개를 받아 더하는 함수 선언

``` scala
def sum(a: Int, b: Int): Int = {
    return a + b
}
```

함수의 내용이 간단하면 아래와 같이 줄여 쓸 수 있음

``` scala
def sum(a: Int, b: Int) = a + b
```
