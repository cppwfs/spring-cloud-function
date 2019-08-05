/*
 * Copyright 2017-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.function.deployer;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;

/**
 * Configuration properties for deciding how to locate the functional class to execute.
 *
 * @author Eric Bottard
 */
@ConfigurationProperties("spring.cloud.function")
public class FunctionProperties {

	/**
	 * Location(s) of jar archives containing the supplier/function/consumer class to run.
	 */
	private String location;

	private String functionName;

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getName() {
		return this.functionName;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@PostConstruct
	public void init() {
		Assert.notNull(this.location, "No archive location provided, please configure spring.cloud.function.location as a jar or directory.");
	}

}