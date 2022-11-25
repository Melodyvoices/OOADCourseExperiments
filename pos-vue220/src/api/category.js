export function listAll() {
  return request({
    url: "/category/all",
    method: "get",
  });
}
import request from "@/utils/request";
// 分页查询Category列表
export function listCategoryByPage(query) {
  return request({
    url: '/category/page',
    method: 'get',
    params: query
  })
}
// 删除Category
export function delCategory(categoryId) {
  return request({
    url: '/category/' + categoryId,
    method: 'delete'
  })
}
// 查询category详细
export function getCategory(categoryId) {
  return request({
    url: '/category/' + categoryId,
    method: 'get'
  })
}

// 新增category
export function addCategory(data) {
  return request({
    url: '/category',
    method: 'post',
    data: data
  })
}

// 修改category
export function updateCategory(data) {
  return request({
    url: '/category',
    method: 'put',
    data: data
  })
}