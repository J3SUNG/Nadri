<template>
  <tr class="notify__item" @click="moveNotifyDetail">
    <td>{{ board.boardNo }}</td>
    <td>{{ board.subject }}</td>
    <td>{{ board.nickname }}</td>
    <td>{{ board.createTime }}</td>
  </tr>
</template>

<script>
export default {
  name: "NotifyListItem",
  props: {
    board: Object,
  },
  methods: {
    moveNotifyDetail() {
      this.$router.push({ name: "AppNotifyDetail", params: { boardNo: this.board.boardNo } });
    },
  },
};
</script>

<style>
.notify__item {
  cursor: pointer;
}
</style>
