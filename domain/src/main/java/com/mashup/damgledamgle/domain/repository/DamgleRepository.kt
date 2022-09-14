package com.mashup.damgledamgle.domain.repository

import com.mashup.damgledamgle.domain.entity.Damgle
import com.mashup.damgledamgle.domain.entity.base.Result

/**
 *  DamgleRepository.kt
 *
 *  Created by Minji Jeong on 2022/07/31
 *  Copyright © 2022 MashUp All rights reserved.
 */

interface DamgleRepository {
    suspend fun writeDamgle(longitude: Double, latitude: Double, content: String, address1: String, address2: String): Result<Damgle>
    suspend fun getMyDamgleList(): Result<List<Damgle>>
    suspend fun getDamgle(id: String): Result<Damgle>

    suspend fun createDamgleReaction(reaction: String, storyId: String): Result<Damgle>
    suspend fun deleteDamgleReaction(storyId: String): Result<Damgle>
    suspend fun reportDamgle(storyId: String): Result<Damgle>
}
