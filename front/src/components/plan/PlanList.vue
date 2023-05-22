<template>
  <div class="plan-note">
    <div class="plan-note__header">
      <h2 class="plan-note__title">여행노트</h2>
      <button class="plan-note__write-button" @click="movePlanCreate">글쓰기</button>
    </div>
    <div class="plan-note__cards">
      <plan-card v-for="item in plans" :itemData="item" :key="item.planNo" />
    </div>
    <div class="'plan-note__pagenation'__box">
      <button
        :class="{
          'plan-note__pagenation': true,
          'plan-note__pagenation__hidden': !this.pageNav.startRange,
        }"
        @click="movePage(startPage - 1)"
      >
        &lt;
      </button>
      <button
        :class="{
          'plan-note__pagenation': true,
          'plan-note__pagenation__selected': this.selected[0],
        }"
        @click="movePage(startPage)"
      >
        {{ this.startPage }}
      </button>
      <button
        :class="{
          'plan-note__pagenation': true,
          'plan-note__pagenation__selected': this.selected[1],
        }"
        @click="movePage(startPage + 1)"
      >
        {{ this.startPage + 1 }}
      </button>
      <button
        :class="{
          'plan-note__pagenation': true,
          'plan-note__pagenation__selected': this.selected[2],
        }"
        @click="movePage(startPage + 2)"
      >
        {{ this.startPage + 2 }}
      </button>
      <button
        :class="{
          'plan-note__pagenation': true,
          'plan-note__pagenation__selected': this.selected[3],
        }"
        @click="movePage(startPage + 3)"
      >
        {{ this.startPage + 3 }}
      </button>
      <button
        :class="{
          'plan-note__pagenation': true,
          'plan-note__pagenation__selected': this.selected[4],
        }"
        @click="movePage(startPage + 4)"
      >
        {{ this.startPage + 4 }}
      </button>
      <button
        :class="{
          'plan-note__pagenation': true,
          'plan-note__pagenation__hidden': !this.pageNav.endRange,
        }"
        @click="movePage(startPage + 5)"
      >
        &gt;
      </button>
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
      pageNav: {},
      nextPage: 1,
      startPage: 1,
      selected: [true, false, false, false, false],
    };
  },
  created() {
    if (this.userInfo !== null) {
      this.userNo = this.userInfo.userNo;
    }
    http.get(`plan/list/${this.userNo}`).then((response) => {
      this.plans = response.data;
      console.log(response.data);
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
      });
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
  visibility: hidden;
}
</style>
