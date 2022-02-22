package com.example.simonsvoss_homework.models

import com.example.simonsvoss_homework.others.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Group(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val name: String,
    val description: String?,
)
//{
//    private val id: UUID
//        get() {
//            return id
//        }
//    private val name: String
//        get() {
//            return name
//        }
//    private val description: String
//        get() {
//            return description
//        }
//}