<template>
  <tr>
    <td>{{ board.articleNo }}</td>
    <td>{{ board.subject }}</td>
    <td>{{ board.userName }}</td>
    <td>{{ board.hit }}</td>
    <td>{{ board.registerTime }}</td>
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

<style></style>
