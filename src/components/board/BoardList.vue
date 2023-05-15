<template>
  <div class="board">
    <h1>자유 게시판</h1>
    <div style="text-align: right">
      <button @click="movePage">게시글 작성</button>
    </div>
    <div class="board__cards">
      <board-card v-for="item in boards" :itemData="item" :key="item.boardNo" />
    </div>
    <div v-if="boards.length">
      <table class="board-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 5%" />
          <col style="width: 10%" />
          <col style="width: 10%" />
          <col style="width: 55%" />
          <col style="width: 5%" />
          <col style="width: 5%" />
          <col style="width: 5%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>타입</th>
            <th>작성일</th>
            <th>제목</th>
            <th>내용</th>
            <th>좋아요</th>
            <th>작성자번호</th>
            <th>작성자</th>
          </tr>
        </thead>
        <tbody>
          <board-list-item
            v-for="board in boards"
            :key="board.boardNo"
            :board="board"
          ></board-list-item>
        </tbody>
      </table>
    </div>
    <div v-else class="text-center">게시글이 없습니다.</div>
  </div>
</template>

<script>
import BoardListItem from "./BoardListItem.vue";
import http from "@/util/http-common";
import BoardCard from "./BoardCard.vue";

export default {
  name: "BoardList",
  components: {
    BoardListItem,
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
    });
  },
  methods: {
    movePage() {},
  },
};
</script>

<style>
.board {
  margin-top: 100px;
  width: 100%;
  height: 100%;
}
.board__cards {
  display: flex;
  flex-wrap: wrap;
}
</style>
