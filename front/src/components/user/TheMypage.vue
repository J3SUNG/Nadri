<template>
  <div class="mypage">
    <div class="mypage__header">
      <img class="mypage__header-img" :src="userImg" />
      <div class="mypage__header-info__box mypage__header-info__box-id">
        <p class="mypage__header-info">아이디</p>
        <p class="mypage__header-info__data">{{ this.id }}</p>
      </div>
      <div class="mypage__header-info__box mypage__header-info__box-nickname">
        <p class="mypage__header-info">닉네임</p>
        <p class="mypage__header-info__data">{{ this.nickname }}</p>
      </div>
      <div class="mypage__header-info__box mypage__header-info__box-email">
        <p class="mypage__header-info">이메일</p>
        <p class="mypage__header-info__data">{{ this.email }}</p>
      </div>
      <div class="mypage__header-button__box">
        <button class="mypage__header-button mypage__header-button__update" @click="moveUserUpdate">
          프로필수정
        </button>
        <button class="mypage__header-button mypage__header-button__delete">회원탈퇴</button>
      </div>
    </div>
    <div class="mypage__main">
      <div id="slideShow">
        <ul class="slides" :style="`left:${this.left}`">
          <li v-for="item in plans" :key="item.planNo"><plan-card :itemData="item" /></li>
        </ul>
        <p class="controller">
          <!-- &lang: 왼쪽 방향 화살표
      &rang: 오른쪽 방향 화살표 -->
          <span class="prev" @click="moveLeft">&lang;</span>
          <span class="next" @click="moveRight">&rang;</span>
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import PlanCard from "@/components/plan/PlanCard.vue";
export default {
  name: "TheMypage",
  data() {
    return {
      left: 0,
      currentIdx: 0, //현재 슬라이드 index
      slideCount: 3, // 슬라이드 개수

      userImg: require("@/assets/jetty.jpg"),
      id: "jetty1234",
      nickname: "제티먹은콜라",
      email: "jetty1234@naver.com",

      plans: {
        0: {
          content: "멋진 여행계획을 만들어봤습니다.",
          createTime: "2023-05-16 17:27:01",
          endDate: "2023-06-23 17:27:01",
          image1: "http://tong.visitkorea.or.kr/cms/resource/96/2690196_image2_1.jpg",
          isLike: 1,
          likeCount: 11,
          nickname: "예삐",
          planNo: 1,
          readCount: 13,
          startDate: "2023-06-16 17:27:01",
          subject: "첫번째 여행계획",
          trips: null,
          userNo: 1,
        },
        1: {
          content: "멋진 여행계획을 만들어봤습니다.",
          createTime: "2023-05-16 17:27:01",
          endDate: "2023-06-23 17:27:01",
          image1: "http://tong.visitkorea.or.kr/cms/resource/96/2690196_image2_1.jpg",
          isLike: 1,
          likeCount: 11,
          nickname: "예삐",
          planNo: 2,
          readCount: 13,
          startDate: "2023-06-16 17:27:01",
          subject: "첫번째 여행계획",
          trips: null,
          userNo: 1,
        },
        2: {
          content: "멋진 여행계획을 만들어봤습니다.",
          createTime: "2023-05-16 17:27:01",
          endDate: "2023-06-23 17:27:01",
          image1: "http://tong.visitkorea.or.kr/cms/resource/96/2690196_image2_1.jpg",
          isLike: 1,
          likeCount: 11,
          nickname: "예삐",
          planNo: 3,
          readCount: 13,
          startDate: "2023-06-16 17:27:01",
          subject: "첫번째 여행계획",
          trips: null,
          userNo: 1,
        },
        4: {
          content: "멋진 여행계획을 만들어봤습니다.",
          createTime: "2023-05-16 17:27:01",
          endDate: "2023-06-23 17:27:01",
          image1: "http://tong.visitkorea.or.kr/cms/resource/96/2690196_image2_1.jpg",
          isLike: 1,
          likeCount: 11,
          nickname: "예삐",
          planNo: 4,
          readCount: 13,
          startDate: "2023-06-16 17:27:01",
          subject: "첫번째 여행계획",
          trips: null,
          userNo: 1,
        },
        5: {
          content: "멋진 여행계획을 만들어봤습니다.",
          createTime: "2023-05-16 17:27:01",
          endDate: "2023-06-23 17:27:01",
          image1: "http://tong.visitkorea.or.kr/cms/resource/96/2690196_image2_1.jpg",
          isLike: 1,
          likeCount: 11,
          nickname: "예삐",
          planNo: 5,
          readCount: 13,
          startDate: "2023-06-16 17:27:01",
          subject: "첫번째 여행계획",
          trips: null,
          userNo: 1,
        },
      },
    };
  },
  methods: {
    moveUserUpdate() {
      this.$router.push({ name: "AppUserUpdate" });
    },
    //
    moveSlide(num) {
      this.left = -num * 280 + "px";
      this.currentIdx = num;
    },
    moveLeft() {
      if (this.currentIdx !== 0) this.moveSlide(this.currentIdx - 1);
    },
    moveRight() {
      if (this.currentIdx !== this.slideCount - 1) {
        this.moveSlide(this.currentIdx + 1);
      }
    },
  },
  components: {
    PlanCard,
  },
};
</script>

