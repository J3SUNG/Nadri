<template>
  <div class="mypage">
    <div class="mypage__header">
      <img class="mypage__header-img" :src="this.userInfo.url" />
      <div class="mypage__header-info__box mypage__header-info__box-id">
        <p class="mypage__header-info">아이디</p>
        <p class="mypage__header-info__data">{{ this.userInfo.id }}</p>
      </div>
      <div class="mypage__header-info__box mypage__header-info__box-nickname">
        <p class="mypage__header-info">닉네임</p>
        <p class="mypage__header-info__data">{{ this.userInfo.nickname }}</p>
      </div>
      <div class="mypage__header-info__box mypage__header-info__box-email">
        <p class="mypage__header-info">이메일</p>
        <p class="mypage__header-info__data">{{ this.userInfo.email }}</p>
      </div>
      <div class="mypage__header-button__box">
        <button class="mypage__header-button mypage__header-button__update" @click="moveUserUpdate">
          프로필수정
        </button>
        <button class="mypage__header-button mypage__header-button__delete" @click="moveUserDelete">
          회원탈퇴
        </button>
      </div>
    </div>
    <div class="mypage__main">
      <div class="mypage__main__visited-attr">
        <h2 class="mypage__main__visited__title">최근 본 관광지</h2>
        <div class="mypage__visited__slideShow">
          <ul class="mypage__visited__slides" :style="`left:${this.attrLeft}`">
            <li v-for="item in places" :key="item.planNo">
              <place-card :itemData="item" />
            </li>
          </ul>
          <p class="mypage__visited__controller">
            <img src="@/assets/next.png" class="mypage__visited__prev" @click="moveAttrLeft" />
            <img src="@/assets/next.png" class="mypage__visited__next" @click="moveAttrRight" />
          </p>
        </div>
      </div>
      <div class="mypage__main__visited-plan">
        <h2 class="mypage__main__visited__title">최근 본 여행노트</h2>
        <div class="mypage__visited__slideShow">
          <ul class="mypage__visited__slides" :style="`left:${this.planLeft}`">
            <li v-for="item in plans" :key="item.planNo">
              <plan-card :itemData="item" :isMypage="true" />
            </li>
          </ul>
          <p class="mypage__visited__controller">
            <img src="@/assets/next.png" class="mypage__visited__prev" @click="movePlanLeft" />
            <img src="@/assets/next.png" class="mypage__visited__next" @click="movePlanRight" />
          </p>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapGetters, mapState } from "vuex";
import http from "@/util/http-common";
import PlanCard from "@/components/plan/PlanCard.vue";
import PlaceCard from "../home/PlaceCard.vue";

const memberStore = "memberStore";

