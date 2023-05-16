import Vue from "vue";
import VueRouter from "vue-router";
import AppHome from "@/views/AppHome.vue";
import AppLogin from "@/views/AppLogin.vue";
import AppBoard from "@/views/AppBoard.vue";
import AppPlan from "@/views/AppPlan.vue";
import AppNotify from "@/views/AppNotify.vue";
import AppMap from "@/views/AppMap.vue";
import AppSignup from "@/views/AppSignup.vue";
import AppError from "@/views/AppError.vue";

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
  {
    path: "/plan",
    name: "AppPlan",
    component: AppPlan,
  },
  {
    path: "/board",
    name: "AppBoard",
    component: AppBoard,
  },
  {
    path: "/notify",
    name: "AppNotify",
    component: AppNotify,
  },
  {
    path: "/map",
    name: "AppMap",
    component: AppMap,
  },
  {
    path: "/signup",
    name: "AppSignup",
    component: AppSignup,
  },
  {
    path: "/*",
    name: "AppError",
    component: AppError,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
