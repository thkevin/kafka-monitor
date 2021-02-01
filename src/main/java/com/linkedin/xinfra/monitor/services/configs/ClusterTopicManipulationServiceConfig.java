/**
 * Copyright 2020 LinkedIn Corp. Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */

package com.linkedin.xinfra.monitor.services.configs;

import java.util.Map;
import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import com.linkedin.xinfra.monitor.XinfraMonitorConstants;

import static org.apache.kafka.common.config.ConfigDef.Range.atLeast;

/**
 * This class is used to extract configuration from a Map&lt;String, Object&gt;, setup defaults and perform basic bounds
 * checking on the values found in the map.  This is used by the TopicManagementService when it is constructed.
 */
public class ClusterTopicManipulationServiceConfig extends AbstractConfig {

  private static final ConfigDef CONFIG;

  public static final String ZOOKEEPER_CONNECT_CONFIG = CommonServiceConfig.ZOOKEEPER_CONNECT_CONFIG;
  public static final String ZOOKEEPER_CONNECT_DOC = CommonServiceConfig.ZOOKEEPER_CONNECT_DOC;

  public static final String TOPIC_CONFIG = CommonServiceConfig.TOPIC_CONFIG;
  public static final String TOPIC_DOC = CommonServiceConfig.TOPIC_DOC;

  public static final String TOPIC_MANIPULATION_SERVICE_TOPIC_PREFIX_CONFIG = "topic.manipulation.topic.prefix";
  public static final String TOPIC_MANIPULATION_SERVICE_TOPIC_PREFIX_DOC = "Root name of the topics created by the Cluster Topic Manipulation Service."
      + " Default value is : xinfra-monitor-cluster-topic-manipulation-service-topic.";

  static {
    CONFIG = new ConfigDef()
      .define(ZOOKEEPER_CONNECT_CONFIG,
              ConfigDef.Type.STRING,
              ConfigDef.Importance.HIGH,
              ZOOKEEPER_CONNECT_DOC)
      .define(TOPIC_CONFIG,
              ConfigDef.Type.STRING,
              ConfigDef.Importance.HIGH,
              TOPIC_DOC)
      .define(TOPIC_MANIPULATION_SERVICE_TOPIC_PREFIX_CONFIG,
              ConfigDef.Type.STRING,
              XinfraMonitorConstants.TOPIC_MANIPULATION_SERVICE_TOPIC,
              ConfigDef.Importance.LOW,
              TOPIC_MANIPULATION_SERVICE_TOPIC_PREFIX_DOC);
  }

  public ClusterTopicManipulationServiceConfig(Map<?, ?> props) {
    super(CONFIG, props);
  }
}
