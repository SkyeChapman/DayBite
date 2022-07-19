package com.example.daybite

data class User(var userName : String ?= null, var userEmail : String ?= null, var userPassword : String ?= null, var userDateOfBirth : Int ?= null, var userNotificationButton : Boolean ?= false, var userNightModeButton : Boolean ?= false )
