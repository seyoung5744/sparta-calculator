# 🧮 Java Console Calculator

간단한 콘솔 기반의 계산기를 단계적으로 구현하는 프로젝트입니다.  
기본 입력/출력부터 클래스, 컬렉션, 제네릭, Enum, 람다 & 스트림까지 점진적으로 개선합니다.

---

## 📗 Lv 1. 클래스 없이 기본 연산 계산기 만들기

### ✅ 기능 요구사항

- **양의 정수 입력 받기**
    - Scanner를 사용하여 두 개의 양의 정수를 입력받습니다.
    - 0도 포함합니다.

- **사칙연산 기호 입력 받기**
    - `+`, `-`, `*`, `/` 기호 중 하나를 입력받아 연산에 사용합니다.

- **연산 수행 및 결과 출력**
    - `if` 또는 `switch` 문으로 연산을 수행합니다.
    - 예외 처리: 나눗셈에서 두 번째 숫자가 0일 경우 오류 메시지를 출력합니다.

- **반복 수행**
    - `"exit"` 입력 시까지 계산을 반복 수행합니다.

<br>

### 📦 프로젝트 구조
```
lv1/  
├── Calculator.java  
└── Parser.java
```
<br>

---

## 📘 Lv 2. 클래스 기반 계산기 만들기

### ✅ 기능 요구사항

- **Calculator 클래스 생성**
    - 연산을 수행하는 `calculate()` 메서드 구현
    - 연산 결과를 저장하는 컬렉션 필드 생성

- **App 클래스에서 Calculator 활용**
    - 사용자 입력은 `App` 클래스에서 처리
    - 연산은 `Calculator` 클래스에서 처리

- **캡슐화 적용**
    - 컬렉션 필드를 `private`으로 설정
    - Getter/Setter 메서드로 간접 접근

- **연산 결과 삭제 기능**
    - 가장 먼저 저장된 결과를 삭제하는 `removeResult()` 메서드 구현

<br>

### 📦 프로젝트 구조
```
lv2/  
├── App.java  
├── Calculator.java  
├── Main.java  
├── Parser.java  
│  
├── exception/  
│   ├── EmptyResultException.java  
│   ├── InvalidNumberInputException.java  
│   └── InvalidOperationInputException.java  
│
├── input/  
│   ├── ConsoleInputProvider.java  
│   └── InputProvider.java  
│
└── output/  
    ├── ConsoleOutputReader.java  
    └── OutputReader.java  
```
<br>

---

## 🚀 Lv 3. Enum, 제네릭, 람다 & 스트림 적용

### ✅ 고급 기능 요구사항

- **Enum 활용**
    - 연산 기호(`+`, `-`, `*`, `/`)를 Enum 타입으로 정의 및 관리

- **제네릭 적용**
    - `Integer`, `Double` 등 다양한 숫자 타입을 처리할 수 있도록 제네릭 적용

- **람다 & 스트림 활용**
    - 저장된 연산 결과들 중 특정 조건(예: 입력값보다 큰 값)을 필터링하여 출력

<br>

### 📦 프로젝트 구조
```
lv3/
├── App.java
├── Calculator.java
├── Main.java
├── Parser.java
│
├── enums/
│   ├── AbstractOperator.java
│   ├── AppStatus.java
│   └── Operator.java
│
├── exception/
│   ├── EmptyResultException.java
│   ├── InvalidNumberInputException.java
│   └── InvalidOperationInputException.java
│
├── formatter/
│   └── ResultFormatter.java
│
├── history/
│   ├── History.java
│   └── HistoryManager.java
│
├── input/
│   ├── ConsoleInputProvider.java
│   └── InputProvider.java
│
└── output/
    ├── ConsoleOutputReader.java
    └── OutputReader.java
```

<br>

---

## 🛠 기술 키워드

- Java 기본 문법 (`Scanner`, `if`, `switch`, `while`)
- 클래스 및 캡슐화
- 컬렉션 (`List`, `Queue` 등)
- Enum, 제네릭(Generic)
- 람다식, 스트림(Stream API)

---

## 📅 개발 기간
2025.07.09 ~ 2025.07.13 (총 5일)

---

## 📒 개발 기록 (TIL)

- [계산기 구현 Lv1 시작 - 불필요한 객체 생성을 피하라!!](https://s-y-130.tistory.com/499)

- [계산기 구현 Lv2 시작 - 아주 살짝 객체 지향적으로...](https://s-y-130.tistory.com/500)

- [Operator Enum 전환](https://s-y-130.tistory.com/501)



