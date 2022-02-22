package com.example.simonsvoss_homework.models

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val buildings: Array<Building>,
    val locks: Array<Lock>,
    val groups: Array<Group>,
    val media: Array<Medium>,
)
//    {
//    private val buildings: Array<Building>
//        get() {
//            return buildings
//        }
//    private val locks: Array<Lock>
//        get() {
//            return locks
//        }
//    private val groups: Array<Group>
//        get() {
//            return groups
//        }
//    private val media: Array<Medium>
//        get() {
//            return media
//        }
//}