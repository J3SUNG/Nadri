<template>
  <div class="plan-detail">
    <div class="plan-detail__header">
      <h3 class="plan-detail__header-title">여행노트</h3>
      <div class="plan-detail__header__right">
        <img class="plan-detail__header-img" :src="userImg" />
        <p class="plan-detail__header-nickname">{{ this.nickname }}</p>
        <p class="plan-detail__header-createtime">{{ this.createTime }}</p>
      </div>
    </div>
    <hr class="plan-detail__hr" />
    <div class="plan-detail__item" v-for="(item, index) in plans" :key="item.attrNo">
      <img :src="item.img" class="plan-detail__item-img" />
      <div class="plan-detail__item-box">
        <div class="plan-detail__item-box__header">
          <p class="plan-detail__item-order">경로 : {{ index }}번</p>
          <h2 class="plan-detail__item-name">{{ item.name }}</h2>
        </div>
        <hr class="plan-detail__item-box__hr" />
        <p class="plan-detail__item-content">{{ item.content }}</p>
      </div>
    </div>
    <div class="plan-deatil__main">
      <h1 class="plan-deatil__main-title">{{ this.subject }}</h1>
      <p class="plan-deatil__main-content">{{ this.content }}</p>
    </div>
    <hr class="plan-detail__hr" />
    <div class="plan-deatil__function">
      <button @click="movePlanList">목록</button>
      <div class="plan-deatil__function-heart">
        <img class="plan-deatil__function-heart-img" @click="heartClick" :src="heart" />
        <p class="plan-deatil__function-heart-text">{{ this.heartCnt }}</p>
      </div>
      <div class="plan-detail__function-admin">
        <button @click="movePlanUpdate">수정</button>
        <button @click="deletePlan">삭제</button>
      </div>
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";

export default {
  name: "PlanDetail",
  data() {
    return {
      plans: {
        0: {
          img: require("@/assets/dummy6.jpg"),
          name: "서해안 도로",
          content: "드라이브 하기 좋은 길",
          attrNo: 1,
        },
        1: {
          img: require("@/assets/dummy5.jpg"),
          name: "서해 바다",
          content: "바다가 예뻐요",
          attrNo: 2,
        },
        2: {
          img: require("@/assets/dummy4.jpg"),
          name: "서해 카페",
          content: "뷰가 좋아요",
          attrNo: 3,
        },
      },
      userImg: require("@/assets/jetty.jpg"),
      nickname: "Jetty",
      createTime: "2023-05-21 02:56",
      subject: "여름의 여행 계획",
      content: "최고의 여행 계획이야!!",
      heart: require("@/assets/heartOff.png"),
      heartChk: false,
      heartCnt: 0,
    };
  },
  methods: {
    movePlanUpdate() {
      this.$router.push({ name: "AppPlanUpdate", params: { planNo: this.plan.planNo } });
    },
    movePlanList() {
      this.$router.push({ name: "AppPlan" });
    },
    deletePlan() {
      console.log(this.plan.planNo);
      if (confirm("정말 삭제하시겠습니까?")) {
        http.delete(`plan/${this.plan.planNo}`).then(() => {
          if (this.plan.planType === 1) {
            this.$router.push({ name: "AppPlan" });
          } else {
            this.$router.push({ name: "AppNotify" });
          }
        });
      }
    },
    heartClick() {
      if (this.heartChk === 0) {
        http.post(`planlike/${this.plan.planNo}/${this.userInfo.userNo}`).then((response) => {
          ++this.heartCnt;
          console.log(response);
        });
        this.heart = require("@/assets/heartOn.png");
      } else {
        http.delete(`planlike/${this.plan.planNo}/${this.userInfo.userNo}`).then((response) => {
          --this.heartCnt;
          console.log(response);
        });
        this.heart = require("@/assets/heartOff.png");
      }
      this.heartChk = this.heartChk === 0 ? 1 : 0;
      this.$forceUpdate();
    },
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
  font-size: 20px;
  font-weight: bold;
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
  font-size: 28px;
  margin-left: 20px;
  text-align: left;
}
.plan-detail__item-name {
  font-size: 28px;
  margin-left: 20px;
}
.plan-detail__item-box__hr {
  width: 100%;
}
.plan-detail__item-content {
  text-align: left;
  padding: 20px;
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
</style>
