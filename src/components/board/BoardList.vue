<template>
  <div>
    <h1>자유 게시판</h1>
    <div style="text-align: right">
      <button @click="movePage">도서 등록</button>
    </div>
    <div v-if="boards.length">
      <table class="board-list">
        <colgroup>
          <col style="width: 5%" />
          <col style="width: 65%" />
          <col style="width: 10%" />
          <col style="width: 5%" />
          <col style="width: 15%" />
        </colgroup>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          <board-list-item
            v-for="board in boards"
            :key="board.articleNo"
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

export default {
  name: "BoardList",
  components: {
    BoardListItem,
  },
  data() {
    return {};
  },
  created() {
    this.boards = [
      {
        articleNo: 10,
        userName: "제티",
        subject: "우유엔 제티!",
        hit: 10,
        registerTime: "2023-05-08 17:03:15",
      },
      {
        articleNo: 9,
        userName: "콜라",
        subject: "코카콜라 맛있다.",
        hit: 102,
        registerTime: "2023-05-08 14:13:15",
      },
      {
        articleNo: 8,
        userName: "사이다",
        subject: "시원한 사이다!",
        hit: 24,
        registerTime: "2023-05-07 11:03:15",
      },
    ];
  },
  methods: {
    movePage() {},
  },
};
</script>

<style></style>
