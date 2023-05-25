<template>
  <div class="board-create">
    <h2 class="board-create__title">게시글 작성</h2>
    <div class="board-create__box">
      <input class="board-create__subject" placeholder="글 제목" v-model="board.subject" />
      <textarea
        class="board-create__content"
        placeholder="내용을 입력하세요."
        v-model="board.content"
      ></textarea>
      <div class="board-create__footer">
        <img class="board-create__button board-create__button-img" src="@/assets/file.png" />
        <!-- 서버에 요청 보내기 -->
        <router-link class="board-create__button board-create__button-a" :to="{ name: 'AppBoard' }"
          >게시하기</router-link
        >
      </div>
    </div>
    <button @click="updateBoard"></button>
  </div>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "BoardCreate",
  data() {
    return {
      board: "",
    };
  },
  created() {
    console.log("@@");
    console.log(this.$route.params.boardNo);
    http.get(`board/${this.$route.params.boardNo}`).then((response) => {
      console.log("!!!");
      this.board = response.data;
    });
  },
  methods: {
    updateBoard() {
      http.put(`board`, JSON.stringify(this.board)).then(() => {
        console.log(this.board.boardType);
        if (this.board.boardType === 1) {
          console.log("AppBoard");
          this.$router.push({ name: "AppBoard" });
        } else {
          console.log("AppNotify");
          this.$router.push({ name: "AppNotify" });
        }
      });
    },
  },
};
</script>

<style></style>
