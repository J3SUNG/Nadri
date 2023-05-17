<template>
  <div class="board-create">
    <h2 class="board-create__title">게시글 작성</h2>
    <div class="board-create__box">
      <input class="board-create__subject" placeholder="글 제목" v-model="subject" />
      <textarea
        class="board-create__content"
        placeholder="내용을 입력하세요."
        v-model="content"
      ></textarea>
      <div class="board-create__footer">
        <img class="board-create__button board-create__button-img" src="@/assets/file.png" />
        <!-- 서버에 요청 보내기 -->
        <router-link class="board-create__button board-create__button-a" :to="{ name: 'AppBoard' }"
          >게시하기</router-link
        >
      </div>
    </div>
    <button @click="createBoard"></button>
  </div>
</template>

<script>
import http from "@/util/http-common";
export default {
  name: "BoardCreate",
  data() {
    return {
      boardType: this.$route.params.boardType,
      content: "",
      subject: "",
    };
  },
  methods: {
    createBoard() {
      let item = {
        boardType: this.boardType,
        content: this.content,
        subject: this.subject,
      };
      http.post(`board`, JSON.stringify(item)).then(() => {
        if (this.boardType === 1) {
          this.$router.push({ name: "AppBoard" });
        } else {
          this.$router.push({ name: "AppNotify" });
        }
      });
    },
  },
};
</script>

<style>
.board-create {
  display: flex;
  align-items: center;
  flex-direction: column;
}
.board-create input:focus,
textarea:focus {
  outline: none;
}
.board-create__title {
  margin-bottom: 20px;
}
.board-create__box {
  width: 60%;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
  border: 1px solid var(--color-lightgray);
}
.board-create__box * {
  margin: 0px;
}
.board-create__box input {
  width: clac(100% - 60px);
  padding: 12px 30px;
  border-radius: 0px;
  border: 1px solid var(--color-lightgray);
}
.board-create__box textarea {
  width: calc(100% - 60px);
  height: 20em;
  padding: 30px;
  border: 1px solid var(--color-lightgray);
}
.board-create__content {
  height: 50%;
}
.board-create__footer {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 96%;
  padding: 0 2%;
  height: 60px;
  border: 1px solid var(--color-lightgray);
  background-color: var(--color-white);
}
.board-create__button {
  width: 40px;
  height: 40px;
  cursor: pointer;
}
.board-create__button-img {
}
.board-create__button-a {
  height: auto;
  width: auto;
}
</style>