<style>
.mypage {
  width: 80%;
  margin-left: 10%;
}
.mypage__header {
  display: flex;
  width: 100%;
  justify-content: space-between;
  align-items: center;
  padding-bottom: 20px;
  border-bottom: 1px solid var(--color-lightgray);
}
.mypage__header-img {
  width: 100px;
  height: 100px;
  border-radius: 70px;
}
.mypage__header-info__box {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  width: 160px;
  height: 60px;
}
.mypage__header-info__box-id {
  width: 140px;
}
.mypage__header-info__box-nickname {
  width: 140px;
}
.mypage__header-info__box-email {
  width: 180px;
}
.mypage__header-info {
  font-size: 16px;
}
.mypage__header-info__data {
  font-size: 16px;
}
.mypage__header-button {
  font-size: 14px;
  height: 40px;
  width: 100px;
  padding: 0px;
  border: 0px solid var(--color-white);
  background-color: var(--color-week);
  color: var(--color-white);
  margin: 5px;
  border-radius: 10px;
}
.mypage__header-button__update {
  background-color: var(--color-week);
}
.mypage__header-button__delete {
  background-color: var(--color-tomato);
}

.mypage__main .plan__card {
  margin: 0px;
  padding: 0px;
}
/*  */
#slideShow {
  width: 930px;
  height: 300px;
  position: relative;
  overflow: hidden;
  margin-top: 20px;
  /*리스트 형식으로 이미지를 일렬로 
  정렬할 것이기 때문에, 500px 밖으로 튀어 나간 이미지들은
  hidden으로 숨겨줘야됨*/
}
.slides {
  position: absolute;
  left: 0;
  top: 0;
  width: 2000px; /* 슬라이드할 사진과 마진 총 넓이 */
  transition: left 0.5s ease-out;
  /*ease-out: 처음에는 느렸다가 점점 빨라짐*/
}
/* 첫 번째 슬라이드 가운데에 정렬하기위해
첫번째 슬라이드만 margin-left조정 */
.slides li:first-child {
  margin-left: 30px;
}
.slides li:last-child {
  margin-right: 30px;
}
/* 슬라이드들 옆으로 정렬 */
.slides li:not(:last-child) {
  float: left;
  margin-right: 20px;
}
.slides li {
  float: left;
}
.controller span {
  position: absolute;
  background-color: transparent;
  color: black;
  text-align: center;
  border-radius: 50%;
  padding: 10px 20px;
  top: 50%;
  font-size: 1.3em;
  cursor: pointer;
}
/* 이전, 다음 화살표에 마우스 커서가 올라가 있을때 */
.controller span:hover {
  background-color: rgba(128, 128, 128, 0.11);
}
.prev {
  left: 10px;
  backdrop-filter: brightness(80%);
}
/* 이전 화살표에 마우스 커서가 올라가 있을때 
이전 화살표가 살짝 왼쪽으로 이동하는 효과*/
.prev:hover {
  transform: translateX(-10px);
}
.next {
  right: 10px;
  backdrop-filter: brightness(80%);
}
/* 다음 화살표에 마우스 커서가 올라가 있을때 
이전 화살표가 살짝 오른쪽으로 이동하는 효과*/
.next:hover {
  transform: translateX(10px);
}
</style>
