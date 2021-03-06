# 자바와 객체지향 프로그래밍 프로젝트 2021-2학기

21.11.21 (일)
- 앱 실행, 버튼 클릭
- figma 사용하여 다마고치 이미지 직접 만들기

21.11.26 (금)
- 다마고치 클래스 생성
  - class Tama
  - 메소드 생성 eat(), sleep(), play()

- 새로 알게된 것
  - AVD 새로고침 하는법: 실행정지 -> 재실행
  - 뷰(View) : 앱 화면을 구성하는 요소들을 뷰(View)라고 칭한다.
  - layout : 뷰의 배치방식을 정의한 것
  - Button 위치 변경하는 방법
  - LinearLayout : 뷰를 한쪽 방향으로 차곡차곡 쌓는 것을 의미한다.
  - 방향을 지정하는 속성은 android:orientation
  - 선택 가능한 방향은 위에서 아래(↓): vertical, 또는 왼쪽에서 오른쪽 방향(→):horizontal
    ex. <LinearLayout android:orientation="vertical"> ... 버튼 추가 ... </LinearLayout>
        => html의 태그와 비슷한 개념!
  - MainActivity 클래스 내부의 onCreate는 '앱이 생성되는 시기에'라는 의미를 가짐

  - 안드로이드 xml과 class 연결하기
    1) MainActivity 파일 상단에 위젯(widget)값 선언
       ex. Button large,small;//Widget Field값 선언 (Button)
           TextView textview; //Widget Field값 선언 (TextView)
    2) onCreate에 findViewById를 통해 연결

21.12.02 (목)
- 다마고치 이름 입력받기 구현
    - first_main.xml 파일 생성 (첫번째 화면)
        - EditText 생성
        🔴 수정필요
            - start now 버튼 대신 입력 버튼 필요 (현재는 입력만 받고 정보를 받지 않는다.)

- 화면 전환
    - MainActivity
        - startButton 이벤트리스너 생성 : setOnClickListener 람다함수
    - SubActivity 파일 생성
        - startButton 클릭시 이동 화면 관리
        - 출처 : https://deumdroid.tistory.com/entry/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%8A%A4%ED%8A%9C%EB%94%94%EC%98%A4-%EB%B2%84%ED%8A%BC-%ED%81%B4%EB%A6%AD-%EC%8B%9C-%ED%99%94%EB%A9%B4-%EC%A0%84%ED%99%98%ED%95%98%EA%B8%B0-Intent
    - first_main.xml 파일 생성
        -
    - Manifest.xml
        - Activity 추가 (코드 이해 필요)


- 새로 알게된 것
    - 이벤트 : 뷰를 터치하거나 키를 누르는 행동
    - 리스너 : 이벤트가 일어나는 것을 감지하는 부분
      (뷰는 이벤트가 일어나길 기다렸다 이벤트가 일어날 때 행동을 한다!)

    [ xml 파일 내 태그와 역할 ]
    - EditText
        - 텍스트 입력
        - android:hint="" // 텍스트박스 설명
        - android:textSize="" // 텍스트박스 글자 사이즈
    - Button
    - TextView
        - 텍스트 출력

21.12.03 (금)
- activity_main.xml
    - 캐릭터의 이름을 저장과 동시에 객체를 생성하는 이벤트 리스너 생성
    - 캐릭터 정상적으로 생성 구현 완료!
    🔴 서로 다른 자바 클래스에서 객체를 공유해야하는데, 방법을 찾는 중!

21.12.05 (일)
- 객체 전달 구현 (serializable 사용)
    - 객체를 전달할 Activity에서 intent.putExtra("key", value)의 형태로 객체 전달 가능
        - key : 객체를 전달할 때 key로 객체를 찾을 수 있다.
        - value : 전달할 객체
    - 객체를 받는 SubActivity에서 intent.getSerializableExtra("key")의 형태로 객체 전달 받음
- eat, play 버튼 기능 구현
    - eat 버튼 클릭시 energy+2
    - play 버튼 클릭시 energy+3
    - energy > 30 이라면 level+1

21.12.06 (월)
< 알게된 것에 정리하기 -> 양이 많아서 생략 >
- 객체에 접근가능한 함수 구현
- energy, level 관리 함수 구현
- 타이머 기능 구현 (sleep, eat)
- 이미지뷰 추가
- 🔴 애니메이션 추가 (play) 수정필요, 이미지 수정필요

- play 애니메이션 추가, 이미지 수정 완료
- 종료화면 구현, restart 버튼 구현

21.12.16 (목)
< 기능 구현 완성 후 수정 보완 >
1. 버튼 중복 클릭 막기
    - SubActivity.java
        - 버튼이 클릭되고 기능이 실행되는 시간 동안 다른 버튼 막기
            - controlButton함수 생성 -> 인자로 버튼과 false // true 값을 받아 버튼을 활성화하거나 비활성화한다.
            - 타이머가 0이 되기 전까지 button.setEnabled(false) // 버튼 클릭 막기
            - 타이머가 0이 된 이후 button.setEnabled(true) // 돌려놓기
2. first_main.xml 위치 수정
    - 기존 xml위치 좌우 간격 조정
3. game rules 게시판 추가
    - toggle button을 이용
        - 버튼 클릭 전 (button.isChecked == false)인 경우 : 캐릭터 생성 화면만 VISIBLE설정
        - 만약 클릭시 버튼의 상태가 checked라면  : 게임룰 게시 화면만 VISIBLE설정판
4. energy up 될때마다 토스트 메시지 띄우는 함수 추가
5. level 1 -> level 2 로 업그레이드된다면 귀가 추가!



