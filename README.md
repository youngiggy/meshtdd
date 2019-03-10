## TDD study : day 3 - 단체 실습 예제

### 최신 실리콘벨리 스타일 기획서
* 머신러닝으로 확률이 높은 로또 번호를 생성해서 블록체인에 저장하는 '로또 번호 생성기'라는 서비스
* 우리는 사용자를 부추겨 포인트를 탕진하게 만드는 것이 목표입니다
* 한 세트당 번호 6개를 받고 100원씩 포인트를 차감합니다
* 사용자는 원하는 세트 수를 고를 수 있습니다
* 당첨 확률은 관심 없으니 그냥 랜덤하게 숫자만 6개씩 나와도 됩니다
* 한 시간 안에 충분히 개발 가능하다고 이미 CEO 보고 들어갔습니다
* 오류가 발견되면 당신은 해고입니다

### 요구사항 재정의
* todo

### 설계를 위한 몇가지 가정
* 시간이 없으니 User와 Point는 미리 만들어 두었습니다
    * User
        * int id
        * string name
    * Point
        * HashMap users
        * getUserPoint(int userId) : int
        * deposit(int userId, int amount) : void
        * withdraw(int userId, int amount) : void
* main 프로그램
    * point가 350원 있는 user를 생성합니다
    * todo
        * 보유한 포인트 안에서 로또 번호를 받아와 찍습니다
    * 마지막에 최종 보유한 포인트를 화면에 찍습니다

### 로또 서비스의 기능 명세

* 누가 / 무엇을 위해 / 어떤 행동을 한다
    * 서비스를 성공적으로 만드는 방법
        * https://www.slideshare.net/UyeongJu/ss-56634188
    * 협업 SW개발 플랫폼 Yobi 발표
        * https://deview.kr/2013/detail.nhn?topicSeq=18
 * todo 
