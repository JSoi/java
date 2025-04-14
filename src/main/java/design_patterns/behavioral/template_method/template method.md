# TEMPLATE METHOD PATTERN - 템플릿 메서드 패턴

## :paperclip: 정의

알고리즘의 각 단계를 정의하며, 서브클래스에서 일부 단계를 구현

## 📜 구성 요소

1. 부모 추상 클래스

   - 큰 틀(템플릿)을 정의
   - 하위 구현은 자식 클래스에서 명세

2. 서브 클래스
    - 추상 메서드를 오버라이드하여 구체적으로 구현

3. 템플릿 메서드
    - 알고리즘의 흐름을 고정하는 메서드
    - 여러 단계로 구성되며, 이 중 일부는 서브클래스가 구현


## 🎯 장점

✔ 중복 제거 가능

✔ 부모 클래스에 의해 전체 흐름을 고정하므로 큰 흐름을 깨트리지 않는다.

## ❌ 단점

❗ 상속에 의존하여 구성이 복잡해질 수 있다.

## 단계

1. 커맨드 인터페이스 작성
2. 커맨드 인터페이스 구현(execute-undo 오퍼레이션)
3. 오퍼레이션의 파라미터, 리시버 인스턴스를 지정
4. 커맨드 인스턴스는 다른 코드로 전송되어, invoker에 의해 실행

## 예시

```java
abstract class AbstractClass {
    public final void process() {
        stepOne();
        stepTwo();      // 추상 메서드
        optionalStep(); // hook 메서드
    }

    private void stepOne() {
        System.out.println("공통 처리 단계");
    }

    protected abstract void stepTwo(); // 반드시 구현해야 함

    protected void optionalStep() {
        // 서브클래스에서 선택적으로 오버라이드
    }
}
```



```java
public class ChildClass extends AbstractClass {
    @Override
    void stepTwo(){
        System.out.println("This is Step Two");    
    }
  
		@Override
		void optionalStep() {
        System.out.println("This is Optional Step");    
    }
}

```