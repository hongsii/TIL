# 쿼리

## 문자열 쿼리

문자열을 검색하려면 `"` 로 감싸야 한다. "search test"

## 필드 기반 쿼리

`field: value` 와 같이 특정 필드의 일치하는 값을 검색할 수 있다.

```
response.status: 200 // status code 200 조회
```

## 범위 쿼리

#### KQL (Kibana Query Language)

* 키바나 6.3부터 사용 가능
* 부등호 사용 (`>`, `>=`, `<`, `<=`)

```
response.status >= 200
```

#### Lucene

`[]`, `{}` 로 부등호 조건 표현

* [ 조건1 TO 조건2 ] : 조건1 보다 크거나 같고 조건2 보다 작거나 같다
* { 조건1 TO 조건2 } : 조건1 보다 크고 조건2 보다 작다

`*` 은 조건 없음

* [ 조건1 TO * ] : 조건1보다 크거나 같다
* [ * TO 조건1 ] : 조건1보다 작거나 같다

```
response.status: [200 TO *]
```

## Boolean 쿼리

`AND` , `OR` , `NOT` 3가지 사용 가능 (반드시 대문자여야 함)

```
NOT filed: value

field: value AND field2: value NOT field3: value

(field: value AND filed2: value) OR field3: value
```
