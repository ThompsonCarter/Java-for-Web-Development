import { useEffect } from 'react';
import { Client } from '@stomp/stompjs';
import { toast } from 'react-toastify';

export function useOrderUpdates(orderId: string) {
  useEffect(() => {
    const client = new Client({brokerURL: '/ws'});
    client.onConnect = () =>
      client.subscribe(`/topic/orders/${orderId}`, msg => {
        const ev = JSON.parse(msg.body) as OrderEvent;
        toast.info(\`Order update: \${ev.status}\`);
      });
    client.activate();
    return () => client.deactivate();
  }, [orderId]);
}
