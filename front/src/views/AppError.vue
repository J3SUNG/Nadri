<template>
  <TheError />
</template>

<script>
// @ is an alias to /src
import TheError from "@/components/error/TheError.vue";

export default {
  name: "AppError",
  components: {
    TheError,
  },
};
</script>