export default {
  name: "TheMypage",
  components: {
    PlanCard,
    PlaceCard,
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
    ...mapGetters(["checkUserInfo"]),
  },
  updated() {
    console.log(this.userInfo);
  },
  data() {
    return {
      attrLeft: 0,
      attrCurrentIdx: 0, //현재 슬라이드 index
      attrSlideCount: 8, // 슬라이드 개수
      planLeft: 0,
      planCurrentIdx: 0, //현재 슬라이드 index
      planSlideCount: 8, // 슬라이드 개수 n-2

      image: "",

      plans: "",
      places: "",
      userNo: 0,
    };
  },
  created() {
    if (this.userInfo !== null) {
      this.userNo = this.userInfo.userNo;
    }
    http.get(`map/watch/${this.userNo}`).then((response) => {
      this.places = response.data;
      console.log(this.places);
      this.loadImg();
    });
    http.get(`plan/watch/${this.userNo}`).then((response) => {
      this.plans = response.data;
      console.log(this.plans);
      this.loadImg();
    });
  },
  methods: {
    ...mapActions(memberStore, ["userLogout"]),
    moveUserUpdate() {
      this.$router.push({ name: "AppUserUpdate" });
    },
    moveUserDelete() {
      if (confirm("정말 계정을 삭제하시겠습니까?")) {
        http.delete(`user/${this.userInfo.id}`).then(() => {
          if (this.userLogout !== null) {
            console.log(this.userInfo.id);
            this.userLogout(this.userInfo.id);
          }
          sessionStorage.removeItem("access-token"); //저장된 토큰 없애기
          sessionStorage.removeItem("refresh-token"); //저장된 토큰 없애기
          this.$router.push({ name: "AppHome" });
        });
      }
    },
    movePlanSlide(num) {
      this.planLeft = -num * 370 + "px";
      this.planCurrentIdx = num;
    },
    movePlanLeft() {
      if (this.planCurrentIdx !== 0) this.movePlanSlide(this.planCurrentIdx - 1);
    },
    movePlanRight() {
      if (this.planCurrentIdx !== this.planSlideCount - 1) {
        this.movePlanSlide(this.planCurrentIdx + 1);
      }
    },
    moveAttrSlide(num) {
      this.attrLeft = -num * 370 + "px";
      this.attrCurrentIdx = num;
    },
    moveAttrLeft() {
      if (this.attrCurrentIdx !== 0) this.moveAttrSlide(this.attrCurrentIdx - 1);
    },
    moveAttrRight() {
      if (this.attrCurrentIdx !== this.attrSlideCount - 1) {
        this.moveAttrSlide(this.attrCurrentIdx + 1);
      }
    },
    loadImg() {
      this.baseUrl = `${process.env.VUE_APP_API_BASE_URL}`;
      for (let i = 0; i < this.plans.length; ++i) {
        this.imgUrl = `${this.baseUrl}/image/showImage?saveFolder=${this.plans[i].imgSaveFolder}&saveFile=${this.plans[i].imgSaveFile}`;
        this.plans[i].imgUrl = this.imgUrl;
      }
    },
  },
};
</script>

<style>
.mypage {
  width: 100%;
}
.mypage__header {
  display: flex;
  width: 100%;
  justify-content: space-between;
  align-items: center;
  margin-top: 10px;
  padding-bottom: 30px;
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
.mypage__main__visited-attr {
  margin-top: 20px;
  animation: fadeInDown 1s;
}
.mypage__main__visited-plan {
  margin-top: 20px;
  opacity: 0;
  animation: fadeInDown 1s;
  animation-delay: 0.5s;
  animation-fill-mode: forwards;
}
.mypage__main__visited__title {
  text-align: left;
  margin-left: 20px;
  color: var(--color-black);
}
.mypage__main__visited-attr .plan__card,
.mypage__main__visited-plan .plan__card {
  margin: 10px 0 0 0;
  padding: 0px;
}
/* slide */
.mypage__visited__slideShow {
  width: 1100px;
  height: 360px;
  position: relative;
  overflow: hidden;
  padding: 0px 20px;
}
.mypage__visited__slides {
  position: absolute;
  left: 0;
  top: 0;
  width: 2000px;
  transition: left 0.3s ease-out;
}
.mypage__visited__slides li:first-child {
  margin-left: 30px;
}
.mypage__visited__slides li:last-child {
  margin-right: 30px;
}
.mypage__visited__slides li:not(:last-child) {
  float: left;
  margin-right: 30px;
}
.mypage__visited__slides li {
  float: left;
}
.mypage__visited__controller img {
  position: absolute;
  background-color: transparent;
  color: black;
  text-align: center;
  top: 50%;
  cursor: pointer;
}
.mypage__visited__prev {
  width: 40px;
  height: 40px;
  left: 0px;
  backdrop-filter: brightness(90%);
  border-radius: 70px;
}
.mypage__visited__prev:hover {
  backdrop-filter: brightness(70%);
}
.mypage__visited__next {
  width: 40px;
  height: 40px;
  right: 0px;
  backdrop-filter: brightness(90%);
  border-radius: 70px;
  transform: rotate(180deg);
}
.mypage__visited__next:hover {
  backdrop-filter: brightness(70%);
  transform: rotate(180deg);
}
</style>
