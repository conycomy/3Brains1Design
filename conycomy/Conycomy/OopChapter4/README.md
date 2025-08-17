객체지향의 사실과 오해 4장
목표
책에서 다룬 추상적인 내용을 코드레벨에서 직접 적용해보고 더욱 구체적으로 이해하기 위해서 간단한 도서관 시스템을 구축하였음. 역할, 책임, 협력의 관점에서 코드를 짜는 능력을
기르고, 설계 능력을 기르는 것을 목표로 함.

### 📁 com.conycomy.dto - 데이터 전달 객체 (DTO)

- `Book`, `BookRequest`, `Conycomy.OopChapter4.dto.Availability`, `BorrowResult`, `BookRentalStat`

### 📁 com.conycomy - 도메인 역할 및 협력자

- `BookCatalog`, `BookRentalHistory`, `Librarian`, `Member` — 역할 기반 인터페이스
- `MemoryBookCatalog`, `MemoryBookRentalHistory`, `DefaultLibrarian` — 역할 구현
- `Conycomy.OopChapter4.Main` — 실행 흐름을 구성하는 시작점

## 실행 흐름 요약 (책 대여 시나리오)

1. `Member`가 `Librarian`에게 책 대여 요청
2. `Librarian`은 `BookCatalog`에 조회 요청
3. `BookCatalog`는 `Conycomy.OopChapter4.dto.Availability` 리스트 반환
4. `Librarian`은 성공 목록을 `BookRentalHistory`에 기록
5. `Librarian`은 대여 결과(`BorrowResult`)를 `Member`에게 통지

고민 / 어려웠던 점

1. 역할과 책임의 경계 설정

- "사서", "회원", "책 목록", "대여 이력"  실제 도메인의 역할을 어떻게 표현해야할지 고민했다.
- 각 역할이 어떤 메시지를 주고 받아야하는지 먼저 정의하였다.

2. 인터페이스 vs 추상 클래스

- 저는 북카탈로그, 사서, 회원, 북히스토리 등 직업이라고 생각하였으며, 시스템이라고 생각하지 않고, "사람"이라고 추상화로 묶으려고 했습니다. 정확하게는, “역할”이라는 개념이
  직업처럼 대체 가능하니 인터페이스가 맞는지,
  아니면 “사람”이라는 공통 속성을 공유하니 추상 클래스가 맞는지 고민했습니다.

- 변경 가능성과 공통 기능 여부를 어떻게 판단하는지가 어려웠음

- 추상 클래스는 기본 구현이나 상태를 공유할 때 쓰는 것이 효율적인 것 같습니다.

3. 책임 분리

- BookCatalog는 책의 대출 가능 여부 조회만,
- BookRentalHistory는 대출 기록과 횟수 관리만 맡도록 분리.
- Librarian은 조율자 같은 느낌입니다.
- (사서)을 어디까지 확장할지도 고민 포인트였습니다.

## 🧠 느낀 점 / 회고

- 역할 중심 설계를 처음 적용해보며, 객체지향 설계의 관점을 다시 배웠다.
- 코드보다 협력 흐름이 먼저라는 개념이 인상 깊었고, 역할-책임-협력이 가장 강력한 구조임을 체감했다.
- 하나의 클래스를 만들기보다, 협력 흐름을 먼저 구성하는 것이 객체지향 설계에 가깝다는 통찰을 얻었다.
- 사람은 익숙한 걸 무의식적으로 하는 법이 있다던데, 타입을 먼저 정의하는 나를 보고 깜짝 놀랐다. 협력을 설계하자!