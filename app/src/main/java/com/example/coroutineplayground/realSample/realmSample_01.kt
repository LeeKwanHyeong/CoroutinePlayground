package com.example.coroutineplayground.realSample

import io.realm.Realm
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

class Dog: RealmObject() {
    var name: String? = null
    var age: Int? = null
}

class Person: RealmObject(){
    @PrimaryKey
    private val id: Long? = null
    private val name: String? = null
    private val dogs: RealmList<Dog>? = null
}



fun main(){
    val dog = Dog()
    dog.name = "Kwan doll"
    dog.age = 1

}