import Vue from "vue";
import Vuex from "vuex";
import createPersistedState from "vuex-persistedstate";

import memberStore from "@/store/modules/memberStore";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: { memberStore },
  plugins: [
    createPersistedState({
      storage: sessionStorage,
    }),
  ],
});
