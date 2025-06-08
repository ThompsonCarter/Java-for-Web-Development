import http from 'k6/http';

export default function() {
  http.get('https://shop.local/api/catalog?page=0');
}
