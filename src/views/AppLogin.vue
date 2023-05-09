<template>
  <div class="login">
    <TheLogin msg="login Page" />
  </div>
</template>

<script>
// @ is an alias to /src
import TheLogin from "@/components/login/TheLogin.vue";

export default {
  name: "AppLogin",
  components: {
    TheLogin,
  },
};
</script>
