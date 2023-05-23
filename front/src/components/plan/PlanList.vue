<template>
  <div class="plan-note">
    <div class="plan-note__header">
      <h2 class="plan-note__title">여행노트</h2>
      <button class="plan-note__write-button" @click="movePlanCreate">글쓰기</button>
    </div>
    <div class="plan-note__cards">
      <plan-card v-for="item in plans" :itemData="item" :key="item.planNo" />
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import PlanCard from "./PlanCard.vue";
import { mapState } from "vuex";

const memberStore = "memberStore";

export default {
  name: "PlanList",
  components: {
    PlanCard,
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data() {
    return {
      plans: [],
      type: "1",
      userNo: 0,
    };
  },
  created() {
    if (this.userInfo !== null) {
      this.userNo = this.userInfo.userNo;
    }
    http.get(`plan/list/${this.userNo}`).then((response) => {
      this.plans = response.data;
      this.loadImg();
      console.log(this.plans);
    });
  },
  methods: {
    movePlanCreate() {
      this.$router.push({ name: "AppPlanCreate" });
    },
    movePage(page) {
      this.nextPage = page;
      if (this.nextPage <= 0) {
        this.nextPage = 1;
      } else if (this.nextPage >= this.pageNav.totalPageCount) {
        this.nextPage = this.pageNav.totalPageCount;
      }
      http.get(`plan?pg=${this.nextPage}&type=${this.type}`).then((response) => {
        this.plans = response.data.list;
        this.pageNav = response.data.pageNavigation;
        console.log(this.pageNav);
        console.log(111);
        if (!this.pageNav.startRange) {
          this.startPage = 1;
          this.selected = [true, false, false, false, false];
        } else if (!this.pageNav.endRange) {
          this.startPage = this.pageNav.totalPageCount - 4;
          this.selected = [false, false, false, false, true];
        } else if (!this.pageNav.startRange2) {
          this.startPage = 1;
          this.selected = [false, true, false, false, false];
        } else if (!this.pageNav.endRange2) {
          this.startPage = this.pageNav.totalPageCount - 4;
          this.selected = [false, false, false, true, false];
        } else {
          this.startPage = this.pageNav.currentPage - 2;
          this.selected = [false, false, true, false, false];
        }
        this.loadImg();
      });
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
.plan-note {
  width: 100%;
  height: 100%;
  padding: 50px 0px;
}
.plan-note__header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 0px 0px 0 10px;
}
.plan-note__title {
  color: var(--color-black);
}
.plan-note__cards {
  width: 100%;
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
}
.plan-note__write-button {
  display: flex;
  width: 90px;
  height: 40px;
  border-radius: 30px;
  justify-content: center;
  align-items: center;
  font-size: 16px;
}
.plan-note__pagenation {
  color: black;
  background-color: white;
}
.plan-note__pagenation__selected {
  color: var(--color-main);
}
.plan-note__pagenation__hidden {
  color: var(--color-lightgray);
  cursor: default;
}
</style>
