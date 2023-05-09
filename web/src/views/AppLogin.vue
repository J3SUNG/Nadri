<template>
  <div class="login">
    <HelloWorld msg="login Page" />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/login/TheLogin.vue";

export default {
  name: "AppLogin",
  components: {
    HelloWorld,
  },
};
</script>
