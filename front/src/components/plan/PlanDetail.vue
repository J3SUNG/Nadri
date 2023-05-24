<template>
  <div class="plan-detail">
    <div class="plan-detail__header">
      <h2 class="plan-detail__header-title">여행노트</h2>
      <div class="plan-detail__header__right">
        <img class="plan-detail__header-img" :src="plans.imgUrl" />
        <p class="plan-detail__header-nickname">{{ plans.nickname }}</p>
        <p class="plan-detail__header-createtime">{{ plans.createTime }}</p>
      </div>
    </div>
    <hr class="plan-detail__hr" />
    <div class="plan-detail__item" v-for="(item, index) in plans.trips" :key="item.tripNo">
      <img :src="item.image1" class="plan-detail__item-img" />
      <div class="plan-detail__item-box">
        <div class="plan-detail__item-box__header">
          <p class="plan-detail__item-order">경로 : {{ index * 1 + 1 }}번</p>
          <h2 class="plan-detail__item-name">{{ item.attrName }}</h2>
        </div>
        <hr class="plan-detail__item-box__hr" />
        <p class="plan-detail__item-content">{{ item.memo }}</p>
      </div>
    </div>
    <div class="plan-deatil__main">
      <h1 class="plan-deatil__main-title">{{ plans.subject }}</h1>
      <p class="plan-deatil__main-content">{{ plans.content }}</p>
    </div>
    <hr class="plan-detail__hr" />
    <div class="plan-deatil__function">
      <button @click="movePlanList">목록</button>
      <div class="plan-deatil__function-heart">
        <img class="plan-deatil__function-heart-img" @click="heartClick" :src="heart" />
        <p class="plan-deatil__function-heart-text">{{ this.heartCnt }}</p>
      </div>
      <div class="plan-detail__function-admin">
        <button v-if="isWriter" @click="deletePlan">삭제</button>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import { mapState } from "vuex";

const memberStore = "memberStore";

export default {
  name: "PlanDetail",
  data() {
    return {
      plans: "",
      heart: require("@/assets/heartOff.png"),
      heartChk: false,
      heartCnt: 0,
      isWriter: false,
      planNo: 0,
      userNo: 0,
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  methods: {
    movePlanList() {
      this.$router.push({ name: "AppPlan" });
    },
    deletePlan() {
      console.log(this.plans.planNo);
      if (confirm("정말 삭제하시겠습니까?")) {
        http.delete(`plan/${this.plans.planNo}`).then(() => {
          this.$router.push({ name: "AppPlan" });
        });
      }
    },
    heartClick() {
      if (this.heartChk) {
        http.post(`planlike/${this.plans.planNo}/${this.userNo}`).then((response) => {
          --this.heartCnt;
          console.log(response);
        });
        this.heart = require("@/assets/heartOff.png");
      } else {
        http.delete(`planlike/${this.plans.planNo}/${this.userNo}`).then((response) => {
          ++this.heartCnt;
          console.log(response);
        });
        this.heart = require("@/assets/heartOn.png");
      }
      this.heartChk = !this.heartChk;
    },
    loadImg() {
      this.baseUrl = `${process.env.VUE_APP_API_BASE_URL}`;
      this.imgUrl = `${this.baseUrl}/image/showImage?saveFolder=${this.plans.imgSaveFolder}&saveFile=${this.plans.imgSaveFile}`;
      this.plans.imgUrl = this.imgUrl;
    },
  },
  created() {
    if (this.userInfo !== null) {
      this.userNo = this.userInfo.userNo;
    }
    this.planNo = this.$route.params.planNo;
    console.log(this.planNo);
    http.get(`plan/${this.planNo}/${this.userNo}`).then((response) => {
      this.plans = response.data;
      this.heartCnt = this.plans.likeCount;
      this.heartChk = this.plans.isLike === 1 ? true : false;
      if (this.heartChk) {
        this.heart = require("@/assets/heartOn.png");
      } else {
        this.heart = require("@/assets/heartOff.png");
      }
      this.loadImg();
      console.log(this.plans);
    });

    if (this.userInfo !== null && this.userInfo.userNo === this.userNo) {
      this.isWriter = true;
    } else {
      this.isWriter = false;
    }
    console.log(this.isWriter);
  },
};
</script>

<style>
.plan-detail {
  margin-top: 20px;
  width: 80%;
  margin-left: 10%;
}
.plan-detail__header {
  display: flex;
  justify-content: space-between;
}
.plan-detail__header-title {
  font-weight: bold;
  color: var(--color-black);
}
.plan-detail__header__right {
  display: flex;
  align-items: center;
  font-weight: bold;
  font-size: 18px;
}
.plan-detail__header-img {
  width: 40px;
  height: 40px;
  border-radius: 70px;
  margin-right: 10px;
}
.plan-detail__header-nickname {
  margin-right: 10px;
}
.plan-detail__header-nickname::after {
  content: " | ";
  color: darkgray;
}
.plan-detail__header-createtime {
  margin-right: 10px;
  color: darkgray;
}
.plan-detail__hr {
  margin: 10px 0;
}
.plan-detail__item {
  width: 100%;
  height: 460px;
  display: flex;
  margin-bottom: 20px;
}
.plan-detail__item-img {
  height: 100%;
  width: 60%;
}
.plan-detail__item-box {
  width: 38%;
  margin-left: 2%;
  padding-top: 30px;
  border-top: 1px solid var(--color-black);
  border-bottom: 1px solid var(--color-black);
}
.plan-detail__item-box__header {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
}
.plan-detail__item-order {
  font-size: 20px;
  margin-left: 20px;
  text-align: left;
  width: 100px;
}
.plan-detail__item-name {
  font-size: 20px;
  margin-left: 20px;
  color: var(--color-black);
  width: 200px;
}
.plan-detail__item-box__hr {
  width: 100%;
}
.plan-detail__item-content {
  text-align: left;
  padding: 20px;
  color: var(--color-black);
}
.plan-deatil__main {
  margin-left: 5%;
  width: 90%;
  text-align: left;
}
.plan-deatil__main-title {
  margin: 24px 0px;
}
.plan-deatil__main-content {
  margin: 20px 0px;
  font-size: 20px;
  font-weight: bold;
}
.plan-deatil__function {
  margin: 30px 0px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.plan-deatil__function button {
  height: 40px;
  padding: 0px 20px;
  border-radius: 20px;
  background: var(--color-white);
  color: var(--color-black);
  border: solid 3px var(--color-darkgray);
}
.plan-deatil__function-heart {
  display: flex;
  align-items: center;
}
.plan-deatil__function-heart-img {
  margin-left: 40px;
  width: 36px;
  height: 36px;
  cursor: pointer;
}
.plan-deatil__function-heart-text {
  margin-left: 16px;
  font-size: 28px;
  font-weight: bold;
  color: var(--color-main);
}
.plan-deatil__function-heart-img:hover {
  animation: scaling 1s ease-in-out infinite;
}
@keyframes scaling {
  from {
    transform: scale(1);
  }
  to {
    transform: scale(1.3);
  }
}
.plan-detail__function-admin {
  width: 200px;
}
</style>
