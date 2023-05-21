<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<c:set var="selectedSido" value="${areaCode}" />
<c:set var="selectedGugun" value="${gugunCode}" />
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>TRIP, TREVEL</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css" />
<link rel="stylesheet" href="./assets/css/main.css" />
</head>

<body>
	<!-- 상단 navbar start -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top py-3">
		<div class="container">
			<a class="navbar-brand text-primary fw-bold" href="index.jsp">
				TRIP, TREVEL </a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-lg-0">
					<li class="nav-item"><a class="nav-link text-dark"
						aria-current="page" href="#">공지사항</a></li>
					<li class="nav-item"><a class="nav-link text-dark"
						aria-current="page"
						href="${root}/MapController?action=mvattraction&areaCode=0&gugunCode=0">관광지</a>
					</li>
				</ul>
				<!-- 로그인 전 -->
				<ul id="navBeforeLogin" class="navbar-nav mb-2 me-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link text-dark"
						aria-current="page" href="#" data-bs-toggle="modal"
						data-bs-target="#signupModal">회원가입</a></li>
					<li class="nav-item"><a class="nav-link text-dark"
						aria-current="page" href="#" data-bs-toggle="modal"
						data-bs-target="#signinModal">로그인</a></li>
				</ul>
				<!-- 로그인 후 -->
				<ul id="navAfterLogin" class="navbar-nav mb-2 me-2 mb-lg-0 d-none">
					<li class="nav-item"><a class="nav-link text-dark"
						aria-current="page" href="#" id="logoutBtn">로그아웃</a></li>
					<li class="nav-item" id="mypageBtn"><a
						class="nav-link text-dark" aria-current="page" href="#"
						data-bs-toggle="modal" data-bs-target="#mypageModal">마이페이지</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle text-dark" href="#"
						id="navbarDropdown" role="button" data-bs-toggle="dropdown"
						aria-expanded="false"> 관리자 </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<li><a class="dropdown-item" href="#" data-bs-toggle="modal"
								data-bs-target="#pollModal">투표만들기</a></li>
							<li><a class="dropdown-item" href="#">차트보기</a></li>
							<li><a class="dropdown-item" href="#">회원관리</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- 상단 navbar end -->

	<div class="container">
		<!-- 제목 -->
		<div style="height: 90px"></div>
		<div class="mt-3 text-center fw-bold">
			<p id="intro-text">🔎 관광 정보 찾기</p>
		</div>
		<div class="row">
			<!-- 관광지 검색 start -->
			<form class="d-flex my-3" onsubmit="return false;" role="search">
				<select id="region-first" class="form-select me-2"
					onchange="selectArea()">
				</select> <select id="region-second" class="form-select me-2">
				</select> <select id="search-content-id" class="form-select me-2">
					<option value="0">관광지 유형</option>
					<option value="12">관광지</option>
					<option value="14">문화시설</option>
					<option value="15">축제공연행사</option>
					<option value="25">여행코스</option>
					<option value="28">레포츠</option>
					<option value="32">숙박</option>
					<option value="38">쇼핑</option>
					<option value="39">음식점</option>
				</select>
				<!-- <input id="search-keyword" class="form-control me-2" type="search" placeholder="검색어" aria-label="검색어" /> -->
				<button id="btn-search" class="btn btn-outline-success"
					type="button">찾기</button>
				<!-- 검색 버튼 -->
			</form>
		</div>
		<div class="row">
			<!-- kakao map start -->
			<div id="map" class="mt-3" style="width: 100%; height: 400px"></div>
			<!-- kakao map end -->
		</div>
		<div class="row">
			<table class="table table-striped" style="display: none">
				<thead>
					<tr>
						<th>대표이미지</th>
						<th>관광지명</th>
						<th>주소</th>
					</tr>
				</thead>
				<tbody id="trip-list"></tbody>
			</table>
		</div>
		<!-- 관광지 검색 end -->
	</div>

	<!-- script -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=376ee42047ef15538cb2858471b7ce27&libraries=services,clusterer,drawing"></script>
	<script>
      // index page 로딩 후 전국의 시도 설정.

      // 시도 지역 선택
      function selectArea() {
        let selectedArea = document.getElementById("search-area");
        let selectedGugun = document.getElementById("search-sigungu");

        let areaCode = selectedArea.value;
        let gugunCode = selectedGugun.value;
        if(areaCode==null) areaCode = 0;
        if(gugunCode==null) gugunCode = 0;
        // 선택한 시도에 따라 시군구 설정.
        let path = "MapController?action=mvattraction&areaCode="+areaCode+"&gugunCode="+gugunCode;
        //선택된 지역코드, 구군코드를 가져가서 선택창에 필요한 정보를 가져온다. 선택되지 않은 상태이면 해당 정보가 null이다.
		location.href= path;
      }
