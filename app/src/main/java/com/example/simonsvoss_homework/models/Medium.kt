package com.example.simonsvoss_homework.models

import com.example.simonsvoss_homework.others.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Medium(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    @Serializable(with = UUIDSerializer::class)
    val groupId: UUID,
    val type: String, // MediumType
    val owner: String,
    val serialNumber: String,
    val description: String?,
)
//{
//    private val id: UUID
//        get() {
//            return id
//        }
//    private val groupId: UUID
//        get() {
//            return groupId
//        }
//    private val type: String // MediumType
//        get() {
//            return type
//        }
//    private val owner: String
//        get() {
//            return owner
//        }
//    private val serialNumber: String
//        get() {
//            return serialNumber
//        }
//    private val description: String
//        get() {
//            return description
//        }
//}