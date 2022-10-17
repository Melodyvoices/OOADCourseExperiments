import request from "@/utils/request";
export function listAll() {
  return request({
    url: "/category/all",
    method: "get",
  });
}