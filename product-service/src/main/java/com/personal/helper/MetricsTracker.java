package com.personal.helper;

import com.microsoft.applicationinsights.TelemetryClient;
import com.microsoft.applicationinsights.telemetry.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetricsTracker {

    private final static Logger LOG = LoggerFactory.getLogger(MetricsTracker.class);

    @Autowired
    TelemetryClient telemetryClient;

    public MetricsTracker trackMetrics() {
        LOG.info("Metrics tracker attached");
        return this;
    }

    public MetricsTracker trackEvent(String event) {
        telemetryClient.trackEvent(event);
        return this;
    }

    public MetricsTracker trackTrace(String message) {
        telemetryClient.trackTrace(message);
        return this;
    }

    public MetricsTracker trackMetric(String metric) {
        telemetryClient.trackMetric(metric, 1.0);
        return this;
    }

    public MetricsTracker trackSQLDependency() {
        telemetryClient.trackDependency("SQL", "SELECT", new Duration(0, 0, 1, 1, 1), true);
        return this;
    }

    public MetricsTracker trackException() {
        telemetryClient.trackException(new RuntimeException());
        return this;
    }
}
