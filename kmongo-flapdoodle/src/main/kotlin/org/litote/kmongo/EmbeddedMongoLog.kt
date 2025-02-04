/*
 * Copyright (C) 2016/2021 Litote
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.litote.kmongo

import de.flapdoodle.embed.mongo.packageresolver.Command
import de.flapdoodle.embed.mongo.config.Defaults
import de.flapdoodle.embed.process.config.process.ProcessOutput
import de.flapdoodle.embed.process.io.Processors

/**
 *
 */
internal object EmbeddedMongoLog {

    val embeddedConfig = Defaults.runtimeConfigFor(Command.MongoD)
        .processOutput(
            if (System.getProperty("kmongo.flapdoddle.log") == "true") {
                ProcessOutput.builder().build()
            } else {
                ProcessOutput.builder()
                    .output(Processors.silent())
                    .error(Processors.silent())
                    .commands(Processors.silent())
                    .build()
            }
        )
        .build()
}