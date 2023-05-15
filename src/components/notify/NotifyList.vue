<template>
  <div class="notify">
    <h1>공지사항</h1>
    <div class="notify__write">
      <button class="notify__write-button">게시글 작성</button>
    </div>
    <!-- <div v-if="boards.length"> -->
    <table>
      <colgroup>
        <col width="640px" />
        <col width="200px" />
        <col width="200px" />
        <col width="100px" />
      </colgroup>
      <thead>
        <tr>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>좋아요</th>
        </tr>
      </thead>
      <tbody>
        <notify-list-item></notify-list-item>
        <!-- <notify-list-item
            v-for="board in boards"
            :key="board.boardNo"
            :board="board"
          ></notify-list-item> -->
      </tbody>
    </table>
    <!-- <div v-else>게시글이 없습니다.</div> -->
  </div>
</template>

<script>
// import http from "@/util/http-common";
import NotifyListItem from "@/components/notify/NotifyListItem.vue";

export default {
  name: "BoardList",
  components: {
    NotifyListItem,
  },
  data() {
    return {
      boards: [],
      type: "1",
    };
  },
  created() {
    // http.get(`board?type=${this.type}`).then((response) => {
    //   this.boards = response.data;
    // });
  },
  methods: {},
};
</script>

<style>
.notify {
  width: 100%;
  height: 100%;
}
.notify__write {
  text-align: right;
}
</style>
