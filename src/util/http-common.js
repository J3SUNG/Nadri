import axios from "axios";

export default axios.create({
  baseURL: "http://192.168.31.78/",
  headers: {
    "Content-Type": "application/json",
  },
});
