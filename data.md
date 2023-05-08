# 생명주기

created - 서버에 데이터를 요청(http 통신)하여 받아오는 로직을 주로 수행
mounted - template 속성에 정의한 화면 요소에 접근할 수 있어 화면 요소를 제어하는 로직 수행
update - 데이터 변경 후 화면 요소 제어와 관련된 로직을 추가

# 디렉티브

v-once - 데이터 변경 시 업데이트 되지 않는 일회성 보간을 수행
v-text - text를 출력할 때 사용
v-html - 실제 HTML을 출력할 때 사용
v-model - 양방향 바인딩 처리를 위해서 사용
v-bind - 엘리먼트의 속성과 바인딩 처리를 위해서 사용, 약어 ':'로 사용 가능
v-show - 조건에 따라 엘리먼트를 화면에 출력 (display)
v-if, v-else-if, v-else - 조건에 따라 엘리먼트를 화면에 렌더링
v-for - 배열이나 객체의 반복에 사용
v-clock - vue Instance가 준비될 때까지 mustache 바인딩을 숨기는데 사용

template - 여러 개의 태그들을 묶어서 처리해야 할 경우 사용
method - 생성과 관련된 data 및 method의 정의 가능, data를 this.데이터이름 으로 접근 가능
filter - 뷰의 필터는 화면에 표시되는 텍스트의 형식을 쉽게 변환해주는 기능
computed - 특정 데이터의 변경사항을 실시간으로 처리. 변경이 없을 경우 캐싱된 데이터를 반환.
watch - Vue Instance의 특정 property가 변경될 때 실행할 콜백 함수 설정. (현재값, 이전값)

event - DOM Event를 청취하기 위해 v-on directive 사용
v-on - directive를 사용하여 DOM 이벤트를 듣고 트리거 될 때 JavaScript를 실행, $event
ref, $refs - $refs 속성을 이용해 DOM에 접근할 수 있다. 권장 X

class binding - element의 class와 style을 변경
