# Workflows

Workflows는 github repository를 기반으로 `build`, `test`, `package`, `release`, `deploy` 등의 커스텀 자동 프로세스


## 설정 방법

### 경로

repository 최상위 폴더에서 `.github/workflows` 생성

### 시점

* github 이벤트 발생
* 스케줄
* 외부 이벤트

### 문법

* YAML 사용

### 제한 사항

* 각 repo 당 20개를 동시에 실행할 수 있음
* 시간당 1000개의 API 요청만 가능
* workflow의 각 job은 최대 6시간까지 실행 가능
* 모든 workflow는 repo 당 최대 20개의 작업을 동시에 실행 가능

## 항목별 설명

### `name`

workflow의 이름. 설정한 이름이 repo actions 페이지에 표시됨.
생략 시 workflow의 파일명으로 설정

### `on` **[required]**

workflow를 실행시킬 이벤트 이름. 이벤트 (`string` 또는 `array`

#### 단일 이벤트 예시

``` yaml
# 푸시 이벤트 발생 시 실행
on: push
```

#### 다중 이벤트 예시

``` yaml
# 푸시 또는 풀리퀘 이벤트 발생 시 실행
on: [push, pull_request]
```

#### 이벤트별 workflow 실행 제한

``` haml
# 기본적으로 전체를 실행하며, 아래와 같이 선택적으로 설정할 수 있음
push:
  branches:   
    - master         # master 브랜치로 푸시되면 실행
    - 'releases/*'   # refs/heads/releases/* 브랜치가 푸시되면 실행
    - '!refs/pull/*'
  tags:        
    - v1              # v1 태그로 푸시되면 실행
  paths:              # 해당 경로와 일치하는 파일이 있는 경우 실행
    - 'test/*'
    - '*.xml'
pull_request:
  paths:
    - 'js/*'
```

#### 스케줄 실행 (cron)

``` yaml
Example scheduling workflows using cron syntax
# 매 15분마다 실행
on:
  schedule:
    # YAML 은 `*` 을 특수문자로 인식. 홑따옴표로 감싸야함
    - cron:  '*/15 * * * *'
```

### `jobs`

workflow는 1개 이상의 jobs을 만들 수 있음.
기본적으로 병렬 실행됨. 순차적으로 실행하려면 `jobs.<job_id>.needs` 키워드를 사용해 다른 작업과 의존성 설정 필요

각 job은 `runs-on` 키워드로 설정한 가상환경에 매번 새로운 인스턴스로 실행함

workflow의 사용 제한 내에선 job 개수의 제한 없이 자유롭게 실행할 수 있음.

### `jobs.<job_id>`

각 job은 `job_id` 를 반드시 설정해야함. `string` 이며, job 설정 데이터에 저장.
`<job_id>` 는 `jobs` 객체 내에서 유일하도록 설정해야함.
`<job_id>` 는 문자 또는 `_`로 시작해야하며, 알파벳, `_`, `-` 만 사용할 수 있음

``` yaml
jobs:
  my_first_job:
    name: My first job
  my_second_job:
    name: My second job
  _my_thrid_job:
    name: My thrid job
```

### `jobs.<job_id>.name`

github에서 표시될 이름

### `jobs.<job_id>.needs`

실행 전 반드시 실행되야할 job 설정

``` yaml
jobs:
  job1:
  job2:
    needs: job1
  job3:
    needs: [job1, job2]
```

`job1` 실행이 끝나면 `job2` 를 실행
`job3` 는 `job1`, `job2` 가 끝나야 실행

위 설정의 실행 순서는 아래와 같음

1. `job1`
2. `job2`
3. `job3`

### `jobs.<job_id>.runs-on` [required]

job을 실행할 가상 머신 설정. 설정한 환경에서 매번 새로운 인스턴스로 job이 실행됨

Available virtual machine types are:

* `ubuntu-latest`, `ubuntu-18.04`, `ubuntu-16.04`
* `windows-latest`, `windows-2019`, `windows-2016`
* `macOS-latest`, `macOS-10.14`

``` yaml
runs-on: ubuntu-18.04
```

------------


# 참고

* [Configuring a workflow](https://help.github.com/en/articles/configuring-a-workflow)
