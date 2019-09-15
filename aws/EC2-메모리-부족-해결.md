# EC2 t2.micro 메모리 부족 해결

AWS EC2 t2.micro(free tier)에서 2개 이상의 JVM 실행 시 메모리 부족으로 인스턴스가 멈추는 현상 발생
스왑파일을 추가하면 인스턴스가 멈추는 현상을 해결할 수 있음

## 스왑(Swap)

하드디스크 영역을 메모리처럼 사용하는 것을 스왑이라고 한다.

### 스왑파일 용량 계산방법

스왑파일 생성 전 아래와 같은 방법으로 용량 계산 (AWS 권장사항)

* 참고: 스왑 공간은 *32MB 이상*이어야 합니다.

| 물리적 RAM의 크기 |	권장 스왑 공간 |
|:-----------------:|:----------------:|
| 2GB 이하 RAM	    | RAM 크기의 2배, 32MB 이상 |
| 2GB를 초과하는 RAM, 32GB 미만 |	4GB + (RAM – 2GB) |
| 32GB 이상 RAM |	RAM 크기의 1배 |

### 스왑파일 생성

##### 1. linux의 `dd` 명령어로 스왑파일 생성

``` shell
# 'swapfile' 이란 이름으로 널 문자(/dev/zero)를 채워 '/(root)' 경로에 생성
# 스왑파일의 크기는 bs * count = 2GB
$ sudo dd if=/dev/zero of=/swapfile bs=1G count=2
```

* `if=FILE` : 표준입력 대신 지정된 파일을 읽기
* `of=FILE` : 표준출력 대신 지정된 파일로 쓰기
* `bs=BYTES` : 한 번에 읽고 쓸 수 있는 블록 크기. 기본 단위는 bytes이며, K/M/G 문자로 단위 설정 가능 ex) 1G, 512M
* `count=N` : 입력 할 수 있는 블록 수 
* `/dev/zero` : 유닉스에서 읽기를 위해 제공하는 널 문자 특수 파일

##### 2. 스왑파일의 읽기, 쓰기 권한 변경

root 사용자만 변경할 수 있도록 권한 변경

``` shell
$ sudo chmod 600 /swapfile
```

##### 3. 스왑영역 설정

``` shell
$ sudo mkswap /swapfile
```

##### 4. 스왑영역 사용

``` shell
# 스왑 실행
$ sudo swapon /swapfile

# 실행 확인
$ swapon -s
```

##### 5. 부팅 시 스왑파일 자동 활성화

리눅스는 마운트 관련 파일시스템 정보를 `etc/fstab` 에 저장한다.
부팅 시 스왑파일을 활성화하려면 `/etc/fstab` 에 추가해준다.

``` shell
$ vim /etc/fstab
$ /swapfile swap swap defaults 0 0
```

아래는 `/etc/fstab` 의 필드별 정보

| 순서 | 필드명 | 설명 |
|:----:|:-------|:-----|
| 1    | 디바이스명 | 파일시스템의 이름 설정 (레이블 설정은 첫번째 필드 앞에 'LABEL=레이블명' 으로 설정) |
| 2    | 마운트 경로 | 파일시스템 마운트 경로 설정 |
| 3    | 파일시스템 종류 | 마운트 시 설정할 파일시스템 종류 설정 (ext, ext2, ext3, ext4, swap, nfs...) |
| 4    | 마운트 옵션 | 파일시스템 옵션 설정<br/> - defaults : 기본 옵션 설정 (rw, suid, dev, exec, auto, nouser, async)<br/>  - auto : 부팅 시 자동 마운트<br/> - noauto : 부팅 시 자동 마운트 방지<br/> - user : 일반사용자 마운트 허용<br/> - owner : 디바이스 소유자만 마운트 허용<br/> - rw : 읽고 쓸 수 있는 파일시스템<br/> - ro : 읽기 전용 <br/> - exec : 실행파일 실행 허용<br/> |
| 5    | 덤프 | 1 : 덤프 가능 / 0 : 덤프 불가능 (기본값) |
| 6    | 파일시스템 점검 | 0 : 부팅 시 점검X<br/> 1 : 루트 파일시스템(/)으로 부팅 시 점검<br/> 2 : 루트 외 파일시스템으로 부팅 시 점검 ('/' 외 마운트 경로 점검)  |

---------------

# 참고

* [AWS - ec2-memory-swap-file](https://aws.amazon.com/ko/premiumsupport/knowledge-center/ec2-memory-swap-file/)
* [Linux manual page - fstab](http://man7.org/linux/man-pages/man5/fstab.5.html)
