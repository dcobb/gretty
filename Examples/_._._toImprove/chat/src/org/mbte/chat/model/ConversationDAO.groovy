/*
 * Copyright 2009-2010 MBTE Sweden AB.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */



package org.mbte.chat.model

import com.google.code.morphia.Morphia
import com.google.code.morphia.dao.BasicDAO
import com.google.inject.Inject
import com.google.inject.name.Named
import com.mongodb.Mongo

@Typed
class ConversationDAO extends BasicDAO<Conversation,String> {
    @Inject
    ConversationDAO(Mongo mongo, Morphia morphia, @Named("mongoDbName") String mongoDbName) {
        super(Conversation, mongo, morphia, mongoDbName)
        ensureIndexes()
    }

    Conversation newConversation () {
        new Conversation(id:UUID.randomUUID())
    }
}
