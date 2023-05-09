<template>
  <header>
    <h3>I'm Header!</h3>
    <nav>
      <router-link to="/">Home</router-link> | <router-link to="/map">Map</router-link> |
      <router-link to="/board">Board</router-link> | <router-link to="/login">Login</router-link> |
      <router-link to="/signup">Signup</router-link>
    </nav>
  </header>
</template>

<script>
export default {
  name: "MainHeader",
};
</script>

<style></style>
