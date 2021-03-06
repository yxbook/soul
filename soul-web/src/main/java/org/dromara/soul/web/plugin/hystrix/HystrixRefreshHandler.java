/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * Contributor license agreements.See the NOTICE file distributed with
 * This work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * he License.You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.dromara.soul.web.plugin.hystrix;

import com.netflix.hystrix.strategy.properties.HystrixPropertiesFactory;
import org.dromara.soul.common.dto.RuleData;
import org.dromara.soul.common.enums.PluginEnum;

import java.util.List;

/**
 * The enum Hystrix rule refresh handler.
 *
 * @author xiaoyu(Myth)
 */
public enum HystrixRefreshHandler {

    /**
     * Ins hystrix rule refresh handler.
     */
    INS;

    /**
     * Refresh hystrix.
     *
     * @param ruleDataList the rule data list
     */
    public void refreshHystrix(final List<RuleData> ruleDataList) {
        ruleDataList.stream()
                .filter(RuleData::getEnabled)
                .filter(e -> PluginEnum.HYSTRIX.getName().equals(e.getPluginName()))
                .findFirst().ifPresent(ruleData -> HystrixPropertiesFactory.reset());
    }
}
