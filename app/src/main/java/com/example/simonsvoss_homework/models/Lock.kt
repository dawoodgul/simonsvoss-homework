package com.example.simonsvoss_homework.models

import com.example.simonsvoss_homework.others.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Lock(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    @Serializable(with = UUIDSerializer::class)
    val buildingId: UUID,
    val type: String, // LockType
    val name: String,   //    # searchable
    val serialNumber: String,
    val floor: String?,    //   # searchable
    val roomNumber: String,    //   # searchable
    val description: String?,
)
//{
//    private val id: UUID
//        get() {
//            return id
//        }
//    private val buildingId: UUID
//        get() {
//            return buildingId
//        }
//    private val type: String // LockType
//        get() {
//            return type
//        }
//    private val name: String   //    # searchable
//        get() {
//            return name
//        }
//    private val serialNumber: String
//        get() {
//            return serialNumber
//        }
//    private val floor: String    //   # searchable
//        get() {
//            return floor
//        }
//    private val roomNumber: String    //   # searchable
//        get() {
//            return roomNumber
//        }
//    private val description: String
//        get() {
//            return description
//        }
//}