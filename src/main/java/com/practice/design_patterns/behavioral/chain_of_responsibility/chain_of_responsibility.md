# CHAIN OF RESPONSIBILITY - 책임 연쇄 패턴
## :paperclip: ​정의

책임 연쇄 패턴은 하나의 요청을 여러 개의 처리 객체(Handler)들이 순차적으로 처리할 수 있도록 하는 디자인 패턴

요청을 처리할 수 있는 객체들이 체인 형태로 연결되어 있고, 요청이 체인을 따라 전달되면서 각 객체가 처리 여부를 결정합니다.



## 📜 개념

1.	요청을 처리할 수 있는 여러 개의 핸들러(Handler)들이 존재
2.	각 핸들러는 자신이 요청을 처리할지 여부를 결정
   - 처리 가능하면 즉시 처리하고 종료
   - 
     처리 불가능하면 다음 핸들러에게 요청을 전달
3.	클라이언트(Caller)는 어떤 핸들러가 요청을 처리할지 신경 쓰지 않아도 됨
4.	핸들러 추가/제거가 용이하여 확장성이 뛰어남



## 🎯 장점

✔ 단일 책임 원칙(SRP) 준수 → 각 핸들러는 하나의 역할만 수행

✔ 유연한 확장 가능 → 새로운 핸들러를 추가해도 기존 코드 수정 최소화

✔ 코드의 응집도를 높이고 결합도를 낮춤 → 요청을 보내는 객체와 처리하는 객체가 분리됨



## ❌ 단점

❗ 처리 객체가 많아지면 성능 저하 가능

❗ 어떤 핸들러가 요청을 처리할지 보장이 어려움 (적절한 순서 보장이 필요)



## 🏛 사용 사례

✅ Spring Security의 필터 체인 (인증 → 권한 검사 → 요청 실행)

✅ 웹 서버의 미들웨어 처리 (로그 → 인증 → CORS 처리 → 비즈니스 로직 실행)

✅ 이벤트 처리 시스템 (UI 이벤트 처리 → 특정 조건에 맞는 핸들러 실행)

✅ 로깅 시스템 (DEBUG → INFO → WARN → ERROR)