<template>
  <div>
    <div>{{ board.boardNo }}</div>
    <div>{{ board.boardType }}</div>
    <div>{{ board.content }}</div>
    <div>{{ board.createTime }}</div>
    <div>{{ board.likeCount }}</div>
    <div>{{ board.nickname }}</div>
    <div>{{ board.subject }}</div>
    <div>{{ board.userNo }}</div>
    <button @click="moveBoardUpdate">수정</button>
    <button @click="deleteBoard">삭제</button>
  </div>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "BoardDetail",
  data() {
    return {
      board: "",
    };
  },
  created() {
    http.get(`board/${this.$route.params.boardNo}`).then((response) => {
      this.board = response.data;
    });
  },
  methods: {
    moveBoardUpdate() {
      this.$router.push({ name: "AppBoardUpdate", params: { boardNo: this.board.boardNo } });
    },
    deleteBoard() {
      console.log(this.board.boardNo);
      http.delete(`board/${this.board.boardNo}`).then((response) => {
        console.log(response);
        this.$router.push({ name: "AppBoard" });
      });
    },
  },
};
</script>

<style></style>
