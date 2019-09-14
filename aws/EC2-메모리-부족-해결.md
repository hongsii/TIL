# EC2 메모리 부족 해결

AWS EC2 t2.micro(free tier)에서 2개 이상의 JVM 실행 시 메모리 부족으로 인스턴스가 멈추는 현상 발생
스왑파일을 추가하면 인스턴스가 멈추는 현상을 해결할 수 있음

## 스왑파일 용량 계산방법

스왑파일 생성 전 아래와 같은 방법으로 용량 계산 (AWS 권장사항)

* 참고: 스왑 공간은 *32MB 이상*이어야 합니다.

| 물리적 RAM의 크기 |	권장 스왑 공간 |
|:-----------------:|:----------------:|
| 2GB 이하 RAM	    | RAM 크기의 2배, 32MB 이상 |
| 2GB를 초과하는 RAM, 32GB 미만 |	4GB + (RAM – 2GB) |
| 32GB 이상 RAM |	RAM 크기의 1배 |

# 참고

* [AWS - ec2-memory-swap-file](https://aws.amazon.com/ko/premiumsupport/knowledge-center/ec2-memory-swap-file/)
