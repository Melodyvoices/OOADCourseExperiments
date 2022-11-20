import request from "@/utils/request";
// 分页查询产品列表
export function listProductByPage(query) {
  return request({
    url: '/product/page',
    method: 'get',
    params: query
  })
}
// 删除产品
export function delProduct(productId) {
  return request({
    url: '/product/' + productId,
    method: 'delete'
  })
}