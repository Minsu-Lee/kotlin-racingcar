# kotlin-racingcar

## 기능 요구 사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
- 각 자동차에 이름을 부여할 수 있다. 자동차 이름은 5자를 초과할 수 없다.
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 기능 목록
### 자동차
- [x] 자동차의 초기 위치 = 0
- [x] 자동차는 무작위 값이 4 이상일 경우 전진
- [x] 자동차 이름은 5자를 초과할 수 없다.
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분

### 자동차 경주
- [x] 주어진 횟수 = m, n대의 자동차 입력
- [x] n대의 자동차로 m 번의 이동한 결과 반환
- [x] 매 라운드 마다 자동차의 위치를 출력
- [x] 자동차 이름도 같이 출력
- [x] 자동차 경주 완료 후 우승자 표시, 우승자는 한 명 이상