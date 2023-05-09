import Vue from "vue";
import VueRouter from "vue-router";
import AppHome from "@/views/AppHome.vue";
import AppLogin from "@/views/AppLogin.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "AppHome",
    component: AppHome,
  },
  {
    path: "/login",
    name: "AppLogin",
    component: AppLogin,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