</script>

	<script>
      // 검색 버튼을 누르면..
      // 지역, 유형, 검색어 얻기.
      // 위 데이터를 가지고 공공데이터에 요청.
      // 받은 데이터를 이용하여 화면 구성.
      document.getElementById("btn-search").addEventListener("click", () => {
        let areaCode = document.getElementById("region-first").value;
        let sigunguCode = document.getElementById("region-second").value;
        let contentTypeId = document.getElementById("search-content-id").value;
        
        fetch("/map/search", {
        	method: "POST",
        	header: {
        		"Content-Type": "application/json",
        	},
        	body: JSON.stringify({
        		areaCode,
        		sigunguCode,
        		contentTypeId,
        	}),
        }).then((response) => response.json()) //data 형식에 맞는 json을 넘겨주도록
        .then((data) => makeList(data));
      });
</script>
	<script>
var positions; // marker 정보 배열.
function makeList(attractions) {
	
  document.querySelector("table").setAttribute("style", "display: ;");
  
  let trips = attractions;
  let tripList = ``;
  positions = [];

  // console.log(positions);
  removeMarker();

  trips.forEach((area) => {
    console.log(area);

    tripList += `
        <tr onclick="moveCenter(\${area.latitude}, \${area.longitude});">
         <td><img src="\${area.image1}" width="100px"></td>
         <td>\${area.title}</td>
         <td>\${area.addr1} \${area.addr2}</td>
       </tr>
     `;

     console.log(area.latitude, area.longitude);
    // for문 돌면서 객체 만들어서
    let markerInfo = {
      title: area.title, // 관광지 이름
      latlng: new kakao.maps.LatLng(area.latitude, area.longitude), // 위도 경도 정보 가지고 좌표값 가진 객체 생성
    };
    positions.push(markerInfo); // 배열에 넣어둠
  });
  document.getElementById("trip-list").innerHTML = tripList;
  displayMarker();
}

// 카카오지도
var mapContainer = document.getElementById("map"), // 지도를 표시할 div
  mapOption = {
    center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
    level: 5, // 지도의 확대 레벨
  };

// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);
// 지도에 표시된 마커 객체 배열
var markers = [];
var selectedMarker = null; // 선택된 마커
let selectedInfoWindow = null;

function removeMarker() {
  for (var i = 0; i < markers.length; i++) {
    // 좌표 넣어둔 배열만큼
    markers[i].setMap(null);
  }
}
function displayMarker() {
  // 마커 이미지의 이미지 주소입니다
  var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; // 마커 이미지

  for (var i = 0; i < positions.length; i++) {
    // 좌표 넣어둔 배열만큼
    // 마커 이미지의 이미지 크기 입니다
    var imageSize = new kakao.maps.Size(24, 35);

    // 마커 이미지를 생성합니다
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
      // map: map, // 마커를 표시할 지도
      position: positions[i].latlng, // 마커를 표시할 위치
      title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
      image: markerImage, // 마커 이미지
    });

    marker.setMap(map);
    // 생성된 마커를 배열에 추가합니다
    markers.push(marker);

    // infowindow
    var infowindow = new kakao.maps.InfoWindow({
      content: positions[i].title,
      position: positions[i].latLng,
    });

    // 마커 이벤트 추가 (누르면 정보 오버레이 표시)
    kakao.maps.event.addListener(marker, "click", makeClickListener(marker, infowindow));

    function makeClickListener(marker, infowindow) {
      return function () {
        !!selectedInfoWindow && selectedInfoWindow.close();
        infowindow.open(map, marker);
        // selectedMarker = selected;
        selectedInfoWindow = infowindow;
      };
    }
  }

  // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
  map.setCenter(positions[0].latlng);
  // 마커 여러개 다 보이게 레벨 자동으로 지정해주는?
}

