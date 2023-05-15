<template>
  <tr>
    <td>{{ board.boardNo }}</td>
    <td>{{ board.boardType }}</td>
    <td>{{ board.createTime }}</td>
    <td>{{ board.subject }}</td>
    <td>{{ board.content }}</td>
    <td>{{ board.likeCount }}</td>
    <td>{{ board.userNo }}</td>
    <td>{{ board.userName }}</td>
  </tr>
</template>

<script>
export default {
  name: "BoardListItem",
  props: {
    board: Object,
  },
};
</script>

<style>
.board__cards {
  padding-left: 50px;
  padding-right: 50px;
}
</style>
