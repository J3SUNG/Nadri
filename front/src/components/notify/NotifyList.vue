<template>
  <div class="notify">
    <h1>공지사항</h1>
    <div class="notify__write">
      <button class="notify__write-button" @click="moveNotifyCreate">게시글 작성</button>
    </div>
    <!-- <div v-if="boards.length"> -->
    <table class="notify__table">
      <colgroup class="notify__colgroup">
        <col width="20%" />
        <col width="40%" />
        <col width="20%" />
        <col width="20%" />
      </colgroup>
      <thead>
        <tr class="notify__table__tr">
          <th>번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
        </tr>
      </thead>
      <tbody>
        <!-- <notify-list-item></notify-list-item> -->
        <notify-list-item
          v-for="board in boards"
          :key="board.boardNo"
          :board="board"
          class="notify__table__data"
        ></notify-list-item>
      </tbody>
    </table>
    <!-- <div v-else>게시글이 없습니다.</div> -->
  </div>
</template>

<script>
import http from "@/util/http-common";
import NotifyListItem from "@/components/notify/NotifyListItem.vue";

export default {
  name: "NotifyList",
  components: {
    NotifyListItem,
  },
  data() {
    return {
      boards: [],
      type: "0",
    };
  },
  created() {
    http.get(`board?type=${this.type}`).then((response) => {
      this.boards = response.data;
    });
  },
  methods: {
    moveNotifyCreate() {
      this.$router.push({ name: "AppNotifyCreate", params: { boardType: this.type } });
    },
  },
};
</script>

<style>
.notify {
  width: 100%;
  height: 100%;
}
.notify__table {
  width: 100%;
}
.notify__tr {
  height: 50px;
}
.notify__colgroup {
  width: 100%;
}
.notify__write {
  text-align: right;
}
.notify__table__data {
  height: 50px;
}
</style>
