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

코틀린에서는 일반적인 if문과 다르게 표현식으로 사용할 수 있습니다.

``` kotlin
val num = 5
val result = if (num == 5) "num은 5이다" else "num은 5가 아니다"
println(result) // "num은 5이다" 출력
```


