export const api = axios.create({ baseURL: '/api' });

export function addToCart(id: number) {
  return api.post('/cart', { productId: id, qty: 1 });
}
