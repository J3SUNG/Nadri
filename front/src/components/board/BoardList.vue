<template>
  <div class="board">
    <h1 class="board__title">커뮤니티</h1>
    <div class="board__write">
      <button class="board__write-button" @click="moveBoardCreate">글쓰기</button>
    </div>
    <div class="board__cards">
      <board-card v-for="item in boards" :itemData="item" :key="item.boardNo" />
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import BoardCard from "./BoardCard.vue";
import { mapState } from "vuex";

const memberStore = "memberStore";

export default {
  name: "BoardList",
  components: {
    BoardCard,
  },
  computed: {
    ...mapState(memberStore, ["userInfo"]),
  },
  data() {
    return {
      boards: [],
      type: "1",
    };
  },
  created() {
    let userNo = this.userInfo === null ? 0 : this.userInfo.userNo;
    http.get(`board?type=${this.type}&userNo=${userNo}`).then((response) => {
      this.boards = response.data;
      console.log(this.boards);
    });
  },
  methods: {
    moveBoardCreate() {
      this.$router.push({ name: "AppBoardCreate", params: { boardType: this.type } });
    },
  },
};
</script>

<style>
.board {
  width: 100%;
  height: 100%;
}
.board__write {
  text-align: right;
  margin-bottom: 20px;
}
.board__cards {
  margin-left: 75px;
  margin-right: 75px;
  display: flex;
  flex-wrap: wrap;
  justify-content: start;
}
.board__write {
  display: flex;
  justify-content: end;
  margin-right: 110px;
}
.board__write-button {
  display: flex;
  width: 90px;
  height: 40px;
  border-radius: 30px;
  justify-content: center;
  align-items: center;
  font-size: 16px;
}
</style>
