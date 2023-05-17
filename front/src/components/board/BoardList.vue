<template>
  <div class="board">
    <h1 class="board__title">게시판</h1>
    <div class="board__write">
      <button class="board__write-button" @click="moveBoardCreate">게시글 작성</button>
    </div>
    <div class="board__cards">
      <board-card v-for="item in boards" :itemData="item" :key="item.boardNo" />
    </div>
  </div>
</template>

<script>
import http from "@/util/http-common";
import BoardCard from "./BoardCard.vue";

export default {
  name: "BoardList",
  components: {
    BoardCard,
  },
  data() {
    return {
      boards: [],
      type: "1",
    };
  },
  created() {
    http.get(`board?type=${this.type}`).then((response) => {
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
}
.board__cards {
  display: flex;
  flex-wrap: wrap;
  margin-left: 50px;
  margin-right: 50px;
}
</style>
