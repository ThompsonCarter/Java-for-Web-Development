
    // Code for Prometheus & Grafana Dashboards section
    // Example Prometheus config
    scrape_configs:
    - job_name: spring
      metrics_path: /actuator/prometheus
      static_configs:
        - targets: ['taskmanager:8080']
    