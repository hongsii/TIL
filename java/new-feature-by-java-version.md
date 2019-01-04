# 자바 버전별 추가된 기능 요약

# Java 7

* 다이아몬드 연산자를 통해 제네릭 타입 추론
* switch구문에서 String 지원
* try-with-resources이 추가돼 close()가 필요한 경우 자동으로 리소스을 닫아줌 (단, AutoCloseable, Closeable을 구현한 경우)
* 하나의 catch 구문에서 여러 개의 Exception 처리 가능
* 숫자 상수 선언시 underscore를 통한 가독성 향상
* 이진 상수 선언 가능 (0b, 0B)
* catch로 선언한 expcetion만 다시 던질 수 있었는데, 정확한 범위의 예외를 다시 던질 수 있도록 변경
* G1 GC 추가로 더 많은 양의 메모리 정리가 가
* NIO 2.0 추가

# Java 8

* 람다 표현식 추가
* Stream API 추가
* interface default, static 메소드 추가
* 날짜 API 추가
* 옵셔널 추가
* Base64 라이브러리 추가

# Java 9

* 모듈 시스템 추가
* 대화형 인터페이스 jshell 추가 
* interface private 접근 제어자 추가
* 익명 클래스에서 다이아몬드 연산자를 통한 타입 추론 가능
* try-with-resources 구문 개선으로 가독성 향상

# Java 10

* 지역 변수 추론 추가 (var)
* G1의 병렬 Full GC 추가
* GC의 stop-the-world시 개별 쓰레드를 멈출 수 있게 변경