function moveCenter(lat, lng) {
  map.setCenter(new kakao.maps.LatLng(lat, lng));
}
</script>

	<!-- 회원가입 modal start -->
	<div class="modal fade" id="signupModal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-centered">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title fw-bold">회원가입</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="">
						<div class="mb-3 mt-3">
							<i class="bi bi-1-square"></i> <label for="name"
								class="form-label"> 이름</label> <input type="text"
								class="form-control" id="name" placeholder="name.." name="name" />
						</div>
						<div class="mb-3">
							<i class="bi bi-2-square"></i> <label for="id" class="form-label">
								아이디</label> <input type="text" class="form-control" id="id"
								placeholder="id.." name="id" />
						</div>
						<div class="mb-3">
							<i class="bi bi-3-square"></i> <label for="password"
								class="form-label"> 비밀번호</label> <input type="password"
								class="form-control" id="password" placeholder="password.."
								name="password" />
						</div>
						<div class="mb-3">
							<i class="bi bi-4-square"></i> <label for="password2"
								class="form-label"> 비밀번호 확인</label> <input type="password"
								class="form-control" id="password2" placeholder="password.."
								name="password2" />
						</div>
						<div class="row mb-3 mt-3">
							<div>
								<i class="bi bi-5-square"></i> <label for="email"
									class="form-label"> 이메일</label>
							</div>
							<div class="col-md-6">
								<input type="text" class="form-control" id="email"
									placeholder="email id.." name="email" />
							</div>
							<div class="col-md-6">
								<select name="emailList" id="emailList" class="form-select">
									<option value="" selected disabled>select email</option>
									<option value="naver">@naver.com</option>
									<option value="google">@gmail.com</option>
									<option value="daum">@daum.com</option>
									<option value="kakao">@kakao.com</option>
								</select>
							</div>
						</div>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" id="btn-signup"
						class="btn btn-primary btn-sm me-3">회원가입</button>
					<button type="button" class="btn btn-outline-danger btn-sm"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 회원가입 modal end -->

	<!-- 로그인 modal start -->
	<div class="modal fade" id="signinModal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm modal-dialog-centered">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title fw-bold">로그인</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="">
						<div class="mb-3">
							<input type="text" class="form-control" id="signinid"
								placeholder="id.." name="id" />
						</div>
						<div class="mb-3">
							<input type="password" class="form-control" id="signinpassword"
								placeholder="password.." name="password" />
						</div>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" id="btn-singin"
						class="btn btn-primary btn-sm me-3">로그인</button>
					<button type="button" id="btn-search"
						class="btn btn-secondary btn-sm me-3">잊음</button>
					<button type="button" class="btn btn-outline-danger btn-sm"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 로그인 modal end -->

	<!-- 마이페이지 modal start -->
	<div class="modal fade" id="mypageModal" data-bs-backdrop="static"
		data-bs-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm modal-dialog-centered">
			<div class="modal-content">
				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title fw-bold">마이페이지</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<form action="">
						<div class="mb-3 mt-3">
							<i class="bi bi-1-square"></i> <label for="name"
								class="form-label"> 이름</label> <input type="text"
								class="form-control" id="editName" value="로그인하세요." name="name"
								disabled />
						</div>
						<div class="mb-3">
							<i class="bi bi-2-square"></i> <label for="id" class="form-label">
								아이디</label> <input type="text" class="form-control" id="editId"
								value="로그인하세요." name="id" disabled />
						</div>
						<div class="mb-3">
							<i class="bi bi-3-square"></i> <label for="password"
								class="form-label"> 비밀번호</label> <input type="password"
								class="form-control" id="editPassword" value="" name="password"
								disabled />
						</div>
						<div class="row mb-3 mt-3">
							<div>
								<i class="bi bi-5-square"></i> <label for="email"
									class="form-label"> 이메일</label> <input type="text"
									class="form-control" id="editEmail" value="로그인하세요."
									name="email" disabled />
							</div>
						</div>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" id="btn-mypage-edit"
						class="btn btn-primary btn-sm me-3" disabled>수정</button>
					<button type="button" id="btn-mypage-withdraw"
						class="btn btn-secondary btn-sm me-3" style="display: none">
						탈퇴</button>
					<button type="button" id="btn-mypage-edit-done"
						class="btn btn-danger btn-sm me-3" style="display: none">
						수정완료</button>
					<button type="button" class="btn btn-outline-danger btn-sm"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 마이페이지 modal end -->

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
		integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
		crossorigin="anonymous"></script>
	<script src="assets/js/attraction.js"></script>
</body>
</html>
