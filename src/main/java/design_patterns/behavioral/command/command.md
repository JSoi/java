# COMMAND - 명령 패턴

## :paperclip: ​정의

메서드 콜이나 행동을 하나의 객체로 표현하는 것

요청의 발신자와 수신자를 분리한다.

실제 오퍼레이션은 "커맨드"라는 객체로 캡슐화 되어 있다.

## 📜 개념

1. Receiver

   요청을 실제로 수행하는 역할

2. Command

    1. Command (abstract class)

    - execute를 선언

    2. Concrete Command(Implementation)

    - 리시버 & 액션을 결합
    - 리시버를 사용해 execute를 **구현**

3. Invoker

   요청을 보내는 역할

## 🎯 장점

✔ 하나의 메서드 콜이었던 것이 객체로 치환되면서 추후에 실행되는 구조를 가질 수 있음

✔ 큐 같은 곳에 적재하여 이후에 실행하는 구조를 가질 수 있다.

## 단계

1. 커맨드 인터페이스 작성
2. 커맨드 인터페이스 구현(execute-undo 오퍼레이션)
3. 오퍼레이션의 파라미터, 리시버 인스턴스를 지정
4. 커맨드 인스턴스는 다른 코드로 전송되어, invoker에 의해 실행

## 예시

```java
public interface Command {
    void execute();
}
```



```java
public class AddMemberCommand implements Command {
    private final String emailAddress;
    private final String listName;
    private final EWSService receiver;

    public AddMemberCommand(String emailAddress, String listName, EWSService receiver) {
        this.emailAddress = emailAddress;
        this.listName = listName;
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.addMember(emailAddress, listName);
    }
}

```

