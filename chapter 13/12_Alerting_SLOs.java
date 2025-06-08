
    // Code for Alerting & SLOs section
    // Example PromQL for alerting
    histogram_quantile(0.99, rate(http_server_requests_seconds_bucket[5m])) > 0.15
    