# vim-surround 정리

[vim-surround](https://github.com/tpope/vim-surround)는 괄호, 따옴표, HTML 태그 등을 손쉽게 감싸주는 플러그인

다음과 같이 `"`로 감싼 문장이 있을 때, `'`로 바꾸고 싶다면 바꾸고 싶은 내용에 커서를 두고 `cs"'` 를 입력

```
"Hello, World!"
```

단축키를 입력하면 아래와 같이 플러그인이 변경시켜줌

```
'Hello, World!'
```

## 설치

[링크](https://github.com/tpope/vim-surround#installation)를 참고  
그 외, Vundle과 같은 플러그인 매니저를 사용한다면 아래의 내용을 플러그인 리스트에 추가

``` shell
Plugin 'tpope/vim-surround'
```

## 사용법

### 감싸기

원하는 문자로 감싸려면 `ys` 명령어 사용  

``` shell
ys<motion|text-object><additional-character>
```

* motion : w, b, h, j, k 과 같은 단축
* text-object : aw, iw, as, is와 같은 단축키

#### 커서 위치의 단어 감싸기

`ysiw<addtional-character>` 를 입력하면 커서가 있는 위치의 단어를 감쌀 수 있음

``` shell
Hello, World

# World 위에 커서를 위치한 후, ysiw) 를 입력하면 괄호로 감쌀 수 있음
Hello, (World)

# 괄호 안 내용의 시작과 끝에 공백을 넣고 싶다면 ysiw( 를 입력
Hello, ( World )
```

#### 현재 라인 감싸기

`yss<addtional-character>` 를 입력하면 현재 라인을 감쌀 수 있음

``` shell
I'm a boy

# yss" 를 입력하면 쌍따옴표로 문장을 감쌀 수 있음
"I'm a boy"
```

### 지우기

감싸고 있는 문자를 지우려면 `ds` 명령어 사용  
아래의 명령어를 입력하면 현재 커서에서 가장 가까운 입력된 문자를 지움

``` shell
ds<character>
```

### 바꾸기

감싸고 있는 문자를 바꾸려면 `cs` 명령어 사용

``` shell
cs<target><replacement-character>
```

#### 예제

##### 괄호 감싸기
```

