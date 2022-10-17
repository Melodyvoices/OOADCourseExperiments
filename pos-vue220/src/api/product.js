import request from "@/utils/request";
export function listAll() {
  return request({
    url: "/product/all",
    method: "get",
  });
}