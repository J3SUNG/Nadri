<template>
  <div class="plan__card" @click="movePlanDetail">
    <img class="plan__card__img" :src="itemData.img" />
    <h3 class="plan__card__subject">{{ itemData.subject }}</h3>
    <p class="plan__card__content">
      {{ itemData.content }}
    </p>
    <hr class="plan__card__hr" />
    <div class="plan__card__footer">
      <div class="plan__card__footer__left">
        <img class="plan__card__footer__writer-img" :src="itemData.imgUrl" />
        <p class="plan__card__footer__writer-nickname">{{ itemData.nickname }}</p>
      </div>
      <div class="plan__card__footer__right" v-if="!isMypage">
        <img
          class="plan__card__footer__icon plan__card__footer__icon-heart"
          @click="heartClick"
          :src="heart"
        />
        <p class="plan__card__footer__text">{{ heartCnt }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
import http from "@/util/http-common";

const memberStore = "memberStore";

export default {
  name: "PlanCard",
  data() {
    return {
      heartChk: this.itemData.isLike,
      heartCnt: this.itemData.likeCount,
      heart: "",
      isMypage: false,
      userNo: 0,
    };
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  props: ["itemData", "isMypageValue"],
  created() {
    if (this.userInfo !== null) {
      this.userNo = this.userInfo.userNo;
    }
  },
  mounted() {
    console.log("AA");
    console.log(this.isMypageValue);
    if (this.isMypageValue === undefined) {
      this.isMypage = false;
      console.log(1);
    } else {
      this.isMypage = true;
      console.log(2);
    }
    this.heart =
      this.itemData.isLike === 0
        ? require("@/assets/heartOff.png")
        : require("@/assets/heartOn.png");
  },
  methods: {
    movePlanDetail(event) {
      if (!(event.target.classList[1] === "plan__card__footer__icon-heart")) {
        this.$router.push({ name: "AppPlanDetail", params: { planNo: this.itemData.planNo } });
      }
    },
    heartClick() {
      if (this.userInfo !== null) {
        if (this.heartChk === 0) {
          http.post(`planlike/${this.itemData.planNo}/${this.userInfo.userNo}`).then((response) => {
            ++this.heartCnt;
            console.log(response);
          });
          this.heart = require("@/assets/heartOn.png");
        } else {
          http
            .delete(`planlike/${this.itemData.planNo}/${this.userInfo.userNo}`)
            .then((response) => {
              --this.heartCnt;
              console.log(response);
            });
          this.heart = require("@/assets/heartOff.png");
        }
        this.heartChk = this.heartChk === 0 ? 1 : 0;
      }
    },
  },
};
</script>

<style>
.plan__card {
  width: 340px;
  height: 340px;
  border: 0px solid var(--color-black);
  margin-bottom: 40px;
  display: flex;
  align-items: center;
  flex-direction: column;
  background-color: var(--color-white);
  transition: all 0.1s linear;
  font-size: 16px;
  text-align: left;
  cursor: pointer;
}
.plan__card:hover {
  transform: scale(1.04);
  box-shadow: 0px 0px 5px var(--color-darkgray);
}
.plan__card__img {
  width: 320px;
  height: 200px;
  margin: 10px;
  /* overflow: hidden; */
}
.plan__card__subject {
  width: 90%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.plan__card__content {
  width: 90%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
}
.plan__card__hr {
  width: 90%;
  margin: 10px;
}
.plan__card__footer {
  width: 90%;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.plan__card__footer__left {
  display: flex;
  justify-content: start;
  align-items: center;
}
.plan__card__footer__right {
  display: flex;
  justify-content: end;
  align-items: center;
}
.plan__card__footer__icon {
  margin-left: 5px;
  width: 20px;
  height: 20px;
}
.plan__card__footer__icon-heart:hover {
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
.plan__card__footer__text {
  margin-left: 10px;
  width: 28px;
  height: 28px;
}
.plan__card__footer__writer-img {
  width: 28px;
  height: 28px;
  border-radius: 70px;
}
.plan__card__footer__writer-nickname {
  font-weight: bold;
  margin-left: 5px;
}
</style>
