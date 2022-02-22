package com.example.simonsvoss_homework.models

import com.example.simonsvoss_homework.others.UUIDSerializer
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Building(
    @Serializable(with = UUIDSerializer::class)
    val id: UUID,
    val shortCut: String,   //    # searchable
    val name: String,    //   # searchable
    val description: String
)
//{
//    private val id: UUID
//        get() {
//            return id
//        }
//    private val shortCut: String   //    # searchable
//        get() {
//            return shortCut
//        }
//    private val name: String    //   # searchable
//        get() {
//            return name
//        }
//    private val description: String
//        get() {
//            return description
//        }
//}