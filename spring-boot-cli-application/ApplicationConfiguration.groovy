/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import com.gopivotal.cloudfoundry.test.core.DataSourceUtils
import com.gopivotal.cloudfoundry.test.core.HealthUtils
import com.gopivotal.cloudfoundry.test.core.MemoryUtils
import com.gopivotal.cloudfoundry.test.core.RuntimeUtils
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan

@ComponentScan
@EnableAutoConfiguration
@Grab('com.gopivotal.cloudfoundry.test:core:1.0.0.BUILD-SNAPSHOT')
@Grab('h2')
@Grab('mysql-connector-java')
@Grab('spring-boot-starter-jdbc')
class ApplicationConfiguration {

    @Bean
    DataSourceUtils dataSourceUtils() {
        return new DataSourceUtils()
    }

    @Bean
    HealthUtils healthUtils() {
        return new HealthUtils()
    }

    @Bean
    MemoryUtils memoryUtils() {
        def memory = new MemoryUtils()
        memory.outOfMemory()

        return memory
    }

    @Bean
    RuntimeUtils runtimeUtils() {
        return new RuntimeUtils()
    }
}
