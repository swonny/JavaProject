# 자바와 객체지향 프로그래밍 프로젝트 2021-2학기

21.11.21 (일)
- 앱 실행, 버튼 클릭 

21.11.26 (금)
- 다마고치 클래스 생성
  - class Tama
  - 메소드 생성 eat(), sleep(), play()

- 알게된 것
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


