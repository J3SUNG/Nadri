<template>
  <header class="header">
    <header class="logo">
      <img class="logo__img" alt="page logo" src="@/assets/logo.png" />
      <h3 class="logo__text">Enjoy Trip!</h3>
    </header>
    <nav class="nav">
      <router-link to="/">Home</router-link> | <router-link to="/map">Map</router-link> |
      <router-link to="/board">Board</router-link>
    </nav>
    <aside class="login">
      <router-link to="/login">Login</router-link> |
      <router-link to="/signup">Signup</router-link>
    </aside>
  </header>
</template>

<script>
export default {
  name: "MainHeader",
};
</script>

<style>
.header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 100px;
}
.logo {
  display: flex;
  align-items: center;
}
.logo__img {
  width: 50px;
  height: 50px;
}
.logo__text {
  margin-left: 10px;
}

.nav {
  padding: 30px;
}

.nav a {
  font-weight: bold;
  color: #2c3e50;
}
.nav a.router-link-exact-active {
  color: #f6a94c;
}
</style>
