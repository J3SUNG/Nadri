<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

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
			<a class="navbar-brand text-primary fw-bold" href="index.html">
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
						aria-current="page" href="/board">공지사항</a></li>
					<li class="nav-item"><a class="nav-link text-dark"
						aria-current="page" href="/map">관광지</a></li>
				</ul>
				<!-- 로그인 전 -->
				<c:if test="${empty userinfo}">
					<ul id="navBeforeLogin" class="navbar-nav mb-2 me-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link text-dark"
							aria-current="page" href="#" data-bs-toggle="modal"
							data-bs-target="#signupModal">회원가입</a></li>
						<li class="nav-item"><a class="nav-link text-dark"
							aria-current="page" href="#" data-bs-toggle="modal"
							data-bs-target="#signinModal">로그인</a></li>
					</ul>
				</c:if>
				<!-- 로그인 후 -->
				<c:if test="${not empty userinfo}">
					<ul id="navAfterLogin" class="navbar-nav mb-2 me-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link text-dark"
							aria-current="page" href="/user/logout" id="logoutBtn">로그아웃</a></li>
						<li class="nav-item" id="mypageBtn"><a
							class="nav-link text-dark" aria-current="page" href="#"
							data-bs-toggle="modal" data-bs-target="#mypageModal">마이페이지</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle text-dark" href="#"
							id="navbarDropdown" role="button" data-bs-toggle="dropdown"
							aria-expanded="false"> 관리자 </a>
							<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
								<li><a class="dropdown-item" href="#"
									data-bs-toggle="modal" data-bs-target="#pollModal">투표만들기</a></li>
								<li><a class="dropdown-item" href="#">차트보기</a></li>
								<li><a class="dropdown-item" href="#">회원관리</a></li>
							</ul></li>
					</ul>
				</c:if>
			</div>
		</div>
	</nav>
	<!-- 상단 navbar end -->

	<div style="height: 80px"></div>
	<!-- 중앙 content start -->
	<div class="container">
		<!-- 상단 제목 start -->
		<div id="intro">
			<div id="intro-top">안녕하세요 &#128400;</div>
			<div id="intro-img">
				<img src="./assets/img/earch.PNG" alt="" />
			</div>
			<p id="intro-text">저희와 함께 여행을 떠나볼까요?</p>
		</div>

		<!-- 상단 제목 end -->
		<div class="row mt-1 m-5">
			<div class="card border-0 col-lg-4 col-md-6">
				<div class="card-body text-center">
					<img src="./assets/img/cloud.png"
						class="card-img-top w-50 mx-auto mt-3" alt="" />
					<h6 class="card-title h4 fw-bold mt-sm-4">신혼여행코스</h6>
					<p class="card-text">
						위 경도처럼 가려는데 어떨까요?<br />조언 부탁드려요.
					</p>
					<a href="#" class="btn btn-outline-primary btn-sm text-center mb-3">더보기</a>
				</div>
			</div>
			<div class="card border-0 col-lg-4 col-md-6">
				<div class="card-body text-center">
					<img src="./assets/img/poll.png" class="card-img-top w-50 mx-auto"
						alt="" />
					<h6 class="card-title h4 fw-bold mt-sm-4">제주도 여행</h6>
					<p class="card-text">
						다음주에 제주도 가는데 이렇게 가려고 합니다.<br />좋은 곳 추천해주세요.
					</p>
					<a href="#" class="btn btn-outline-primary btn-sm text-center mb-3">더보기</a>
				</div>
			</div>
			<div class="card border-0 col-lg-4 col-md-6">
				<div class="card-body text-center">
					<img src="./assets/img/notify.png"
						class="card-img-top w-50 mx-auto mt-3" alt="" />
					<h6 class="card-title h4 fw-bold mt-sm-4">해외 여행</h6>
					<p class="card-text">
						20살에 첫 여행을 가려고 하는데, <br /> 여기는 어떠신가요.
					</p>
					<a href="#" class="btn btn-outline-primary btn-sm text-center mb-3">더보기</a>
				</div>
			</div>
		</div>
	</div>
	<!-- 중앙 content end -->

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
					<form action="" id="form-join" method="post">
						<input type="hidden" name="action" value="join">
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
						<div class="mb-3" id="idcheck-result"></div>
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
									<option value="@naver.com">@naver.com</option>
									<option value="@gmail.com">@gmail.com</option>
									<option value="@daum.com">@daum.com</option>
									<option value="@kakao.com">@kakao.com</option>
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
						id="modal-close" data-bs-dismiss="modal">Close</button>
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
					<form action="" id="form-login" method="post">
						<div class="mb-3">
							<input type="text" class="form-control" id="userid"
								placeholder="id.." name="id" />
						</div>
						<div class="mb-3">
							<input type="password" class="form-control" id="userpwd"
								placeholder="password.." name="password" />
						</div>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" id="btn-login"
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
					<form id="my-form" action="/user">
						<input type="hidden" name="id" value="${userinfo.id }" />
						<div class="mb-3 mt-3">
							<i class="bi bi-1-square"></i> <label for="name"
								class="form-label"> 이름</label> <input type="text"
								class="form-control" id="editName" value="${userinfo.name }"
								name="name" />
						</div>
						<div class="mb-3">
							<i class="bi bi-2-square"></i> <label for="id" class="form-label">
								아이디</label> <input type="text" class="form-control" id="editId"
								value="${userinfo.id}" name="id" disabled />
						</div>
						<div class="mb-3">
							<i class="bi bi-3-square"></i> <label for="password"
								class="form-label"> 비밀번호</label> <input type="password"
								class="form-control" id="editPassword"
								value="${userinfo.password }" name="password" />
						</div>
						<div class="row mb-3 mt-3">
							<div>
								<i class="bi bi-5-square"></i> <label for="email"
									class="form-label"> 이메일</label> <input type="text"
									class="form-control" id="editEmail" value="${userinfo.email }"
									name="email" />
							</div>
						</div>
					</form>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" id="btn-mypage-edit"
						class="btn btn-primary btn-sm me-3">수정</button>
					<!-- 추가 -->
					<button type="button" id="btn-mypage-withdraw"
						class="btn btn-secondary btn-sm me-3"">탈퇴</button>
					<button type="button" id="btn-mypage-edit-done"
						class="btn btn-danger btn-sm me-3" style="display: none;">
						수정완료</button>
					<button type="button" class="btn btn-outline-danger btn-sm"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- 마이페이지 modal end -->

	<script>
      document.querySelector("#btn-login").addEventListener("click", function () {
        if (!document.querySelector("#userid").value) {
          alert("아이디 입력!!");
          return;
        } else if (!document.querySelector("#userpwd").value) {
          alert("비밀번호 입력!!");
          return;
        } else {
          let form = document.querySelector("#form-login");
          form.setAttribute("action", "/user");
          form.submit();
        }
      });
      let msgs = '${msg}';
      if(msgs!=''){
         alert(msgs);
      }
    </script>

 	<!-- 회원가입 -->
	<script>
    let isUseId = false;
    document.querySelector("#id").addEventListener("keyup", function () {
      let id = this.value;
         let resultDiv = document.querySelector("#idcheck-result");
         if(id.length < 6 || id.length > 16) {
            resultDiv.setAttribute("class", "mb-3 text-dark");
            resultDiv.textContent = "아이디는 6자 이상 16자 이하 입니다.";
            isUseId = false;
         } else {
        	fetch("/user/idCheck/" + id)
            .then(response => response.text())
            .then(data => {
               console.log(data);
             if(data == 0) {
                  resultDiv.setAttribute("class", "mb-3 text-primary");
                   resultDiv.textContent = id + "는 사용할 수 있습니다.";
                   isUseId = true;
             } else {
                  resultDiv.setAttribute("class", "mb-3 text-danger");
                    resultDiv.textContent = id + "는 사용할 수 없습니다.";
                  isUseId = false;
             }
           });
         }
    });
    
   document.querySelector("#btn-signup").addEventListener("click", function () {
      if (!document.querySelector("#name").value) {
          alert("이름 입력!!");
          return;
        } else if (!document.querySelector("#id").value) {
          alert("아이디 입력!!");
          return;
        } else if (!document.querySelector("#password").value) {
          alert("비밀번호 입력!!");
          return;
        } else if (document.querySelector("#password").value != document.querySelector("#password2").value) {
          alert("비밀번호 확인!!");
          return;
        } else if(!isUseId){
            alert("사용할 수 없는 아이디!!"); ///////////////////////////추가
             return;
        }
        else {
          let form = document.querySelector("#form-join");
          form.setAttribute("action", "/user/join");
          form.submit();
        }
   });
    </script>


	<!-- 추가 수정 -->
	<script>
      document.querySelector("#btn-mypage-edit").addEventListener("click", function () {
       if (!document.querySelector("#editName").value) {
              alert("이름 입력!!");
              return;
            } 
        else if (!document.querySelector("#editPassword").value) {
          alert("비밀번호 입력!!");
          return;
        } 
        else if (!document.querySelector("#editEmail").value) {
            alert("이메일 입력!!");
            return;
          }
        else {
          let form = document.querySelector("#my-form");
          form.setAttribute("action", "/user/modify");
          form.setAttribute("method", "post");
          form.submit();
        }
      });
      msgs = '${msg}';
      if(msgs!=''){
         alert(msgs);
      }
    </script>
	<!-- 삭제 -->
	<script>
      document.querySelector("#btn-mypage-withdraw").addEventListener("click", function () {
    	  let form = document.querySelector("#my-form");
        	if(confirm("정말 탈퇴하시겠습니까?")==true){
                location.href="/user/delete";
        	}
      });
    </script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
		integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
		integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
		crossorigin="anonymous">
   </script>

</body>

</html>