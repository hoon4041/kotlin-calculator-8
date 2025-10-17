
- 구현할 기능 목록
  - 입력이 올바른지 검증하는 기능
  - 구분자와 숫자를 구분하는 기능  
    -  커스텀 구분자를 추가하는 기능
  - 숫자를 계산하는 기능
  - 입력을 받는 기능
  - 결과를 입력해주는 기능
  - 전체 상황을 진행해주는 기능

각 기능들을 만들때 하나의 클래스라고 생각하고 작성하려고 하였습니다  
그리고 각각 최소한의 책임? 기능?을 가지도록 하려고 노력했습니다  

### 추가 디테일
커스텀 구분자는 무조건 한 자  
`-`를 커스텀 구분자로 사용할 수 없음  
숫자도 불가

`Calculator`는 숫자를 계산하는 클래스, List<Int>를 입력으로 받고 결과로 합을 계산해 주는 add 함수 존재

`InputParser`는 입력이 올바른지 검증하고, 구분자와 숫자를 구분하는 기능을 가지고 있음 

`Processor`는 입력을 받고, `InputParser`를 실행시키고, `Calculator`를 실행시키고, 입력을 받고, 결과를 입력해준다.  
그렇게 전체 상황을 진행해 주는 클래스이다.

`Application.kt`에서는 `Processor.run()`만 존재하고 `run()` 안에 전체 진행상황이 담겨있다.

`ApplicationTest`에서는 통합 테스트를 진행하였다.  
처음에는 통합 테스트만 진행하려고 하였으나, `InputParserTest`에 대한 부분도 추가하였다.

`InputParser`에서 처음에는 
```kotlin
val parts = subInput.split(Regex("[,:${customSeparator}]"))
```
처럼 바로 구분자에 추가해 주었으나, 특수문자(이스케이프가 필요한 문자)가 커스텀 구분자로 적용되지 않음을 확인 하였음  
```kotlin
val escapedSeparator = Regex.escape(customSeparator.toString())
val parts = subInput.split(Regex("[,:]|${escapedSeparator}"))
```
그래서 다음과 같이 변경하여 특수문자인 경우에 escape를 추가하도록 하였음

이스케이프가 필요한 문자 : . , * , + , ? , ( , ) , [ , ] , { , } , ^ , $ , | , \ 